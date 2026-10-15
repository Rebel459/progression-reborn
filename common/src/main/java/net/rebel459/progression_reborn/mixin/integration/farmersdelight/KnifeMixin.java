package net.rebel459.progression_reborn.mixin.integration.farmersdelight;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.progression_reborn.registry.PRItemCodecs;
import net.rebel459.progression_reborn.registry.PRItems;
import net.rebel459.unified.api.codec.ExtensibleCodecs;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import vectorwing.farmersdelight.common.item.KnifeItem;
import vectorwing.farmersdelight.common.registry.ModItems;

@Mixin(value = ProgressionReborn.class)
public class KnifeMixin {

    @Inject(method = "initRegistries", at = @At(value = "HEAD"))
    private static void registerKnife(CallbackInfo ci) {
        PRItemCodecs.KNIFE = ExtensibleCodecs.ITEM.register(ProgressionReborn.id("knife"), () -> KnifeItem::new);
    }

    @Inject(method = "init", at = @At(value = "TAIL"))
    private static void handleKnife(CallbackInfo ci) {
        var farmersDelightEntries = ProgressionReborn.FARMERS_DELIGHT_DATA.helpers().creativeEntries().create("farmers_delight_additions");
        farmersDelightEntries.insertAfter(ResourceKey.create(Registries.CREATIVE_MODE_TAB, Identifier.fromNamespaceAndPath("farmersdelight", "farmersdelight")), ModItems.GOLDEN_KNIFE.get(), PRItems.ROSE_KNIFE);
    }
}