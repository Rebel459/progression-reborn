package net.legacy.progression_reborn;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.progression_reborn.client.PRBlockRenderLayers;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Optional;

import static net.legacy.progression_reborn.PRConstants.MOD_ID;
import static net.minecraft.core.registries.Registries.PLACED_FEATURE;

/**
 * by Rebel459
 */
public class ProgressionReborn implements ModInitializer {

	public static final ResourceKey<PlacedFeature> NETHER_ROSE_ORE = ResourceKey.create(PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID,"ore_rose_nether"));

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("progression_reborn");

		PRItems.init();
		PRGearItems.init();
		PRBlocks.init();
		PRCreativeInventorySorting.init();
		PRBlockRenderLayers.init();
		PRTrimItemModels.init();

		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES, NETHER_ROSE_ORE);

		if (FabricLoader.getInstance().isModLoaded("legacies_and_legends")) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "progression_reborn_legacies_and_legends_data_integration"), modContainer.get(),
					Component.translatable("pack.progression_reborn.legacies_and_legends_data_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("end_reborn")) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "progression_reborn_end_reborn_data_integration"), modContainer.get(),
					Component.translatable("pack.progression_reborn.end_reborn_data_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("progression_reborn", path);
	}

}