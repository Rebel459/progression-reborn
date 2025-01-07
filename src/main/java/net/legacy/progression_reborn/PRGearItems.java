package net.legacy.progression_reborn;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;

import java.util.function.Function;

public final class PRGearItems {

    // Weapons
    public static final SwordItem PLACEHOLDER_SWORD = register("placeholder_sword", settings -> new SwordItem(PRToolMaterial.COPPER, 4f, -3.2f, settings
            .stacksTo(1)
            .durability(750)
    ));

    // Armor
    public static final ArmorItem COPPER_HELMET = register("copper_helmet", settings -> new ArmorItem(PRArmorMaterials.COPPER, ArmorType.HELMET, settings
            .stacksTo(1)
    ));
    public static final ArmorItem COPPER_CHESTPLATE = register("copper_chestplate", settings -> new ArmorItem(PRArmorMaterials.COPPER, ArmorType.HELMET, settings
            .stacksTo(1)
    ));
    public static final ArmorItem COPPER_LEGGINGS = register("copper_leggings", settings -> new ArmorItem(PRArmorMaterials.COPPER, ArmorType.HELMET, settings
            .stacksTo(1)
    ));
    public static final ArmorItem COPPER_BOOTS = register("copper_boots", settings -> new ArmorItem(PRArmorMaterials.COPPER, ArmorType.HELMET, settings
            .stacksTo(1)
    ));

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, net.legacy.progression_reborn.PRConstants.id(name)), function);
    }

    private static Item register (String name) {
        return register(name, Item::new);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }

}
