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
		this.valueLookupBuilder(PRItemTags.ROSE_TOOL_MATERIALS)
				.add(PRItems.ROSE_INGOT)
				.add(PRItems.ROSE_ALLOY);
		this.valueLookupBuilder(PRItemTags.REPAIRS_ROSE_ARMOR)
				.add(PRItems.ROSE_INGOT)
				.add(PRItems.ROSE_ALLOY);

		this.valueLookupBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
				.add(PRItems.ROSE_INGOT);

		this.valueLookupBuilder(ItemTags.IRON_TOOL_MATERIALS)
				.add(PRItems.IRON_ALLOY);
		this.valueLookupBuilder(ItemTags.REPAIRS_IRON_ARMOR)
				.add(PRItems.IRON_ALLOY);

		this.valueLookupBuilder(ItemTags.NETHERITE_TOOL_MATERIALS)
				.add(Items.NETHERITE_SCRAP);
		this.valueLookupBuilder(ItemTags.REPAIRS_NETHERITE_ARMOR)
				.add(Items.NETHERITE_SCRAP);

		this.valueLookupBuilder(ItemTags.PIGLIN_LOVED)
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
                .add(PRItems.ROSE_HORSE_ARMOR)
                .add(PRItems.ROSE_NAUTILUS_ARMOR);

		this.valueLookupBuilder(ItemTags.PIGLIN_SAFE_ARMOR)
				.add(PRItems.ROSE_HELMET)
				.add(PRItems.ROSE_CHESTPLATE)
				.add(PRItems.ROSE_LEGGINGS)
				.add(PRItems.ROSE_BOOTS);

		this.valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
				.add(PRItems.ROSE_HELMET)
				.add(PRItems.ROSE_CHESTPLATE)
				.add(PRItems.ROSE_LEGGINGS)
				.add(PRItems.ROSE_BOOTS);

		this.valueLookupBuilder(ItemTags.HEAD_ARMOR)
				.add(PRItems.ROSE_HELMET);
		this.valueLookupBuilder(ItemTags.CHEST_ARMOR)
				.add(PRItems.ROSE_CHESTPLATE);
		this.valueLookupBuilder(ItemTags.LEG_ARMOR)
				.add(PRItems.ROSE_LEGGINGS);
        this.valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(PRItems.ROSE_BOOTS);

		this.valueLookupBuilder(ItemTags.SWORDS)
				.add(PRItems.ROSE_SWORD);
		this.valueLookupBuilder(ItemTags.AXES)
				.add(PRItems.ROSE_AXE);
		this.valueLookupBuilder(ItemTags.PICKAXES)
				.add(PRItems.ROSE_PICKAXE);
		this.valueLookupBuilder(ItemTags.SHOVELS)
				.add(PRItems.ROSE_SHOVEL);
        this.valueLookupBuilder(ItemTags.HOES)
                .add(PRItems.ROSE_HOE);
        this.valueLookupBuilder(ItemTags.SPEARS)
                .add(PRItems.ROSE_SPEAR);

		this.valueLookupBuilder(ItemTags.TRIM_MATERIALS)
				.add(PRItems.ROSE_INGOT);

		this.valueLookupBuilder(ItemTags.HORSE_FOOD)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT);
		this.valueLookupBuilder(ItemTags.HORSE_TEMPT_ITEMS)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT);

		this.valueLookupBuilder(PRItemTags.STONE_PICKAXES)
				.add(Items.STONE_PICKAXE);
	}

}
