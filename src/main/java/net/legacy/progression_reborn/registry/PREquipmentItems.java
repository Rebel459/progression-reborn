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
    // Tools
    public static final Item COPPER_SWORD = register("copper_sword", new Properties().sword(PRToolMaterial.COPPER, 3f, -2.4f)
            .stacksTo(1)
            .durability(190)
    );
    public static final Item COPPER_PICKAXE = register("copper_pickaxe", new Properties().pickaxe(PRToolMaterial.COPPER, 1f, -2.8f)
            .stacksTo(1)
            .durability(190)
    );
    public static final Item COPPER_AXE = register("copper_axe", new Properties().axe(PRToolMaterial.COPPER, 6f, -3.1f)
            .stacksTo(1)
            .durability(190)
    );
    public static final Item COPPER_SHOVEL = register("copper_shovel", new Properties().shovel(PRToolMaterial.COPPER, 1.5f, -3f)
            .stacksTo(1)
            .durability(190)
    );
    public static final Item COPPER_HOE = register("copper_hoe", new Properties().hoe(PRToolMaterial.COPPER, -2f, -1f)
            .stacksTo(1)
            .durability(190)
    );

    public static final Item ROSE_SWORD = register("rose_sword", new Properties().sword(PRToolMaterial.ROSE, 3f, -2.4f)
            .stacksTo(1)
            .durability(281)
            .fireResistant()
    );
    public static final Item ROSE_PICKAXE = register("rose_pickaxe", new Properties().pickaxe(PRToolMaterial.ROSE, 1f, -2.8f)
            .stacksTo(1)
            .durability(281)
            .fireResistant()
    );
    public static final Item ROSE_AXE = register("rose_axe", new Properties().axe(PRToolMaterial.ROSE, 6f, -3.1f)
            .stacksTo(1)
            .durability(281)
            .fireResistant()
    );
    public static final Item ROSE_SHOVEL = register("rose_shovel", new Properties().shovel(PRToolMaterial.ROSE, 1.5f, -3f)
            .stacksTo(1)
            .durability(281)
            .fireResistant()
    );
    public static final Item ROSE_HOE = register("rose_hoe", new Properties().hoe(PRToolMaterial.ROSE, -2f, -1f)
            .stacksTo(1)
            .durability(281)
            .fireResistant()
    );

    // Armor
    public static final Item COPPER_HELMET = register("copper_helmet", new Item.Properties().humanoidArmor(PRArmorMaterials.COPPER, ArmorType.HELMET)
            .stacksTo(1)
    );
    public static final Item COPPER_CHESTPLATE = register("copper_chestplate", new Item.Properties().humanoidArmor(PRArmorMaterials.COPPER, ArmorType.CHESTPLATE)
            .stacksTo(1)
    );
    public static final Item COPPER_LEGGINGS = register("copper_leggings", new Item.Properties().humanoidArmor(PRArmorMaterials.COPPER, ArmorType.LEGGINGS)
            .stacksTo(1)
    );
    public static final Item COPPER_BOOTS = register("copper_boots", new Item.Properties().humanoidArmor(PRArmorMaterials.COPPER, ArmorType.BOOTS)
            .stacksTo(1)
    );
    public static final Item COPPER_HORSE_ARMOR = register("copper_horse_armor", new Item.Properties().horseArmor(PRArmorMaterials.COPPER)
            .stacksTo(1)
    );

    public static final Item ROSE_HELMET = register("rose_helmet", new Item.Properties().humanoidArmor(PRArmorMaterials.ROSE, ArmorType.HELMET)
            .stacksTo(1)
            .fireResistant()
    );
    public static final Item ROSE_CHESTPLATE = register("rose_chestplate", new Item.Properties().humanoidArmor(PRArmorMaterials.ROSE, ArmorType.CHESTPLATE)
            .stacksTo(1)
            .fireResistant()
    );
    public static final Item ROSE_LEGGINGS = register("rose_leggings", new Item.Properties().humanoidArmor(PRArmorMaterials.ROSE, ArmorType.LEGGINGS)
            .stacksTo(1)
            .fireResistant()
    );
    public static final Item ROSE_BOOTS = register("rose_boots", new Item.Properties().humanoidArmor(PRArmorMaterials.ROSE, ArmorType.BOOTS)
            .stacksTo(1)
            .fireResistant()
    );
    public static final Item ROSE_HORSE_ARMOR = register("rose_horse_armor", new Item.Properties().horseArmor(PRArmorMaterials.ROSE)
            .stacksTo(1)
            .fireResistant()
    );

    public static final Item NETHERITE_HORSE_ARMOR = register("netherite_horse_armor", new Item.Properties().horseArmor(ArmorMaterials.NETHERITE)
            .stacksTo(1)
            .fireResistant()
    );


    public static void init() {
    }

    private static @NotNull Item register(String name, @NotNull Properties properties) {
        return Items.registerItem(ResourceKey.create(Registries.ITEM, net.legacy.progression_reborn.PRConstants.id(name)), Item::new, properties);
    }

    private static Item register (String name) {
        return register(name, new Properties());
    }

    public static Function<Properties, Item> createBlockItemWithCustomItemName(Block block) {
        return properties -> new BlockItem(block, properties.useItemDescriptionPrefix());
    }

}
