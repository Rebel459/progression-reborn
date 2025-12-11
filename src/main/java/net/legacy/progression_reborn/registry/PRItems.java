package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.PRConstants;
import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.Util;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.equipment.ArmorType;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class PRItems {

    // Items
    public static final Item RAW_COPPER_NUGGET = register("raw_copper_nugget",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item RAW_IRON_NUGGET = register("raw_iron_nugget",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item RAW_GOLD_NUGGET = register("raw_gold_nugget",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item RAW_ROSE_NUGGET = register("raw_rose_nugget",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final Item ROSE_NUGGET = register("rose_nugget",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final Item DIAMOND_SHARD = register("diamond_shard",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item RAW_ROSE = register("raw_rose",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final Item ROSE_INGOT = register("rose_ingot",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final Item IRON_ALLOY = register("iron_alloy",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item ROSE_ALLOY = register("rose_alloy",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final SmithingTemplateItem IRON_UPGRADE_SMITHING_TEMPLATE = register("iron_upgrade_smithing_template",
            PRItems::createIronUpgradeTemplate,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final SmithingTemplateItem ROSE_UPGRADE_SMITHING_TEMPLATE = register("rose_upgrade_smithing_template",
            PRItems::createRoseUpgradeTemplate,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item ENCHANTED_GOLDEN_CARROT = register("enchanted_golden_carrot",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.RARE)
                    .food(PRFoods.ENCHANTED_GOLDEN_CARROT, PRConsumables.ENCHANTED_GOLDEN_CARROT)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
    );

    public static final Item ROSE_SWORD = register("rose_sword",
            Item::new,
            new Properties()
                    .sword(PRToolMaterial.ROSE, 3f, -2.4f)
                    .fireResistant()
    );
    public static final Item ROSE_PICKAXE = register("rose_pickaxe",
            Item::new,
            new Properties()
                    .pickaxe(PRToolMaterial.ROSE, 1f, -2.8f)
                    .fireResistant()
    );
    public static final AxeItem ROSE_AXE = register("rose_axe",
            (properties) -> new AxeItem(PRToolMaterial.ROSE, 6f, -3.1f, properties), (
                    new Properties()
                            .fireResistant()
            )
    );
    public static final ShovelItem ROSE_SHOVEL = register("rose_shovel",
            (properties) -> new ShovelItem(PRToolMaterial.ROSE, 1.5f, -3f, properties), (
                    new Properties()
                            .fireResistant()
            )
    );
    public static final HoeItem ROSE_HOE = register("rose_hoe",
            (properties) -> new HoeItem(PRToolMaterial.ROSE, -2f, -1f, properties), (
                    new Properties()
                            .fireResistant()
            )
    );
    public static final Item ROSE_SPEAR = register("rose_spear",
            Item::new,
            new Properties()
                    .fireResistant()
                    .spear(PRToolMaterial.ROSE, 0.95F, 0.95F, 0.6F, 2.5F, 8.0F, 6.75F, 5.1F, 11.25F, 4.6F)
    );

    public static final Item ROSE_HELMET = register("rose_helmet",
            Item::new,
            new Properties()
                    .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.HELMET)
                    .fireResistant()
    );
    public static final Item ROSE_CHESTPLATE = register("rose_chestplate",
            Item::new,
            new Properties()
                    .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.CHESTPLATE)
                    .fireResistant()
    );
    public static final Item ROSE_LEGGINGS = register("rose_leggings",
            Item::new,
            new Properties()
                    .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.LEGGINGS)
                    .fireResistant()
    );
    public static final Item ROSE_BOOTS = register("rose_boots",
            Item::new,
            new Properties()
                    .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.BOOTS)
                    .fireResistant()
    );
    public static final Item ROSE_HORSE_ARMOR = register("rose_horse_armor",
            Item::new,
            new Properties()
                    .horseArmor(PRArmorMaterials.ROSE)
                    .fireResistant()
    );
    public static final Item ROSE_NAUTILUS_ARMOR = register("rose_nautilus_armor",
            Item::new,
            new Properties()
                    .nautilusArmor(PRArmorMaterials.ROSE)
                    .fireResistant()
    );

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function, Item.@NotNull Properties properties) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, PRConstants.id(name)), function, properties);
    }

    public static SmithingTemplateItem createIronUpgradeTemplate(Item.Properties properties) {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.additions_slot_description"))),
                SmithingTemplateItem.createNetheriteUpgradeIconList(),
                SmithingTemplateItem.createNetheriteUpgradeMaterialList(),
                properties
        );
    }

    public static SmithingTemplateItem createRoseUpgradeTemplate(Item.Properties properties) {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.additions_slot_description"))),
                SmithingTemplateItem.createNetheriteUpgradeIconList(),
                SmithingTemplateItem.createNetheriteUpgradeMaterialList(),
                properties
        );
    }
}
