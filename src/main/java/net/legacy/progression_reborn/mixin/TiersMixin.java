package net.legacy.progression_reborn.mixin;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = Tiers.class)
public abstract class TiersMixin {

    @Shadow public abstract Ingredient getRepairIngredient();

    @Shadow public abstract TagKey<Block> getIncorrectBlocksForDrops();

    @Inject(method = "getUses", at = @At("HEAD"), cancellable = true)
    private void modifyUses(CallbackInfoReturnable<Integer> cir) {
        if (getIncorrectBlocksForDrops().equals(BlockTags.INCORRECT_FOR_IRON_TOOL) && getRepairIngredient().equals(Ingredient.of(Items.IRON_INGOT))) {
            cir.setReturnValue(510);
        }
        if (getIncorrectBlocksForDrops().equals(BlockTags.INCORRECT_FOR_GOLD_TOOL) && getRepairIngredient().equals(Ingredient.of(Items.GOLD_INGOT))) {
            cir.setReturnValue(73);
        }
    }

}