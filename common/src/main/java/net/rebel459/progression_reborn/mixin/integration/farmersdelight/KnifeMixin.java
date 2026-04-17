package net.rebel459.progression_reborn.mixin.integration.farmersdelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.progression_reborn.registry.PRItems;
import net.rebel459.progression_reborn.registry.PRToolMaterials;
import net.rebel459.unified.platform.UnifiedHelpers;
import net.rebel459.unified.util.SuppliedItem;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.registry.ModItems;

@Mixin(value = ProgressionReborn.class)
public class KnifeMixin {

    @Unique
    private static SuppliedItem ROSE_KNIFE;

    @Inject(method = "initRegistries", at = @At(value = "HEAD"))
    private static void registerKnife(CallbackInfo ci) {
        ROSE_KNIFE = PRItems.ITEMS.register("rose_knife",
                KnifeItem::new,
                () -> ModItems.knifeItem(PRToolMaterials.ROSE)
                        .fireResistant()
        );
    }

    @Inject(method = "init", at = @At(value = "TAIL"))
    private static void handleKnife(CallbackInfo ci) {
        UnifiedHelpers.CREATIVE_ENTRIES.insert(ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath("farmersdelight", "farmersdelight")), ROSE_KNIFE);
    }
}