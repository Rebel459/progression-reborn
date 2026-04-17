package net.rebel459.progression_reborn.mixin.integration.item_tooltips;

import net.rebel459.item_tooltips.util.ScreenHelper;
import net.rebel459.progression_reborn.client.StoredItemsTooltip;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = StoredItemsTooltip.class)
public class StoredItemTooltipsMixin {

    @Inject(method = "hasKeyDown", at = @At(value = "HEAD"), cancellable = true)
    private static void hasConfiguredKeyDown(CallbackInfoReturnable<Boolean> cir) {
        cir.setReturnValue(ScreenHelper.Tooltip.hasKeyDown());
    }
}