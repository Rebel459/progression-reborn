package net.legacy.progression_reborn.mixin.item;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = ItemStack.class)
public class ItemStackMixin {

    @Inject(method = "getMaxDamage", at = @At(value = "TAIL"), cancellable = true)
    private void durableShields(CallbackInfoReturnable<Integer> cir) {
        ItemStack stack = ItemStack.class.cast(this);
        if (stack.is(Items.SHIELD) && cir.getReturnValue() == 336) {
            cir.setReturnValue(504);
        }
    }
}