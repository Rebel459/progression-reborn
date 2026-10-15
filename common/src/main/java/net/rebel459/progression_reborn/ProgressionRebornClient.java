package net.rebel459.progression_reborn;

import net.rebel459.progression_reborn.config.PRConfig;
import net.rebel459.progression_reborn.registry.PREquipmentAssets;
import net.rebel459.unified.api.client.core.UnifiedClientHelpers;
import net.rebel459.unified.api.core.UnifiedPlatform;

public class ProgressionRebornClient {

	public static void init() {
		if (PRConfig.get().misc.retextured_iron_equipment) {
			UnifiedClientHelpers.RESOURCE_PACKS.addRequired(ProgressionReborn.id("retextured_iron_equipment"));
		}
		if (UnifiedPlatform.isModLoaded("farmersdelight") && PRConfig.get().integrations.farmers_delight) {
			UnifiedClientHelpers.RESOURCE_PACKS.addRequired(ProgressionReborn.id("farmers_delight_integration"));
		}
		UnifiedClientHelpers.SIMPLE_BABY_ARMOR.add(PREquipmentAssets.ROSE);
	}
}