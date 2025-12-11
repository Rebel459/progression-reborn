package net.legacy.progression_reborn.mixin.entity;

import net.legacy.progression_reborn.config.PRConfig;
import net.legacy.progression_reborn.registry.PRItems;
import net.minecraft.util.RandomSource;
import net.minecraft.world.Difficulty;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.Iterator;

import static net.minecraft.world.entity.Mob.getEquipmentForSlot;

@Mixin(value = Mob.class)
public class MobMixin {

    @Inject(method = "populateDefaultEquipmentSlots", at = @At(value = "HEAD"), cancellable = true)
    private void selectMobArmor(RandomSource random, DifficultyInstance difficulty, CallbackInfo ci) {
        LivingEntity livingEntity = LivingEntity.class.cast(this);
        if (!PRConfig.get.misc.mob_spawn_equipment || livingEntity.level().dimension() != Level.NETHER) return;
        if (random.nextFloat() < 0.15F * difficulty.getSpecialMultiplier()) {
            int i = random.nextInt(3);

            for(int j = 1; (float)j <= 3.0F; ++j) {
                if (random.nextFloat() < 0.1087F) {
                    ++i;
                }
            }

            float f = livingEntity.level().getDifficulty() == Difficulty.HARD ? 0.1F : 0.25F;
            boolean bl = true;

            for(EquipmentSlot equipmentSlot : Mob.EQUIPMENT_POPULATION_ORDER) {
                ItemStack itemStack = livingEntity.getItemBySlot(equipmentSlot);
                if (!bl && random.nextFloat() < f) {
                    break;
                }

                bl = false;
                if (itemStack.isEmpty()) {
                    i = i - 1;
                    Item item = getEquipmentForSlotNether(equipmentSlot, i);
                    if (item != null) livingEntity.setItemSlot(equipmentSlot, new ItemStack(item));
                }
            }
        }
        ci.cancel();
    }

    @Unique
    @Nullable
    private static Item getEquipmentForSlotNether(EquipmentSlot slot, int chance) {
        switch (slot) {
            case HEAD:
                if (chance == 0) {
                    return Items.LEATHER_HELMET;
                } else if (chance == 1) {
                    return Items.GOLDEN_HELMET;
                }  else if (chance == 2) {
                    return Items.CHAINMAIL_HELMET;
                } else if (chance == 3) {
                    return PRItems.ROSE_HELMET;
                } else if (chance == 4) {
                    return Items.DIAMOND_HELMET;
                }
            case CHEST:
                if (chance == 0) {
                    return Items.LEATHER_CHESTPLATE;
                } else if (chance == 1) {
                    return Items.GOLDEN_CHESTPLATE;
                }  else if (chance == 2) {
                    return Items.CHAINMAIL_CHESTPLATE;
                } else if (chance == 3) {
                    return PRItems.ROSE_CHESTPLATE;
                } else if (chance == 4) {
                    return Items.DIAMOND_CHESTPLATE;
                }
            case LEGS:
                if (chance == 0) {
                    return Items.LEATHER_LEGGINGS;
                } else if (chance == 1) {
                    return Items.GOLDEN_LEGGINGS;
                }  else if (chance == 2) {
                    return Items.CHAINMAIL_LEGGINGS;
                } else if (chance == 3) {
                    return PRItems.ROSE_LEGGINGS;
                } else if (chance == 4) {
                    return Items.DIAMOND_LEGGINGS;
                }
            case FEET:
                if (chance == 0) {
                    return Items.LEATHER_BOOTS;
                } else if (chance == 1) {
                    return Items.GOLDEN_BOOTS;
                }  else if (chance == 2) {
                    return Items.CHAINMAIL_BOOTS;
                } else if (chance == 3) {
                    return PRItems.ROSE_BOOTS;
                } else if (chance == 4) {
                    return Items.DIAMOND_BOOTS;
                }
            default:
                return null;
        }
    }
}