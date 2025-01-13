package net.legacy.progression_reborn;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.List;
import java.util.Map;

public class PRTrimMaterials {
    public static final List<String> TRIM_MATERIALS = List.of("rose_ingot");

    public static final ResourceKey<TrimMaterial> ROSE = createResourceKey("rose_ingot");

    public static void bootstrap(BootstrapContext<TrimMaterial> bootstrapContext) {
        TrimMaterials.register(bootstrapContext, ROSE, PRItems.ROSE_INGOT, Style.EMPTY.withColor(12876948), Map.of(PREquipmentAssets.ROSE, "rose_ingot_darker"));
    }

    private static ResourceKey<TrimMaterial> createResourceKey(String string) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, string));
    }
}