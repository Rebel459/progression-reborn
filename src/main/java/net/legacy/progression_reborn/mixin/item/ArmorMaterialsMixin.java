package net.legacy.progression_reborn.mixin.item;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.legacy.progression_reborn.registry.PRArmorMaterials;
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
            return original.call(i, PRArmorMaterials.makeDefense(1, 3, 3, 1, 4), j, holder, f, g, tagKey, resourceKey);
        } else if (resourceKey == CHAINMAIL) {
            return original.call(i, PRArmorMaterials.makeDefense(2, 4, 5, 3, 8), j, holder, 1f, g, tagKey, resourceKey);
        } else if (resourceKey == IRON) {
            return original.call(i, PRArmorMaterials.makeDefense(2, 5, 6, 3, 8), j, holder, f, g, tagKey, resourceKey);
        } else if (resourceKey == GOLD) {
            return original.call(i, PRArmorMaterials.makeDefense(1, 3, 3, 1, 4), j, holder, 1f, g, tagKey, resourceKey);
        } else if (resourceKey == DIAMOND) {
            return original.call(i, PRArmorMaterials.makeDefense(3, 6, 7, 4, 12), j, holder, 1f, g, tagKey, resourceKey);
        } else if (resourceKey == NETHERITE) {
            return original.call(i, PRArmorMaterials.makeDefense(3, 6, 7, 4, 12), j, holder, 2f, g, tagKey, resourceKey);
        } else {
            return original.call(i, map, j, holder, f, g, tagKey, resourceKey);
        }
    }
}