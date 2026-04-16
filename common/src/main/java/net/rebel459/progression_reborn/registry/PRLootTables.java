package net.rebel459.progression_reborn.registry;

import net.minecraft.advancements.criterion.LocationPredicate;
import net.minecraft.advancements.criterion.MinMaxBounds;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.storage.loot.BuiltInLootTables;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.EmptyLootItem;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.EnchantRandomlyFunction;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LocationCheck;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.rebel459.progression_reborn.config.PRConfig;
import net.rebel459.unified.platform.UnifiedEvents;
import org.jetbrains.annotations.NotNull;

public class PRLootTables {

    public static void init() {
        UnifiedEvents.LootTables.modify(((table, key, provider) -> {
            if (!PRConfig.get().misc.loot_table_injects) return;
            if (key == BuiltInLootTables.VILLAGE_WEAPONSMITH || key == BuiltInLootTables.ABANDONED_MINESHAFT || key == createLaL("chests/cabin/underground") || key == createLaL("chests/cabin/deep")) {
                LootPool.Builder pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(EmptyLootItem.emptyItem().setWeight(2))
                        .add(LootItem.lootTableItem(PRItems.IRON_UPGRADE_SMITHING_TEMPLATE).setWeight(1));
                table.addPool(pool);
            }
            if (key == BuiltInLootTables.NETHER_BRIDGE || key == createLaL("chests/spire")) {
                LootPool.Builder pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(EmptyLootItem.emptyItem().setWeight(5))
                        .add(LootItem.lootTableItem(PRItems.ROSE_UPGRADE_SMITHING_TEMPLATE).setWeight(1));
                table.addPool(pool);
            }
            if (key == BuiltInLootTables.TRIAL_CHAMBERS_REWARD || key == create("remnants", "chests/remnants/vault")) {
                LootPool.Builder pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(EmptyLootItem.emptyItem().setWeight(8))
                        .add(LootItem.lootTableItem(PRItems.IRON_UPGRADE_SMITHING_TEMPLATE).setWeight(1));
                table.addPool(pool);
            }
            if (key == BuiltInLootTables.ABANDONED_MINESHAFT) {
                table.editPool(item -> item == Items.IRON_PICKAXE, LootItem.lootTableItem(Items.COPPER_PICKAXE).setWeight(5).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atLeast(1)))), false);
                table.editPool(item -> item == Items.IRON_PICKAXE, LootItem.lootTableItem(Items.IRON_PICKAXE).setWeight(5).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atMost(0)))), true);
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 5F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atLeast(1)))), false);
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(Items.IRON_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 5F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atMost(0)))), true);
            }
            if (key == BuiltInLootTables.SIMPLE_DUNGEON) {
                table.editPool(item -> item == Items.COPPER_HORSE_ARMOR, LootItem.lootTableItem(Items.COPPER_HORSE_ARMOR).setWeight(15).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atLeast(1)))), true);
                table.editPool(item -> item == Items.IRON_HORSE_ARMOR, LootItem.lootTableItem(Items.IRON_HORSE_ARMOR).setWeight(15).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atMost(0)))), true);
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 4F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atLeast(1)))), false);
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(Items.IRON_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 4F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atMost(0)))), true);
            }
            if (key == createLaL("chests/dungeon/simple/chest") || key == createLaL("chests/dungeon/arid/chest") || key == createLaL("chests/dungeon/frozen/chest") || key == createLaL("chests/dungeon/verdant/chest")) {
                table.editPool(item -> item == Items.IRON_HORSE_ARMOR, EmptyLootItem.emptyItem(), true);
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 4F))), true);
            }
            if (key == createLaL("chests/dungeon/deep/chest") || key == createLaL("chests/dungeon/infernal/chest")) {
                table.editPool(item -> item == Items.COPPER_HORSE_ARMOR, EmptyLootItem.emptyItem(), true);
            }
            if (key == BuiltInLootTables.DESERT_PYRAMID) {
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 5F))), false);
            }
            if (key == createLaL("chests/spire")) {
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(PRItems.ROSE_INGOT).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 5F))), true);
                table.editPool(item -> item == Items.IRON_HORSE_ARMOR, LootItem.lootTableItem(PRItems.ROSE_HORSE_ARMOR).setWeight(1), true);
            }
            if (key == BuiltInLootTables.PIGLIN_BARTERING) {
                table.editPool(item -> item == Items.IRON_BOOTS, LootItem.lootTableItem(PRItems.ROSE_BOOTS).setWeight(8).apply(new EnchantRandomlyFunction.Builder().withEnchantment(provider.lookup(Registries.ENCHANTMENT).get().getOrThrow(Enchantments.SOUL_SPEED))), true);
                table.editPool(item -> item == Items.IRON_NUGGET, LootItem.lootTableItem(PRItems.ROSE_NUGGET).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(10F, 36F))), true);
            }
            if (key == BuiltInLootTables.BASTION_BRIDGE) {
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(PRItems.ROSE_INGOT).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(4F, 9F))), true);
                table.editPool(item -> item == Items.IRON_NUGGET, LootItem.lootTableItem(PRItems.ROSE_NUGGET).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 6F))), true);
            }
            if (key == BuiltInLootTables.BASTION_OTHER) {
                table.editPool(item -> item == Items.IRON_SWORD, LootItem.lootTableItem(PRItems.ROSE_SWORD).setWeight(2).apply(new EnchantRandomlyFunction.Builder().withOneOf(provider.getOrThrow(EnchantmentTags.ON_RANDOM_LOOT))), true);
                table.editPool(item -> item == Items.IRON_NUGGET, LootItem.lootTableItem(PRItems.ROSE_NUGGET).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 8F))), true);
                table.editPool(item -> item == Items.IRON_BLOCK, LootItem.lootTableItem(PRBlocks.ROSE_BLOCK).setWeight(2).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1F), false)), true);
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(PRItems.ROSE_INGOT).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 6F))), true);
            }
            if (key == BuiltInLootTables.BASTION_TREASURE) {
                table.editPool(item -> item == Items.IRON_BLOCK, LootItem.lootTableItem(PRBlocks.ROSE_BLOCK).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 5F))), true);
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(PRItems.ROSE_INGOT).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(3F, 9F))), true);
            }
            if (key == BuiltInLootTables.NETHER_BRIDGE) {
                table.editPool(item -> item == Items.IRON_HORSE_ARMOR, LootItem.lootTableItem(PRItems.ROSE_HORSE_ARMOR).setWeight(5), true);
                table.editPool(item -> item == Items.IRON_INGOT, LootItem.lootTableItem(PRItems.ROSE_INGOT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 5F))), true);
            }
            if (key == BuiltInLootTables.RUINED_PORTAL) {
                table.editPool(item -> item == Items.IRON_NUGGET, LootItem.lootTableItem(PRItems.ROSE_NUGGET).setWeight(40).apply(SetItemCountFunction.setCount(UniformGenerator.between(9F, 18F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.inDimension(Level.NETHER))), false);
                table.editPool(item -> item == Items.IRON_NUGGET, LootItem.lootTableItem(Items.IRON_NUGGET).setWeight(40).apply(SetItemCountFunction.setCount(UniformGenerator.between(9F, 18F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.inDimension(Level.OVERWORLD))), true);
            }
            if (key == BuiltInLootTables.END_CITY_TREASURE) {
                table.editPool(item -> item == Items.DIAMOND, LootItem.lootTableItem(Items.DIAMOND).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 5F))), true);
            }
        }));
    }

    private static @NotNull ResourceKey<LootTable> create(String namespace, String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath(namespace, path));
    }

    private static @NotNull ResourceKey<LootTable> createLaL(String path) {
        return ResourceKey.create(Registries.LOOT_TABLE, Identifier.fromNamespaceAndPath("legacies_and_legends", path));
    }
}
