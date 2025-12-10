package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.PRConstants;
import net.legacy.progression_reborn.datagen.PRModelProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.List;

public class PRTrimMaterials {
    public static final List<String> TRIM_MATERIALS = List.of("rose_ingot", "rose_ingot_darker");

    public static final ResourceKey<TrimMaterial> ROSE = register("rose_ingot");
    public static final ResourceKey<TrimMaterial> ROSE_DARKER = register("rose_ingot_darker");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        TrimMaterials.register(context, ROSE, Style.EMPTY.withColor(12876948), PRModelProvider.ROSE_INGOT);
        TrimMaterials.register(context, ROSE_DARKER, Style.EMPTY.withColor(12876948), PRModelProvider.ROSE_INGOT_DARKER);
    }

    private static ResourceKey<TrimMaterial> register(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, PRConstants.id(name));

    }

}