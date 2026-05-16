package net.legacy.progression_reborn;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.loader.api.FabricLoader;
import net.legacy.progression_reborn.config.PRConfig;
import net.legacy.progression_reborn.lib.PRCreativeTabs;
import net.legacy.progression_reborn.registry.PRItems;
import net.legacy.progression_reborn.registry.PRTiers;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ItemLike;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.farmersdelight.common.item.KnifeItem;
// import vectorwing.farmersdelight.common.registry.ModItems;

import static vectorwing.farmersdelight.common.registry.ModItems.GOLDEN_KNIFE;

public class KnifeIntegration {
    private static final Logger LOGGER = LoggerFactory.getLogger("Progression Reborn");
    private static Item RoseKnife;
    private static Item CopperKnife;

    public static void init() {
        LOGGER.info("[Progression Reborn] farmersdelight:golden_knife found; trying to work out.");
        RoseKnife = new KnifeItem(
                PRTiers.ROSE,
                0.5F,
                -2.0F,
                new Item.Properties().fireResistant()
        );

        CopperKnife = new KnifeItem(
                PRTiers.COPPER,
                0.5F,
                -2.0F,
                new Item.Properties()
        );
        PRItems.actualRegister(
                RoseKnife,
                "rose_knife"
//                CreativeModeTabs.COMBAT
        );
        PRItems.actualRegister(
                CopperKnife,
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

        PRCreativeTabs.addAfter(goldenKnife, RoseKnife, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, CreativeModeTabs.COMBAT);
        PRCreativeTabs.addAfter(flintKnife, CopperKnife, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS, CreativeModeTabs.COMBAT);

//        ItemGroupEvents.modifyEntriesEvent(
//                ResourceKey.create(Registries.CREATIVE_MODE_TAB,
//                                   new ResourceLocation("farmersdelight", "farmersdelight")))
//                .register(entries -> entries.accept(RoseKnife));
    }
}
