package net.rebel459.progression_reborn;

import net.fabricmc.api.ClientModInitializer;

public class ProgressionRebornFabricClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        ProgressionReborn.init();
    }
}
