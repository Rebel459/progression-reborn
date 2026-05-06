package net.legacy.progression_reborn.registry;

import com.google.common.base.Suppliers;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum PRTiers implements Tier {

    COPPER(BlockTags.NEEDS_STONE_TOOL, 190, 5.0F, 1.0F, 14, 1, () -> Ingredient.of(Items.COPPER_INGOT)),
    ROSE(BlockTags.NEEDS_IRON_TOOL, 281, 10.0F, 2.0F, 22, 2, () -> Ingredient.of(PRItems.ROSE_INGOT));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final int level;
    private final Supplier<Ingredient> repairIngredient;

    private PRTiers(
            TagKey<Block> incorrectBlockForDrops,
            int uses,
            float speed,
            float damage,
            int enchantmentValue,
            int level,
            Supplier<Ingredient> repairIngredient
    ) {
        this.incorrectBlocksForDrops = incorrectBlockForDrops;
        this.uses = uses;
        this.speed = speed;
        this.damage = damage;
        this.enchantmentValue = enchantmentValue;
        this.level = level;
        this.repairIngredient = Suppliers.memoize(repairIngredient::get);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

//    @Override
//    public TagKey<Block> getIncorrectBlocksForDrops() {
//        return this.incorrectBlocksForDrops;
//    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public int getLevel() {
        return this.level;
    }
}