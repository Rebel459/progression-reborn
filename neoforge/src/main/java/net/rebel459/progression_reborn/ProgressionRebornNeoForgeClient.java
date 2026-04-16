package net.rebel459.progression_reborn;

import me.shedaniel.autoconfig.AutoConfigClient;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModLoadingContext;
import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.client.gui.IConfigScreenFactory;
import net.rebel459.progression_reborn.config.PRConfig;

@Mod(value = ProgressionReborn.MOD_ID, dist = Dist.CLIENT)
public class ProgressionRebornNeoForgeClient {

    public ProgressionRebornNeoForgeClient(IEventBus modEventBus) {
        ProgressionRebornClient.init();
        ModLoadingContext.get().registerExtensionPoint(
                IConfigScreenFactory.class,
                () -> (modContainer, parent) ->
                        AutoConfigClient.getConfigScreen(PRConfig.class, parent).get()
        );
    }
}