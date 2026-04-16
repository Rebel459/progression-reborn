package net.rebel459.progression_reborn.registry;

import net.rebel459.progression_reborn.ProgressionReborn;
import net.minecraft.resources.Identifier;
import net.rebel459.progression_reborn.config.PRConfig;
import net.rebel459.unified.platform.UnifiedPlatform;

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

        if (PRConfig.get().integrations.farmers_delight && UnifiedPlatform.get().isModLoaded("farmersdelight")) {
            PRItems.ITEMS.addAlias(Identifier.fromNamespaceAndPath("farmersknives", "copper_knife"), Identifier.fromNamespaceAndPath("farmersdelight", "copper_knife"));
            PRItems.ITEMS.addAlias(Identifier.fromNamespaceAndPath("farmersknives", "rose_knife"), ProgressionReborn.id("rose_knife"));
        }
    }

    public static void convertToVanilla(String name) {
        PRItems.ITEMS.addAlias(ProgressionReborn.id(name), Identifier.withDefaultNamespace(name));
    }
}
