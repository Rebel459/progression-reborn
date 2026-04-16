package net.rebel459.progression_reborn.sound;

import net.minecraft.world.level.block.SoundType;

public final class PRBlockSounds {

    public static final SoundType ROSE_BLOCK = new SoundType(1F, 1F,
            PRSounds.ROSE_BLOCK_BREAK.get(),
            PRSounds.ROSE_BLOCK_STEP.get(),
            PRSounds.ROSE_BLOCK_PLACE.get(),
            PRSounds.ROSE_BLOCK_HIT.get(),
            PRSounds.ROSE_BLOCK_FALL.get()
    );
    public static final SoundType ROSE_LAMP = new SoundType(1F, 1F,
            PRSounds.ROSE_LAMP_BREAK.get(),
            PRSounds.ROSE_LAMP_STEP.get(),
            PRSounds.ROSE_LAMP_PLACE.get(),
            PRSounds.ROSE_LAMP_HIT.get(),
            PRSounds.ROSE_LAMP_FALL.get()
    );

    public static void init() {
    }
}
