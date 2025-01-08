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
				.add(PRBlocks.ROSE_BLOCK);

		this.getOrCreateTagBuilder(BlockTags.NEEDS_STONE_TOOL)
				.add(PRBlocks.ROSE_BLOCK);

		this.getOrCreateTagBuilder(BlockTags.STAIRS)
			.add(PRBlocks.ROSE_BLOCK);

		this.getOrCreateTagBuilder(BlockTags.SLABS)
				.add(PRBlocks.ROSE_BLOCK);

		this.getOrCreateTagBuilder(BlockTags.DOORS)
				.add(PRBlocks.ROSE_BLOCK);

		this.getOrCreateTagBuilder(BlockTags.TRAPDOORS)
				.add(PRBlocks.ROSE_BLOCK);
	}

}
