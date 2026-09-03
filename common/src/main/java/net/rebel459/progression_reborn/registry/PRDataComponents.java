package net.rebel459.progression_reborn.registry;

import com.mojang.serialization.Codec;
import net.minecraft.core.component.DataComponentType;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.progression_reborn.util.CollectionData;
import net.rebel459.unified.platform.UnifiedEvents;
import net.rebel459.unified.platform.UnifiedRegistries;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class PRDataComponents {

    public static void init(){
        UnifiedEvents.DefaultDataComponents.modify(((item, builder, provider) -> {
            if (item == Items.COPPER_NUGGET) builder.set(COLLECTION_DATA.get(), new CollectionData(Items.COPPER_INGOT));
            if (item == Items.IRON_NUGGET) builder.set(COLLECTION_DATA.get(), new CollectionData(Items.IRON_INGOT));
            if (item == Items.GOLD_NUGGET) builder.set(COLLECTION_DATA.get(), new CollectionData(Items.GOLD_INGOT));

            if (ProgressionReborn.doEnderscapeIntegration()) {
                if (item == PRItems.RAW_SHADOLINE_NUGGET.get()) builder.set(COLLECTION_DATA.get(), new CollectionData(enderscape("raw_shadoline")));
                if (item == enderscape("shadoline_nugget")) builder.set(COLLECTION_DATA.get(), new CollectionData(enderscape("shadoline_ingot")));
            }
        }));
    }

    private static Item enderscape(String path) {
        return BuiltInRegistries.ITEM.getValue(Identifier.fromNamespaceAndPath("enderscape", path));
    }

    public static UnifiedRegistries.DataComponentTypes COMPONENTS = UnifiedRegistries.DataComponentTypes.create(ProgressionReborn.MOD_ID);

    public static final Supplier<DataComponentType<CollectionData>> COLLECTION_DATA = COMPONENTS.register(
            "collection_data",
            builder -> builder
                    .persistent(CollectionData.CODEC)
                    .networkSynchronized(CollectionData.STREAM_CODEC)
    );

    public static final Supplier<DataComponentType<Map<Identifier, Integer>>> STORED_ITEMS = COMPONENTS.register(
            "stored_items",
            builder -> builder
                    .persistent(Codec.unboundedMap(Identifier.CODEC, Codec.INT))
                    .networkSynchronized(ByteBufCodecs.map(HashMap::new, Identifier.STREAM_CODEC, ByteBufCodecs.INT))
    );
}