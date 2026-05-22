package net.legacy.progression_reborn.mixin;

import net.legacy.progression_reborn.enchantment.ModEnchantments;
import net.minecraft.world.inventory.AnvilMenu;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(AnvilMenu.class)
public class AnvilMenuMixin {

    @Inject(method = "createResult", at = @At("TAIL"))
    private void setReforgeCost(CallbackInfo ci) {
        AnvilMenu menu = AnvilMenu.class.cast(this);

        ItemStack result = menu.getSlot(2).getItem();

        if (!result.isEmpty()
                && EnchantmentHelper.getItemEnchantmentLevel(
                ModEnchantments.REFORGE,
                result
        ) > 0) {

            ((AnvilMenuAccessor)(Object)menu)
                    .getCost()
                    .set(8);
        }
    }
}