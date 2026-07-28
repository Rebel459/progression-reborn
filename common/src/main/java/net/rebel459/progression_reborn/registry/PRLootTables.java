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
import net.rebel459.unified.platform.UnifiedPlatform;
import net.rebel459.unified.util.LootEntry;
import org.jetbrains.annotations.NotNull;

public class PRLootTables {

    public static void init() {
        UnifiedEvents.LootTables.modify(((table, key, provider) -> {
            LootPool.Builder pool;
            if (!PRConfig.get().misc.loot_table_injects) return;
            if (key == BuiltInLootTables.VILLAGE_WEAPONSMITH || key == BuiltInLootTables.ABANDONED_MINESHAFT || key == createLaL("chests/cabin/underground") || key == createLaL("chests/cabin/deep")) {
                pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(EmptyLootItem.emptyItem().setWeight(2))
                        .add(LootItem.lootTableItem(PRItems.IRON_UPGRADE_SMITHING_TEMPLATE).setWeight(1));
                table.addPool(pool);
            }
            if (key == BuiltInLootTables.NETHER_BRIDGE || key == createLaL("chests/spire")) {
                pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(EmptyLootItem.emptyItem().setWeight(5))
                        .add(LootItem.lootTableItem(PRItems.ROSE_UPGRADE_SMITHING_TEMPLATE).setWeight(1));
                table.addPool(pool);
                pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1F))
                        .add(EmptyLootItem.emptyItem().setWeight(17))
                        .add(LootItem.lootTableItem(PRItems.ENCHANTED_GOLDEN_CARROT).setWeight(1));
                table.addPool(pool);
            }
            if (key == BuiltInLootTables.TRIAL_CHAMBERS_REWARD || key == create("remnants", "chests/remnants/vault")) {
                pool = LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(EmptyLootItem.emptyItem().setWeight(8))
                        .add(LootItem.lootTableItem(PRItems.IRON_UPGRADE_SMITHING_TEMPLATE).setWeight(1));
                table.addPool(pool);
            }
            if (key == BuiltInLootTables.ABANDONED_MINESHAFT) {
                table.editPool(item -> item == Items.IRON_PICKAXE, LootEntry.insert(LootItem.lootTableItem(Items.COPPER_PICKAXE).setWeight(5).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atLeast(1))))));
                table.editPool(item -> item == Items.IRON_PICKAXE, LootEntry.replace(LootItem.lootTableItem(Items.IRON_PICKAXE).setWeight(5).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atMost(0))))));
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.insert(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 5F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atLeast(1))))));
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.replace(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 5F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atMost(0))))));
            }
            if (key == BuiltInLootTables.SIMPLE_DUNGEON) {
                table.editPool(item -> item == Items.COPPER_HORSE_ARMOR, LootEntry.replace(LootItem.lootTableItem(Items.COPPER_HORSE_ARMOR).setWeight(15).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atLeast(1))))));
                table.editPool(item -> item == Items.IRON_HORSE_ARMOR, LootEntry.replace(LootItem.lootTableItem(Items.IRON_HORSE_ARMOR).setWeight(15).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atMost(0))))));
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.insert(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 4F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atLeast(1))))));
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.replace(LootItem.lootTableItem(Items.IRON_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 4F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.atYLocation(MinMaxBounds.Doubles.atMost(0))))));
            }
            if (key == createLaL("chests/dungeon/simple/chest") || key == createLaL("chests/dungeon/arid/chest") || key == createLaL("chests/dungeon/frozen/chest") || key == createLaL("chests/dungeon/verdant/chest")) {
                table.editPool(item -> item == Items.IRON_HORSE_ARMOR, LootEntry.remove());
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.replace(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 4F)))));
            }
            if (key == createLaL("chests/dungeon/deep/chest") || key == createLaL("chests/dungeon/infernal/chest")) {
                table.editPool(item -> item == Items.COPPER_HORSE_ARMOR, LootEntry.remove());
            }
            if (key == BuiltInLootTables.DESERT_PYRAMID) {
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.insert(LootItem.lootTableItem(Items.COPPER_INGOT).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 5F)))));
            }
            if (key == createLaL("chests/spire")) {
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_INGOT).setWeight(3).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 5F)))));
                table.editPool(item -> item == Items.IRON_HORSE_ARMOR, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_HORSE_ARMOR).setWeight(1)));
            }
            if (key == BuiltInLootTables.PIGLIN_BARTERING) {
                table.editPool(item -> item == Items.IRON_BOOTS, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_BOOTS).setWeight(8).apply(new EnchantRandomlyFunction.Builder().withEnchantment(provider.lookup(Registries.ENCHANTMENT).get().getOrThrow(Enchantments.SOUL_SPEED)))));
                table.editPool(item -> item == Items.IRON_NUGGET, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_NUGGET).setWeight(10).apply(SetItemCountFunction.setCount(UniformGenerator.between(9F, 36F)))));
            }
            if (key == BuiltInLootTables.BASTION_BRIDGE) {
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_INGOT).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(3F, 7F)))));
                table.editPool(item -> item == Items.IRON_NUGGET, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_NUGGET).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 6F)))));
            }
            if (key == BuiltInLootTables.BASTION_OTHER) {
                table.editPool(item -> item == Items.IRON_SWORD, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_SWORD).setWeight(2).apply(new EnchantRandomlyFunction.Builder().withOneOf(provider.getOrThrow(EnchantmentTags.ON_RANDOM_LOOT)))));
                table.editPool(item -> item == Items.IRON_NUGGET, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_NUGGET).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 8F)))));
                table.editPool(item -> item == Items.IRON_BLOCK, LootEntry.replace(LootItem.lootTableItem(PRBlocks.ROSE_BLOCK).setWeight(2).apply(SetItemCountFunction.setCount(ConstantValue.exactly(1F), false))));
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_INGOT).setWeight(2).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 6F)))));
            }
            if (key == BuiltInLootTables.BASTION_TREASURE) {
                table.editPool(item -> item == Items.IRON_BLOCK, LootEntry.replace(LootItem.lootTableItem(PRBlocks.ROSE_BLOCK).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 4F)))));
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_INGOT).setWeight(1).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 8F)))));
                pool = LootPool.lootPool().setRolls(UniformGenerator.between(0F, 1F))
                        .add(LootItem.lootTableItem(Items.BOOK).apply(EnchantRandomlyFunction.randomEnchantment().withEnchantment(provider.lookup(Registries.ENCHANTMENT).get().getOrThrow(PREnchantments.REFORGE))));
                table.addPool(pool);
                table.editPool(item -> item == Items.ENCHANTED_GOLDEN_APPLE, LootEntry.replace(LootItem.lootTableItem(PRItems.ENCHANTED_GOLDEN_CARROT).setWeight(2)));
            }
            if (key == BuiltInLootTables.NETHER_BRIDGE) {
                table.editPool(item -> item == Items.IRON_HORSE_ARMOR, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_HORSE_ARMOR).setWeight(5)));
                table.editPool(item -> item == Items.IRON_INGOT, LootEntry.replace(LootItem.lootTableItem(PRItems.ROSE_INGOT).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(1F, 5F)))));
            }
            if (key == BuiltInLootTables.RUINED_PORTAL) {
                table.editPool(item -> item == Items.IRON_NUGGET, LootEntry.insert(LootItem.lootTableItem(PRItems.ROSE_NUGGET).setWeight(40).apply(SetItemCountFunction.setCount(UniformGenerator.between(9F, 18F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.inDimension(Level.NETHER)))));
                table.editPool(item -> item == Items.IRON_NUGGET, LootEntry.replace(LootItem.lootTableItem(Items.IRON_NUGGET).setWeight(40).apply(SetItemCountFunction.setCount(UniformGenerator.between(9F, 18F))).when(LocationCheck.checkLocation(LocationPredicate.Builder.inDimension(Level.OVERWORLD)))));
                table.editPool(item -> item == Items.ENCHANTED_GOLDEN_APPLE, LootEntry.replace(LootItem.lootTableItem(PRItems.ENCHANTED_GOLDEN_CARROT).setWeight(1)));
            }
            if (key == BuiltInLootTables.END_CITY_TREASURE && !UnifiedPlatform.isModLoaded("enderscape")) {
                table.editPool(item -> item == Items.DIAMOND, LootEntry.replace(LootItem.lootTableItem(Items.DIAMOND).setWeight(5).apply(SetItemCountFunction.setCount(UniformGenerator.between(2F, 5F)))));
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
