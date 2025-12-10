package net.legacy.progression_reborn.sound;

import net.legacy.progression_reborn.PRConstants;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import org.jetbrains.annotations.NotNull;

public class PRSounds {
	public static final SoundEvent ROSE_BLOCK_BREAK = register("block.rose_block.break");
	public static final SoundEvent ROSE_BLOCK_STEP = register("block.rose_block.step");
	public static final SoundEvent ROSE_BLOCK_PLACE = register("block.rose_block.place");
	public static final SoundEvent ROSE_BLOCK_HIT = register("block.rose_block.hit");
	public static final SoundEvent ROSE_BLOCK_FALL = register("block.rose_block.fall");

	public static final SoundEvent ROSE_LAMP_BREAK = register("block.rose_lamp.break");
	public static final SoundEvent ROSE_LAMP_STEP = register("block.rose_lamp.step");
	public static final SoundEvent ROSE_LAMP_PLACE = register("block.rose_lamp.place");
	public static final SoundEvent ROSE_LAMP_HIT = register("block.rose_lamp.hit");
	public static final SoundEvent ROSE_LAMP_FALL = register("block.rose_lamp.fall");

	public static final SoundEvent ROSE_DOOR_TOGGLE = register("block.rose_door.toggle");
	public static final SoundEvent ROSE_TRAPDOOR_TOGGLE = register("block.rose_trapdoor.toggle");

	@NotNull
	private static SoundEvent register(@NotNull String string) {
        Identifier identifier = PRConstants.id(string);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(String id) {
		return registerForHolder(PRConstants.id(id));
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(Identifier id) {
		return registerForHolder(id, id);
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(Identifier id, Identifier soundId) {
		return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(soundId));
	}

	public static void init() {}
}
