package net.rebel459.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.rebel459.unified.fabric.FabricUnifiedDatagen;
import org.jetbrains.annotations.NotNull;

public final class PRDataGenerator implements DataGeneratorEntrypoint {

	@Override
	public void onInitializeDataGenerator(@NotNull FabricDataGenerator dataGenerator) {

		final FabricUnifiedDatagen.Pack pack = FabricUnifiedDatagen.register(dataGenerator);

		pack.addProvider(PRModelProvider::new);
		pack.addProvider(PRBlockLootProvider::new);
		pack.addProvider(PRRegistryProvider::new);

	}

	public void buildRegistry(RegistrySetBuilder registrySetBuilder) {
		PRRegistryProvider.buildRegistry(registrySetBuilder);
	}


}
