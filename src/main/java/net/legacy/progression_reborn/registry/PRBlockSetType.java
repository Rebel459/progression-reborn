package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.PRConstants;
import net.legacy.progression_reborn.sound.PRBlockSounds;
import net.legacy.progression_reborn.sound.PRSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.sounds.SoundEvents;

public class PRBlockSetType {

    public static final BlockSetType ROSE = new BlockSetType(
            PRConstants.string("rose"),
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