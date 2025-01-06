package net.legacy.progression_reborn.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.EquipmentAssets;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.EnumMap;

@Mixin(ArmorMaterials.class)
public interface TestMixin {


    @WrapOperation(method = "method_48412", at = @At("HEAD"))
    private static void leather_inject(EnumMap enumMap, CallbackInfo ci) {
        new ArmorMaterial(5, Util.make(new EnumMap(ArmorType.class), TestMixin::accept), 15, SoundEvents.ARMOR_EQUIP_LEATHER, 0.0F, 0.0F, ItemTags.REPAIRS_LEATHER_ARMOR, EquipmentAssets.LEATHER);
    }

    private static void accept(EnumMap enumMap) {
        enumMap.put(ArmorType.BOOTS, 15);
        enumMap.put(ArmorType.LEGGINGS, 15);
        enumMap.put(ArmorType.CHESTPLATE, 15);
        enumMap.put(ArmorType.HELMET, 15);
        enumMap.put(ArmorType.BODY, 15);
    }
}