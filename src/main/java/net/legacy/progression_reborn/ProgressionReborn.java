package net.legacy.progression_reborn;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import static net.legacy.progression_reborn.PRConstants.MOD_ID;
import static net.minecraft.core.registries.Registries.PLACED_FEATURE;

/**
 * by Rebel459
 */
public class ProgressionReborn implements ModInitializer {

	public static final ResourceKey<PlacedFeature> NETHER_ROSE_ORE = ResourceKey.create(PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(MOD_ID,"ore_rose_nether"));

	@Override
	public void onInitialize() {
		PRItems.init();
		PRGearItems.init();
		PRBlocks.init();
		PRCreativeInventorySorting.init();

		BiomeModifications.addFeature(BiomeSelectors.foundInTheNether(), GenerationStep.Decoration.UNDERGROUND_ORES, NETHER_ROSE_ORE);
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("progression_reborn", path);
	}
}