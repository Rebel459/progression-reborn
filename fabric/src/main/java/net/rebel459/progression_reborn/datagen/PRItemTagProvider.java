package net.rebel459.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.rebel459.progression_reborn.registry.PRItems;
import net.rebel459.progression_reborn.tag.PRItemTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public final class PRItemTagProvider extends FabricTagsProvider.ItemTagsProvider {
	public PRItemTagProvider(@NotNull FabricPackOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registries) {
		super(output, registries);
	}

	@Override
	protected void addTags(@NotNull HolderLookup.Provider arg) {
		this.valueLookupBuilder(PRItemTags.ROSE_TOOL_MATERIALS)
				.add(PRItems.ROSE_INGOT.get())
				.add(PRItems.ROSE_ALLOY.get());
		this.valueLookupBuilder(PRItemTags.REPAIRS_ROSE_ARMOR)
				.add(PRItems.ROSE_INGOT.get())
				.add(PRItems.ROSE_ALLOY.get());

		this.valueLookupBuilder(ItemTags.BEACON_PAYMENT_ITEMS)
				.add(PRItems.ROSE_INGOT.get());

		this.valueLookupBuilder(ItemTags.IRON_TOOL_MATERIALS)
				.add(PRItems.IRON_ALLOY.get());
		this.valueLookupBuilder(ItemTags.REPAIRS_IRON_ARMOR)
				.add(PRItems.IRON_ALLOY.get());

		this.valueLookupBuilder(ItemTags.NETHERITE_TOOL_MATERIALS)
				.add(Items.NETHERITE_SCRAP);
		this.valueLookupBuilder(ItemTags.REPAIRS_NETHERITE_ARMOR)
				.add(Items.NETHERITE_SCRAP);

		this.valueLookupBuilder(ItemTags.PIGLIN_LOVED)
				.add(PRItems.RAW_GOLD_NUGGET.get())
				.add(PRItems.ENCHANTED_GOLDEN_CARROT.get())
				.add(PRItems.ROSE_UPGRADE_SMITHING_TEMPLATE.get())
				.add(PRItems.ROSE_SWORD.get())
				.add(PRItems.ROSE_AXE.get())
				.add(PRItems.ROSE_PICKAXE.get())
				.add(PRItems.ROSE_SHOVEL.get())
				.add(PRItems.ROSE_HOE.get())
				.add(PRItems.ROSE_HELMET.get())
				.add(PRItems.ROSE_CHESTPLATE.get())
				.add(PRItems.ROSE_LEGGINGS.get())
				.add(PRItems.ROSE_BOOTS.get())
                .add(PRItems.ROSE_HORSE_ARMOR.get())
                .add(PRItems.ROSE_NAUTILUS_ARMOR.get());

		this.valueLookupBuilder(ItemTags.PIGLIN_SAFE_ARMOR)
				.add(PRItems.ROSE_HELMET.get())
				.add(PRItems.ROSE_CHESTPLATE.get())
				.add(PRItems.ROSE_LEGGINGS.get())
				.add(PRItems.ROSE_BOOTS.get());

		this.valueLookupBuilder(ItemTags.TRIMMABLE_ARMOR)
				.add(PRItems.ROSE_HELMET.get())
				.add(PRItems.ROSE_CHESTPLATE.get())
				.add(PRItems.ROSE_LEGGINGS.get())
				.add(PRItems.ROSE_BOOTS.get());

		this.valueLookupBuilder(ItemTags.HEAD_ARMOR)
				.add(PRItems.ROSE_HELMET.get());
		this.valueLookupBuilder(ItemTags.CHEST_ARMOR)
				.add(PRItems.ROSE_CHESTPLATE.get());
		this.valueLookupBuilder(ItemTags.LEG_ARMOR)
				.add(PRItems.ROSE_LEGGINGS.get());
        this.valueLookupBuilder(ItemTags.FOOT_ARMOR)
                .add(PRItems.ROSE_BOOTS.get());

		this.valueLookupBuilder(ItemTags.SWORDS)
				.add(PRItems.ROSE_SWORD.get());
		this.valueLookupBuilder(ItemTags.AXES)
				.add(PRItems.ROSE_AXE.get());
		this.valueLookupBuilder(ItemTags.PICKAXES)
				.add(PRItems.ROSE_PICKAXE.get());
		this.valueLookupBuilder(ItemTags.SHOVELS)
				.add(PRItems.ROSE_SHOVEL.get());
        this.valueLookupBuilder(ItemTags.HOES)
                .add(PRItems.ROSE_HOE.get());
        this.valueLookupBuilder(ItemTags.SPEARS)
                .add(PRItems.ROSE_SPEAR.get());

		this.valueLookupBuilder(ItemTags.TRIM_MATERIALS)
				.add(PRItems.ROSE_INGOT.get());

		this.valueLookupBuilder(ItemTags.HORSE_FOOD)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT.get());
		this.valueLookupBuilder(ItemTags.HORSE_TEMPT_ITEMS)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT.get());

        this.builder(PRItemTags.IRON_UPGRADE_STONES)
                .add(getItem(Items.COBBLESTONE))
                .add(getItem(Items.ANDESITE))
                .add(getItem(Items.DIORITE))
                .add(getItem(Items.GRANITE))
                .addOptional(this.getItem("bloom:dolerite"));

		this.valueLookupBuilder(PRItemTags.STONE_PICKAXES)
				.add(Items.STONE_PICKAXE);

		this.valueLookupBuilder(ItemTags.METAL_NUGGETS)
				.add(PRItems.ROSE_NUGGET.get());
	}

    private ResourceKey<Item> getItem(Item item) {
        return item.builtInRegistryHolder().key();
    }
    private ResourceKey<Item> getItem(String id) {
        return ResourceKey.create(this.registryKey, Identifier.parse(id));
    }
}
