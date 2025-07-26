package net.legacy.progression_reborn.registry;

import net.fabricmc.fabric.api.item.v1.FabricItem;
import net.minecraft.resources.ResourceKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.*;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.level.block.Block;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.Item.Properties;
import org.jetbrains.annotations.NotNull;

import java.util.function.Function;

public final class PREquipmentItems {
/*    // Tools
    public static final Item COPPER_SWORD = register("copper_sword", settings -> new Item(settings
            .stacksTo(1)
            .sword(PRToolMaterial.COPPER, 3f, -2.4f)
            .durability(190)
    ));
    public static final Item COPPER_PICKAXE = register("copper_pickaxe", settings -> new Item(settings
            .stacksTo(1)
            .pickaxe(PRToolMaterial.COPPER, 1f, -2.8f)
            .durability(190)
    ));
    public static final AxeItem COPPER_AXE = register("copper_axe", settings -> new AxeItem(PRToolMaterial.COPPER, 6f, -3.1f, settings
            .stacksTo(1)
            .durability(190)
    ));
    public static final ShovelItem COPPER_SHOVEL = register("copper_shovel", settings -> new ShovelItem(PRToolMaterial.COPPER, 1.5f, -3f, settings
            .stacksTo(1)
            .durability(190)
    ));
    public static final HoeItem COPPER_HOE = register("copper_hoe", settings -> new HoeItem(PRToolMaterial.COPPER, -2f, -1f, settings
            .stacksTo(1)
            .durability(190)
    ));

    public static final Item ROSE_SWORD = register("rose_sword", settings -> new Item(settings
            .stacksTo(1)
            .sword(PRToolMaterial.ROSE, 3f, -2.4f)
            .durability(281)
            .fireResistant()
    ));
    public static final Item ROSE_PICKAXE = register("rose_pickaxe", settings -> new Item(settings
            .stacksTo(1)
            .pickaxe(PRToolMaterial.ROSE, 1f, -2.8f)
            .durability(281)
            .fireResistant()
    ));
    public static final AxeItem ROSE_AXE = register("rose_axe", settings -> new AxeItem(PRToolMaterial.ROSE, 6f, -3.1f, settings
            .stacksTo(1)
            .durability(281)
            .fireResistant()
    ));
    public static final ShovelItem ROSE_SHOVEL = register("rose_shovel", settings -> new ShovelItem(PRToolMaterial.ROSE, 1.5f, -3f, settings
            .stacksTo(1)
            .durability(281)
            .fireResistant()
    ));
    public static final HoeItem ROSE_HOE = register("rose_hoe", settings -> new HoeItem(PRToolMaterial.ROSE, -2f, -1f, settings
            .stacksTo(1)
            .durability(281)
            .fireResistant()
    ));

    // Armor
    public static final Item COPPER_HELMET = register("copper_helmet", settings -> new Item(settings
            .stacksTo(1)
            .humanoidArmor(PRArmorMaterials.COPPER, ArmorType.HELMET)
    ));
    public static final Item COPPER_CHESTPLATE = register("copper_chestplate", settings -> new Item(settings
            .stacksTo(1)
            .humanoidArmor(PRArmorMaterials.COPPER, ArmorType.CHESTPLATE)
    ));
    public static final Item COPPER_LEGGINGS = register("copper_leggings", settings -> new Item(settings
            .stacksTo(1)
            .humanoidArmor(PRArmorMaterials.COPPER, ArmorType.LEGGINGS)
    ));
    public static final Item COPPER_BOOTS = register("copper_boots", settings -> new Item(settings
            .stacksTo(1)
            .humanoidArmor(PRArmorMaterials.COPPER, ArmorType.BOOTS)
    ));
    public static final Item COPPER_HORSE_ARMOR = register("copper_horse_armor", settings -> new Item(settings
            .stacksTo(1)
            .horseArmor(PRArmorMaterials.COPPER)
    ));

    public static final Item ROSE_HELMET = register("rose_helmet", settings -> new Item(settings
            .stacksTo(1)
            .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.HELMET)
            .fireResistant()
    ));
    public static final Item ROSE_CHESTPLATE = register("rose_chestplate", settings -> new Item(settings
            .stacksTo(1)
            .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.CHESTPLATE)
            .fireResistant()
    ));
    public static final Item ROSE_LEGGINGS = register("rose_leggings", settings -> new Item(settings
            .stacksTo(1)
            .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.LEGGINGS)
            .fireResistant()
    ));
    public static final Item ROSE_BOOTS = register("rose_boots", settings -> new Item(settings
            .stacksTo(1)
            .humanoidArmor(PRArmorMaterials.ROSE, ArmorType.BOOTS)
            .fireResistant()
    ));
    public static final Item ROSE_HORSE_ARMOR = register("rose_horse_armor", settings -> new Item(settings
            .stacksTo(1)
            .horseArmor(PRArmorMaterials.ROSE)
            .fireResistant()
    ));

    public static final Item NETHERITE_HORSE_ARMOR = register("netherite_horse_armor", settings -> new Item(settings
            .stacksTo(1)
            .horseArmor(ArmorMaterials.NETHERITE)
            .fireResistant()
    ));*/


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