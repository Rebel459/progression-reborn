package net.legacy.progression_reborn.registry;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.legacy.progression_reborn.PRConstants;
import net.legacy.progression_reborn.ProgressionReborn;
import net.minecraft.core.component.DataComponents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.equipment.ArmorMaterials;

public class PRItemComponents {
    public static void init(){

        if (ProgressionReborn.isEndRebornLoaded) {
            DefaultItemComponentEvents.MODIFY.register(context -> {
                context.modify(PRItems.NETHERITE_HORSE_ARMOR, builder -> {
                    builder.set(DataComponents.ATTRIBUTE_MODIFIERS, createNetheriteHorseArmorAttributes());
                });
            });
        }

    }
    public static ItemAttributeModifiers createNetheriteHorseArmorAttributes() {
        return ItemAttributeModifiers.builder()
                .add(Attributes.ARMOR, new AttributeModifier(ARMOR_ID, 12, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.BODY)
                .add(Attributes.ARMOR_TOUGHNESS, new AttributeModifier(ARMOR_TOUGHNESS_ID, ArmorMaterials.NETHERITE.toughness(), AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.BODY)
                .add(Attributes.KNOCKBACK_RESISTANCE, new AttributeModifier(KNOCKBACK_RESISTANCE_ID, ArmorMaterials.NETHERITE.knockbackResistance() * 2F, AttributeModifier.Operation.ADD_VALUE), EquipmentSlotGroup.BODY)
                .add(Attributes.BURNING_TIME, new AttributeModifier(BURNING_TIME_ID, -0.50, AttributeModifier.Operation.ADD_MULTIPLIED_BASE), EquipmentSlotGroup.BODY)
                .build();
    }

    public static final ResourceLocation ARMOR_ID = PRConstants.id("armor");
    public static final ResourceLocation ARMOR_TOUGHNESS_ID = PRConstants.id("armor_toughness");
    public static final ResourceLocation KNOCKBACK_RESISTANCE_ID = PRConstants.id("knockback_resistance");

    public static final ResourceLocation BURNING_TIME_ID = PRConstants.id("burning_time");

}