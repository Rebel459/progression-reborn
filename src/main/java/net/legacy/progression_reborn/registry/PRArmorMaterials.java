package net.legacy.progression_reborn.registry;

import com.google.common.collect.Maps;
import net.legacy.progression_reborn.sound.PRSounds;
import net.legacy.progression_reborn.tag.PRItemTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.Map;

public interface PRArmorMaterials {
    ArmorMaterial COPPER = new ArmorMaterial(
            11,
            makeDefense(1, 3, 4, 2, 6),
            8,
            PRSounds.ARMOR_EQUIP_COPPER,
            0.0F,
            0.0F,
            PRItemTags.REPAIRS_COPPER_ARMOR,
            PREquipmentAssets.COPPER
    );

    ArmorMaterial ROSE = new ArmorMaterial(
            10,
            makeDefense(2, 4, 4, 2, 6),
            25,
            SoundEvents.ARMOR_EQUIP_GOLD,
            2F,
            0.0F,
            PRItemTags.REPAIRS_ROSE_ARMOR,
            PREquipmentAssets.ROSE
    );

    private static Map<ArmorType, Integer> makeDefense(int boots, int leggings, int chestplate, int helmet, int body) {
        return Maps.newEnumMap(Map.of(ArmorType.BOOTS, boots, ArmorType.LEGGINGS, leggings, ArmorType.CHESTPLATE, chestplate, ArmorType.HELMET, helmet, ArmorType.BODY, body));
    }
}
