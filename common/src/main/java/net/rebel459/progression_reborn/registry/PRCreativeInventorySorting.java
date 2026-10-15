package net.rebel459.progression_reborn.registry;

import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.unified.api.registry.CreativeModeTabIds;

public class PRCreativeInventorySorting {

	public static void init() {
		
		var entries = ProgressionReborn.DATA.helpers().creativeEntries().create("progression_reborn_additions");
		var enderscapeEntries = ProgressionReborn.ENDERSCAPE_DATA.helpers().creativeEntries().create("enderscape_additions");

		// Combat
		entries.insertAfter(CreativeModeTabIds.COMBAT, Items.GOLDEN_BOOTS, PRItems.ROSE_HELMET, PRItems.ROSE_CHESTPLATE, PRItems.ROSE_LEGGINGS,  PRItems.ROSE_BOOTS);
		entries.insertAfter(CreativeModeTabIds.COMBAT, Items.GOLDEN_SWORD, PRItems.ROSE_SWORD);
		entries.insertAfter(CreativeModeTabIds.COMBAT, Items.GOLDEN_AXE, PRItems.ROSE_AXE);
		entries.insertAfter(CreativeModeTabIds.COMBAT, Items.GOLDEN_SPEAR, PRItems.ROSE_SPEAR);
		entries.insertAfter(CreativeModeTabIds.COMBAT, Items.GOLDEN_HORSE_ARMOR, PRItems.ROSE_HORSE_ARMOR);
		entries.insertAfter(CreativeModeTabIds.COMBAT, Items.GOLDEN_NAUTILUS_ARMOR, PRItems.ROSE_NAUTILUS_ARMOR);

		// Tools and Utilities
		entries.insertAfter(CreativeModeTabIds.TOOLS_AND_UTILITIES, Items.GOLDEN_HOE, PRItems.ROSE_SHOVEL, PRItems.ROSE_PICKAXE, PRItems.ROSE_AXE, PRItems.ROSE_HOE);

		// Food and Drinks
		entries.insertAfter(CreativeModeTabIds.FOOD_AND_DRINKS, Items.GOLDEN_CARROT, PRItems.ENCHANTED_GOLDEN_CARROT);

		// Ingredients
		entries.insertAfter(CreativeModeTabIds.INGREDIENTS, Items.CHARCOAL, PRItems.RAW_COPPER_NUGGET, PRItems.RAW_IRON_NUGGET, PRItems.RAW_GOLD_NUGGET, PRItems.RAW_ROSE_NUGGET);
		enderscapeEntries.insertAfter(CreativeModeTabIds.INGREDIENTS, PRItems.RAW_ROSE_NUGGET, PRItems.RAW_SHADOLINE_NUGGET);
		entries.insertAfter(CreativeModeTabIds.INGREDIENTS, Items.RAW_GOLD, PRItems.RAW_ROSE);
		entries.insertAfter(CreativeModeTabIds.INGREDIENTS, Items.GOLD_NUGGET, PRItems.ROSE_NUGGET, PRItems.DIAMOND_SHARD);
		entries.insertAfter(CreativeModeTabIds.INGREDIENTS, Items.IRON_INGOT, PRItems.IRON_ALLOY);
		entries.insertAfter(CreativeModeTabIds.INGREDIENTS, Items.GOLD_INGOT, PRItems.ROSE_INGOT, PRItems.ROSE_ALLOY);
		entries.insertBefore(CreativeModeTabIds.INGREDIENTS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, PRItems.IRON_UPGRADE_SMITHING_TEMPLATE, PRItems.ROSE_UPGRADE_SMITHING_TEMPLATE);

		// Building Blocks
		entries.insertBefore(CreativeModeTabIds.BUILDING_BLOCKS, Blocks.COPPER_BLOCK, PRBlocks.COPPER_BLOCK);
		entries.insertBefore(CreativeModeTabIds.BUILDING_BLOCKS, Blocks.EXPOSED_COPPER, PRBlocks.EXPOSED_COPPER);
		entries.insertBefore(CreativeModeTabIds.BUILDING_BLOCKS, Blocks.WEATHERED_COPPER, PRBlocks.WEATHERED_COPPER);
		entries.insertBefore(CreativeModeTabIds.BUILDING_BLOCKS, Blocks.OXIDIZED_COPPER, PRBlocks.OXIDIZED_COPPER);
		entries.insertBefore(CreativeModeTabIds.BUILDING_BLOCKS, Blocks.WAXED_COPPER_BLOCK, PRBlocks.WAXED_COPPER_BLOCK);
		entries.insertBefore(CreativeModeTabIds.BUILDING_BLOCKS, Blocks.WAXED_EXPOSED_COPPER, PRBlocks.WAXED_EXPOSED_COPPER);
		entries.insertBefore(CreativeModeTabIds.BUILDING_BLOCKS, Blocks.WAXED_WEATHERED_COPPER, PRBlocks.WAXED_WEATHERED_COPPER);
		entries.insertBefore(CreativeModeTabIds.BUILDING_BLOCKS, Blocks.WAXED_OXIDIZED_COPPER, PRBlocks.WAXED_OXIDIZED_COPPER);

		entries.insertAfter(CreativeModeTabIds.BUILDING_BLOCKS, Blocks.LIGHT_WEIGHTED_PRESSURE_PLATE, PRBlocks.GOLD_CHAIN);

		entries.insertAfter(
				CreativeModeTabIds.BUILDING_BLOCKS,
				Blocks.COPPER_CHAIN.waxedOxidized(),
				PRBlocks.ROSE_BLOCK,
				PRBlocks.POLISHED_ROSE,
				PRBlocks.CUT_POLISHED_ROSE,
				PRBlocks.CUT_POLISHED_ROSE_STAIRS,
				PRBlocks.CUT_POLISHED_ROSE_SLAB,
				PRBlocks.ROSE_DOOR,
				PRBlocks.ROSE_TRAPDOOR,
				PRBlocks.ROSE_LAMP,
				PRBlocks.ROSE_CHAIN
		);

		// Natural Blocks
		entries.insertAfter(CreativeModeTabIds.NATURAL_BLOCKS, Blocks.NETHER_QUARTZ_ORE, PRBlocks.BLACKSTONE_QUARTZ_ORE);
		entries.insertAfter(CreativeModeTabIds.NATURAL_BLOCKS, Blocks.NETHER_GOLD_ORE, PRBlocks.BLACKSTONE_GOLD_ORE, PRBlocks.NETHER_ROSE_ORE, PRBlocks.BLACKSTONE_ROSE_ORE);
		entries.insertAfter(CreativeModeTabIds.NATURAL_BLOCKS, Blocks.RAW_GOLD_BLOCK, PRBlocks.RAW_ROSE_BLOCK);

		// Functional Blocks
		entries.insertAfter(CreativeModeTabIds.FUNCTIONAL_BLOCKS, Blocks.WAXED_OXIDIZED_COPPER_BULB, PRBlocks.ROSE_LAMP);
		entries.insertAfter(CreativeModeTabIds.FUNCTIONAL_BLOCKS, Blocks.COPPER_LANTERN.waxedOxidized(), PRBlocks.GOLD_LANTERN, PRBlocks.ROSE_LANTERN);
		entries.insertAfter(CreativeModeTabIds.FUNCTIONAL_BLOCKS, Blocks.COPPER_CHAIN.waxedOxidized(), PRBlocks.GOLD_CHAIN, PRBlocks.ROSE_CHAIN);
	}
}
