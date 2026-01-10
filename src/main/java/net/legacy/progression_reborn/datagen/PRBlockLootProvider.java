package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.legacy.progression_reborn.registry.PRBlocks;
import net.minecraft.core.HolderLookup;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class PRBlockLootProvider extends FabricBlockLootTableProvider {

	public PRBlockLootProvider(@NotNull FabricDataOutput dataOutput, CompletableFuture<HolderLookup.Provider> registries) {
		super(dataOutput, registries);
	}

	@Override
	public void generate() {
		this.dropSelf(PRBlocks.COPPER_BLOCK);
		this.dropSelf(PRBlocks.ROSE_BLOCK);
		this.dropSelf(PRBlocks.RAW_ROSE_BLOCK);
		this.dropSelf(PRBlocks.POLISHED_ROSE);
		this.dropSelf(PRBlocks.POLISHED_CUT_ROSE);
		this.dropSelf(PRBlocks.POLISHED_CUT_ROSE_STAIRS);
        this.add(PRBlocks.ROSE_DOOR, this::createDoorTable);
		this.dropSelf(PRBlocks.ROSE_TRAPDOOR);
		this.dropSelf(PRBlocks.ROSE_LAMP);
		this.add(PRBlocks.POLISHED_CUT_ROSE_SLAB, this::createSlabItemTable);
	}

}
