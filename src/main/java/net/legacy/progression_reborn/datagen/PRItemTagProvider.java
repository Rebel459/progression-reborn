package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.legacy.progression_reborn.registry.PREquipmentItems;
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
				.add(PREquipmentItems.ROSE_SWORD)
				.add(PREquipmentItems.ROSE_AXE)
				.add(PREquipmentItems.ROSE_PICKAXE)
				.add(PREquipmentItems.ROSE_SHOVEL)
				.add(PREquipmentItems.ROSE_HOE)
				.add(PREquipmentItems.ROSE_HELMET)
				.add(PREquipmentItems.ROSE_CHESTPLATE)
				.add(PREquipmentItems.ROSE_LEGGINGS)
				.add(PREquipmentItems.ROSE_BOOTS)
				.add(PREquipmentItems.ROSE_HORSE_ARMOR);

		this.getOrCreateTagBuilder(ItemTags.PIGLIN_SAFE_ARMOR)
				.add(PREquipmentItems.ROSE_HELMET)
				.add(PREquipmentItems.ROSE_CHESTPLATE)
				.add(PREquipmentItems.ROSE_LEGGINGS)
				.add(PREquipmentItems.ROSE_BOOTS);

		this.getOrCreateTagBuilder(ItemTags.TRIMMABLE_ARMOR)
				.add(PREquipmentItems.COPPER_HELMET)
				.add(PREquipmentItems.COPPER_CHESTPLATE)
				.add(PREquipmentItems.COPPER_LEGGINGS)
				.add(PREquipmentItems.COPPER_BOOTS)
				.add(PREquipmentItems.ROSE_HELMET)
				.add(PREquipmentItems.ROSE_CHESTPLATE)
				.add(PREquipmentItems.ROSE_LEGGINGS)
				.add(PREquipmentItems.ROSE_BOOTS);

		this.getOrCreateTagBuilder(ItemTags.HEAD_ARMOR)
				.add(PREquipmentItems.COPPER_HELMET)
				.add(PREquipmentItems.ROSE_HELMET);
		this.getOrCreateTagBuilder(ItemTags.CHEST_ARMOR)
				.add(PREquipmentItems.COPPER_CHESTPLATE)
				.add(PREquipmentItems.ROSE_CHESTPLATE);
		this.getOrCreateTagBuilder(ItemTags.LEG_ARMOR)
				.add(PREquipmentItems.COPPER_LEGGINGS)
				.add(PREquipmentItems.ROSE_LEGGINGS);
		this.getOrCreateTagBuilder(ItemTags.FOOT_ARMOR)
				.add(PREquipmentItems.COPPER_BOOTS)
				.add(PREquipmentItems.ROSE_BOOTS);

		this.getOrCreateTagBuilder(ItemTags.SWORDS)
				.add(PREquipmentItems.COPPER_SWORD)
				.add(PREquipmentItems.ROSE_SWORD);
		this.getOrCreateTagBuilder(ItemTags.AXES)
				.add(PREquipmentItems.COPPER_AXE)
				.add(PREquipmentItems.ROSE_AXE);
		this.getOrCreateTagBuilder(ItemTags.PICKAXES)
				.add(PREquipmentItems.COPPER_PICKAXE)
				.add(PREquipmentItems.ROSE_PICKAXE);
		this.getOrCreateTagBuilder(ItemTags.SHOVELS)
				.add(PREquipmentItems.COPPER_SHOVEL)
				.add(PREquipmentItems.ROSE_SHOVEL);
		this.getOrCreateTagBuilder(ItemTags.HOES)
				.add(PREquipmentItems.COPPER_HOE)
				.add(PREquipmentItems.ROSE_HOE);

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
