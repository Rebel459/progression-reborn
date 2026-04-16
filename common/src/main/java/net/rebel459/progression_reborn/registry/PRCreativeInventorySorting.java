package net.rebel459.progression_reborn.registry;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.rebel459.unified.platform.UnifiedHelpers;
import net.rebel459.unified.util.CreativeModeTabs;

public class PRCreativeInventorySorting {

	public static void init() {

		// Combat
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.COMBAT, Items.GOLDEN_BOOTS, PRItems.ROSE_HELMET, PRItems.ROSE_CHESTPLATE, PRItems.ROSE_LEGGINGS,  PRItems.ROSE_BOOTS);
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.COMBAT, Items.GOLDEN_SWORD, PRItems.ROSE_SWORD, PRItems.ROSE_AXE, PRItems.ROSE_SPEAR);
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.COMBAT, Items.GOLDEN_HORSE_ARMOR, PRItems.ROSE_HORSE_ARMOR);
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.COMBAT, Items.GOLDEN_NAUTILUS_ARMOR, PRItems.ROSE_NAUTILUS_ARMOR);

		// Tools and Utilities
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.TOOLS_AND_UTILITIES, Items.GOLDEN_HOE, PRItems.ROSE_SHOVEL, PRItems.ROSE_PICKAXE, PRItems.ROSE_AXE, PRItems.ROSE_HOE);

		// Food and Drinks
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.FOOD_AND_DRINKS, Items.GOLDEN_CARROT, PRItems.ENCHANTED_GOLDEN_CARROT);

		// Ingredients
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.INGREDIENTS, Items.CHARCOAL, PRItems.RAW_COPPER_NUGGET, PRItems.RAW_IRON_NUGGET, PRItems.RAW_GOLD_NUGGET, PRItems.RAW_ROSE_NUGGET);
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.INGREDIENTS, Items.RAW_GOLD, PRItems.RAW_ROSE);
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.INGREDIENTS, Items.GOLD_NUGGET, PRItems.ROSE_NUGGET, PRItems.DIAMOND_SHARD);
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.INGREDIENTS, Items.IRON_INGOT, PRItems.IRON_ALLOY);
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.INGREDIENTS, Items.GOLD_INGOT, PRItems.ROSE_INGOT, PRItems.ROSE_ALLOY);
		UnifiedHelpers.CREATIVE_ENTRIES.insertBefore(CreativeModeTabs.INGREDIENTS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, PRItems.IRON_UPGRADE_SMITHING_TEMPLATE, PRItems.ROSE_UPGRADE_SMITHING_TEMPLATE);

		// Building Blocks
		UnifiedHelpers.CREATIVE_ENTRIES.insertBefore(CreativeModeTabs.BUILDING_BLOCKS, Blocks.COPPER_BLOCK, PRBlocks.COPPER_BLOCK);
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(
				CreativeModeTabs.BUILDING_BLOCKS,
				Blocks.WAXED_OXIDIZED_COPPER_BULB,
				PRBlocks.ROSE_BLOCK,
				PRBlocks.POLISHED_ROSE,
				PRBlocks.POLISHED_CUT_ROSE,
				PRBlocks.POLISHED_CUT_ROSE_STAIRS,
				PRBlocks.POLISHED_CUT_ROSE_SLAB,
				PRBlocks.ROSE_DOOR,
				PRBlocks.ROSE_TRAPDOOR,
				PRBlocks.ROSE_LAMP
		);

		// Natural Blocks
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.NATURAL_BLOCKS, Blocks.NETHER_QUARTZ_ORE, PRBlocks.BLACKSTONE_QUARTZ_ORE);
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.NATURAL_BLOCKS, Blocks.NETHER_GOLD_ORE, PRBlocks.BLACKSTONE_GOLD_ORE, PRBlocks.NETHER_ROSE_ORE, PRBlocks.BLACKSTONE_ROSE_ORE);
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.NATURAL_BLOCKS, Blocks.RAW_GOLD_BLOCK, PRBlocks.RAW_ROSE_BLOCK);

		// Functional Blocks
		UnifiedHelpers.CREATIVE_ENTRIES.insertAfter(CreativeModeTabs.FUNCTIONAL_BLOCKS, Blocks.WAXED_OXIDIZED_COPPER_BULB, PRBlocks.ROSE_LAMP);
	}
}
