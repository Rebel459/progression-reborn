package net.legacy.progression_reborn;

import net.minecraft.Util;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.TrimMaterial;

import java.util.Map;

public class PRTrimMaterials {
    public static final ResourceKey<TrimMaterial> ROSE = registryKey("rose");

    public static void bootstrap(BootstrapContext<TrimMaterial> context) {
        register(context, ROSE, PRItems.ROSE_INGOT, Style.EMPTY.withColor(12876948), Map.of(EquipmentAssets.DIAMOND, "rose"));
    }

    private static void register(BootstrapContext<TrimMaterial> context, ResourceKey<TrimMaterial> materialKey, Item ingredient, Style style) {
        register(context, materialKey, ingredient, style, Map.of());
    }

    private static void register(
            BootstrapContext<TrimMaterial> context,
            ResourceKey<TrimMaterial> materialKey,
            Item ingredient,
            Style style,
            Map<ResourceKey<EquipmentAsset>, String> overrideArmorMaterials
    ) {
        TrimMaterial trimMaterial = TrimMaterial.create(
                materialKey.location().getPath(),
                ingredient,
                Component.translatable(Util.makeDescriptionId("trim_material", materialKey.location())).withStyle(style),
                overrideArmorMaterials
        );
        context.register(materialKey, trimMaterial);
    }

    private static ResourceKey<TrimMaterial> registryKey(String name) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "rose"));
    }
}
