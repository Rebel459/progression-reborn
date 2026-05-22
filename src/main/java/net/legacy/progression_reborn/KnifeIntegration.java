package net.legacy.progression_reborn;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.legacy.progression_reborn.registry.PRItems;
import net.legacy.progression_reborn.registry.PRTiers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import vectorwing.farmersdelight.common.item.KnifeItem;

// import vectorwing.farmersdelight.common.registry.ModItems;

public class KnifeIntegration {
    private static final Logger LOGGER = LoggerFactory.getLogger("Progression Reborn");
    private static Item roseKnife;
    private static Item copperKnife;

    public static void init() {
        LOGGER.info("[Progression Reborn] farmersdelight:golden_knife found; trying to work out.");
        roseKnife = new KnifeItem(
                PRTiers.ROSE,
                0.5F,
                -2.0F,
                new Item.Properties().fireResistant()
        );

        copperKnife = new KnifeItem(
                PRTiers.COPPER,
                0.5F,
                -2.0F,
                new Item.Properties()
        );
        PRItems.actualRegister(
                roseKnife,
                "rose_knife"
//                CreativeModeTabs.COMBAT
        );
        PRItems.actualRegister(
                copperKnife,
                "copper_knife"
//                CreativeModeTabs.COMBAT
        );
    } 

    public static void addCreativeTab() {
        ResourceLocation goldenKnifeId = new ResourceLocation("farmersdelight", "golden_knife");
        Item goldenKnife = BuiltInRegistries.ITEM.getOptional(goldenKnifeId).orElse(null);
        if (goldenKnife == null) {
            LOGGER.info("[Progression Reborn] farmersdelight:golden_knife not found; skipping FD compat.");
            return;
        }

        ResourceLocation flintKnifeId = new ResourceLocation("farmersdelight", "flint_knife");
        Item flintKnife = BuiltInRegistries.ITEM.getOptional(flintKnifeId).orElse(null);
        if (flintKnife == null) {
            LOGGER.info("[Progression Reborn] farmersdelight:flint_knife not found; skipping FD compat.");
            return;
        }

        ItemGroupEvents.modifyEntriesEvent(
            ResourceKey.create(Registries.CREATIVE_MODE_TAB,
                new ResourceLocation("farmersdelight", "farmersdelight"))
        ).register(entries -> {
            entries.addAfter(goldenKnife, roseKnife);
        });

        ItemGroupEvents.modifyEntriesEvent(
            ResourceKey.create(Registries.CREATIVE_MODE_TAB,
                new ResourceLocation("farmersdelight", "farmersdelight"))
        ).register(entries -> {
            entries.addAfter(flintKnife, copperKnife);
        });
    }
}
