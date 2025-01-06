package net.legacy.progression_reborn;

import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;

public interface ProgressionEquipmentAssets {
    ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace("equipment_asset"));
    ResourceKey<EquipmentAsset> DUNGEON = createId("dungeon");
    ResourceKey<EquipmentAsset> FORTRESS = createId("fortress");
    ResourceKey<EquipmentAsset> WARD = createId("ward");

    static ResourceKey<EquipmentAsset> createId(String name) {
        return ResourceKey.create(ROOT_ID, ResourceLocation.withDefaultNamespace(name));
    }
}
