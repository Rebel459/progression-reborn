package net.rebel459.progression_reborn;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.rebel459.unified.platform.NeoForgeUnifiedRegistries;

@Mod(ProgressionReborn.MOD_ID)
public class ProgressionRebornNeoForge {

    public ProgressionRebornNeoForge(IEventBus modEventBus) {
        NeoForgeUnifiedRegistries.registerBus(ProgressionReborn.MOD_ID, modEventBus);
        ProgressionReborn.initRegistries();
        modEventBus.addListener(ProgressionRebornNeoForge::commonSetup);
    }

    private static void commonSetup(final FMLCommonSetupEvent event) {
        ProgressionReborn.init();
    }
}