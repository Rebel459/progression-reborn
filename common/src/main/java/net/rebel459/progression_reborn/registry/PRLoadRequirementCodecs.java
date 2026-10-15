package net.rebel459.progression_reborn.registry;

import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.progression_reborn.config.PRConfig;
import net.rebel459.unified.api.codec.ExtensibleCodecBase;
import net.rebel459.unified.api.codec.ExtensibleCodecs;

public class PRLoadRequirementCodecs {

    public static ExtensibleCodecBase.Simple<Boolean> ENDERSCAPE_INTEGRATION = ExtensibleCodecs.LOAD_REQUIREMENT.register(ProgressionReborn.id("enderscape_integration"), () -> PRConfig.get().integrations.enderscape);
    public static ExtensibleCodecBase.Simple<Boolean> FARMERS_DELIGHT_INTEGRATION = ExtensibleCodecs.LOAD_REQUIREMENT.register(ProgressionReborn.id("farmers_delight_integration"), () -> PRConfig.get().integrations.farmers_delight);

    public static void init() {}
}
