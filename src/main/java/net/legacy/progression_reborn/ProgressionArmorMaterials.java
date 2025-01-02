package net.legacy.progression_reborn;

import net.minecraft.Util;
import net.minecraft.core.Holder;
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
import java.util.List;
import java.util.function.Supplier;

public class ProgressionArmorMaterials {
    public static final Holder<ArmorMaterial> COPPER;
    public static final Holder<ArmorMaterial> ROSE;

    public ProgressionArmorMaterials() {
    }

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngredient) {
        List<ArmorMaterial.Layer> list = List.of(new ArmorMaterial.Layer(ResourceLocation.withDefaultNamespace(name)));
        return register(name, defense, enchantmentValue, equipSound, toughness, knockbackResistance, repairIngredient, list);
    }

    private static Holder<ArmorMaterial> register(String name, EnumMap<ArmorItem.Type, Integer> defense, int enchantmentValue, Holder<SoundEvent> equipSound, float toughness, float knockbackResistance, Supplier<Ingredient> repairIngridient, List<ArmorMaterial.Layer> layers) {
        EnumMap<ArmorItem.Type, Integer> enumMap = new EnumMap(ArmorItem.Type.class);
        ArmorItem.Type[] var9 = ArmorItem.Type.values();
        int var10 = var9.length;

        for(int var11 = 0; var11 < var10; ++var11) {
            ArmorItem.Type type = var9[var11];
            enumMap.put(type, (Integer)defense.get(type));
        }

        return Registry.registerForHolder(BuiltInRegistries.ARMOR_MATERIAL, ResourceLocation.withDefaultNamespace(name), new ArmorMaterial(enumMap, enchantmentValue, equipSound, repairIngridient, layers, toughness, knockbackResistance));
    }

    static {
        COPPER = register("copper", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (enumMap) -> {
            enumMap.put(ArmorItem.Type.BOOTS, 1);
            enumMap.put(ArmorItem.Type.LEGGINGS, 3);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 4);
            enumMap.put(ArmorItem.Type.HELMET, 2);
            enumMap.put(ArmorItem.Type.BODY, 0);
        }), 10, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F, () -> {
            return Ingredient.of(new ItemLike[]{Items.COPPER_INGOT});
        });
    }

    static {
        ROSE = register("rose", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (enumMap) -> {
            enumMap.put(ArmorItem.Type.BOOTS, 2);
            enumMap.put(ArmorItem.Type.LEGGINGS, 4);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 4);
            enumMap.put(ArmorItem.Type.HELMET, 2);
            enumMap.put(ArmorItem.Type.BODY, 0);
        }), 10, SoundEvents.ARMOR_EQUIP_GOLD, 0.5F, 0.0F, () -> {
            return Ingredient.of(new ItemLike[]{Items.COPPER_INGOT});
        });
    }
}