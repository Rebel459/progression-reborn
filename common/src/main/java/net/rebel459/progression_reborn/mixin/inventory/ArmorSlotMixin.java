package net.rebel459.progression_reborn.mixin.inventory;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.rebel459.progression_reborn.util.CollectionHelper;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(targets = "net.minecraft.world.inventory.ArmorSlot")
public abstract class ArmorSlotMixin {

    @Shadow @Final private LivingEntity owner;
    @Shadow @Final private EquipmentSlot slot;

    @Inject(method = "setByPlayer(Lnet/minecraft/world/item/ItemStack;Lnet/minecraft/world/item/ItemStack;)V", at = @At("HEAD"))
    private void dropCollectionItemsOnUnequip(ItemStack itemStack, ItemStack previous, CallbackInfo ci) {
        if (this.slot != EquipmentSlot.CHEST || previous.isEmpty() || ItemStack.isSameItemSameComponents(previous, itemStack)) {
            return;
        }

        if (this.owner instanceof Player player) {
            CollectionHelper.dropAllCollected(player, previous);
        }
    }
}
