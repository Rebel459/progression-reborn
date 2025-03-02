package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.PRConstants;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAsset;

public interface PREquipmentAssets {
    ResourceKey<? extends Registry<EquipmentAsset>> ROOT_ID = ResourceKey.createRegistryKey(ResourceLocation.withDefaultNamespace("equipment_asset"));
    ResourceKey<EquipmentAsset> COPPER = createId("copper");
    ResourceKey<EquipmentAsset> ROSE = createId("rose");

    static ResourceKey<EquipmentAsset> createId(String path) {
        return ResourceKey.create(ROOT_ID, PRConstants.id(path));
    }
}
