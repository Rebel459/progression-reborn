package net.legacy.progression_reborn.datagen;

import java.util.concurrent.CompletableFuture;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.legacy.progression_reborn.PRBlocks;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.BlockTags;
import org.jetbrains.annotations.NotNull;

public final class PRBlockTagProvider extends FabricTagProvider.BlockTagProvider {
	public PRBlockTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider arg) {
		this.getOrCreateTagBuilder(BlockTags.MINEABLE_WITH_PICKAXE)
				.add(PRBlocks.COPPER_BLOCK)
				.add(PRBlocks.NETHER_ROSE_ORE)
				.add(PRBlocks.POLISHED_ROSE)
				.add(PRBlocks.POLISHED_CUT_ROSE)
				.add(PRBlocks.POLISHED_CUT_ROSE_SLAB)
				.add(PRBlocks.POLISHED_CUT_ROSE_STAIRS)
				.add(PRBlocks.ROSE_LAMP)
				.add(PRBlocks.ROSE_TRAPDOOR)
				.add(PRBlocks.ROSE_DOOR)
				.add(PRBlocks.ROSE_BLOCK);

		this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
				.add(PRBlocks.COPPER_BLOCK)
				.add(PRBlocks.NETHER_ROSE_ORE)
				.add(PRBlocks.POLISHED_ROSE)
				.add(PRBlocks.POLISHED_CUT_ROSE)
				.add(PRBlocks.POLISHED_CUT_ROSE_SLAB)
				.add(PRBlocks.POLISHED_CUT_ROSE_STAIRS)
				.add(PRBlocks.ROSE_LAMP)
				.add(PRBlocks.ROSE_TRAPDOOR)
				.add(PRBlocks.ROSE_DOOR)
				.add(PRBlocks.ROSE_BLOCK);

		this.getOrCreateTagBuilder(BlockTags.STAIRS)
			.add(PRBlocks.POLISHED_CUT_ROSE_STAIRS);

		this.getOrCreateTagBuilder(BlockTags.SLABS)
				.add(PRBlocks.POLISHED_CUT_ROSE_SLAB);

		this.getOrCreateTagBuilder(BlockTags.DOORS)
				.add(PRBlocks.ROSE_DOOR);

		this.getOrCreateTagBuilder(BlockTags.TRAPDOORS)
				.add(PRBlocks.ROSE_TRAPDOOR);

		this.getOrCreateTagBuilder(BlockTags.BEACON_BASE_BLOCKS)
				.add(PRBlocks.COPPER_BLOCK)
				.add(PRBlocks.ROSE_BLOCK);

		this.getOrCreateTagBuilder(BlockTags.PIGLIN_REPELLENTS)
				.add(PRBlocks.ROSE_LAMP);
	}

}
