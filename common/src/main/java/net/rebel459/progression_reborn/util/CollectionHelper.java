package net.rebel459.progression_reborn.util;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.rebel459.progression_reborn.registry.PRDataComponents;
import net.rebel459.progression_reborn.registry.PRItems;

import java.util.HashMap;
import java.util.Map;

public class CollectionHelper {

    public static HashMap<Item, Item> COLLECTION_ITEMS = new HashMap<>(Map.of(
            PRItems.RAW_COPPER_NUGGET.get(), Items.RAW_COPPER,
            PRItems.RAW_IRON_NUGGET.get(), Items.RAW_IRON,
            PRItems.RAW_GOLD_NUGGET.get(), Items.RAW_GOLD,
            PRItems.RAW_ROSE_NUGGET.get(), PRItems.RAW_ROSE.get(),
            Items.COPPER_NUGGET, Items.COPPER_INGOT,
            Items.IRON_NUGGET, Items.IRON_INGOT,
            Items.GOLD_NUGGET, Items.GOLD_INGOT,
            PRItems.ROSE_NUGGET.get(), PRItems.ROSE_INGOT.get(),
            PRItems.DIAMOND_SHARD.get(), Items.DIAMOND
    ));

    public static int getMaxStackSize(Item item) {
        return 64;
    }

    public static int getCountPerConversion(Item item) {
        return 9;
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
