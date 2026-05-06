package net.legacy.progression_reborn.registry;

import net.minecraft.Util;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;

import java.util.EnumMap;
import java.util.function.Supplier;

public class PRArmorMaterials {

    public static final ArmorMaterial COPPER;
    public static final ArmorMaterial ROSE;

    static {
        COPPER = register("copper",
                Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, 1);
                    map.put(ArmorItem.Type.LEGGINGS, 3);
                    map.put(ArmorItem.Type.CHESTPLATE, 4);
                    map.put(ArmorItem.Type.HELMET, 2);
                }),
                9,
                SoundEvents.ARMOR_EQUIP_IRON,
                0.0F,
                0.0F,
                () -> Ingredient.of(Items.COPPER_INGOT)
        );

        ROSE = register("rose",
                Util.make(new EnumMap<>(ArmorItem.Type.class), map -> {
                    map.put(ArmorItem.Type.BOOTS, 2);
                    map.put(ArmorItem.Type.LEGGINGS, 4);
                    map.put(ArmorItem.Type.CHESTPLATE, 4);
                    map.put(ArmorItem.Type.HELMET, 2);
                }),
                25,
                SoundEvents.ARMOR_EQUIP_GOLD,
                2.0F,
                0.1F,
                () -> Ingredient.of(Items.BLAZE_ROD)
        );
    }

    private static ArmorMaterial register(
            String name,
            EnumMap<ArmorItem.Type, Integer> defensePoints,
            int enchantmentValue,
            SoundEvent equipSound,
            float toughness,
            float knockbackResistance,
            Supplier<Ingredient> repairIngredient
    ) {

        return new ArmorMaterial() {

            @Override
            public int getDurabilityForType(ArmorItem.Type type) {
                return defensePoints.get(type);
            }

            @Override
            public int getDefenseForType(ArmorItem.Type type) {
                return defensePoints.get(type);
            }

            @Override
            public int getEnchantmentValue() {
                return enchantmentValue;
            }

            @Override
            public SoundEvent getEquipSound() {
                return equipSound;
            }

            @Override
            public Ingredient getRepairIngredient() {
                return repairIngredient.get();
            }

            @Override
            public String getName() {
                return name;
            }

            @Override
            public float getToughness() {
                return toughness;
            }

            @Override
            public float getKnockbackResistance() {
                return knockbackResistance;
            }
        };
    }
}
