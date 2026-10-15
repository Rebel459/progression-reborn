package net.rebel459.progression_reborn;

import net.fabricmc.api.ModInitializer;
import net.rebel459.progression_reborn.datagen.PRBlockTagProvider;
import net.rebel459.progression_reborn.datagen.PRItemTagProvider;
import net.rebel459.unified.fabric.FabricUnifiedInitializer;

public class ProgressionRebornFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ProgressionReborn.initRegistries();
        FabricUnifiedInitializer.register(this::onInitializeCommon);
    }

    public void onInitializeCommon() {
        ProgressionReborn.init();
        PRBlockTagProvider.init();
        PRItemTagProvider.init();
    }
}
