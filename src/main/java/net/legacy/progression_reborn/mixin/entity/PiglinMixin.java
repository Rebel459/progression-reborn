package net.legacy.progression_reborn.mixin.entity;

import net.legacy.progression_reborn.config.PRConfig;
import net.legacy.progression_reborn.registry.PRItems;
import net.minecraft.util.RandomSource;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.piglin.Piglin;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Random;

@Mixin(value = Piglin.class)
public class PiglinMixin {

    @Inject(method = "populateDefaultEquipmentSlots", at = @At(value = "HEAD"), cancellable = true)
    private void selectPiglinArmor(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        if (!PRConfig.get.misc.mob_spawn_equipment) return;
        Piglin piglin = Piglin.class.cast(this);
        int i = random.nextInt(5);
        if (piglin.isAdult() && i == 0) {
            piglin.maybeWearArmor(EquipmentSlot.HEAD, new ItemStack(PRItems.ROSE_HELMET), random);
            piglin.maybeWearArmor(EquipmentSlot.CHEST, new ItemStack(PRItems.ROSE_CHESTPLATE), random);
            piglin.maybeWearArmor(EquipmentSlot.LEGS, new ItemStack(PRItems.ROSE_LEGGINGS), random);
            piglin.maybeWearArmor(EquipmentSlot.FEET, new ItemStack(PRItems.ROSE_BOOTS), random);
        }
        else if (piglin.isAdult()) {
            piglin.maybeWearArmor(EquipmentSlot.HEAD, new ItemStack(Items.GOLDEN_HELMET), random);
            piglin.maybeWearArmor(EquipmentSlot.CHEST, new ItemStack(Items.GOLDEN_CHESTPLATE), random);
            piglin.maybeWearArmor(EquipmentSlot.LEGS, new ItemStack(Items.GOLDEN_LEGGINGS), random);
            piglin.maybeWearArmor(EquipmentSlot.FEET, new ItemStack(Items.GOLDEN_BOOTS), random);
        }
        ci.cancel();
    }

    @Inject(method = "createSpawnWeapon", at = @At(value = "TAIL"), cancellable = true)
    private void selectPiglinWeapon(CallbackInfoReturnable<ItemStack> cir) {
        if (!PRConfig.get.misc.mob_spawn_equipment) return;
        if (cir.getReturnValue() == Items.GOLDEN_SWORD.getDefaultInstance() && new Random().nextInt(5) == 0) cir.setReturnValue(new ItemStack(PRItems.ROSE_SWORD));
        if (cir.getReturnValue() == Items.GOLDEN_SPEAR.getDefaultInstance() && new Random().nextInt(5) == 0) cir.setReturnValue(new ItemStack(PRItems.ROSE_SPEAR));
    }
}