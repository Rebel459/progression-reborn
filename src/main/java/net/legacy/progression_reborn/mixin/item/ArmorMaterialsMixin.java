package net.legacy.progression_reborn.mixin.item;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.Util;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.*;
import org.spongepowered.asm.mixin.Mixin;

import java.util.EnumMap;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.world.item.equipment.ArmorMaterials;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;

import static net.minecraft.world.item.equipment.EquipmentAssets.*;

@Mixin(value = ArmorMaterials.class)
public interface ArmorMaterialsMixin {

    @WrapOperation
            (
            method = "<clinit>",
            at = @At
                    (
                            value = "NEW",
                            target = "(ILjava/util/Map;ILnet/minecraft/core/Holder;FFLnet/minecraft/tags/TagKey;Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/world/item/equipment/ArmorMaterial;"
                    )
            )
    private static ArmorMaterial modifyArmorMaterial(int i, Map map, int j, Holder holder, float f, float g, TagKey tagKey, ResourceKey resourceKey, Operation<ArmorMaterial> original){
            if (resourceKey == LEATHER) {
                Map<ArmorType, Integer> leatherMap;
                leatherMap = Util.make(new EnumMap(ArmorType.class), enumMap -> {
                    enumMap.put(ArmorType.BOOTS, 1);
                    enumMap.put(ArmorType.LEGGINGS, 3);
                    enumMap.put(ArmorType.CHESTPLATE, 3);
                    enumMap.put(ArmorType.HELMET, 1);
                    enumMap.put(ArmorType.BODY, 4);
                });
                return original.call(i, leatherMap, j, holder, f, g, tagKey, resourceKey);
            } else if (resourceKey == CHAINMAIL) {
                Map<ArmorType, Integer> chainmailMap;
                chainmailMap = Util.make(new EnumMap(ArmorType.class), enumMap -> {
                    enumMap.put(ArmorType.BOOTS, 2);
                    enumMap.put(ArmorType.LEGGINGS, 4);
                    enumMap.put(ArmorType.CHESTPLATE, 5);
                    enumMap.put(ArmorType.HELMET, 3);
                    enumMap.put(ArmorType.BODY, 8);
                });
                return original.call(i, chainmailMap, j, holder, 1f, g, tagKey, resourceKey);
            } else if (resourceKey == IRON) {
                Map<ArmorType, Integer> ironMap;
                ironMap = Util.make(new EnumMap(ArmorType.class), enumMap -> {
                    enumMap.put(ArmorType.BOOTS, 2);
                    enumMap.put(ArmorType.LEGGINGS, 5);
                    enumMap.put(ArmorType.CHESTPLATE, 6);
                    enumMap.put(ArmorType.HELMET, 3);
                    enumMap.put(ArmorType.BODY, 8);
                });
                return original.call(i, ironMap, j, holder, f, g, tagKey, resourceKey);
            } else if (resourceKey == GOLD) {
                Map<ArmorType, Integer> goldMap;
                goldMap = Util.make(new EnumMap(ArmorType.class), enumMap -> {
                    enumMap.put(ArmorType.BOOTS, 1);
                    enumMap.put(ArmorType.LEGGINGS, 3);
                    enumMap.put(ArmorType.CHESTPLATE, 3);
                    enumMap.put(ArmorType.HELMET, 1);
                    enumMap.put(ArmorType.BODY, 4);
                });
                return original.call(i, goldMap, j, holder, 1f, g, tagKey, resourceKey);
            } else if (resourceKey == DIAMOND) {
                Map<ArmorType, Integer> diamondMap;
                diamondMap = Util.make(new EnumMap(ArmorType.class), enumMap -> {
                    enumMap.put(ArmorType.BOOTS, 3);
                    enumMap.put(ArmorType.LEGGINGS, 6);
                    enumMap.put(ArmorType.CHESTPLATE, 7);
                    enumMap.put(ArmorType.HELMET, 4);
                    enumMap.put(ArmorType.BODY, 12);
                });
                return original.call(i, diamondMap, j, holder, 1f, g, tagKey, resourceKey);
            } else if (resourceKey == NETHERITE) {
                Map<ArmorType, Integer> netheriteMap;
                netheriteMap = Util.make(new EnumMap(ArmorType.class), enumMap -> {
                    enumMap.put(ArmorType.BOOTS, 3);
                    enumMap.put(ArmorType.LEGGINGS, 6);
                    enumMap.put(ArmorType.CHESTPLATE, 7);
                    enumMap.put(ArmorType.HELMET, 4);
                    enumMap.put(ArmorType.BODY, 12);
                });
                return original.call(i, netheriteMap, j, holder, 2f, g, tagKey, resourceKey);
            } else {
                return original.call(i, map, j, holder, f, g, tagKey, resourceKey);
        }
    }
}