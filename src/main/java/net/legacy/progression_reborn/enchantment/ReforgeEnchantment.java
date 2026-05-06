package net.legacy.progression_reborn.enchantment;

import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;

import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class ReforgeEnchantment extends Enchantment {

    public ReforgeEnchantment() {
        // DIGGER = pickaxes, shovels, etc.
        super(Rarity.VERY_RARE, EnchantmentCategory.DIGGER, new EquipmentSlot[] {
                EquipmentSlot.MAINHAND
        });
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getMinCost(int level) {
        return 15;
    }

    @Override
    public int getMaxCost(int level) {
        return 65;
    }
}