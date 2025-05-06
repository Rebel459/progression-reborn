package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.frozenblock.lib.feature_flag.api.FeatureFlagApi;
import net.minecraft.core.RegistrySetBuilder;
import org.jetbrains.annotations.NotNull;

public final class PRDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(@NotNull FabricDataGenerator dataGenerator) {

		FeatureFlagApi.rebuild();
		final FabricDataGenerator.Pack pack = dataGenerator.createPack();

		pack.addProvider(PRModelProvider::new);
		pack.addProvider(PRItemTagProvider::new);
		pack.addProvider(PRBlockTagProvider::new);
		pack.addProvider(PRBlockLootProvider::new);
		pack.addProvider(PRRegistryProvider::new);

	}

	public void buildRegistry(RegistrySetBuilder registrySetBuilder) {
		PRRegistryProvider.buildRegistry(registrySetBuilder);
	}


}
