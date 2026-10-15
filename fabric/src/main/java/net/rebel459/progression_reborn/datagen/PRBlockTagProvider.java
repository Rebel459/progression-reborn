package net.rebel459.progression_reborn.datagen;

import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.progression_reborn.registry.PRBlocks;

public final class PRBlockTagProvider {

	public static void init() {
		
		var tags = ProgressionReborn.DATA.helpers().tags();

		tags.create(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(PRBlocks.COPPER_BLOCK.key())
				.add(PRBlocks.EXPOSED_COPPER.key())
				.add(PRBlocks.WEATHERED_COPPER.key())
				.add(PRBlocks.OXIDIZED_COPPER.key())
				.add(PRBlocks.WAXED_COPPER_BLOCK.key())
				.add(PRBlocks.WAXED_EXPOSED_COPPER.key())
				.add(PRBlocks.WAXED_WEATHERED_COPPER.key())
				.add(PRBlocks.WAXED_OXIDIZED_COPPER.key())
				.add(PRBlocks.BLACKSTONE_QUARTZ_ORE.key())
				.add(PRBlocks.BLACKSTONE_GOLD_ORE.key())
				.add(PRBlocks.BLACKSTONE_ROSE_ORE.key())
				.add(PRBlocks.NETHER_ROSE_ORE.key())
				.add(PRBlocks.POLISHED_ROSE.key())
				.add(PRBlocks.CUT_POLISHED_ROSE.key())
				.add(PRBlocks.CUT_POLISHED_ROSE_SLAB.key())
				.add(PRBlocks.CUT_POLISHED_ROSE_STAIRS.key())
				.add(PRBlocks.ROSE_LAMP.key())
				.add(PRBlocks.ROSE_TRAPDOOR.key())
				.add(PRBlocks.ROSE_DOOR.key())
				.add(PRBlocks.ROSE_BLOCK.key())
				.add(PRBlocks.RAW_ROSE_BLOCK.key())
				.add(PRBlocks.ROSE_LANTERN.key())
				.add(PRBlocks.ROSE_CHAIN.key())
				.add(PRBlocks.GOLD_LANTERN.key())
				.add(PRBlocks.GOLD_CHAIN.key());

		tags.create(BlockTags.NEEDS_STONE_TOOL)
				.add(PRBlocks.COPPER_BLOCK.key())
				.add(PRBlocks.EXPOSED_COPPER.key())
				.add(PRBlocks.WEATHERED_COPPER.key())
				.add(PRBlocks.OXIDIZED_COPPER.key())
				.add(PRBlocks.WAXED_COPPER_BLOCK.key())
				.add(PRBlocks.WAXED_EXPOSED_COPPER.key())
				.add(PRBlocks.WAXED_WEATHERED_COPPER.key())
				.add(PRBlocks.WAXED_OXIDIZED_COPPER.key())
				.add(PRBlocks.NETHER_ROSE_ORE.key())
				.add(PRBlocks.POLISHED_ROSE.key())
				.add(PRBlocks.CUT_POLISHED_ROSE.key())
				.add(PRBlocks.CUT_POLISHED_ROSE_SLAB.key())
				.add(PRBlocks.CUT_POLISHED_ROSE_STAIRS.key())
				.add(PRBlocks.ROSE_LAMP.key())
				.add(PRBlocks.ROSE_TRAPDOOR.key())
				.add(PRBlocks.ROSE_DOOR.key())
				.add(PRBlocks.ROSE_BLOCK.key())
				.add(PRBlocks.RAW_ROSE_BLOCK.key());

		tags.create(BlockTags.STAIRS)
			.add(PRBlocks.CUT_POLISHED_ROSE_STAIRS.key());

		tags.create(BlockTags.SLABS)
				.add(PRBlocks.CUT_POLISHED_ROSE_SLAB.key());

		tags.create(BlockTags.DOORS)
				.add(PRBlocks.ROSE_DOOR.key());

		tags.create(BlockTags.TRAPDOORS)
				.add(PRBlocks.ROSE_TRAPDOOR.key());

		tags.create(BlockTags.CHAINS)
				.add(PRBlocks.ROSE_CHAIN.key())
				.add(PRBlocks.GOLD_CHAIN.key());

		tags.create(BlockTags.LANTERNS)
				.add(PRBlocks.ROSE_LANTERN.key())
				.add(PRBlocks.GOLD_LANTERN.key());

		tags.create(BlockTags.BEACON_BASE_BLOCKS)
				.add(PRBlocks.COPPER_BLOCK.key())
				.add(PRBlocks.EXPOSED_COPPER.key())
				.add(PRBlocks.WEATHERED_COPPER.key())
				.add(PRBlocks.OXIDIZED_COPPER.key())
				.add(PRBlocks.WAXED_COPPER_BLOCK.key())
				.add(PRBlocks.WAXED_EXPOSED_COPPER.key())
				.add(PRBlocks.WAXED_WEATHERED_COPPER.key())
				.add(PRBlocks.WAXED_OXIDIZED_COPPER.key())
				.add(PRBlocks.ROSE_BLOCK.key());

		tags.create(BlockTags.PIGLIN_REPELLENTS)
				.add(PRBlocks.ROSE_LAMP.key());

		tags.create(BlockTags.NETHER_CARVER_REPLACEABLES)
				.add(Blocks.QUARTZ_BLOCK.properties().blockId())
				.add(Blocks.SMOOTH_BASALT.properties().blockId())
				.add(Blocks.RAW_GOLD_BLOCK.properties().blockId())
				.add(PRBlocks.NETHER_ROSE_ORE.key())
				.add(PRBlocks.BLACKSTONE_QUARTZ_ORE.key())
				.add(PRBlocks.BLACKSTONE_ROSE_ORE.key());
	}

}
