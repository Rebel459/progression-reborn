package net.rebel459.progression_reborn.datagen;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.progression_reborn.registry.PRItems;
import net.rebel459.progression_reborn.tag.PRItemTags;

public final class PRItemTagProvider {

	public static void init() {

		var tags = ProgressionReborn.DATA.helpers().tags();

		tags.create(PRItemTags.ROSE_TOOL_MATERIALS)
				.add(PRItems.ROSE_INGOT.key())
				.add(PRItems.ROSE_ALLOY.key());
		tags.create(PRItemTags.REPAIRS_ROSE_ARMOR)
				.add(PRItems.ROSE_INGOT.key())
				.add(PRItems.ROSE_ALLOY.key());

		tags.create(ItemTags.BEACON_PAYMENT_ITEMS)
				.add(PRItems.ROSE_INGOT.key());

		tags.create(ItemTags.IRON_TOOL_MATERIALS)
				.add(PRItems.IRON_ALLOY.key());
		tags.create(ItemTags.REPAIRS_IRON_ARMOR)
				.add(PRItems.IRON_ALLOY.key());

		tags.create(ItemTags.NETHERITE_TOOL_MATERIALS)
				.add(Items.NETHERITE_SCRAP.builtInRegistryHolder().key());
		tags.create(ItemTags.REPAIRS_NETHERITE_ARMOR)
				.add(Items.NETHERITE_SCRAP.builtInRegistryHolder().key());

		tags.create(ItemTags.PIGLIN_LOVED)
				.add(PRItems.RAW_GOLD_NUGGET.key())
				.add(PRItems.ENCHANTED_GOLDEN_CARROT.key())
				.add(PRItems.ROSE_UPGRADE_SMITHING_TEMPLATE.key())
				.add(PRItems.ROSE_SWORD.key())
				.add(PRItems.ROSE_AXE.key())
				.add(PRItems.ROSE_PICKAXE.key())
				.add(PRItems.ROSE_SHOVEL.key())
				.add(PRItems.ROSE_HOE.key())
				.add(PRItems.ROSE_HELMET.key())
				.add(PRItems.ROSE_CHESTPLATE.key())
				.add(PRItems.ROSE_LEGGINGS.key())
				.add(PRItems.ROSE_BOOTS.key())
                .add(PRItems.ROSE_HORSE_ARMOR.key())
                .add(PRItems.ROSE_NAUTILUS_ARMOR.key());

		tags.create(ItemTags.PIGLIN_SAFE_ARMOR)
				.add(PRItems.ROSE_HELMET.key())
				.add(PRItems.ROSE_CHESTPLATE.key())
				.add(PRItems.ROSE_LEGGINGS.key())
				.add(PRItems.ROSE_BOOTS.key());

		tags.create(ItemTags.TRIMMABLE_ARMOR)
				.add(PRItems.ROSE_HELMET.key())
				.add(PRItems.ROSE_CHESTPLATE.key())
				.add(PRItems.ROSE_LEGGINGS.key())
				.add(PRItems.ROSE_BOOTS.key());

		tags.create(ItemTags.HEAD_ARMOR)
				.add(PRItems.ROSE_HELMET.key());
		tags.create(ItemTags.CHEST_ARMOR)
				.add(PRItems.ROSE_CHESTPLATE.key());
		tags.create(ItemTags.LEG_ARMOR)
				.add(PRItems.ROSE_LEGGINGS.key());
        tags.create(ItemTags.FOOT_ARMOR)
                .add(PRItems.ROSE_BOOTS.key());

		tags.create(ItemTags.SWORDS)
				.add(PRItems.ROSE_SWORD.key());
		tags.create(ItemTags.AXES)
				.add(PRItems.ROSE_AXE.key());
		tags.create(ItemTags.PICKAXES)
				.add(PRItems.ROSE_PICKAXE.key());
		tags.create(ItemTags.SHOVELS)
				.add(PRItems.ROSE_SHOVEL.key());
        tags.create(ItemTags.HOES)
                .add(PRItems.ROSE_HOE.key());
        tags.create(ItemTags.SPEARS)
                .add(PRItems.ROSE_SPEAR.key());

		tags.create(ItemTags.TRIM_MATERIALS)
				.add(PRItems.ROSE_INGOT.key());

		tags.create(ItemTags.HORSE_FOOD)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT.key());
		tags.create(ItemTags.HORSE_TEMPT_ITEMS)
				.add(PRItems.ENCHANTED_GOLDEN_CARROT.key());

        tags.create(PRItemTags.IRON_UPGRADE_STONES)
                .add(getItem(Items.COBBLESTONE))
                .add(getItem(Items.ANDESITE))
                .add(getItem(Items.DIORITE))
                .add(getItem(Items.GRANITE))
                .addOptional(getItem("bloom:dolerite"));

		tags.create(PRItemTags.STONE_PICKAXES)
				.add(Items.STONE_PICKAXE.builtInRegistryHolder().key());

		tags.create(ItemTags.METAL_NUGGETS)
				.add(PRItems.ROSE_NUGGET.key());
	}

    private static ResourceKey<Item> getItem(Item item) {
        return item.builtInRegistryHolder().key();
    }
    private static ResourceKey<Item> getItem(String id) {
        return ResourceKey.create(Registries.ITEM, Identifier.parse(id));
    }
}
