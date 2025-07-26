package net.legacy.progression_reborn.registry;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

public class PRCreativeInventorySorting {

	public static void init() {

		// Combat
		addAfterInCombat(Items.CHAINMAIL_BOOTS, PRItems.COPPER_HELMET);
		addAfterInCombat(PRItems.COPPER_HELMET, PRItems.COPPER_CHESTPLATE);
		addAfterInCombat(PRItems.COPPER_CHESTPLATE, PRItems.COPPER_LEGGINGS);
		addAfterInCombat(PRItems.COPPER_LEGGINGS, PRItems.COPPER_BOOTS);

		addAfterInCombat(Items.GOLDEN_BOOTS, PRItems.ROSE_HELMET);
		addAfterInCombat(PRItems.ROSE_HELMET, PRItems.ROSE_CHESTPLATE);
		addAfterInCombat(PRItems.ROSE_CHESTPLATE, PRItems.ROSE_LEGGINGS);
		addAfterInCombat(PRItems.ROSE_LEGGINGS, PRItems.ROSE_BOOTS);

		addAfterInCombat(Items.STONE_SWORD, PRItems.COPPER_SWORD); // shovel pickaxe axe hoe
		addAfterInCombat(Items.STONE_AXE, PRItems.COPPER_AXE);

		addAfterInCombat(Items.GOLDEN_SWORD, PRItems.ROSE_SWORD);
		addAfterInCombat(Items.GOLDEN_AXE, PRItems.ROSE_AXE);

		addAfterInCombat(Items.LEATHER_HORSE_ARMOR, PRItems.COPPER_HORSE_ARMOR);
		addAfterInCombat(Items.GOLDEN_HORSE_ARMOR, PRItems.ROSE_HORSE_ARMOR);
		addAfterInCombat(Items.DIAMOND_HORSE_ARMOR, PRItems.NETHERITE_HORSE_ARMOR);

		// Tools and Utilities
		addAfterInToolsAndUtilities(Items.STONE_HOE, PRItems.COPPER_SHOVEL);
		addAfterInToolsAndUtilities(PRItems.COPPER_SHOVEL, PRItems.COPPER_PICKAXE);
		addAfterInToolsAndUtilities(PRItems.COPPER_PICKAXE, PRItems.COPPER_AXE);
		addAfterInToolsAndUtilities(PRItems.COPPER_AXE, PRItems.COPPER_HOE);

		addAfterInToolsAndUtilities(Items.GOLDEN_HOE, PRItems.ROSE_SHOVEL);
		addAfterInToolsAndUtilities(PRItems.ROSE_SHOVEL, PRItems.ROSE_PICKAXE);
		addAfterInToolsAndUtilities(PRItems.ROSE_PICKAXE, PRItems.ROSE_AXE);
		addAfterInToolsAndUtilities(PRItems.ROSE_AXE, PRItems.ROSE_HOE);

		// Food and Drinks
		addAfterInFoodAndDrinks(Items.GOLDEN_CARROT, PRItems.ENCHANTED_GOLDEN_CARROT);

		// Ingredients
		addAfterInIngredients(Items.CHARCOAL, PRItems.RAW_IRON_NUGGET);
		addAfterInIngredients(PRItems.RAW_IRON_NUGGET, PRItems.RAW_COPPER_NUGGET);
		addAfterInIngredients(PRItems.RAW_COPPER_NUGGET, PRItems.RAW_GOLD_NUGGET);
		addAfterInIngredients(PRItems.RAW_GOLD_NUGGET, PRItems.RAW_ROSE_NUGGET);

		addAfterInIngredients(Items.RAW_GOLD, PRItems.RAW_ROSE);

		addAfterInIngredients(Items.IRON_NUGGET, PRItems.COPPER_NUGGET);
		addAfterInIngredients(Items.GOLD_NUGGET, PRItems.ROSE_NUGGET);
		addAfterInIngredients(PRItems.ROSE_NUGGET, PRItems.DIAMOND_NUGGET);

		addAfterInIngredients(Items.IRON_INGOT, PRItems.IRON_ALLOY);
		addAfterInIngredients(Items.GOLD_INGOT, PRItems.ROSE_INGOT);
		addAfterInIngredients(PRItems.ROSE_INGOT, PRItems.ROSE_ALLOY);

		addBeforeInIngredients(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, PRItems.IRON_UPGRADE_SMITHING_TEMPLATE);
		addAfterInIngredients(PRItems.IRON_UPGRADE_SMITHING_TEMPLATE, PRItems.ROSE_UPGRADE_SMITHING_TEMPLATE);

		// Building Blocks
		addBeforeInBuildingBlocks(Blocks.COPPER_BLOCK, PRBlocks.COPPER_BLOCK);

		addAfterInBuildingBlocks(Blocks.WAXED_OXIDIZED_COPPER_BULB, PRBlocks.ROSE_BLOCK);
		addAfterInBuildingBlocks(PRBlocks.ROSE_BLOCK, PRBlocks.POLISHED_ROSE);
		addAfterInBuildingBlocks(PRBlocks.POLISHED_ROSE, PRBlocks.POLISHED_CUT_ROSE);
		addAfterInBuildingBlocks(PRBlocks.POLISHED_CUT_ROSE, PRBlocks.POLISHED_CUT_ROSE_STAIRS);
		addAfterInBuildingBlocks(PRBlocks.POLISHED_CUT_ROSE_STAIRS, PRBlocks.POLISHED_CUT_ROSE_SLAB);
		addAfterInBuildingBlocks(PRBlocks.POLISHED_CUT_ROSE_SLAB, PRBlocks.ROSE_DOOR);
		addAfterInBuildingBlocks(PRBlocks.ROSE_DOOR, PRBlocks.ROSE_TRAPDOOR);
		addAfterInBuildingBlocks(PRBlocks.ROSE_TRAPDOOR, PRBlocks.ROSE_LAMP);

		// Natural Blocks
		addAfterInNaturalBlocks(Blocks.NETHER_QUARTZ_ORE, PRBlocks.BLACKSTONE_QUARTZ_ORE);
		addAfterInNaturalBlocks(Blocks.NETHER_GOLD_ORE, PRBlocks.BLACKSTONE_GOLD_ORE);
		addAfterInNaturalBlocks(PRBlocks.BLACKSTONE_GOLD_ORE, PRBlocks.NETHER_ROSE_ORE);
		addAfterInNaturalBlocks(PRBlocks.NETHER_ROSE_ORE, PRBlocks.BLACKSTONE_ROSE_ORE);

		addAfterInNaturalBlocks(Blocks.RAW_GOLD_BLOCK, PRBlocks.RAW_ROSE_BLOCK);

		// Functional Blocks
		addAfterInFunctionalBlocks(Blocks.WAXED_OXIDIZED_COPPER_BULB, PRBlocks.ROSE_LAMP);
	}

	private static void addAfterInNaturalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.NATURAL_BLOCKS);
	}

	private static void addBeforeInBuildingBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS);
	}

	private static void addAfterInBuildingBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.BUILDING_BLOCKS);
	}

	private static void addAfterInRedstone(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.REDSTONE_BLOCKS);
	}

	private static void addAfterInFunctionalBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.FUNCTIONAL_BLOCKS);
	}

	private static void addBeforeInRedstoneBlocks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.REDSTONE_BLOCKS);
	}

	private static void addInToolsAndUtilities(ItemLike item) {
		FrozenCreativeTabs.add(item, CreativeModeTabs.TOOLS_AND_UTILITIES);
	}

	private static void addAfterInToolsAndUtilities(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.TOOLS_AND_UTILITIES);
	}

	private static void addBeforeInIngredients(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.INGREDIENTS);
	}

	private static void addAfterInIngredients(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.INGREDIENTS);
	}

	private static void addBeforeInFoodAndDrinks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.FOOD_AND_DRINKS);
	}

	private static void addAfterInFoodAndDrinks(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.FOOD_AND_DRINKS);
	}

	private static void addAfterInCombat(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.COMBAT);
	}

	private static void addBeforeInSpawnEggs(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addBefore(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
	}

	private static void addAfterInSpawnEggs(ItemLike comparedItem, ItemLike item) {
		FrozenCreativeTabs.addAfter(comparedItem, item, CreativeModeTabs.SPAWN_EGGS);
	}
}
