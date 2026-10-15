package net.rebel459.progression_reborn.registry;

import net.minecraft.ChatFormatting;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Util;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.*;
import net.minecraft.world.item.Item.Properties;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.item.component.Weapon;
import net.minecraft.world.item.enchantment.Repairable;
import net.minecraft.world.item.equipment.ArmorType;
import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.progression_reborn.util.CollectionData;
import net.rebel459.unified.api.core.SuppliedItem;
import net.rebel459.unified.api.core.UnifiedRegistries;
import net.rebel459.unified.api.data.registry.ItemGenerator;
import net.rebel459.unified.api.registry.VanillaItemCodecs;
import vectorwing.farmersdelight.common.item.KnifeItem;

import java.util.List;

public final class PRItems {

    public static UnifiedRegistries.Items ITEMS = UnifiedRegistries.Items.create(ProgressionReborn.MOD_ID);

    // Items
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
    public static final SuppliedItem RAW_COPPER_NUGGET = ITEMS.register("raw_copper_nugget",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .component(PRDataComponents.COLLECTION_DATA.get(), new CollectionData(Items.RAW_COPPER.builtInRegistryHolder().key()))
    );
    public static final SuppliedItem RAW_IRON_NUGGET = ITEMS.register("raw_iron_nugget",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .component(PRDataComponents.COLLECTION_DATA.get(), new CollectionData(Items.RAW_IRON.builtInRegistryHolder().key()))
    );
    public static final SuppliedItem RAW_GOLD_NUGGET = ITEMS.register("raw_gold_nugget",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .component(PRDataComponents.COLLECTION_DATA.get(), new CollectionData(Items.RAW_GOLD.builtInRegistryHolder().key()))
    );
    public static final SuppliedItem RAW_ROSE_NUGGET = ITEMS.register("raw_rose_nugget",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .fireResistant()
                    .component(PRDataComponents.COLLECTION_DATA.get(), new CollectionData(RAW_ROSE.key()))
    );
    public static final SuppliedItem ROSE_NUGGET = ITEMS.register("rose_nugget",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .fireResistant()
                    .component(PRDataComponents.COLLECTION_DATA.get(), new CollectionData(ROSE_INGOT.key()))
    );
    public static final SuppliedItem DIAMOND_SHARD = ITEMS.register("diamond_shard",
            Item::new,
            () -> new Properties()
                    .stacksTo(64)
                    .component(PRDataComponents.COLLECTION_DATA.get(), new CollectionData(Items.DIAMOND.builtInRegistryHolder().key()))
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
    public static final SuppliedItem RAW_SHADOLINE_NUGGET = ProgressionReborn.ENDERSCAPE_DATA.registries().items().register("raw_shadoline_nugget",
            VanillaItemCodecs.ITEM.create(),
            builder -> builder
                    .properties(properties -> properties
                            .stacksTo(64)
                            .component(PRDataComponents.COLLECTION_DATA.get(), new CollectionData(ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath("enderscape", "raw_shadoline"))))
                    )
                    .assets(ItemGenerator.Assets::generated)
    );

    public static final SuppliedItem ROSE_SWORD = ITEMS.register("rose_sword",
            Item::new,
            () -> new Properties()
                    .sword(PRToolMaterials.ROSE, 3F, -2.4F)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_PICKAXE = ITEMS.register("rose_pickaxe",
            Item::new,
            () -> new Properties()
                    .pickaxe(PRToolMaterials.ROSE, 1F, -2.8F)
                    .fireResistant()
    );
    public static final SuppliedItem ROSE_AXE = ITEMS.register("rose_axe",
            (properties) -> new AxeItem(PRToolMaterials.ROSE, 6F, -3.1F, properties), (
                    () -> new Properties()
                            .fireResistant()
            )
    );
    public static final SuppliedItem ROSE_SHOVEL = ITEMS.register("rose_shovel",
            (properties) -> new ShovelItem(PRToolMaterials.ROSE, 1.5F, -3F, properties), (
                    () -> new Properties()
                            .fireResistant()
            )
    );
    public static final SuppliedItem ROSE_HOE = ITEMS.register("rose_hoe",
            (properties) -> new HoeItem(PRToolMaterials.ROSE, -2F, -1F, properties), (
                    () -> new Properties()
                            .fireResistant()
            )
    );
    public static final SuppliedItem ROSE_SPEAR = ITEMS.register("rose_spear",
            Item::new,
            () -> new Properties()
                    .fireResistant()
                    .spear(PRToolMaterials.ROSE, 0.95F, 0.95F, 0.6F, 2.5F, 8.0F, 6.75F, 5.1F, 11.25F, 4.6F)
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

    public static final SuppliedItem ROSE_KNIFE = ProgressionReborn.FARMERS_DELIGHT_DATA.registries().items().register(
            "rose_knife",
            PRItemCodecs.KNIFE.create(),
            builder -> builder.properties(properties -> properties
                    .durability(PRToolMaterials.ROSE.durability())
                    .delayedComponent(DataComponents.REPAIRABLE, provider -> new Repairable(provider.lookup(Registries.ITEM).get().getOrThrow(PRToolMaterials.ROSE.repairItems())))
                    .enchantable(PRToolMaterials.ROSE.enchantmentValue())
                    .attributes(ItemAttributeModifiers.builder()
                            .add(Attributes.ATTACK_DAMAGE, new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, 0.5F + PRToolMaterials.ROSE.attackDamageBonus(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                            .add(Attributes.ATTACK_SPEED, new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, -2F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.MAINHAND)
                            .build()
                    )
                    .delayedComponent(DataComponents.TOOL, provider -> new Tool(
                            List.of(
                                    Tool.Rule.deniesDrops(provider.getOrThrow(PRToolMaterials.ROSE.incorrectBlocksForDrops())),
                                    Tool.Rule.minesAndDrops(provider.getOrThrow(TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath("farmersdelight", "mineable/knife"))), PRToolMaterials.ROSE.speed())
                            ),
                            1.0F,
                            1,
                            false
                    ))
                    .component(DataComponents.WEAPON, new Weapon(2))
            )
    );

    public static void init() {}

    public static SmithingTemplateItem createIronUpgradeTemplate(Properties properties) {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", ProgressionReborn.id("smithing_template.iron_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", ProgressionReborn.id("smithing_template.iron_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", ProgressionReborn.id("smithing_template.iron_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", ProgressionReborn.id("smithing_template.iron_upgrade.additions_slot_description"))),
                SmithingTemplateItem.createNetheriteUpgradeIconList(),
                SmithingTemplateItem.createNetheriteUpgradeMaterialList(),
                properties
        );
    }

    public static SmithingTemplateItem createRoseUpgradeTemplate(Properties properties) {
        return new SmithingTemplateItem(
                Component.translatable(Util.makeDescriptionId("item", ProgressionReborn.id("smithing_template.rose_upgrade.applies_to"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", ProgressionReborn.id("smithing_template.rose_upgrade.ingredients"))).withStyle(ChatFormatting.BLUE),
                Component.translatable(Util.makeDescriptionId("item", ProgressionReborn.id("smithing_template.rose_upgrade.base_slot_description"))),
                Component.translatable(Util.makeDescriptionId("item", ProgressionReborn.id("smithing_template.rose_upgrade.additions_slot_description"))),
                SmithingTemplateItem.createNetheriteUpgradeIconList(),
                SmithingTemplateItem.createNetheriteUpgradeMaterialList(),
                properties
        );
    }
}
