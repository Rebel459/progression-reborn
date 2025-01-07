package net.legacy.progression_reborn;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public interface PRArmorMaterials {
    ArmorMaterial COPPER = new net.minecraft.world.item.equipment.ArmorMaterial(7, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.BOOTS, 1);
        enumMap.put(ArmorType.LEGGINGS, 3);
        enumMap.put(ArmorType.CHESTPLATE, 4);
        enumMap.put(ArmorType.HELMET, 2);
        enumMap.put(ArmorType.BODY, 6);
    }), 9, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, PRItemTags.REPAIRS_COPPER_ARMOR, PREquipmentAssets.COPPER);

    ArmorMaterial ROSE = new net.minecraft.world.item.equipment.ArmorMaterial(10, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.BOOTS, 2);
        enumMap.put(ArmorType.LEGGINGS, 4);
        enumMap.put(ArmorType.CHESTPLATE, 4);
        enumMap.put(ArmorType.HELMET, 2);
        enumMap.put(ArmorType.BODY, 6);
    }), 25, SoundEvents.ARMOR_EQUIP_GOLD, 0.2F, 0.0F, PRItemTags.REPAIRS_ROSE_ARMOR, PREquipmentAssets.ROSE);
}
