package net.legacy.progression_reborn;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.trim.TrimMaterial;
import net.minecraft.world.item.equipment.trim.TrimMaterials;

import java.util.List;
import java.util.Map;

public class PRTrimMaterials {
    public static final List<String> TRIM_MATERIALS = List.of("rose_ingot", "rose_ingot_darker", "copper_darker");

    public static final ResourceKey<TrimMaterial> ROSE = createResourceKey("rose_ingot");
    public static final ResourceKey<TrimMaterial> ROSE_DARKER = createResourceKey("rose_ingot_darker");
    public static final ResourceKey<TrimMaterial> COPPER_DARKER = createResourceKey("copper_darker");

    public static void bootstrap(BootstrapContext<TrimMaterial> bootstrapContext) {
        TrimMaterials.register(bootstrapContext, ROSE, PRItems.ROSE_INGOT, Style.EMPTY.withColor(12876948), Map.of(PREquipmentAssets.ROSE, "rose_ingot_darker"));
        TrimMaterials.register(bootstrapContext, ROSE_DARKER, PRItems.ROSE_INGOT, Style.EMPTY.withColor(12876948));
        TrimMaterials.register(bootstrapContext, COPPER_DARKER, Items.COPPER_INGOT, Style.EMPTY.withColor(11823181));
    }

    private static ResourceKey<TrimMaterial> createResourceKey(String string) {
        return ResourceKey.create(Registries.TRIM_MATERIAL, ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, string));
    }
}