package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.legacy.progression_reborn.PRGearItems;
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

		this.getOrCreateTagBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
				.add(PRItems.ROSE_INGOT);

		this.getOrCreateTagBuilder(ItemTags.IRON_TOOL_MATERIALS)
				.add(PRItems.IRON_ALLOY);
		this.getOrCreateTagBuilder(ItemTags.REPAIRS_IRON_ARMOR)
				.add(PRItems.IRON_ALLOY);

		this.getOrCreateTagBuilder(ItemTags.NETHERITE_TOOL_MATERIALS)
				.add(Items.NETHERITE_SCRAP);
		this.getOrCreateTagBuilder(ItemTags.REPAIRS_NETHERITE_ARMOR)
				.add(Items.NETHERITE_SCRAP);

		this.getOrCreateTagBuilder(ItemTags.PIGLIN_LOVED)
				.add(PRItems.RAW_GOLD_NUGGET)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT)
				.add(PRItems.ROSE_UPGRADE_SMITHING_TEMPLATE)
				.add(PRGearItems.ROSE_SWORD)
				.add(PRGearItems.ROSE_AXE)
				.add(PRGearItems.ROSE_PICKAXE)
				.add(PRGearItems.ROSE_SHOVEL)
				.add(PRGearItems.ROSE_HOE)
				.add(PRGearItems.ROSE_HELMET)
				.add(PRGearItems.ROSE_CHESTPLATE)
				.add(PRGearItems.ROSE_LEGGINGS)
				.add(PRGearItems.ROSE_BOOTS)
				.add(PRGearItems.ROSE_HORSE_ARMOR);

		this.getOrCreateTagBuilder(ItemTags.PIGLIN_SAFE_ARMOR)
				.add(PRGearItems.ROSE_HELMET)
				.add(PRGearItems.ROSE_CHESTPLATE)
				.add(PRGearItems.ROSE_LEGGINGS)
				.add(PRGearItems.ROSE_BOOTS);

		this.getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
				.add(PRGearItems.COPPER_HELMET)
				.add(PRGearItems.COPPER_CHESTPLATE)
				.add(PRGearItems.COPPER_LEGGINGS)
				.add(PRGearItems.COPPER_BOOTS)
				.add(PRGearItems.ROSE_HELMET)
				.add(PRGearItems.ROSE_CHESTPLATE)
				.add(PRGearItems.ROSE_LEGGINGS)
				.add(PRGearItems.ROSE_BOOTS);

		this.getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
				.add(PRItems.ROSE_INGOT);

		this.getOrCreateTagBuilder(ItemTags.HORSE_FOOD)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT);
		this.getOrCreateTagBuilder(ItemTags.HORSE_TEMPT_ITEMS)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT);
	}

}
