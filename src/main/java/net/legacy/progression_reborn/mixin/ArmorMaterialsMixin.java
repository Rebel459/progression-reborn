package net.legacy.progression_reborn.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.equipment.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

import java.util.EnumMap;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.item.equipment.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.invoke.arg.Args;

import java.util.EnumMap;

@Mixin(ArmorMaterials.class)
public interface ArmorMaterialsMixin {

    @WrapOperation(
            method = "method_48412",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/EnumMap;put(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;",
                    ordinal = 0
            )
    )
    private static Object modifyBootsValue(EnumMap instance, Enum key, Object value, Operation<Object> original) {
        return original.call(instance, key, Integer.valueOf(500));
    }

    @WrapOperation(
            method = "method_48412",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/EnumMap;put(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;",
                    ordinal = 1
            )
    )
    private static Object modifyLeggingsValue(EnumMap instance, Enum key, Object value, Operation<Object> original) {
        return original.call(instance, key, Integer.valueOf(500));
    }

    @WrapOperation(
            method = "method_48412",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/EnumMap;put(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;",
                    ordinal = 2
            )
    )
    private static Object modifyChestplateValue(EnumMap instance, Enum key, Object value, Operation<Object> original) {
        return original.call(instance, key, Integer.valueOf(500));
    }

    @WrapOperation(
            method = "method_48412",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/EnumMap;put(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;",
                    ordinal = 3
            )
    )
    private static Object modifyHelmetValue(EnumMap instance, Enum key, Object value, Operation<Object> original) {
        return original.call(instance, key, Integer.valueOf(500));
    }

    @WrapOperation(
            method = "method_48412",
            at = @At(
                    value = "INVOKE",
                    target = "Ljava/util/EnumMap;put(Ljava/lang/Enum;Ljava/lang/Object;)Ljava/lang/Object;",
                    ordinal = 4
            )
    )
    private static Object modifyBodyValue(EnumMap instance, Enum key, Object value, Operation<Object> original) {
        return original.call(instance, key, Integer.valueOf(500));
    }

}