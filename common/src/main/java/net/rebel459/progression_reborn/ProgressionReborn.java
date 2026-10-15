package net.rebel459.progression_reborn;

import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.rebel459.progression_reborn.config.PRConfig;
import net.rebel459.progression_reborn.registry.*;
import net.rebel459.progression_reborn.sound.PRSounds;
import net.rebel459.unified.api.codec.ExtensibleCodecs;
import net.rebel459.unified.api.core.UnifiedData;
import net.rebel459.unified.api.core.UnifiedEvents;
import net.rebel459.unified.api.core.UnifiedHelpers;
import net.rebel459.unified.api.core.UnifiedPlatform;
import net.rebel459.unified.api.registry.UnifiedLoadRequirementCodecs;

import java.util.List;

import static net.minecraft.core.registries.Registries.PLACED_FEATURE;

/**
 * by Rebel459
 */
public class ProgressionReborn {

	public static boolean doEnderscapeIntegration() {
		return UnifiedPlatform.isModLoaded("enderscape") && PRConfig.get().integrations.enderscape;
	}

    public static final String MOD_ID = "progression_reborn";
    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

	public static final ResourceKey<PlacedFeature> NETHER_ROSE_ORE = ResourceKey.create(PLACED_FEATURE, Identifier.fromNamespaceAndPath(MOD_ID,"ore_rose_nether"));
	
	public static void initRegistries() {
		PRLoadRequirementCodecs.init();
		PRItemCodecs.init();
		PRItems.init();
		PRSounds.init();
		PRBlocks.init();
		PRRegistryAliases.init();
		PRDataComponents.init();
	}
	
	public static void init() {

		PRCreativeInventorySorting.init();
		PRLootTables.init();

		DATA.helpers().biomeModifiers().create("nether_rose_ore", provider -> provider.getOrThrow(BiomeTags.IS_NETHER)).addFeature(NETHER_ROSE_ORE, GenerationStep.Decoration.UNDERGROUND_ORES);

		UnifiedHelpers.BLOCK_CONVERSIONS.addWeathering(
				PRBlocks.COPPER_BLOCK,
				PRBlocks.EXPOSED_COPPER,
				PRBlocks.WEATHERED_COPPER,
				PRBlocks.OXIDIZED_COPPER,
				PRBlocks.WAXED_COPPER_BLOCK,
				PRBlocks.WAXED_EXPOSED_COPPER,
				PRBlocks.WAXED_WEATHERED_COPPER,
				PRBlocks.WAXED_OXIDIZED_COPPER
		);

		if (PRConfig.get().generation.modified_overworld_ores) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("modified_overworld_ores"));
		}
		if (PRConfig.get().generation.modified_nether_ores) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("modified_nether_ores"));
		}
		if (PRConfig.get().generation.modified_bastions) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("modified_bastions"));
		}

		if (UnifiedPlatform.isModLoaded("farmersdelight") && PRConfig.get().integrations.farmers_delight) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("farmers_delight_integration"));
		}
		if (UnifiedPlatform.isModLoaded("legacies_and_legends") && PRConfig.get().integrations.legacies_and_legends) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("legacies_and_legends_integration"));
		}
		if (UnifiedPlatform.isModLoaded("end_reborn") && PRConfig.get().integrations.end_reborn) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("end_reborn_integration"));
		}
		if (UnifiedPlatform.isModLoaded("wilderwild") && PRConfig.get().integrations.wilder_wild) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("wilder_wild_integration"));
		}
		if (UnifiedPlatform.isModLoaded("trailiertales") && PRConfig.get().integrations.trailier_tales) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("trailier_tales_integration"));
		}
        if (UnifiedPlatform.isModLoaded("remnants") && PRConfig.get().integrations.remnants) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("remnants_integration"));
        }
		if (UnifiedPlatform.isModLoaded("bloom") && PRConfig.get().integrations.bloom) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("bloom_integration"));
		}
		if (doEnderscapeIntegration()) {
			UnifiedHelpers.DATA_PACKS.addRequired(ProgressionReborn.id("enderscape_integration"));
		}
	}

	public static UnifiedData DATA = UnifiedData.create(MOD_ID).build();

	public static UnifiedData ENDERSCAPE_DATA = UnifiedData.create(ProgressionReborn.MOD_ID).requirement(ExtensibleCodecs.LOAD_REQUIREMENT.allOf().create(() -> List.of(
			UnifiedLoadRequirementCodecs.MODS_LOADED.create(() -> List.of("enderscape")),
			PRLoadRequirementCodecs.ENDERSCAPE_INTEGRATION.create()
	))).build();

	public static UnifiedData FARMERS_DELIGHT_DATA = UnifiedData.create(ProgressionReborn.MOD_ID).requirement(ExtensibleCodecs.LOAD_REQUIREMENT.allOf().create(() -> List.of(
			UnifiedLoadRequirementCodecs.MODS_LOADED.create(() -> List.of("farmersdelight")),
			PRLoadRequirementCodecs.FARMERS_DELIGHT_INTEGRATION.create()
	))).build();
}