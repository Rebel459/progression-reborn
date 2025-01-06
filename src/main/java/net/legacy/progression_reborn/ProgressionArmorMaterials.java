package net.legacy.progression_reborn;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public interface ProgressionArmorMaterials {
    ArmorMaterial COPPER = new net.minecraft.world.item.equipment.ArmorMaterial(5, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.BOOTS, 1);
        enumMap.put(ArmorType.LEGGINGS, 3);
        enumMap.put(ArmorType.CHESTPLATE, 4);
        enumMap.put(ArmorType.HELMET, 2);
        enumMap.put(ArmorType.BODY, 0);
    }), 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.1F, ProgressionItemTags.REPAIRS_COPPER_ARMOR, ProgressionEquipmentAssets.COPPER);

    ArmorMaterial ROSE = new net.minecraft.world.item.equipment.ArmorMaterial(5, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.BOOTS, 3);
        enumMap.put(ArmorType.LEGGINGS, 6);
        enumMap.put(ArmorType.CHESTPLATE, 6);
        enumMap.put(ArmorType.HELMET, 3);
        enumMap.put(ArmorType.BODY, 7);
    }), 10, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.1F, ProgressionItemTags.REPAIRS_ROSE_ARMOR, ProgressionEquipmentAssets.ROSE);
}
