package net.rebel459.progression_reborn;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.rebel459.progression_reborn.config.PRConfig;
import net.rebel459.progression_reborn.registry.*;
import net.rebel459.progression_reborn.sound.PRSounds;
import net.rebel459.unified.platform.UnifiedHelpers;
import net.rebel459.unified.platform.UnifiedPlatform;
import net.rebel459.unified.util.PackType;

import static net.minecraft.core.registries.Registries.PLACED_FEATURE;

/**
 * by Rebel459
 */
public class ProgressionReborn {

    public static final String MOD_ID = "progression_reborn";
    public static Identifier id(String path) {
        return Identifier.fromNamespaceAndPath(MOD_ID, path);
    }

    public static boolean isEndRebornLoaded() {
		return UnifiedPlatform.get().isModLoaded("end_reborn");
	}

	public static final ResourceKey<PlacedFeature> NETHER_ROSE_ORE = ResourceKey.create(PLACED_FEATURE, Identifier.fromNamespaceAndPath(MOD_ID,"ore_rose_nether"));
	
	public static void initRegistries() {
		PRItems.init();
		PRSounds.init();
		PRBlocks.init();
		PRRegistryAliases.init();
		UnifiedHelpers.BIOME_MODIFICATIONS.register(BiomeTags.IS_NETHER, context -> {
			context.getFeatures().addFeature(NETHER_ROSE_ORE, GenerationStep.Decoration.UNDERGROUND_ORES);
		});
	}
	
	public static void init() {

		PRCreativeInventorySorting.init();
		PRLootTables.init();
		
		if (PRConfig.get().generation.modified_overworld_ores) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("modified_overworld_ores"), PackType.REQUIRED_DATA);
		}
		if (PRConfig.get().generation.modified_nether_ores) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("modified_nether_ores"), PackType.REQUIRED_DATA);
		}

		if (UnifiedPlatform.get().isModLoaded("farmersdelight") && PRConfig.get().integrations.farmers_delight) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("farmers_delight_integration"), PackType.REQUIRED_DATA);
		}
		if (UnifiedPlatform.get().isModLoaded("legacies_and_legends") && PRConfig.get().integrations.legacies_and_legends) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("legacies_and_legends_integration"), PackType.REQUIRED_DATA);
		}
		if (isEndRebornLoaded() && PRConfig.get().integrations.end_reborn) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("end_reborn_integration"), PackType.REQUIRED_DATA);
		}
		if (UnifiedPlatform.get().isModLoaded("wilderwild") && PRConfig.get().integrations.wilder_wild) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("wilder_wild_integration"), PackType.REQUIRED_DATA);
		}
		if (UnifiedPlatform.get().isModLoaded("trailiertales") && PRConfig.get().integrations.trailier_tales) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("trailier_tales_integration"), PackType.REQUIRED_DATA);
		}
        if (UnifiedPlatform.get().isModLoaded("remnants") && PRConfig.get().integrations.remnants) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("remnants_integration"), PackType.REQUIRED_DATA);
        }
        if (UnifiedPlatform.get().isModLoaded("bloom") && PRConfig.get().integrations.bloom) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("bloom_integration"), PackType.REQUIRED_DATA);
        }
	}
}