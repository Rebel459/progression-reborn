package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.PRConstants;
import net.legacy.progression_reborn.lib.PRCreativeTabs;
import net.legacy.progression_reborn.lib.PRNotNull;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.flag.FeatureFlag;
import net.minecraft.world.item.*;
import net.minecraft.world.level.ItemLike;

public final class PRItems {

    // Items

    public static final Item RAW_COPPER_NUGGET = new Item(
            new Item.Properties()
                    .stacksTo(64)
    );
    public static final Item RAW_IRON_NUGGET = new Item(
            new Item.Properties()
                    .stacksTo(64)
    );
    public static final Item RAW_GOLD_NUGGET = new Item(
            new Item.Properties()
                    .stacksTo(64)
    );
    public static final Item RAW_ROSE_NUGGET = new Item(
            new Item.Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final Item COPPER_NUGGET = new Item(
            new Item.Properties()
                    .stacksTo(64)
    );
    public static final Item ROSE_NUGGET = new Item(
            new Item.Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final Item DIAMOND_NUGGET = new Item(
            new Item.Properties()
                    .stacksTo(64)
    );
    public static final Item RAW_ROSE = new Item(
            new Item.Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final Item ROSE_INGOT = new Item(
            new Item.Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final Item IRON_ALLOY = new Item(
            new Item.Properties()
                    .stacksTo(64)
    );
    public static final Item ROSE_ALLOY = new Item(
            new Item.Properties()
                    .stacksTo(64)
                    .fireResistant()
    );
    public static final SmithingTemplateItem IRON_UPGRADE_SMITHING_TEMPLATE = createIronUpgradeTemplate();
    public static final SmithingTemplateItem ROSE_UPGRADE_SMITHING_TEMPLATE = createRoseUpgradeTemplate();
    public static final Item ENCHANTED_GOLDEN_CARROT = new Item(
            new Item.Properties()
                    .stacksTo(64)
                    .rarity(Rarity.RARE)
                    .food(PRFoods.ENCHANTED_GOLDEN_CARROT)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
    );

    // Tools

    public static final SwordItem COPPER_SWORD = new SwordItem(PRTiers.COPPER,
            new Item.Properties()
                    .attributes(SwordItem.createAttributes(PRTiers.COPPER, 3, -2.4F))
                    .stacksTo(1)
                    .durability(190)
    );
    public static final PickaxeItem COPPER_PICKAXE = new PickaxeItem(PRTiers.COPPER,
            new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(PRTiers.COPPER, 1, -2.8F))
                    .stacksTo(1)
                    .durability(190)
    );
    public static final AxeItem COPPER_AXE = new AxeItem(PRTiers.COPPER,
            new Item.Properties()
                    .attributes(AxeItem.createAttributes(PRTiers.COPPER, 6, -3.1F))
                    .stacksTo(1)
                    .durability(190)
    );
    public static final ShovelItem COPPER_SHOVEL = new ShovelItem(PRTiers.COPPER,
            new Item.Properties()
                    .attributes(ShovelItem.createAttributes(PRTiers.COPPER, 1.5F, -3F))
                    .stacksTo(1)
                    .durability(190)
    );
    public static final HoeItem COPPER_HOE = new HoeItem(PRTiers.COPPER,
            new Item.Properties()
                    .attributes(HoeItem.createAttributes(PRTiers.COPPER, -2, -1F))
                    .stacksTo(1)
                    .durability(190)
    );

    public static final SwordItem ROSE_SWORD = new SwordItem(PRTiers.ROSE,
            new Item.Properties()
                    .attributes(SwordItem.createAttributes(PRTiers.ROSE, 3, -2.4F))
                    .stacksTo(1)
                    .durability(281)
                    .fireResistant()
    );
    public static final PickaxeItem ROSE_PICKAXE = new PickaxeItem(PRTiers.ROSE,
            new Item.Properties()
                    .attributes(PickaxeItem.createAttributes(PRTiers.ROSE, 1, -2.8F))
                    .stacksTo(1)
                    .durability(281)
                    .fireResistant()
    );
    public static final AxeItem ROSE_AXE = new AxeItem(PRTiers.ROSE,
            new Item.Properties()
                    .attributes(AxeItem.createAttributes(PRTiers.ROSE, 6, -3.1F))
                    .stacksTo(1)
                    .durability(281)
                    .fireResistant()
    );
    public static final ShovelItem ROSE_SHOVEL = new ShovelItem(PRTiers.ROSE,
            new Item.Properties()
                    .attributes(ShovelItem.createAttributes(PRTiers.ROSE, 1.5F, -3F))
                    .stacksTo(1)
                    .durability(281)
                    .fireResistant()
    );
    public static final HoeItem ROSE_HOE = new HoeItem(PRTiers.ROSE,
            new Item.Properties()
                    .attributes(HoeItem.createAttributes(PRTiers.ROSE, -2, -1F))
                    .stacksTo(1)
                    .durability(281)
                    .fireResistant()
    );
    
    // Armor

    public static final ArmorItem COPPER_HELMET = new ArmorItem(PRArmorMaterials.COPPER, ArmorItem.Type.HELMET,
            new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(7))
                    .stacksTo(1)
    );
    public static final ArmorItem COPPER_CHESTPLATE = new ArmorItem(PRArmorMaterials.COPPER, ArmorItem.Type.CHESTPLATE,
            new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(7))
                    .stacksTo(1)
    );
    public static final ArmorItem COPPER_LEGGINGS = new ArmorItem(PRArmorMaterials.COPPER, ArmorItem.Type.LEGGINGS,
            new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(7))
                    .stacksTo(1)
    );
    public static final ArmorItem COPPER_BOOTS = new ArmorItem(PRArmorMaterials.COPPER, ArmorItem.Type.BOOTS,
            new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(7))
                    .stacksTo(1)
    );
    public static final AnimalArmorItem COPPER_HORSE_ARMOR = new AnimalArmorItem(PRArmorMaterials.COPPER, AnimalArmorItem.BodyType.EQUESTRIAN, false,
            new Item.Properties()
                    .stacksTo(1)
    );

    public static final ArmorItem ROSE_HELMET = new ArmorItem(PRArmorMaterials.ROSE, ArmorItem.Type.HELMET,
            new Item.Properties()
                    .durability(ArmorItem.Type.HELMET.getDurability(10))
                    .stacksTo(1)
                    .fireResistant()
    );
    public static final ArmorItem ROSE_CHESTPLATE = new ArmorItem(PRArmorMaterials.ROSE, ArmorItem.Type.CHESTPLATE,
            new Item.Properties()
                    .durability(ArmorItem.Type.CHESTPLATE.getDurability(10))
                    .stacksTo(1)
                    .fireResistant()
    );
    public static final ArmorItem ROSE_LEGGINGS = new ArmorItem(PRArmorMaterials.ROSE, ArmorItem.Type.LEGGINGS,
            new Item.Properties()
                    .durability(ArmorItem.Type.LEGGINGS.getDurability(10))
                    .stacksTo(1)
                    .fireResistant()
    );
    public static final ArmorItem ROSE_BOOTS = new ArmorItem(PRArmorMaterials.ROSE, ArmorItem.Type.BOOTS,
            new Item.Properties()
                    .durability(ArmorItem.Type.BOOTS.getDurability(10))
                    .stacksTo(1)
                    .fireResistant()
    );
    public static final AnimalArmorItem ROSE_HORSE_ARMOR = new AnimalArmorItem(PRArmorMaterials.ROSE, AnimalArmorItem.BodyType.EQUESTRIAN, false,
            new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
    );

    public static final AnimalArmorItem NETHERITE_HORSE_ARMOR = new AnimalArmorItem(ArmorMaterials.NETHERITE, AnimalArmorItem.BodyType.EQUESTRIAN, false,
            new Item.Properties()
                    .stacksTo(1)
                    .fireResistant()
    );

    public static void register() {

        // Combat

        registerItemAfter(Items.CHAINMAIL_BOOTS, COPPER_HELMET, "copper_helmet", CreativeModeTabs.COMBAT);
        registerItemAfter(COPPER_HELMET, COPPER_CHESTPLATE, "copper_chestplate", CreativeModeTabs.COMBAT);
        registerItemAfter(COPPER_CHESTPLATE, COPPER_LEGGINGS, "copper_leggings", CreativeModeTabs.COMBAT);
        registerItemAfter(COPPER_LEGGINGS, COPPER_BOOTS, "copper_boots", CreativeModeTabs.COMBAT);

        registerItemAfter(Items.GOLDEN_BOOTS, ROSE_HELMET, "rose_helmet", CreativeModeTabs.COMBAT);
        registerItemAfter(ROSE_HELMET, ROSE_CHESTPLATE, "rose_chestplate", CreativeModeTabs.COMBAT);
        registerItemAfter(ROSE_CHESTPLATE, ROSE_LEGGINGS, "rose_leggings", CreativeModeTabs.COMBAT);
        registerItemAfter(ROSE_LEGGINGS, ROSE_BOOTS, "rose_boots", CreativeModeTabs.COMBAT);

        registerItemAfter(Items.STONE_SWORD, COPPER_SWORD, "copper_sword", CreativeModeTabs.COMBAT);
        registerItemAfter(Items.STONE_AXE, COPPER_AXE, "copper_axe", CreativeModeTabs.COMBAT);

        registerItemAfter(Items.GOLDEN_SWORD, ROSE_SWORD, "rose_sword", CreativeModeTabs.COMBAT);
        registerItemAfter(Items.GOLDEN_AXE, ROSE_AXE, "rose_axe", CreativeModeTabs.COMBAT);

        registerItemAfter(Items.LEATHER_HORSE_ARMOR, COPPER_HORSE_ARMOR, "copper_horse_armor", CreativeModeTabs.COMBAT);
        registerItemAfter(Items.GOLDEN_HORSE_ARMOR, ROSE_HORSE_ARMOR, "golden_horse_armor", CreativeModeTabs.COMBAT);
        registerItemAfter(Items.DIAMOND_HORSE_ARMOR, NETHERITE_HORSE_ARMOR, "netherite_horse_armor", CreativeModeTabs.COMBAT);

        // Tools and Utilities

        registerItemAfter(Items.STONE_HOE, COPPER_SHOVEL, "copper_shovel", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(COPPER_SHOVEL, COPPER_PICKAXE, "copper_pickaxe", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(COPPER_PICKAXE, COPPER_AXE, "copper_axe", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(COPPER_AXE, COPPER_HOE, "copper_hoe", CreativeModeTabs.TOOLS_AND_UTILITIES);

        registerItemAfter(Items.GOLDEN_HOE, ROSE_SHOVEL, "rose_shovel", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(ROSE_SHOVEL, ROSE_PICKAXE, "rose_pickaxe", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(ROSE_PICKAXE, ROSE_AXE, "rose_axe", CreativeModeTabs.TOOLS_AND_UTILITIES);
        registerItemAfter(ROSE_AXE, ROSE_HOE, "rose_hoe", CreativeModeTabs.TOOLS_AND_UTILITIES);

        // Food and Drinks

        registerItemAfter(Items.GOLDEN_CARROT, ENCHANTED_GOLDEN_CARROT, "enchanted_golden_carrot", CreativeModeTabs.FOOD_AND_DRINKS);

        // Ingredients

        registerItemAfter(Items.CHARCOAL, RAW_IRON_NUGGET, "raw_iron_nugget", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(RAW_IRON_NUGGET, RAW_COPPER_NUGGET, "raw_copper_nugget", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(RAW_COPPER_NUGGET, RAW_GOLD_NUGGET, "raw_gold_nugget", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(RAW_GOLD_NUGGET, RAW_ROSE_NUGGET, "raw_rose_nugget", CreativeModeTabs.INGREDIENTS);

        registerItemAfter(Items.RAW_GOLD, RAW_ROSE, "raw_rose", CreativeModeTabs.INGREDIENTS);

        registerItemAfter(Items.IRON_NUGGET, COPPER_NUGGET, "copper_nugget", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(Items.GOLD_NUGGET, ROSE_NUGGET, "rose_nugget", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(ROSE_NUGGET, DIAMOND_NUGGET, "diamond_nugget", CreativeModeTabs.INGREDIENTS);

        registerItemAfter(Items.IRON_INGOT, IRON_ALLOY, "iron_alloy", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(Items.GOLD_INGOT, ROSE_INGOT, "rose_ingot", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(ROSE_INGOT, ROSE_ALLOY, "rose_alloy", CreativeModeTabs.INGREDIENTS);

        registerItemAfter(Items.SNORT_POTTERY_SHERD, IRON_UPGRADE_SMITHING_TEMPLATE, "iron_upgrade_smithing_template", CreativeModeTabs.INGREDIENTS);
        registerItemAfter(IRON_UPGRADE_SMITHING_TEMPLATE, ROSE_UPGRADE_SMITHING_TEMPLATE, "rose_upgrade_smithing_template", CreativeModeTabs.INGREDIENTS);

    }

    @SafeVarargs
    private static void registerItemAfter(@PRNotNull ItemLike comparedItem, @PRNotNull Item item, @PRNotNull String path, @PRNotNull ResourceKey<CreativeModeTab>... tabs) {
        registerItemAfter(comparedItem, item, path, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, tabs);
    }

    @SafeVarargs
    private static void registerItemAfter(@PRNotNull ItemLike comparedItem, @PRNotNull Item item, @PRNotNull String path, @PRNotNull CreativeModeTab.TabVisibility tabVisibility, @PRNotNull ResourceKey<CreativeModeTab>... tabs) {
        actualRegister(item, path);
        PRCreativeTabs.addAfter(comparedItem, item, tabVisibility, tabs);
    }

    private static void actualRegister(@PRNotNull Item item, @PRNotNull String path) {
        if (BuiltInRegistries.ITEM.getOptional(PRConstants.id(path)).isEmpty()) {
            Registry.register(BuiltInRegistries.ITEM, PRConstants.id(path), item);
        }
    }

    public static SmithingTemplateItem createIronUpgradeTemplate() {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID,"smithing_template.iron_upgrade"))).withStyle(ChatFormatting.GRAY),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.iron_upgrade.additions_slot_description"))),
                SmithingTemplateItem.createNetheriteUpgradeIconList(),
                SmithingTemplateItem.createNetheriteUpgradeMaterialList(),
                new FeatureFlag[0]);
    }

    public static SmithingTemplateItem createRoseUpgradeTemplate() {
        return new SmithingTemplateItem(Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("upgrade", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID,"smithing_template.rose_upgrade"))).withStyle(ChatFormatting.GRAY),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "smithing_template.rose_upgrade.additions_slot_description"))),
                SmithingTemplateItem.createNetheriteUpgradeIconList(),
                SmithingTemplateItem.createNetheriteUpgradeMaterialList(),
                new FeatureFlag[0]);
    }
}
