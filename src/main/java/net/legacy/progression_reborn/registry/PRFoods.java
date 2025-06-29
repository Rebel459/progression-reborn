package net.legacy.progression_reborn.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
public class PRFoods {
    public static final FoodProperties ENCHANTED_GOLDEN_CARROT;

    public PRFoods() {
    }

    static {
        ENCHANTED_GOLDEN_CARROT = (new FoodProperties.Builder())
                .nutrition(6)
                .saturationModifier(2.4F)
                .alwaysEdible()
                .effect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1), 1F)
                .effect(new MobEffectInstance(MobEffects.SATURATION, 10, 1), 1F)
                .effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 1F)
                .effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1F)
                .build();
    }
}