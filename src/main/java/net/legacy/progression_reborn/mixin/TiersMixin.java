package net.legacy.progression_reborn.mixin;

import net.minecraft.world.item.Tiers;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Tiers.class)
public abstract class TiersMixin {

    @Inject(method = "getUses", at = @At("HEAD"), cancellable = true)
    private void modifyUses(CallbackInfoReturnable<Integer> cir) {
        Tiers tier = (Tiers) (Object) this;

        if (tier == Tiers.IRON) {
            cir.setReturnValue(510);
        } else if (tier == Tiers.GOLD) {
            cir.setReturnValue(73);
        }
    }
}