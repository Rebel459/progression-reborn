package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.PRConstants;
import net.legacy.progression_reborn.food.PRConsumables;
import net.legacy.progression_reborn.food.PRFoods;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.*;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;
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
    public static final Item COPPER_NUGGET = register("copper_nugget",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item ROSE_NUGGET = register("rose_nugget",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final Item DIAMOND_NUGGET = register("diamond_nugget",
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
                    .trimMaterial(PRTrimMaterials.ROSE)
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

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function, Item.@NotNull Properties properties) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, net.legacy.progression_reborn.PRConstants.id(name)), function, properties);
    }

    public static SmithingTemplateItem createIronUpgradeTemplate(Item.Properties properties) {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.additions_slot_description"))),
                SmithingTemplateItem.createNetheriteUpgradeIconList(),
                SmithingTemplateItem.createNetheriteUpgradeMaterialList(),
                properties
        );
    }

    public static SmithingTemplateItem createRoseUpgradeTemplate(Item.Properties properties) {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.additions_slot_description"))),
                SmithingTemplateItem.createNetheriteUpgradeIconList(),
                SmithingTemplateItem.createNetheriteUpgradeMaterialList(),
                properties
        );
    }
}
