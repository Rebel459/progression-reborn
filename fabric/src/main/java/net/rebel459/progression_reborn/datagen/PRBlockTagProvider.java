package net.rebel459.progression_reborn.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.rebel459.progression_reborn.registry.PRBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.jetbrains.annotations.NotNull;

public final class PRBlockTagProvider extends FabricTagsProvider.BlockTagsProvider {
	public PRBlockTagProvider(@NotNull FabricPackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider arg) {
		this.valueLookupBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(PRBlocks.COPPER_BLOCK.get())
				.add(PRBlocks.BLACKSTONE_QUARTZ_ORE.get())
				.add(PRBlocks.BLACKSTONE_GOLD_ORE.get())
				.add(PRBlocks.BLACKSTONE_ROSE_ORE.get())
				.add(PRBlocks.NETHER_ROSE_ORE.get())
				.add(PRBlocks.POLISHED_ROSE.get())
				.add(PRBlocks.POLISHED_CUT_ROSE.get())
				.add(PRBlocks.POLISHED_CUT_ROSE_SLAB.get())
				.add(PRBlocks.POLISHED_CUT_ROSE_STAIRS.get())
				.add(PRBlocks.ROSE_LAMP.get())
				.add(PRBlocks.ROSE_TRAPDOOR.get())
				.add(PRBlocks.ROSE_DOOR.get())
				.add(PRBlocks.ROSE_BLOCK.get())
				.add(PRBlocks.RAW_ROSE_BLOCK.get());

		this.valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
				.add(PRBlocks.COPPER_BLOCK.get())
				.add(PRBlocks.NETHER_ROSE_ORE.get())
				.add(PRBlocks.POLISHED_ROSE.get())
				.add(PRBlocks.POLISHED_CUT_ROSE.get())
				.add(PRBlocks.POLISHED_CUT_ROSE_SLAB.get())
				.add(PRBlocks.POLISHED_CUT_ROSE_STAIRS.get())
				.add(PRBlocks.ROSE_LAMP.get())
				.add(PRBlocks.ROSE_TRAPDOOR.get())
				.add(PRBlocks.ROSE_DOOR.get())
				.add(PRBlocks.ROSE_BLOCK.get())
				.add(PRBlocks.RAW_ROSE_BLOCK.get());

		this.valueLookupBuilder(BlockTags.STAIRS)
			.add(PRBlocks.POLISHED_CUT_ROSE_STAIRS.get());

		this.valueLookupBuilder(BlockTags.SLABS)
				.add(PRBlocks.POLISHED_CUT_ROSE_SLAB.get());

		this.valueLookupBuilder(BlockTags.DOORS)
				.add(PRBlocks.ROSE_DOOR.get());

		this.valueLookupBuilder(BlockTags.TRAPDOORS)
				.add(PRBlocks.ROSE_TRAPDOOR.get());

		this.valueLookupBuilder(BlockTags.BEACON_BASE_BLOCKS)
				.add(PRBlocks.COPPER_BLOCK.get())
				.add(PRBlocks.ROSE_BLOCK.get());

		this.valueLookupBuilder(BlockTags.PIGLIN_REPELLENTS)
				.add(PRBlocks.ROSE_LAMP.get());
	}

}
