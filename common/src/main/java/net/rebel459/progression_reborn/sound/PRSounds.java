package net.rebel459.progression_reborn.sound;

import net.rebel459.progression_reborn.ProgressionReborn;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;
import net.rebel459.unified.platform.UnifiedRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Properties;
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

	@NotNull
	private static SoundEvent register(@NotNull String string) {
        Identifier identifier = ProgressionReborn.id(string);
		return Registry.register(BuiltInRegistries.SOUND_EVENT, identifier, SoundEvent.createVariableRangeEvent(identifier));
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(String id) {
		return registerForHolder(ProgressionReborn.id(id));
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(Identifier id) {
		return registerForHolder(id, id);
	}

	private static Holder.@NotNull Reference<SoundEvent> registerForHolder(Identifier id, Identifier soundId) {
		return Registry.registerForHolder(BuiltInRegistries.SOUND_EVENT, id, SoundEvent.createVariableRangeEvent(soundId));
	}

	public static void init() {}
}
