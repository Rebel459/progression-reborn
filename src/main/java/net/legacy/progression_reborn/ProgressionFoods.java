package net.legacy.progression_reborn;

import net.minecraft.world.food.FoodProperties;

public class ProgressionFoods {
    public static final FoodProperties ENCHANTED_BEETROOT;
    public static final FoodProperties ENCHANTED_BEETROOT_SOUP;

    public ProgressionFoods() {
    }

    static {
        ENCHANTED_BEETROOT = (new FoodProperties.Builder()).nutrition(3).saturationModifier(1.2F).alwaysEdible().build();
        ENCHANTED_BEETROOT_SOUP = (new FoodProperties.Builder()).nutrition(9).saturationModifier(1.2F).alwaysEdible().build();
    }
}