package net.rebel459.progression_reborn.mixin;

import me.shedaniel.autoconfig.AutoConfig;
import me.shedaniel.autoconfig.serializer.JanksonConfigSerializer;
import net.rebel459.progression_reborn.config.PRConfig;
import net.rebel459.unified.platform.UnifiedPlatform;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.objectweb.asm.tree.ClassNode;
import org.spongepowered.asm.mixin.extensibility.IMixinConfigPlugin;
import org.spongepowered.asm.mixin.extensibility.IMixinInfo;

import java.util.List;
import java.util.Set;

public final class PRMixinPlugin implements IMixinConfigPlugin {

    private static boolean registeredConfig = false;

    @Override
    public void onLoad(String mixinPackage) {
        if (!registeredConfig) {
            AutoConfig.register(PRConfig.class, JanksonConfigSerializer::new);
            registeredConfig = true;
        }
    }

    @Override
    @Nullable
    public String getRefMapperConfig() {
        return null;
    }

    @Override
    public boolean shouldApplyMixin(String targetClassName, @NotNull String mixinClassName) {

        if (mixinClassName.contains("integration.farmersdelight")) return UnifiedPlatform.get().isModLoaded("farmersdelight");
        if (mixinClassName.contains("integration.item_tooltips")) return UnifiedPlatform.get().isModLoaded("item_tooltips");

        return true;
    }

    @Override
    public void acceptTargets(Set<String> myTargets, Set<String> otherTargets) {}

    @Override
    @Nullable
    public List<String> getMixins() {
        return null;
    }

    @Override
    public void preApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}

    @Override
    public void postApply(String targetClassName, ClassNode targetClass, String mixinClassName, IMixinInfo mixinInfo) {}
}
