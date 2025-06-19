package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.PRConstants;
import net.legacy.progression_reborn.datagen.PRModelProvider;
import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PRTrimMaterials {
    public static final List<ResourceKey<TrimMaterial>> TRIM_MATERIALS = new ArrayList<>();

    public static final ResourceKey<TrimMaterial> ROSE = register("rose_ingot");
    public static final ResourceKey<TrimMaterial> ROSE_DARKER = register("rose_ingot_darker");
    public static final ResourceKey<TrimMaterial> COPPER_DARKER = register("copper_darker");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, ROSE, PRItems.ROSE_INGOT, Style.EMPTY.withColor(12876948));
        register(context, ROSE_DARKER, PRItems.ROSE_INGOT, Style.EMPTY.withColor(12876948));
        register(context, COPPER_DARKER, Items.COPPER_INGOT, Style.EMPTY.withColor(11823181));
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> key, Item item, Style style) {
        ResourceLocation location = key.location();
        TrimMaterial material = new TrimMaterial(PRModelProvider.ROSE, Component.translatable(Util.makeDescriptionId("trim_material", location)).withStyle(style));
        context.register(key, material);
    }

    private static ResourceKey<TrimMaterial> register(String name) {
        ResourceKey<TrimMaterial> key = ResourceKey.create(Registries.TRIM_MATERIAL, PRConstants.id(name));
        TRIM_MATERIALS.add(key);
        return key;
    }
}