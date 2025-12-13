package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.legacy.progression_reborn.ProgressionReborn;
import net.legacy.progression_reborn.registry.PRTrimMaterials;
import net.minecraft.core.*;
import net.minecraft.core.registries.Registries;

import java.util.List;
import java.util.concurrent.CompletableFuture;


public class PRRegistryProvider extends FabricDynamicRegistryProvider {
    protected PRRegistryProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    public static void buildRegistry(RegistrySetBuilder registrySetBuilder) {
        registrySetBuilder.add(Registries.TRIM_MATERIAL, PRTrimMaterials::bootstrap);
    }

    @Override
    public void configure(HolderLookup.Provider registries, Entries entries) {
        addAll(entries, registries.lookupOrThrow(Registries.TRIM_MATERIAL), ProgressionReborn.MOD_ID);
    }

    @Override
    public String getName() {
        return "Progression Reborn";
    }

    @SuppressWarnings("UnusedReturnValue")
    public <T> List<Holder<T>> addAll(Entries entries, HolderLookup.RegistryLookup<T> registry, String modId) {
        return registry.listElementIds()
                .filter(registryKey -> registryKey.identifier().getNamespace().equals(ProgressionReborn.MOD_ID))
                .map(key -> entries.add(registry, key))
                .toList();
    }
}
