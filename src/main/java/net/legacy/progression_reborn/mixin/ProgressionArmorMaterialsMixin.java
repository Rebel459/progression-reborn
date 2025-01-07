package net.legacy.progression_reborn.mixin;

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

@Mixin(ArmorMaterials.class)
public interface ProgressionArmorMaterialsMixin {

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
        if (resourceKey == LEATHER){
            Map<ArmorType, Integer> leatherMap;
            leatherMap = Util.make(new EnumMap(ArmorType.class), customMap -> {
                customMap.put(ArmorType.BOOTS, 1);
                customMap.put(ArmorType.LEGGINGS, 3);
                customMap.put(ArmorType.CHESTPLATE, 3);
                customMap.put(ArmorType.HELMET, 1);
                customMap.put(ArmorType.BODY, 4);
            });
            return original.call(i, leatherMap, j, holder, f, g, tagKey, resourceKey);
        }
        else if (resourceKey == CHAINMAIL){
            Map<ArmorType, Integer> chainmailMap;
            chainmailMap = Util.make(new EnumMap(ArmorType.class), customMap -> {
                customMap.put(ArmorType.BOOTS, 2);
                customMap.put(ArmorType.LEGGINGS, 4);
                customMap.put(ArmorType.CHESTPLATE, 5);
                customMap.put(ArmorType.HELMET, 3);
                customMap.put(ArmorType.BODY, 8);
            });
            return original.call(i, chainmailMap, j, holder, 1f, g, tagKey, resourceKey);
        }
        else if (resourceKey == IRON){
            Map<ArmorType, Integer> ironMap;
            ironMap = Util.make(new EnumMap(ArmorType.class), customMap -> {
                customMap.put(ArmorType.BOOTS, 2);
                customMap.put(ArmorType.LEGGINGS, 5);
                customMap.put(ArmorType.CHESTPLATE, 6);
                customMap.put(ArmorType.HELMET, 3);
                customMap.put(ArmorType.BODY, 8);
            });
            return original.call(i, ironMap, j, holder, f, g, tagKey, resourceKey);
        }
        else if (resourceKey == GOLD){
            Map<ArmorType, Integer> goldMap;
            goldMap = Util.make(new EnumMap(ArmorType.class), customMap -> {
                customMap.put(ArmorType.BOOTS, 1);
                customMap.put(ArmorType.LEGGINGS, 3);
                customMap.put(ArmorType.CHESTPLATE, 3);
                customMap.put(ArmorType.HELMET, 1);
                customMap.put(ArmorType.BODY, 4);
            });
            return original.call(i, goldMap, j, holder, 1f, g, tagKey, resourceKey);
        }
        else if (resourceKey == DIAMOND){
            Map<ArmorType, Integer> diamondMap;
            diamondMap = Util.make(new EnumMap(ArmorType.class), customMap -> {
                customMap.put(ArmorType.BOOTS, 3);
                customMap.put(ArmorType.LEGGINGS, 6);
                customMap.put(ArmorType.CHESTPLATE, 7);
                customMap.put(ArmorType.HELMET, 4);
                customMap.put(ArmorType.BODY, 12);
            });
            return original.call(i, diamondMap, j, holder, 1f, g, tagKey, resourceKey);
        }
        else if (resourceKey == NETHERITE){
            Map<ArmorType, Integer> netheriteMap;
            netheriteMap = Util.make(new EnumMap(ArmorType.class), customMap -> {
                customMap.put(ArmorType.BOOTS, 3);
                customMap.put(ArmorType.LEGGINGS, 6);
                customMap.put(ArmorType.CHESTPLATE, 7);
                customMap.put(ArmorType.HELMET, 4);
                customMap.put(ArmorType.BODY, 12);
            });
            return original.call(i, netheriteMap, j, holder, 2f, g, tagKey, resourceKey);
        }
        else {
            return original.call(i, map, j, holder, f, g, tagKey, resourceKey);
        }
    }
}