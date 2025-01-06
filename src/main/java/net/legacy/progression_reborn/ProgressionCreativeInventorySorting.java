package net.legacy.progression_reborn;

import net.frozenblock.lib.item.api.FrozenCreativeTabs;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;

public class ProgressionCreativeInventorySorting {

	public static void init() {
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_FAR, ProgressionItems.MUSIC_DISC_SVALL);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_11, ProgressionItems.MUSIC_DISC_TASWELL);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_OTHERSIDE, ProgressionItems.MUSIC_DISC_SHULKER);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_CREATOR_MUSIC_BOX, ProgressionItems.MUSIC_DISC_TUNDRA);
		addAfterInToolsAndUtilities(Items.MUSIC_DISC_RELIC, ProgressionItems.MUSIC_DISC_FAR_LANDS);

		addAfterInToolsAndUtilities(Items.MILK_BUCKET, ProgressionItems.WOODEN_BUCKET);
		addAfterInToolsAndUtilities(ProgressionItems.WOODEN_BUCKET, ProgressionItems.COAL_BUCKET);
		addAfterInToolsAndUtilities(ProgressionItems.COAL_BUCKET, ProgressionItems.CHARCOAL_BUCKET);

		addAfterInIngredients(Items.HEART_OF_THE_SEA, ProgressionItems.METAL_CHUNK);
		addAfterInIngredients(ProgressionItems.METAL_CHUNK, ProgressionItems.DISC_FRAGMENT_FAR_LANDS);

		addAfterInFoodAndDrinks(Items.BEETROOT, ProgressionItems.ENCHANTED_BEETROOT);
		addAfterInFoodAndDrinks(Items.BEETROOT_SOUP, ProgressionItems.ENCHANTED_BEETROOT_SOUP);

		addAfterInCombat(Items.NETHERITE_AXE, ProgressionGearItems.ANCIENT_KNIFE);
		addAfterInCombat(ProgressionGearItems.ANCIENT_KNIFE, ProgressionGearItems.HOOK);

		addAfterInCombat(Items.NETHERITE_BOOTS, ProgressionGearItems.DUNGEON_HELMET);
		addAfterInCombat(ProgressionGearItems.DUNGEON_HELMET, ProgressionGearItems.DUNGEON_CHESTPLATE);
		addAfterInCombat(ProgressionGearItems.DUNGEON_CHESTPLATE, ProgressionGearItems.DUNGEON_LEGGINGS);
		addAfterInCombat(ProgressionGearItems.DUNGEON_LEGGINGS, ProgressionGearItems.DUNGEON_BOOTS);

		addAfterInCombat(ProgressionGearItems.DUNGEON_BOOTS, ProgressionGearItems.FORTRESS_HELMET);
		addAfterInCombat(ProgressionGearItems.FORTRESS_HELMET, ProgressionGearItems.FORTRESS_CHESTPLATE);
		addAfterInCombat(ProgressionGearItems.FORTRESS_CHESTPLATE, ProgressionGearItems.FORTRESS_LEGGINGS);
		addAfterInCombat(ProgressionGearItems.FORTRESS_LEGGINGS, ProgressionGearItems.FORTRESS_BOOTS);

		addAfterInCombat(ProgressionGearItems.FORTRESS_BOOTS, ProgressionGearItems.WARD_HELMET);
		addAfterInCombat(ProgressionGearItems.WARD_HELMET, ProgressionGearItems.WARD_CHESTPLATE);
		addAfterInCombat(ProgressionGearItems.WARD_CHESTPLATE, ProgressionGearItems.WARD_LEGGINGS);
		addAfterInCombat(ProgressionGearItems.WARD_LEGGINGS, ProgressionGearItems.WARD_BOOTS);

		addAfterInBuildingBlocks(Blocks.END_STONE_BRICKS, ProgressionBlocks.CRACKED_END_STONE_BRICKS);
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
