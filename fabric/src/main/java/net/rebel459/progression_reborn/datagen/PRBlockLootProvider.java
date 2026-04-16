package net.rebel459.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.rebel459.progression_reborn.registry.PRBlocks;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class PRBlockLootProvider extends FabricBlockLootSubProvider {

	public PRBlockLootProvider(@NotNull FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registries) {
		super(dataOutput, registries);
	}

	@Override
	public void generate() {
		this.dropSelf(PRBlocks.COPPER_BLOCK.get());
		this.dropSelf(PRBlocks.ROSE_BLOCK.get());
		this.dropSelf(PRBlocks.RAW_ROSE_BLOCK.get());
		this.dropSelf(PRBlocks.POLISHED_ROSE.get());
		this.dropSelf(PRBlocks.POLISHED_CUT_ROSE.get());
		this.dropSelf(PRBlocks.POLISHED_CUT_ROSE_STAIRS.get());
        this.add(PRBlocks.ROSE_DOOR.get(), this::createDoorTable);
		this.dropSelf(PRBlocks.ROSE_TRAPDOOR.get());
		this.dropSelf(PRBlocks.ROSE_LAMP.get());
		this.add(PRBlocks.POLISHED_CUT_ROSE_SLAB.get(), this::createSlabItemTable);
	}

}
