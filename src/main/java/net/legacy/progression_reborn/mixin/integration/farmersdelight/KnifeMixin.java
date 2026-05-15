package net.legacy.progression_reborn.mixin.integration.farmersdelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;

import net.legacy.progression_reborn.ProgressionReborn;
import net.legacy.progression_reborn.registry.PRItems;
import net.legacy.progression_reborn.registry.PRTiers;
// import net.legacy.progression_reborn.registry.PRToolMaterials;
import java.util.function.Supplier;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

// import vectorwing.farmersdelight.common.item.KnifeItem;
// import vectorwing.farmersdelight.common.registry.ModItems;


import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.world.item.CreativeModeTab;

// import static vectorwing.farmersdelight.common.registry.ModItems.IRON_KNIFE;

@Mixin(value = ProgressionReborn.class)
public class KnifeMixin {
//
//  @Unique
//private static final Item ROSE_KNIFE =
//          new KnifeItem(PRTiers.ROSE, 3.0F, -2.4F, (new Item.Properties()).fireResistant());
//
//  // private static Supplier<Item> ROSE_KNIFE;
//
//  @Inject(method = "onInitialize", at = @At(value = "HEAD"))
//  private static void registerKnife(CallbackInfo ci) {
//    PRItems.registerItemAfter((ItemLike) IRON_KNIFE, ROSE_KNIFE, "copper_sword", CreativeModeTabs.COMBAT);
//  }
//
//  @Inject(method = "init", at = @At("TAIL"))
//  private static void handleKnife(CallbackInfo ci) {
//    ItemGroupEvents.modifyEntriesEvent(
//        ResourceKey.create(
//            Registries.CREATIVE_MODE_TAB,
//            new ResourceLocation("farmersdelight", "farmersdelight")))
//        .register(entries -> {
//          entries.accept(ROSE_KNIFE);
//        });
//  }

}
