package net.legacy.progression_reborn.mixin.entity;

import net.legacy.progression_reborn.config.PRConfig;
import net.legacy.progression_reborn.registry.PRItems;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(value = Zombie.class)
public class ZombieMixin {

    @Inject(method = "populateDefaultEquipmentSlots", at = @At(value = "HEAD"), cancellable = true)
    private void selectZombieWeapon(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        if (!PRConfig.get.misc.mob_spawn_equipment) return;
        Mob mob = Mob.class.cast(this);
        LivingEntity livingEntity = LivingEntity.class.cast(this);
        mob.populateDefaultEquipmentSlots(random, difficulty);
        if (random.nextFloat() < (livingEntity.level().getDifficulty() == Difficulty.HARD ? 0.05F : 0.01F)) {
            int i = random.nextInt(3);
            int r = random.nextInt(3);
            if (i == 0) {
                if (r == 0) livingEntity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(PRItems.COPPER_SWORD));
                else livingEntity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SWORD));
            } else {
                if (r == 0) livingEntity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(PRItems.COPPER_SHOVEL));
                else livingEntity.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(Items.IRON_SHOVEL));
            }
        }
        ci.cancel();
    }
}