package net.legacy.progression_reborn.mixin;

import net.legacy.progression_reborn.tag.PRItemTags;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffectUtil;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Player.class, priority = 1001)
public class PlayerMixin {

    @Inject(method = "getDestroySpeed", at = @At(value = "TAIL"), cancellable = true)
    private void stonePickaxeSpeed(BlockState state, CallbackInfoReturnable<Float> cir) {
        Player player = Player.class.cast(this);
        if (state.is(BlockTags.IRON_ORES) && player.getItemInHand(InteractionHand.MAIN_HAND).is(PRItemTags.STONE_PICKAXES)) {
            cir.setReturnValue(cir.getReturnValue() / 5F);
        }
    }
}