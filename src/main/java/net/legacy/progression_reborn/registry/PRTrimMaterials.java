package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.ProgressionReborn;
import net.legacy.progression_reborn.datagen.PRModelProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.MaterialAssetGroup;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.List;
import java.util.Map;

public class PRTrimMaterials {
    public static final MaterialAssetGroup ROSE_GROUP = MaterialAssetGroup.create("rose", Map.of(PREquipmentAssets.ROSE, "rose_darker"));

    public static final ResourceKey<TrimMaterial> ROSE = register("rose");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        TrimMaterials.register(context, ROSE, Style.EMPTY.withColor(12876948), ROSE_GROUP);
    }

    private static ResourceKey<TrimMaterial> register(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, ProgressionReborn.id(name));

    }
}