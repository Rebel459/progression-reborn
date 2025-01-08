package net.legacy.progression_reborn;

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
                    SoundType.NETHERITE_BLOCK,
                    SoundEvents.IRON_DOOR_CLOSE,
                    SoundEvents.IRON_DOOR_OPEN,
                    SoundEvents.IRON_TRAPDOOR_CLOSE,
                    SoundEvents.IRON_TRAPDOOR_OPEN,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
                    SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
                    SoundEvents.STONE_BUTTON_CLICK_OFF,
                    SoundEvents.STONE_BUTTON_CLICK_ON
                    );
}