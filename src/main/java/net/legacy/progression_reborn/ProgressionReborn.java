package net.legacy.progression_reborn;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerLifecycleEvents;
import net.fabricmc.fabric.api.resource.ResourceManagerHelper;
import net.fabricmc.fabric.api.resource.ResourcePackActivationType;
import net.fabricmc.loader.api.FabricLoader;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.progression_reborn.config.PRConfig;
import net.legacy.progression_reborn.enchantment.ModEnchantments;
import net.legacy.progression_reborn.registry.*;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Optional;

import static net.legacy.progression_reborn.ProgressionReborn.MOD_ID;
import static net.minecraft.core.registries.Registries.PLACED_FEATURE;

/**
 * by Rebel459
 */
public class ProgressionReborn implements ModInitializer {

	public static final String MOD_ID = "progression_reborn";
	public static ResourceLocation id(String path) {
		return new ResourceLocation(MOD_ID, path);
	}

	public static final ResourceKey<PlacedFeature> NETHER_ROSE_ORE =
			ResourceKey.create(PLACED_FEATURE, new ResourceLocation(MOD_ID, "ore_rose_nether"));

	@Override
	public void onInitialize() {
		Optional<ModContainer> modContainer = FabricLoader.getInstance().getModContainer("progression_reborn");

		ModEnchantments.register();
		PRItems.register();
		PRBlocks.register();
		PRConfig.initClient();

		// Register Nether Rose Ore generation
		BiomeModifications.addFeature(
				BiomeSelectors.foundInTheNether(),
				GenerationStep.Decoration.UNDERGROUND_ORES,
				NETHER_ROSE_ORE
		);

		// Register builtin resource packs
		if (PRConfig.get.generation.modified_overworld_ores) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					new ResourceLocation(MOD_ID, "modified_overworld_ores"),
					modContainer.get(),
					Component.translatable("pack.progression_reborn.modified_overworld_ores"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}

		if (PRConfig.get.generation.modified_nether_ores) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					new ResourceLocation(MOD_ID, "modified_nether_ores"),
					modContainer.get(),
					Component.translatable("pack.progression_reborn.modified_nether_ores"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}

		if (PRConfig.get.misc.retextured_iron_equipment) {
			ResourceManagerHelper.registerBuiltinResourcePack(
					new ResourceLocation(MOD_ID, "retextured_iron_equipment"),
					modContainer.get(),
					Component.translatable("pack.progression_reborn.retextured_iron_equipment"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}

		if (FabricLoader.getInstance().isModLoaded("farmersdelight")
				&& PRConfig.get.integrations.farmers_delight) {

			// Integrations
			KnifeIntegration.init();
			ServerLifecycleEvents.SERVER_STARTED.register(server -> {
				KnifeIntegration.addCreativeTab();
			});
			ResourceManagerHelper.registerBuiltinResourcePack(
					new ResourceLocation(MOD_ID, "farmers_delight_integration"),
					modContainer.get(),
					Component.translatable("pack.progression_reborn.farmers_delight_integration"),
					ResourcePackActivationType.ALWAYS_ENABLED
			);
		}
	}
}
