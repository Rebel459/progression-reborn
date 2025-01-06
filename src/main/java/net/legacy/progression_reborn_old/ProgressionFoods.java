package net.legacy.progression_reborn_old;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class ProgressionFoods {
    public static final FoodProperties ENCHANTED_GOLDEN_CARROT;

    public ProgressionFoods() {
    }

    static {
        ENCHANTED_GOLDEN_CARROT = (new FoodProperties.Builder()).nutrition(6).saturationModifier(2.4F).effect(new MobEffectInstance(MobEffects.REGENERATION, 300, 1), 1.0F).effect(new MobEffectInstance(MobEffects.SATURATION, 10, 1), 1.0F).effect(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0), 1.0F).effect(new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 0), 1.0F).alwaysEdible().build();
    }
}