package net.rebel459.progression_reborn.mixin.entity;

import net.rebel459.progression_reborn.config.PRConfig;
import net.rebel459.progression_reborn.registry.PRItems;
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
        if (!PRConfig.get().misc.mob_spawn_equipment) return;
        Piglin piglin = Piglin.class.cast(this);
        int i = random.nextInt(5);
        if (piglin.isAdult() && i == 0) {
            piglin.maybeWearArmor(EquipmentSlot.HEAD, PRItems.ROSE_HELMET.getDefaultInstance(), random);
            piglin.maybeWearArmor(EquipmentSlot.CHEST, PRItems.ROSE_CHESTPLATE.getDefaultInstance(), random);
            piglin.maybeWearArmor(EquipmentSlot.LEGS, PRItems.ROSE_LEGGINGS.getDefaultInstance(), random);
            piglin.maybeWearArmor(EquipmentSlot.FEET, PRItems.ROSE_BOOTS.getDefaultInstance(), random);
        }
        else if (piglin.isAdult()) {
            piglin.maybeWearArmor(EquipmentSlot.HEAD, Items.GOLDEN_HELMET.getDefaultInstance(), random);
            piglin.maybeWearArmor(EquipmentSlot.CHEST, Items.GOLDEN_CHESTPLATE.getDefaultInstance(), random);
            piglin.maybeWearArmor(EquipmentSlot.LEGS, Items.GOLDEN_LEGGINGS.getDefaultInstance(), random);
            piglin.maybeWearArmor(EquipmentSlot.FEET, Items.GOLDEN_BOOTS.getDefaultInstance(), random);
        }
        ci.cancel();
    }

    @Inject(method = "createSpawnWeapon", at = @At(value = "TAIL"), cancellable = true)
    private void selectPiglinWeapon(CallbackInfoReturnable<ItemStack> cir) {
        if (!PRConfig.get().misc.mob_spawn_equipment) return;
        if (cir.getReturnValue().getItem() == Items.GOLDEN_SWORD && new Random().nextInt(5) == 0) cir.setReturnValue(PRItems.ROSE_SWORD.getDefaultInstance());
        if (cir.getReturnValue().getItem() == Items.GOLDEN_SPEAR && new Random().nextInt(5) == 0) cir.setReturnValue(PRItems.ROSE_SPEAR.getDefaultInstance());
    }
}