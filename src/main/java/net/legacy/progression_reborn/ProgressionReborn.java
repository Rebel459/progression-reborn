package net.legacy.progression_reborn;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.progression_reborn.config.PRConfig;
import net.legacy.progression_reborn.registry.*;
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

		PRItems.register();
		PRBlocks.register();
		PRConfig.initClient();

		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES, NETHER_ROSE_ORE);

		ResourceManagerHelper.registerBuiltinResourcePack(
				ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "progression_reborn_asset_overrides"), modContainer.get(),
				Component.translatable("pack.progression_reborn.progression_reborn_asset_overrides"),
				ResourcePackActivationType.ALWAYS_ENABLED
		);

		if (PRConfig.get.generation.modified_overworld_ores) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "modified_overworld_ores"), modContainer.get(),
					Component.translatable("pack.progression_reborn.modified_overworld_ores"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (PRConfig.get.generation.modified_nether_ores) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "modified_nether_ores"), modContainer.get(),
					Component.translatable("pack.progression_reborn.modified_nether_ores"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (PRConfig.get.misc.retextured_iron_equipment) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "retextured_iron_equipment"), modContainer.get(),
					Component.translatable("pack.progression_reborn.retextured_iron_equipment"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}

		if (FabricLoader.getInstance().isModLoaded("farmersdelight") && FabricLoader.getInstance().isModLoaded("farmersknives") && PRConfig.get.integrations.farmers_delight) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "progression_reborn_farmers_delight_integration"), modContainer.get(),
					Component.translatable("pack.progression_reborn.farmers_delight_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("legacies_and_legends") && PRConfig.get.integrations.legacies_and_legends) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "progression_reborn_legacies_and_legends_integration"), modContainer.get(),
					Component.translatable("pack.progression_reborn.legacies_and_legends_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("wilderwild") && PRConfig.get.integrations.wilder_wild) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "progression_reborn_wilder_wild_integration"), modContainer.get(),
					Component.translatable("pack.progression_reborn.wilder_wild_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("trailiertales") && PRConfig.get.integrations.trailier_tales) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "progression_reborn_trailier_tales_integration"), modContainer.get(),
					Component.translatable("pack.progression_reborn.trailier_tales_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
		if (FabricLoader.getInstance().isModLoaded("remnants") && PRConfig.get.integrations.remnants) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					ResourceLocation.fromNamespaceAndPath(PRConstants.MOD_ID, "progression_reborn_remnants_integration"), modContainer.get(),
					Component.translatable("pack.progression_reborn.remnants_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
	}

}