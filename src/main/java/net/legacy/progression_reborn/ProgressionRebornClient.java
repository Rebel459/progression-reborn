package net.legacy.progression_reborn;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.legacy.progression_reborn.client.PRBlockRenderLayers;
import net.legacy.progression_reborn.registry.PRTrimItemModels;

@Environment(EnvType.CLIENT)
public final class ProgressionRebornClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        PRBlockRenderLayers.init();
    }
}