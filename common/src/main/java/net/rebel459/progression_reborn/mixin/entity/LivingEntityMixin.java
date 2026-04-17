package net.rebel459.progression_reborn.mixin.entity;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.rebel459.progression_reborn.util.CollectionHelper;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(LivingEntity.class)
public abstract class LivingEntityMixin {

    @Inject(method = "onEquipItem", at = @At("HEAD"))
    private void dropCollectionItemsOnRemoval(EquipmentSlot slot, ItemStack oldStack, ItemStack newStack, CallbackInfo ci) {
        LivingEntity entity = LivingEntity.class.cast(this);
        if (!(entity instanceof Player player) || slot != EquipmentSlot.CHEST) return;
        if (oldStack.isEmpty()) return;

        if (!ItemStack.isSameItemSameComponents(oldStack, newStack) || oldStack.getCount() != newStack.getCount()) {
            CollectionHelper.dropAllCollected(player, oldStack);
        }
    }
}
