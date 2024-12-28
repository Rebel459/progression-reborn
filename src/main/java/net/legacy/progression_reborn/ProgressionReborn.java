package net.legacy.progression_reborn;

import net.fabricmc.api.ModInitializer;
import net.minecraft.resources.ResourceLocation;

/**
 * by Rebel459
 */
public class ProgressionReborn implements ModInitializer {
	@Override
	public void onInitialize() {
		ProgressionItems.register();
	}

	public static ResourceLocation id(String path) {
		return ResourceLocation.fromNamespaceAndPath("legacies_and_legends", path);
	}
}