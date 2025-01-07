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
    public static final Item PLACEHOLDER_ITEM = register("placeholder_item",
            Item::new,
            new Properties()
                    .stacksTo(64)
    );
    public static final Item ENCHANTED_GOLDEN_CARROT = register("enchanted_golden_carrot",
            Item::new,
            new Properties()
                    .stacksTo(1)
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
