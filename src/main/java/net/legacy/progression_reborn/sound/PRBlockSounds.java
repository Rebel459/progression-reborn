package net.legacy.progression_reborn.sound;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.level.block.SoundType;

public final class PRBlockSounds {

    public static final SoundType ROSE_BLOCK = new SoundType(1F, 1F,
            PRSounds.ROSE_BLOCK_BREAK,
            PRSounds.ROSE_BLOCK_STEP,
            PRSounds.ROSE_BLOCK_PLACE,
            PRSounds.ROSE_BLOCK_HIT,
            PRSounds.ROSE_BLOCK_FALL
    );
    public static final SoundType ROSE_LAMP = new SoundType(1F, 1F,
            PRSounds.ROSE_LAMP_BREAK,
            PRSounds.ROSE_LAMP_STEP,
            PRSounds.ROSE_LAMP_PLACE,
            PRSounds.ROSE_LAMP_HIT,
            PRSounds.ROSE_LAMP_FALL
    );

    public static void init() {
    }
}
