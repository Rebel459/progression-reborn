package net.legacy.progression_reborn.mixin;

import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.ArmorMaterials;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(ArmorMaterials.class)
public class ArmorMaterialsMixin {

    @Inject(method = "getDefenseForType", at = @At("HEAD"), cancellable = true)
    private void modifyDefense(ArmorItem.Type type, CallbackInfoReturnable<Integer> cir) {

        ArmorMaterials material = (ArmorMaterials)(Object)this;

        if (material == ArmorMaterials.LEATHER) {
            cir.setReturnValue(switch (type) {
                case HELMET -> 1;
                case CHESTPLATE -> 3;
                case LEGGINGS -> 3;
                case BOOTS -> 1;
            });
            return;
        }

        if (material == ArmorMaterials.CHAIN) {
            cir.setReturnValue(switch (type) {
                case HELMET -> 3;
                case CHESTPLATE -> 5;
                case LEGGINGS -> 4;
                case BOOTS -> 2;
            });
            return;
        }

        if (material == ArmorMaterials.IRON) {
            cir.setReturnValue(switch (type) {
                case HELMET -> 3;
                case CHESTPLATE -> 6;
                case LEGGINGS -> 5;
                case BOOTS -> 2;
            });
            return;
        }

        if (material == ArmorMaterials.GOLD) {
            cir.setReturnValue(switch (type) {
                case HELMET -> 1;
                case CHESTPLATE -> 3;
                case LEGGINGS -> 3;
                case BOOTS -> 1;
            });
            return;
        }

        if (material == ArmorMaterials.DIAMOND || material == ArmorMaterials.NETHERITE) {
            cir.setReturnValue(switch (type) {
                case HELMET -> 4;
                case CHESTPLATE -> 7;
                case LEGGINGS -> 6;
                case BOOTS -> 3;
            });
        }
    }

    @Inject(method = "getToughness", at = @At("HEAD"), cancellable = true)
    private void modifyToughness(CallbackInfoReturnable<Float> cir) {

        ArmorMaterials material = (ArmorMaterials)(Object)this;

        if (material == ArmorMaterials.CHAIN) {
            cir.setReturnValue(1.0F);
        } else if (material == ArmorMaterials.GOLD) {
            cir.setReturnValue(1.0F);
        } else if (material == ArmorMaterials.DIAMOND) {
            cir.setReturnValue(1.0F);
        } else if (material == ArmorMaterials.NETHERITE) {
            cir.setReturnValue(2.0F);
        }
    }
}