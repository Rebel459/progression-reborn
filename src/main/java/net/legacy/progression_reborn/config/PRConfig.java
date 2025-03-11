package net.legacy.progression_reborn.config;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.ConfigData;
import me.shedaniel.autoconfig.annotation.Config;
import me.shedaniel.autoconfig.annotation.ConfigEntry;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.legacy.progression_reborn.PRConstants;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

@Config(name = PRConstants.MOD_ID)
public class PRConfig implements ConfigData {

  @Contract(pure = true)
  public static @NotNull Path configPath(boolean json5) {
    return Path.of("./config/" + PRConstants.MOD_ID + "." + (json5 ? "json5" : "json"));
  }

  public static PRConfig get;

  public static void initClient() {
    AutoConfig.register(PRConfig.class, JanksonConfigSerializer::new);
    get = AutoConfig.getConfigHolder(PRConfig.class).getConfig();
  }

  @ConfigEntry.Gui.CollapsibleObject
  public GeneralConfig general = new GeneralConfig();

  @ConfigEntry.Gui.CollapsibleObject
  public IntegrationsConfig integrations = new IntegrationsConfig();

  public static class GeneralConfig {
    @ConfigEntry.Category("config")
    public boolean modified_ore_generation = true;
    @ConfigEntry.Category("config")
    public boolean retextured_iron_equipment = true;
  }

  public static class IntegrationsConfig {
    @ConfigEntry.Category("config")
    public boolean end_reborn = true;

    @ConfigEntry.Category("config")
    public boolean legacies_and_legends = true;

    @ConfigEntry.Category("config")
    public boolean wilder_wild = true;
  }

}
