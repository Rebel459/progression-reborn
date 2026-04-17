package net.rebel459.progression_reborn.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.enchantment.Enchantment;
import net.rebel459.progression_reborn.ProgressionReborn;

public class PREnchantments {
    public static final ResourceKey<Enchantment> COLLECTION = register("collection");
    public static final ResourceKey<Enchantment> REFORGE = register("reforge");

    public static ResourceKey<Enchantment> register(String path) {
        return ResourceKey.create(Registries.ENCHANTMENT, ProgressionReborn.id(path));
    }
}
