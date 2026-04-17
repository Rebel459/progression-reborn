package net.rebel459.progression_reborn.registry;

import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.rebel459.progression_reborn.sound.PRBlockSounds;
import net.rebel459.progression_reborn.sound.PRSounds;

public class PRBlockSetTypes {

    public static final BlockSetType ROSE = new BlockSetType(
            "rose",
            true,
            true,
            true,
            BlockSetType.PressurePlateSensitivity.EVERYTHING,
            PRBlockSounds.ROSE_BLOCK,
            PRSounds.ROSE_DOOR_TOGGLE.get(),
            PRSounds.ROSE_DOOR_TOGGLE.get(),
            PRSounds.ROSE_TRAPDOOR_TOGGLE.get(),
            PRSounds.ROSE_TRAPDOOR_TOGGLE.get(),
            SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.STONE_BUTTON_CLICK_OFF,
            SoundEvents.STONE_BUTTON_CLICK_ON
    );
}