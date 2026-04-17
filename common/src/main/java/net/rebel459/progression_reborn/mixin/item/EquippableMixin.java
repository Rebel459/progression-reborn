package net.rebel459.progression_reborn.mixin.item;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.equipment.Equippable;
import net.rebel459.progression_reborn.util.CollectionHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(Equippable.class)
public class EquippableMixin {

    @Inject(method = "swapWithEquipmentSlot", at = @At("HEAD"))
    private void dropCollectionItemsBeforeEquipSwap(ItemStack inHand, Player player, CallbackInfoReturnable<?> cir) {
        Equippable equippable = Equippable.class.cast(this);
        if (equippable.slot() != EquipmentSlot.CHEST) return;

        ItemStack equippedChest = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!equippedChest.isEmpty() && !ItemStack.isSameItemSameComponents(inHand, equippedChest)) {
            CollectionHelper.dropAllCollected(player, equippedChest);
        }
    }
}
