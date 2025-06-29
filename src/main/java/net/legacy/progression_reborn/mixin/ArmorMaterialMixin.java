package net.legacy.progression_reborn.mixin;

import java.util.EnumMap;
import java.util.Map;

import net.minecraft.Util;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;


@Mixin(ArmorMaterial.class)
public abstract class ArmorMaterialMixin {
    @Shadow @Final private Map<ArmorItem.Type, Integer> defense;


    @Inject(method = "getDefense", at = @At("HEAD"), cancellable = true)
    private void modifyDefense(ArmorItem.Type type, CallbackInfoReturnable<Integer> cir) {
        ArmorMaterial material = (ArmorMaterial)(Object)this;
        Map<ArmorItem.Type, Integer> newProtectionAmounts = this.defense;
        if (material == ArmorMaterials.LEATHER.value()) {
            newProtectionAmounts = Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 4);
            });
        }
        else if (material == ArmorMaterials.CHAIN.value()) {
            newProtectionAmounts = Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 4);
                map.put(ArmorItem.Type.CHESTPLATE, 5);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 8);
            });
        }
        else if (material == ArmorMaterials.IRON.value()) {
            newProtectionAmounts = Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 2);
                map.put(ArmorItem.Type.LEGGINGS, 5);
                map.put(ArmorItem.Type.CHESTPLATE, 6);
                map.put(ArmorItem.Type.HELMET, 3);
                map.put(ArmorItem.Type.BODY, 8);
            });
        }
        else if (material == ArmorMaterials.GOLD.value()) {
            newProtectionAmounts = Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 1);
                map.put(ArmorItem.Type.LEGGINGS, 3);
                map.put(ArmorItem.Type.CHESTPLATE, 3);
                map.put(ArmorItem.Type.HELMET, 1);
                map.put(ArmorItem.Type.BODY, 4);
            });
        }
        else if (material == ArmorMaterials.DIAMOND.value() || material == ArmorMaterials.ARMADILLO.value()) {
            newProtectionAmounts = Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 12);
            });
        }
        else if (material == ArmorMaterials.NETHERITE.value()) {
            newProtectionAmounts = Util.make(new EnumMap<ArmorItem.Type, Integer>(ArmorItem.Type.class), map -> {
                map.put(ArmorItem.Type.BOOTS, 3);
                map.put(ArmorItem.Type.LEGGINGS, 6);
                map.put(ArmorItem.Type.CHESTPLATE, 7);
                map.put(ArmorItem.Type.HELMET, 4);
                map.put(ArmorItem.Type.BODY, 12);
            });
        }
        cir.setReturnValue(newProtectionAmounts.get(type));
    }

    @Inject(method = "toughness", at = @At("HEAD"), cancellable = true)
    private void modifyToughness(CallbackInfoReturnable<Float> cir) {
        ArmorMaterial material = (ArmorMaterial)(Object)this;
        if (material == ArmorMaterials.CHAIN.value()) {
            cir.setReturnValue(1F);
        }
        else if (material == ArmorMaterials.GOLD.value()) {
            cir.setReturnValue(1F);
        }
        else if (material == ArmorMaterials.DIAMOND.value()) {
            cir.setReturnValue(1F);
        }
        else if (material == ArmorMaterials.NETHERITE.value()) {
            cir.setReturnValue(2F);
        }
    }
}
