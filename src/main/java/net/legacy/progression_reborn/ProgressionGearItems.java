package net.legacy.progression_reborn;

import net.frozenblock.lib.shadow.org.jetbrains.annotations.NotNull;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;

import java.util.function.Function;

public final class ProgressionGearItems {

    // Weapons
    public static final ProgressionWeapon HOOK = register("hook", settings -> new ProgressionWeapon(ProgressionToolMaterial.METAL, 4f, -3.2f, settings
            .stacksTo(1)
            .durability(750)
    ));
    public static final ProgressionWeapon ANCIENT_KNIFE = register("ancient_knife", settings -> new ProgressionWeapon(ProgressionToolMaterial.ANCIENT, 2f, -2f, settings
            .stacksTo(1)
            .durability(3048)
    ));

    // Armor
    public static final ArmorItem DUNGEON_HELMET = register("dungeon_helmet", settings -> new ArmorItem(ProgressionArmorMaterials.DUNGEON, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.HELMET.getDurability(27))
    ));
    public static final ArmorItem DUNGEON_CHESTPLATE = register("dungeon_chestplate", settings -> new ArmorItem(ProgressionArmorMaterials.DUNGEON, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.CHESTPLATE.getDurability(27))
    ));
    public static final ArmorItem DUNGEON_LEGGINGS = register("dungeon_leggings", settings -> new ArmorItem(ProgressionArmorMaterials.DUNGEON, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.LEGGINGS.getDurability(27))
    ));
    public static final ArmorItem DUNGEON_BOOTS = register("dungeon_boots", settings -> new ArmorItem(ProgressionArmorMaterials.DUNGEON, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.BOOTS.getDurability(27))
    ));

    public static final ArmorItem FORTRESS_HELMET = register("fortress_helmet", settings -> new ArmorItem(ProgressionArmorMaterials.FORTRESS, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.HELMET.getDurability(23))
            .fireResistant()
    ));
    public static final ArmorItem FORTRESS_CHESTPLATE = register("fortress_chestplate", settings -> new ArmorItem(ProgressionArmorMaterials.FORTRESS, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.CHESTPLATE.getDurability(23))
            .fireResistant()
    ));
    public static final ArmorItem FORTRESS_LEGGINGS = register("fortress_leggings", settings -> new ArmorItem(ProgressionArmorMaterials.FORTRESS, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.LEGGINGS.getDurability(23))
            .fireResistant()
    ));
    public static final ArmorItem FORTRESS_BOOTS = register("fortress_boots", settings -> new ArmorItem(ProgressionArmorMaterials.FORTRESS, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.BOOTS.getDurability(23))
            .fireResistant()
    ));

    public static final ArmorItem WARD_HELMET = register("ward_helmet", settings -> new ArmorItem(ProgressionArmorMaterials.WARD, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.HELMET.getDurability(41))
    ));
    public static final ArmorItem WARD_CHESTPLATE = register("ward_chestplate", settings -> new ArmorItem(ProgressionArmorMaterials.WARD, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.CHESTPLATE.getDurability(41))
    ));
    public static final ArmorItem WARD_LEGGINGS = register("ward_leggings", settings -> new ArmorItem(ProgressionArmorMaterials.WARD, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.LEGGINGS.getDurability(41))
    ));
    public static final ArmorItem WARD_BOOTS = register("ward_boots", settings -> new ArmorItem(ProgressionArmorMaterials.WARD, ArmorType.HELMET, settings
            .stacksTo(1)
            .durability(ArmorType.BOOTS.getDurability(41))
    ));

    public static void init() {
    }

    private static @NotNull <T extends Item> T register(String name, @NotNull Function<Properties, Item> function) {
        return (T) Items.registerItem(ResourceKey.create(Registries.ITEM, ProgressionConstants.id(name)), function);
    }

    private static Item register (String name) {
        return register(name, Item::new);
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }

}
