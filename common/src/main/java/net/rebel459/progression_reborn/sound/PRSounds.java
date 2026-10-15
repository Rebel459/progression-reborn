package net.rebel459.progression_reborn.sound;

import net.minecraft.sounds.SoundEvent;
import net.rebel459.progression_reborn.ProgressionReborn;
import net.rebel459.unified.api.core.UnifiedRegistries;

import java.util.function.Supplier;

public class PRSounds {

	public static UnifiedRegistries.SoundEvents SOUNDS = UnifiedRegistries.SoundEvents.create(ProgressionReborn.MOD_ID);

	public static final Supplier<SoundEvent> ROSE_BLOCK_BREAK = SOUNDS.register("block.rose_block.break");
	public static final Supplier<SoundEvent> ROSE_BLOCK_STEP = SOUNDS.register("block.rose_block.step");
	public static final Supplier<SoundEvent> ROSE_BLOCK_PLACE = SOUNDS.register("block.rose_block.place");
	public static final Supplier<SoundEvent> ROSE_BLOCK_HIT = SOUNDS.register("block.rose_block.hit");
	public static final Supplier<SoundEvent> ROSE_BLOCK_FALL = SOUNDS.register("block.rose_block.fall");

	public static final Supplier<SoundEvent> ROSE_LAMP_BREAK = SOUNDS.register("block.rose_lamp.break");
	public static final Supplier<SoundEvent> ROSE_LAMP_STEP = SOUNDS.register("block.rose_lamp.step");
	public static final Supplier<SoundEvent> ROSE_LAMP_PLACE = SOUNDS.register("block.rose_lamp.place");
	public static final Supplier<SoundEvent> ROSE_LAMP_HIT = SOUNDS.register("block.rose_lamp.hit");
	public static final Supplier<SoundEvent> ROSE_LAMP_FALL = SOUNDS.register("block.rose_lamp.fall");

	public static final Supplier<SoundEvent> ROSE_DOOR_TOGGLE = SOUNDS.register("block.rose_door.toggle");
	public static final Supplier<SoundEvent> ROSE_TRAPDOOR_TOGGLE = SOUNDS.register("block.rose_trapdoor.toggle");

	public static void init() {}
}
