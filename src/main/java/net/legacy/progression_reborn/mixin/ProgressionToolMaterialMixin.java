package net.legacy.progression_reborn.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ToolMaterial;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(ToolMaterial.class)
public interface ProgressionToolMaterialMixin {

    @WrapOperation(
            method = "<clinit>",
            at = @At
                    (
                            value = "NEW",
                            target = "(Lnet/minecraft/tags/TagKey;IFFILnet/minecraft/tags/TagKey;)Lnet/minecraft/world/item/ToolMaterial;"
                    )
    )
    private static ToolMaterial modifyToughness(TagKey tagKey, int i, float f, float g, int j, TagKey tagKey2, Operation<ToolMaterial> original) {
        if (tagKey == BlockTags.INCORRECT_FOR_GOLD_TOOL && i == 32 && f == 12f && g == 0f && j == 22 && tagKey2 == ItemTags.GOLD_TOOL_MATERIALS){
            return original.call(tagKey, 73, 10f, g, j, tagKey2);
        }
        else {
            return original.call(tagKey, i, f, g, j, tagKey2);
        }
    }
}