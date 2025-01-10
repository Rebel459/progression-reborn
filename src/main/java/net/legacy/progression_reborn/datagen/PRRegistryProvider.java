package net.legacy.progression_reborn.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.CompletableFuture;

import java.util.concurrent.CompletableFuture;

public class PRRegistryProvider extends FabricDynamicRegistryProvider {
    PRRegistryProvider(@NotNull FabricDataOutput output, @NotNull CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(@NotNull HolderLookup.Provider registries, @NotNull Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.TRIM_MATERIAL));

        bootstrap(entries);
    }

    public static void bootstrap(@NotNull Entries entries) {
        final var customTrimMaterials = asLookup(entries.getLookup(Registries.TRIM_MATERIAL));

    }

    public static <T> HolderLookup.RegistryLookup<T> asLookup(HolderGetter<T> getter) {
        return (HolderLookup.RegistryLookup<T>) getter;
    }

    @Override
    @NotNull
    public String getName() {
        return "Progression Reborn Dynamic Registries";
    }
}
