package net.legacy.progression_reborn.registry;

import com.google.common.collect.Maps;
import net.legacy.progression_reborn.sound.PRSounds;
import net.legacy.progression_reborn.tag.PRItemTags;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.Map;

public interface PRArmorMaterials {

    ArmorMaterial ROSE = new ArmorMaterial(
            10,
            ArmorMaterials.makeDefense(2, 4, 4, 2, 6),
            25,
            SoundEvents.ARMOR_EQUIP_GOLD,
            2F,
            0.0F,
            PRItemTags.REPAIRS_ROSE_ARMOR,
            PREquipmentAssets.ROSE
    );
}
