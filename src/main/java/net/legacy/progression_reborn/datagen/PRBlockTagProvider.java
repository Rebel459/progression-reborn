package net.legacy.progression_reborn.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.legacy.progression_reborn.registry.PRBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.jetbrains.annotations.NotNull;

public final class PRBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public PRBlockTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider arg) {
		this.valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(PRBlocks.COPPER_BLOCK)
				.add(PRBlocks.BLACKSTONE_QUARTZ_ORE)
				.add(PRBlocks.BLACKSTONE_GOLD_ORE)
				.add(PRBlocks.BLACKSTONE_ROSE_ORE)
				.add(PRBlocks.NETHER_ROSE_ORE)
				.add(PRBlocks.POLISHED_ROSE)
				.add(PRBlocks.POLISHED_CUT_ROSE)
				.add(PRBlocks.POLISHED_CUT_ROSE_SLAB)
				.add(PRBlocks.POLISHED_CUT_ROSE_STAIRS)
				.add(PRBlocks.ROSE_LAMP)
				.add(PRBlocks.ROSE_TRAPDOOR)
				.add(PRBlocks.ROSE_DOOR)
				.add(PRBlocks.ROSE_BLOCK)
				.add(PRBlocks.RAW_ROSE_BLOCK);

		this.valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
				.add(PRBlocks.COPPER_BLOCK)
				.add(PRBlocks.NETHER_ROSE_ORE)
				.add(PRBlocks.POLISHED_ROSE)
				.add(PRBlocks.POLISHED_CUT_ROSE)
				.add(PRBlocks.POLISHED_CUT_ROSE_SLAB)
				.add(PRBlocks.POLISHED_CUT_ROSE_STAIRS)
				.add(PRBlocks.ROSE_LAMP)
				.add(PRBlocks.ROSE_TRAPDOOR)
				.add(PRBlocks.ROSE_DOOR)
				.add(PRBlocks.ROSE_BLOCK)
				.add(PRBlocks.RAW_ROSE_BLOCK);

		this.valueLookupBuilder(BlockTags.STAIRS)
			.add(PRBlocks.POLISHED_CUT_ROSE_STAIRS);

		this.valueLookupBuilder(BlockTags.SLABS)
				.add(PRBlocks.POLISHED_CUT_ROSE_SLAB);

		this.valueLookupBuilder(BlockTags.DOORS)
				.add(PRBlocks.ROSE_DOOR);

		this.valueLookupBuilder(BlockTags.TRAPDOORS)
				.add(PRBlocks.ROSE_TRAPDOOR);

		this.valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
				.add(PRBlocks.COPPER_BLOCK)
				.add(PRBlocks.ROSE_BLOCK);

		this.valueLookupBuilder(BlockTags.PIGLIN_REPELLENTS)
				.add(PRBlocks.ROSE_LAMP);
	}

}
