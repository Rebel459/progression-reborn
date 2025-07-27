package net.legacy.progression_reborn.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.component.Consumable;
import net.minecraft.world.item.consume_effects.ApplyStatusEffectsConsumeEffect;

import java.util.List;

public class PRConsumables {
    public static final Consumable ENCHANTED_GOLDEN_CARROT = defaultFood()
            .onConsume(
                    new ApplyStatusEffectsConsumeEffect(
                            List.of(
                                    new MobEffectInstance(MobEffects.REGENERATION, 300, 1),
                                    new MobEffectInstance(MobEffects.SATURATION, 10, 1),
                                    new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600, 0),
                                    new MobEffectInstance(MobEffects.SPEED, 1200, 0)
                            )
                    )
            )
            .build();

    public static Consumable.Builder defaultFood() {
        return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.EAT).sound(SoundEvents.GENERIC_EAT).hasConsumeParticles(true);
    }

    public static Consumable.Builder defaultDrink() {
        return Consumable.builder().consumeSeconds(1.6F).animation(ItemUseAnimation.DRINK).sound(SoundEvents.GENERIC_DRINK).hasConsumeParticles(false);
    }
}
