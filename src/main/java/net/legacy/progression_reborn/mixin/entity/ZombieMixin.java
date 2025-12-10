package net.legacy.progression_reborn.mixin.entity;

import net.legacy.progression_reborn.config.PRConfig;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.monster.zombie.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Zombie.class)
public class ZombieMixin {

    @Inject(method = "populateDefaultEquipmentSlots", at = @At(value = "TAIL"))
    private void selectZombieWeapon(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        if (!PRConfig.get.misc.mob_spawn_equipment) return;
        LivingEntity livingEntity = LivingEntity.class.cast(this);
        int r = random.nextInt(3);
        if (r == 0 && livingEntity.getItemBySlot(EquipmentSlot.MAINHAND).is(Items.IRON_SWORD))
            livingEntity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.COPPER_SWORD));
        else if (r == 0 && livingEntity.getItemBySlot(EquipmentSlot.MAINHAND).is(Items.IRON_SHOVEL))
            livingEntity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.COPPER_SHOVEL));
        else if (r == 0 && livingEntity.getItemBySlot(EquipmentSlot.MAINHAND).is(Items.IRON_SPEAR))
            livingEntity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.COPPER_SPEAR));
    }
}