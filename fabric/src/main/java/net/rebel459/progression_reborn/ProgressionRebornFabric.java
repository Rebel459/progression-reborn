package net.rebel459.progression_reborn;

import net.fabricmc.api.ModInitializer;

public class ProgressionRebornFabric implements ModInitializer {

    @Override
    public void onInitialize() {
        ProgressionReborn.initRegistries();
        ProgressionReborn.init();
    }
}
