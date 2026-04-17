package net.rebel459.progression_reborn.registry;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.Identifier;
import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.unified.platform.UnifiedRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PRDataComponents {

    public static void init(){}

    public static UnifiedRegistries.DataComponentTypes COMPONENTS = UnifiedRegistries.DataComponentTypes.create(ProgressionReborn.MOD_ID);

    public static final Supplier<DataComponentType<Map<Identifier, Integer>>> STORED_ITEMS = COMPONENTS.register(
            "stored_items",
            builder -> builder
                    .persistent(Codec.unboundedMap(Identifier.CODEC, Codec.INT))
                    .networkSynchronized(ByteBufCodecs.map(HashMap::new, Identifier.STREAM_CODEC, ByteBufCodecs.INT))
    );
}