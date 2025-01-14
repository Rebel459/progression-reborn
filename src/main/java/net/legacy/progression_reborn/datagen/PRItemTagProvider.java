package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.legacy.progression_reborn.PRItemTags;
import net.legacy.progression_reborn.PRItems;
import net.minecraft.core.HolderLookup;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class PRItemTagProvider extends FabricTagProvider.ItemTagProvider {
	public PRItemTagProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider arg) {
		this.getOrCreateTagBuilder(PRItemTags.COPPER_TOOL_MATERIALS)
				.add(Items.COPPER_INGOT);
		this.getOrCreateTagBuilder(PRItemTags.REPAIRS_COPPER_ARMOR)
				.add(Items.COPPER_INGOT);

		this.getOrCreateTagBuilder(PRItemTags.ROSE_TOOL_MATERIALS)
				.add(PRItems.ROSE_INGOT)
				.add(PRItems.ROSE_ALLOY);
		this.getOrCreateTagBuilder(PRItemTags.REPAIRS_ROSE_ARMOR)
				.add(PRItems.ROSE_INGOT)
				.add(PRItems.ROSE_ALLOY);
	}

}
