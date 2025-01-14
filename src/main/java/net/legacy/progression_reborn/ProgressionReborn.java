package net.legacy.progression_reborn;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.frozenblock.lib.entrypoint.api.FrozenModInitializer;
import net.legacy.progression_reborn.client.PRBlockRenderLayers;
import net.legacy.progression_reborn.datafix.PRDataFixer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.io.IOException;
import java.util.Optional;

import static net.legacy.progression_reborn.PRConstants.MOD_ID;
import static net.minecraft.core.registries.Registries.PLACED_FEATURE;

/**
 * by Rebel459
 */
public class ProgressionReborn extends FrozenModInitializer {

	public ProgressionReborn() {
		super(PRConstants.MOD_ID);
	}

	public static final ResourceKey<PlacedFeature> NETHER_ROSE_ORE = ResourceKey.create(PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID,"ore_rose_nether"));

	@Override
	public void onInitialize(String modId, ModContainer container) {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("progression_reborn");
		try {
			PRConfig.main();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		PRDataFixer.applyDataFixes(container);

		PRItems.init();
		PRGearItems.init();
		PRBlocks.init();
		PRCreativeInventorySorting.init();
		PRBlockRenderLayers.init();
		PRTrimItemModels.init();

		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES, NETHER_ROSE_ORE);

		if (FabricLoader.getInstance().isModLoaded("legacies_and_legends") && PRConfig.compat_datapacks_enabled) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "progression_reborn_legacies_and_legends_data_integration"), modContainer.get(),
					Component.translatable("pack.progression_reborn.legacies_and_legends_data_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("end_reborn") && PRConfig.compat_datapacks_enabled) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "progression_reborn_end_reborn_data_integration"), modContainer.get(),
					Component.translatable("pack.progression_reborn.end_reborn_data_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
	}

}