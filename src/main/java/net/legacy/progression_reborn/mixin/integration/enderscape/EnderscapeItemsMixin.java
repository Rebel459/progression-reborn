package net.legacy.progression_reborn.mixin.integration.enderscape;

import com.google.common.collect.Maps;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.bunten.enderscape.Enderscape;
import net.bunten.enderscape.registry.EnderscapeAttributes;
import net.bunten.enderscape.registry.EnderscapeItems;
import net.legacy.progression_reborn.config.PRConfig;
import net.minecraft.core.Holder;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.ArmorMaterials;
import net.minecraft.world.item.equipment.ArmorType;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import java.util.Map;

@Mixin(value = EnderscapeItems.class)
public class EnderscapeItemsMixin {

    @Shadow
    @Final
    private static ArmorMaterial SHADOLINE_ARMOR_MATERIAL;

    @WrapOperation
            (
                    method = "<clinit>",
                    at = @At
                            (
                                    value = "NEW",
                                    target = "(ILjava/util/Map;ILnet/minecraft/core/Holder;FFLnet/minecraft/tags/TagKey;Lnet/minecraft/resources/ResourceKey;)Lnet/minecraft/world/item/equipment/ArmorMaterial;"
                            )
            )
    private static ArmorMaterial modifyEnderscapeArmor(int i, Map map, int j, Holder holder, float f, float g, TagKey tagKey, ResourceKey resourceKey, Operation<ArmorMaterial> original){
        if (resourceKey == EnderscapeItems.SHADOLINE_ARMOR_ASSET) {
            return original.call(i, ArmorMaterials.makeDefense(2, 5, 6, 3, 16), j, holder, f, g, tagKey, resourceKey);
        }
        return original.call(i, map, j, holder, f, g, tagKey, resourceKey);
    }

    @Inject(method = "shadolineArmorProperties", at = @At(value = "HEAD"), cancellable = true)
    private static void modifyShadolineStealth(ArmorType type, CallbackInfoReturnable<Item.Properties> cir){
        ItemAttributeModifiers.Builder builder = ItemAttributeModifiers.builder();
        EquipmentSlotGroup group = EquipmentSlotGroup.bySlot(type.getSlot());
        Identifier identifier = Enderscape.id("armor." + type.getName());

        builder.add(Attributes.ARMOR, new AttributeModifier(identifier, SHADOLINE_ARMOR_MATERIAL.defense().getOrDefault(type, 0), AttributeModifier.Operation.ADD_VALUE), group);

        final Map<ArmorType, Double> shadolineStealth = Maps.newEnumMap(Map.of(ArmorType.BOOTS, 0.15, ArmorType.LEGGINGS, 0.15, ArmorType.CHESTPLATE, 0.15, ArmorType.HELMET, 0.15, ArmorType.BODY, 0.6));

        double stealth = shadolineStealth.getOrDefault(type, 0.0);

        builder.add(EnderscapeAttributes.STEALTH, new AttributeModifier(identifier, stealth, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), group);

        ItemAttributeModifiers attributes = builder.build();

        cir.setReturnValue(new Item.Properties().humanoidArmor(SHADOLINE_ARMOR_MATERIAL, type).attributes(attributes));
    }
}
