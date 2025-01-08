package net.legacy.progression_reborn;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;

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
    public static final Item IRON_UPGRADE_SMITHING_TEMPLATE = register("iron_upgrade_smithing_template",
            SmithingTemplateItem::createArmorTrimTemplate,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item ROSE_UPGRADE_SMITHING_TEMPLATE = register("rose_upgrade_smithing_template",
            SmithingTemplateItem::createArmorTrimTemplate,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.UNCOMMON)
    );
    public static final Item ENCHANTED_GOLDEN_CARROT = register("enchanted_golden_carrot",
            Item::new,
            new Properties()
                    .stacksTo(64)
                    .rarity(Rarity.EPIC)
                    .food(PRFoods.ENCHANTED_GOLDEN_CARROT, PRConsumables.ENCHANTED_GOLDEN_CARROT)
                    .component(DataComponents.ENCHANTMENT_GLINT_OVERRIDE, true)
    );

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function, Item.@NotNull Properties properties) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, net.legacy.progression_reborn.PRConstants.id(name)), function, properties);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }
}
