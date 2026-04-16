package net.rebel459.progression_reborn.registry;

import net.rebel459.progression_reborn.ProgressionReborn;
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
import net.rebel459.unified.platform.UnifiedRegistries;
import net.rebel459.unified.util.SuppliedItem;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class PRItems {

    public static UnifiedRegistries.Items ITEMS = UnifiedRegistries.Items.create(ProgressionReborn.MOD_ID);

    // Items
    public static final SuppliedItem RAW_COPPER_NUGGET = ITEMS.register("raw_copper_nugget",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
    );
    public static final SuppliedItem RAW_IRON_NUGGET = ITEMS.register("raw_iron_nugget",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
    );
    public static final SuppliedItem RAW_GOLD_NUGGET = ITEMS.register("raw_gold_nugget",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
    );
    public static final SuppliedItem RAW_ROSE_NUGGET = ITEMS.register("raw_rose_nugget",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_NUGGET = ITEMS.register("rose_nugget",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final SuppliedItem DIAMOND_SHARD = ITEMS.register("diamond_shard",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
    );
    public static final SuppliedItem RAW_ROSE = ITEMS.register("raw_rose",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_INGOT = ITEMS.register("rose_ingot",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .trimMaterial(PRTrimMaterials.ROSE)
                    .fireResistant()
    );
    public static final SuppliedItem IRON_ALLOY = ITEMS.register("iron_alloy",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
    );
    public static final SuppliedItem ROSE_ALLOY = ITEMS.register("rose_alloy",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final SuppliedItem IRON_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("iron_upgrade_smithing_template",
            PRItems::createIronUpgradeTemplate,
            () -> new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final SuppliedItem ROSE_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("rose_upgrade_smithing_template",
            PRItems::createRoseUpgradeTemplate,
            () -> new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final SuppliedItem ENCHANTED_GOLDEN_CARROT = ITEMS.register("enchanted_golden_carrot",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.RARE)
                    .food(PRFoods.ENCHANTED_GOLDEN_CARROT, PRConsumables.ENCHANTED_GOLDEN_CARROT)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
    );

    public static final SuppliedItem ROSE_SWORD = ITEMS.register("rose_sword",
            Item::new,
            () -> new Properties()
                    .sword(PRToolMaterial.ROSE, 3f, -2.4f)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_PICKAXE = ITEMS.register("rose_pickaxe",
            Item::new,
            () -> new Properties()
                    .pickaxe(PRToolMaterial.ROSE, 1f, -2.8f)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_AXE = ITEMS.register("rose_axe",
            (properties) -> new AxeItem(PRToolMaterial.ROSE, 6f, -3.1f, properties), (
                    () -> new Properties()
                            .fireResistant()
            )
    );
    public static final SuppliedItem ROSE_SHOVEL = ITEMS.register("rose_shovel",
            (properties) -> new ShovelItem(PRToolMaterial.ROSE, 1.5f, -3f, properties), (
                    () -> new Properties()
                            .fireResistant()
            )
    );
    public static final SuppliedItem ROSE_HOE = ITEMS.register("rose_hoe",
            (properties) -> new HoeItem(PRToolMaterial.ROSE, -2f, -1f, properties), (
                    () -> new Properties()
                            .fireResistant()
            )
    );
    public static final SuppliedItem ROSE_SPEAR = ITEMS.register("rose_spear",
            Item::new,
            () -> new Properties()
                    .fireResistant()
                    .spear(PRToolMaterial.ROSE, 0.95F, 0.95F, 0.6F, 2.5F, 8.0F, 6.75F, 5.1F, 11.25F, 4.6F)
    );

    public static final SuppliedItem ROSE_HELMET = ITEMS.register("rose_helmet",
            Item::new,
            () -> new Properties()
                    .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.HELMET)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_CHESTPLATE = ITEMS.register("rose_chestplate",
            Item::new,
            () -> new Properties()
                    .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.CHESTPLATE)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_LEGGINGS = ITEMS.register("rose_leggings",
            Item::new,
            () -> new Properties()
                    .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.LEGGINGS)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_BOOTS = ITEMS.register("rose_boots",
            Item::new,
            () -> new Properties()
                    .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.BOOTS)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_HORSE_ARMOR = ITEMS.register("rose_horse_armor",
            Item::new,
            () -> new Properties()
                    .horseArmor(PRArmorMaterials.ROSE)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_NAUTILUS_ARMOR = ITEMS.register("rose_nautilus_armor",
            Item::new,
            () -> new Properties()
                    .nautilusArmor(PRArmorMaterials.ROSE)
                    .fireResistant()
    );

    public static void init() {}

    public static SmithingTemplateItem createIronUpgradeTemplate(Properties properties) {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(ProgressionReborn.MOD_ID, "smithing_template.iron_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(ProgressionReborn.MOD_ID, "smithing_template.iron_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(ProgressionReborn.MOD_ID, "smithing_template.iron_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(ProgressionReborn.MOD_ID, "smithing_template.iron_upgrade.additions_slot_description"))),
                SmithingTemplateItem.createNetheriteUpgradeIconList(),
                SmithingTemplateItem.createNetheriteUpgradeMaterialList(),
                properties
        );
    }

    public static SmithingTemplateItem createRoseUpgradeTemplate(Properties properties) {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(ProgressionReborn.MOD_ID, "smithing_template.rose_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(ProgressionReborn.MOD_ID, "smithing_template.rose_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(ProgressionReborn.MOD_ID, "smithing_template.rose_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", Identifier.fromNamespaceAndPath(ProgressionReborn.MOD_ID, "smithing_template.rose_upgrade.additions_slot_description"))),
                SmithingTemplateItem.createNetheriteUpgradeIconList(),
                SmithingTemplateItem.createNetheriteUpgradeMaterialList(),
                properties
        );
    }
}
