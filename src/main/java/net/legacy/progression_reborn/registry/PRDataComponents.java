package net.legacy.progression_reborn.registry;

import net.fabricmc.fabric.api.item.v1.DefaultItemComponentEvents;
import net.legacy.progression_reborn.config.PRConfig;
import net.minecraft.core.component.DataComponents;
import net.minecraft.world.item.component.ProvidesTrimMaterial;

public class PRDataComponents {

    public static void init(){
        DefaultItemComponentEvents.MODIFY.register(context -> {
            if (PRConfig.get.misc.trim_materials) {
                context.modify(PRItems.ROSE_INGOT, builder -> {
                    builder.set(DataComponents.PROVIDES_TRIM_MATERIAL, new ProvidesTrimMaterial(PRTrimMaterials.ROSE));
                });
            }
        });
    }
}