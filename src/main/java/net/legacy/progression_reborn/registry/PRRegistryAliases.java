package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.ProgressionReborn;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;

public class PRRegistryAliases {

    public static void init() {
        convertToVanilla("copper_sword");
        convertToVanilla("copper_pickaxe");
        convertToVanilla("copper_axe");
        convertToVanilla("copper_hoe");
        convertToVanilla("copper_shovel");
        convertToVanilla("copper_helmet");
        convertToVanilla("copper_chestplate");
        convertToVanilla("copper_leggings");
        convertToVanilla("copper_boots");
        convertToVanilla("copper_horse_armor");
        convertToVanilla("copper_nugget");

        convertToVanilla("netherite_horse_armor");
    }

    public static void convertToVanilla(String name) {
        BuiltInRegistries.ITEM.addAlias(ProgressionReborn.id(name), Identifier.withDefaultNamespace(name));
    }
}
