package net.legacy.progression_reborn.mixin.client;

import com.ibm.icu.impl.Pair;
import com.mojang.logging.LogUtils;
import net.legacy.progression_reborn.ProgressionReborn;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.item.BlockModelWrapper;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

@Mixin(value = BlockModelWrapper.class)
public class BlockModelWrapperMixin {

    private static final Set<Pair<Identifier, Identifier>> ATLAS_MISMATCHES = ConcurrentHashMap.newKeySet();

    @Inject(method = "detectRenderType", at = @At(value = "HEAD"), cancellable = true)
    private static void PR$detectRenderType(List<BakedQuad> list, CallbackInfoReturnable<Function<ItemStack, RenderType>> cir) {
        Iterator<BakedQuad> iterator = list.iterator();
        if (!iterator.hasNext()) {
            cir.setReturnValue(BlockModelWrapper.ITEM_RENDER_TYPE_GETTER);
        } else {
            Identifier identifier = iterator.next().sprite().atlasLocation();

            while(iterator.hasNext()) {
                BakedQuad bakedQuad = iterator.next();
                Identifier identifier2 = bakedQuad.sprite().atlasLocation();
                if (!identifier2.equals(identifier)) {
                    Pair<Identifier, Identifier> mismatch = Pair.of(identifier2, identifier);
                    if (ATLAS_MISMATCHES.add(mismatch)) {
                        LogUtils.getLogger().warn("Multiple atlases used in model, expected {}, but also got {}", identifier2, identifier);
                        LogUtils.getLogger().warn("Further instances of atlas mismatches have been suppressed for brevity");
                    }
                }
            }

            if (identifier.equals(TextureAtlas.LOCATION_ITEMS)) {
                cir.setReturnValue(BlockModelWrapper.ITEM_RENDER_TYPE_GETTER);
            } else if (identifier.equals(TextureAtlas.LOCATION_BLOCKS)) {
                cir.setReturnValue(BlockModelWrapper.BLOCK_RENDER_TYPE_GETTER);
            } else {
                throw new IllegalArgumentException("Atlas " + identifier + " can't be used for item models");
            }
        }
    }
}