package net.legacy.progression_reborn;

import net.minecraft.world.food.FoodProperties;

public class PRFoods {
    public static final FoodProperties ENCHANTED_GOLDEN_CARROT;

    public PRFoods() {
    }

    static {
        ENCHANTED_GOLDEN_CARROT = (new FoodProperties.Builder()).nutrition(6).saturationModifier(2.4F).alwaysEdible().build();
    }
}