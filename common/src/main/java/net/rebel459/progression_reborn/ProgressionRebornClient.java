package net.rebel459.progression_reborn;

import net.rebel459.progression_reborn.config.PRConfig;
import net.rebel459.progression_reborn.registry.PREquipmentAssets;
import net.rebel459.unified.platform.UnifiedHelpers;
import net.rebel459.unified.platform.UnifiedPlatform;
import net.rebel459.unified.platform.client.UnifiedClientHelpers;
import net.rebel459.unified.util.PackType;

public class ProgressionRebornClient {

	public static void init() {
		if (PRConfig.get().misc.retextured_iron_equipment) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("retextured_iron_equipment"), PackType.REQUIRED_RESOURCES);
		}
		if (UnifiedPlatform.get().isModLoaded("farmersdelight") && PRConfig.get().integrations.farmers_delight) {
			UnifiedHelpers.PACKS.add(ProgressionReborn.id("farmers_delight_integration"), PackType.REQUIRED_RESOURCES);
		}
		UnifiedClientHelpers.LEGACY_BABY_ARMOR.add(PREquipmentAssets.ROSE);
	}
}