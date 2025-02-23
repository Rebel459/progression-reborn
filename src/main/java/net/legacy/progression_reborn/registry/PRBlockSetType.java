package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.sound.PRBlockSounds;
import net.legacy.progression_reborn.sound.PRSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.sounds.SoundEvents;

public class PRBlockSetType {

    private static BlockSetType registerPRBlockSetType(
            String name,
            boolean canOpenByHand,
            boolean canOpenByWindCharge,
            boolean canButtonBeActivatedByArrows,
            BlockSetType.PressurePlateSensitivity pressurePlateSensitivity,
            SoundType soundType,
            SoundEvent doorClose,
            SoundEvent doorOpen,
            SoundEvent trapdoorClose,
            SoundEvent trapdoorOpen,
            SoundEvent pressurePlateClickOff,
            SoundEvent pressurePlateClickOn,
            SoundEvent buttonClickOff,
            SoundEvent buttonClickOn
    )
    {
        return new BlockSetType(name, canOpenByHand, canOpenByWindCharge, canButtonBeActivatedByArrows, pressurePlateSensitivity, soundType, doorClose, doorOpen, trapdoorClose, trapdoorOpen, pressurePlateClickOff, pressurePlateClickOn, buttonClickOff, buttonClickOn);
    }


    public static final BlockSetType ROSE = registerPRBlockSetType
            (
                    "rose",
                    true,
                    true,
                    true,
                    BlockSetType.PressurePlateSensitivity.EVERYTHING,
                    PRBlockSounds.ROSE_BLOCK,
                    PRSounds.ROSE_DOOR_TOGGLE,
                    PRSounds.ROSE_DOOR_TOGGLE,
                    PRSounds.ROSE_TRAPDOOR_TOGGLE,
                    PRSounds.ROSE_TRAPDOOR_TOGGLE,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
                    );
}