package net.rebel459.progression_reborn.util;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.ExtraCodecs;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.rebel459.progression_reborn.registry.PRDataComponents;
import net.rebel459.progression_reborn.registry.PRItems;

import java.util.HashMap;
import java.util.Map;

public record CollectionData(int maxSize, Item conversionItem, int conversionCount) {

    public static final Codec<CollectionData> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            ExtraCodecs.POSITIVE_INT.fieldOf("max_size").forGetter(CollectionData::maxSize),
            BuiltInRegistries.ITEM.byNameCodec().fieldOf("item").forGetter(CollectionData::conversionItem),
            ExtraCodecs.POSITIVE_INT.fieldOf("conversion_count").forGetter(CollectionData::conversionCount)
    ).apply(instance, CollectionData::new));

    public static final StreamCodec<ByteBuf, CollectionData> STREAM_CODEC = ByteBufCodecs.fromCodec(CODEC);

    public CollectionData(ItemLike item) {
        this(64, item.asItem(), 9);
    }

    public static void dropAllCollected(Player player, ItemStack chestplate) {
        Map<Identifier, Integer> stored = chestplate.getOrDefault(PRDataComponents.STORED_ITEMS.get(), Map.of());
        if (stored.isEmpty()) return;
        if (!(player.level() instanceof ServerLevel level)) return;

        var itemLookup = level.registryAccess().lookup(Registries.ITEM).orElse(null);
        if (itemLookup == null) return;

        for (Map.Entry<Identifier, Integer> entry : stored.entrySet()) {
            var optional = itemLookup.get(entry.getKey());
            if (optional.isEmpty()) continue;

            Item item = optional.get().value();
            int count = entry.getValue();

            while (count > 0) {
                int toDrop = Math.min(count, item.getDefaultMaxStackSize());
                ItemStack drop = new ItemStack(item, toDrop);
                player.spawnAtLocation(level, drop);
                count -= toDrop;
            }
        }

        chestplate.set(PRDataComponents.STORED_ITEMS.get(), Map.of());
    }
}
