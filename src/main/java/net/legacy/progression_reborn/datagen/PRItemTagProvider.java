package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.legacy.progression_reborn.registry.PRItems;
import net.legacy.progression_reborn.tag.PRItemTags;
import net.legacy.progression_reborn.registry.PRItems;
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
				.add(PRItems.ROSE_SWORD)
				.add(PRItems.ROSE_AXE)
				.add(PRItems.ROSE_PICKAXE)
				.add(PRItems.ROSE_SHOVEL)
				.add(PRItems.ROSE_HOE)
				.add(PRItems.ROSE_HELMET)
				.add(PRItems.ROSE_CHESTPLATE)
				.add(PRItems.ROSE_LEGGINGS)
				.add(PRItems.ROSE_BOOTS)
				.add(PRItems.ROSE_HORSE_ARMOR);

		this.getOrCreateTagBuilder(ItemTags.PIGLIN_SAFE_ARMOR)
				.add(PRItems.ROSE_HELMET)
				.add(PRItems.ROSE_CHESTPLATE)
				.add(PRItems.ROSE_LEGGINGS)
				.add(PRItems.ROSE_BOOTS);

		this.getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
				.add(PRItems.COPPER_HELMET)
				.add(PRItems.COPPER_CHESTPLATE)
				.add(PRItems.COPPER_LEGGINGS)
				.add(PRItems.COPPER_BOOTS)
				.add(PRItems.ROSE_HELMET)
				.add(PRItems.ROSE_CHESTPLATE)
				.add(PRItems.ROSE_LEGGINGS)
				.add(PRItems.ROSE_BOOTS);

		this.getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
				.add(PRItems.COPPER_HELMET)
				.add(PRItems.ROSE_HELMET);
		this.getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
				.add(PRItems.COPPER_CHESTPLATE)
				.add(PRItems.ROSE_CHESTPLATE);
		this.getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
				.add(PRItems.COPPER_LEGGINGS)
				.add(PRItems.ROSE_LEGGINGS);
		this.getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
				.add(PRItems.COPPER_BOOTS)
				.add(PRItems.ROSE_BOOTS);

		this.getOrCreateTagBuilder(ItemTags.SWORDS)
				.add(PRItems.COPPER_SWORD)
				.add(PRItems.ROSE_SWORD);
		this.getOrCreateTagBuilder(ItemTags.AXES)
				.add(PRItems.COPPER_AXE)
				.add(PRItems.ROSE_AXE);
		this.getOrCreateTagBuilder(ItemTags.PICKAXES)
				.add(PRItems.COPPER_PICKAXE)
				.add(PRItems.ROSE_PICKAXE);
		this.getOrCreateTagBuilder(ItemTags.SHOVELS)
				.add(PRItems.COPPER_SHOVEL)
				.add(PRItems.ROSE_SHOVEL);
		this.getOrCreateTagBuilder(ItemTags.HOES)
				.add(PRItems.COPPER_HOE)
				.add(PRItems.ROSE_HOE);

		this.getOrCreateTagBuilder(ItemTags.TRIM_MATERIALS)
				.add(PRItems.ROSE_INGOT);

		this.getOrCreateTagBuilder(ItemTags.HORSE_FOOD)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT);
		this.getOrCreateTagBuilder(ItemTags.HORSE_TEMPT_ITEMS)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT);

		this.getOrCreateTagBuilder(PRItemTags.STONE_PICKAXES)
				.add(Items.STONE_PICKAXE);
	}

}
