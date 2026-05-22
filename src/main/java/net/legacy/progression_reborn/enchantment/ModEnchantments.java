package net.legacy.progression_reborn.enchantment;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.enchantment.Enchantment;

public class ModEnchantments {

    public static final Enchantment REFORGE = Registry.register(
            BuiltInRegistries.ENCHANTMENT,
            new ResourceLocation("progression_reborn", "reforge"),
            new ReforgeEnchantment()
    );

    public static void register() {
    }
}
