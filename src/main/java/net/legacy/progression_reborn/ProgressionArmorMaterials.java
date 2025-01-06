package net.legacy.progression_reborn;

import net.minecraft.Util;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.equipment.ArmorType;

import java.util.EnumMap;

public interface ProgressionArmorMaterials {
    net.minecraft.world.item.equipment.ArmorMaterial DUNGEON = new net.minecraft.world.item.equipment.ArmorMaterial(5, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.BOOTS, 2);
        enumMap.put(ArmorType.LEGGINGS, 5);
        enumMap.put(ArmorType.CHESTPLATE, 6);
        enumMap.put(ArmorType.HELMET, 3);
        enumMap.put(ArmorType.BODY, 5);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.1F, ProgressionItemTags.REPAIRS_DUNGEON_ARMOR, ProgressionEquipmentAssets.DUNGEON);

    net.minecraft.world.item.equipment.ArmorMaterial FORTRESS = new net.minecraft.world.item.equipment.ArmorMaterial(5, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.BOOTS, 3);
        enumMap.put(ArmorType.LEGGINGS, 6);
        enumMap.put(ArmorType.CHESTPLATE, 6);
        enumMap.put(ArmorType.HELMET, 3);
        enumMap.put(ArmorType.BODY, 7);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.1F, ProgressionItemTags.REPAIRS_FORTRESS_ARMOR, ProgressionEquipmentAssets.FORTRESS);

    net.minecraft.world.item.equipment.ArmorMaterial WARD = new net.minecraft.world.item.equipment.ArmorMaterial(5, Util.make(new EnumMap(ArmorType.class), enumMap -> {
        enumMap.put(ArmorType.BOOTS, 3);
        enumMap.put(ArmorType.LEGGINGS, 6);
        enumMap.put(ArmorType.CHESTPLATE, 7);
        enumMap.put(ArmorType.HELMET, 4);
        enumMap.put(ArmorType.BODY, 11);
    }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.2F, ProgressionItemTags.REPAIRS_WARD_ARMOR, ProgressionEquipmentAssets.WARD);
}


/*
public class ProgressionArmorMaterialsOld {
    public static final Holder<ArmorMaterial> DUNGEON;
    public static final Holder<ArmorMaterial> FORTRESS;
    public static final Holder<ArmorMaterial> WARD;

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
        DUNGEON = register("dungeon", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (enumMap) -> {
            enumMap.put(ArmorItem.Type.BOOTS, 2);
            enumMap.put(ArmorItem.Type.LEGGINGS, 5);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
            enumMap.put(ArmorItem.Type.HELMET, 3);
            enumMap.put(ArmorItem.Type.BODY, 5);
        }), 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.1F, () -> {
            return Ingredient.of(new ItemLike[]{Items.IRON_INGOT});
        });
        FORTRESS = register("fortress", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (enumMap) -> {
            enumMap.put(ArmorItem.Type.BOOTS, 3);
            enumMap.put(ArmorItem.Type.LEGGINGS, 6);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 6);
            enumMap.put(ArmorItem.Type.HELMET, 3);
            enumMap.put(ArmorItem.Type.BODY, 7);
        }), 16, SoundEvents.ARMOR_EQUIP_DIAMOND, 0.0F, 0.1F, () -> {
            return Ingredient.of(new ItemLike[]{Items.BLAZE_ROD});
        });
        WARD = register("ward", (EnumMap)Util.make(new EnumMap(ArmorItem.Type.class), (enumMap) -> {
            enumMap.put(ArmorItem.Type.BOOTS, 3);
            enumMap.put(ArmorItem.Type.LEGGINGS, 6);
            enumMap.put(ArmorItem.Type.CHESTPLATE, 7);
            enumMap.put(ArmorItem.Type.HELMET, 4);
            enumMap.put(ArmorItem.Type.BODY, 11);
        }), 8, SoundEvents.ARMOR_EQUIP_DIAMOND, 1.0F, 0.2F, () -> {
            return Ingredient.of(new ItemLike[]{Items.ECHO_SHARD});
        });
    }
}*/
