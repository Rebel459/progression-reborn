package net.legacy.progression_reborn.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.legacy.progression_reborn.PREquipmentAssets;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

import java.util.Map;

import static net.minecraft.world.item.equipment.trim.TrimMaterials.COPPER;

@Mixin(value = TrimMaterials.class, priority = 1001)
public class PRTrimMaterialsMixin {

    @WrapOperation
            (
            method = "register(Lnet/minecraft/data/worldgen/BootstrapContext;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/world/item/Item;Lnet/minecraft/network/chat/Style;)V",
            at = @At
                    (
                            value = "INVOKE",
                            target = "Lnet/minecraft/world/item/equipment/trim/TrimMaterials;register(Lnet/minecraft/data/worldgen/BootstrapContext;Lnet/minecraft/resources/ResourceKey;Lnet/minecraft/world/item/Item;Lnet/minecraft/network/chat/Style;Ljava/util/Map;)V"
                    )
            )
    private static void modifyTrimMaterials(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> materialKey, Item ingredient, Style style, Map<ResourceKey<EquipmentAsset>, String> overrideArmorMaterials, Operation<Void> original){
        if (materialKey == COPPER){
            original.call(context, materialKey, ingredient, style, Map.of(PREquipmentAssets.COPPER, "copper_darker"));
        }
        else {
            original.call(context, materialKey, ingredient, style, overrideArmorMaterials);
        }
    }
}