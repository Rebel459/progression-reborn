package net.legacy.progression_reborn.registry;

import net.legacy.progression_reborn.tag.PRItemTags;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.Tool;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.List;

public record PRToolMaterial(
        TagKey<Block> incorrectBlocksForDrops, int durability, float speed, float attackDamageBonus, int enchantmentValue, TagKey<Item> repairItems
) {

    public static final ToolMaterial COPPER = new ToolMaterial(BlockTags.INCORRECT_FOR_STONE_TOOL, 190, 5.0F, 1.0F, 13, PRItemTags.COPPER_TOOL_MATERIALS);
    public static final ToolMaterial ROSE = new ToolMaterial(BlockTags.INCORRECT_FOR_IRON_TOOL, 281, 10.0F, 2.0F, 22, PRItemTags.ROSE_TOOL_MATERIALS);

    private Item.Properties applyCommonProperties(Item.Properties properties) {
        return properties.durability(this.durability).repairable(this.repairItems).enchantable(this.enchantmentValue);
    }

    public Item.Properties applyToolProperties(Item.Properties properties, TagKey<Block> mineableBlocks, float attackDamage, float attackSpeed) {
        HolderGetter<Block> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return this.applyCommonProperties(properties)
                .component(
                        DataComponents.TOOL,
                        new Tool(
                                List.of(
                                        Tool.Rule.deniesDrops(holderGetter.getOrThrow(this.incorrectBlocksForDrops)),
                                        Tool.Rule.minesAndDrops(holderGetter.getOrThrow(mineableBlocks), this.speed)
                                ),
                                1.0F,
                                1,
                                true
                        )
                )
                .attributes(this.createToolAttributes(attackDamage, attackSpeed));
    }

    private ItemAttributeModifiers createToolAttributes(float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (double)(attackDamage + this.attackDamageBonus), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, (double)attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }

    public Item.Properties applySwordProperties(Item.Properties properties, float attackDamage, float attackSpeed) {
        HolderGetter<Block> holderGetter = BuiltInRegistries.acquireBootstrapRegistrationLookup(BuiltInRegistries.BLOCK);
        return this.applyCommonProperties(properties)
                .component(
                        DataComponents.TOOL,
                        new Tool(
                                List.of(
                                        Tool.Rule.minesAndDrops(HolderSet.direct(Blocks.COBWEB.builtInRegistryHolder()), 15.0F),
                                        Tool.Rule.overrideSpeed(holderGetter.getOrThrow(BlockTags.SWORD_EFFICIENT), 1.5F)
                                ),
                                1.0F,
                                2,
                                false
                        )
                )
                .attributes(this.createSwordAttributes(attackDamage, attackSpeed));
    }

    private ItemAttributeModifiers createSwordAttributes(float attackDamage, float attackSpeed) {
        return ItemAttributeModifiers.builder()
                .add(
                        Attributes.ATTACK_DAMAGE,
                        new AttributeModifier(Item.BASE_ATTACK_DAMAGE_ID, (double)(attackDamage + this.attackDamageBonus), AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .add(
                        Attributes.ATTACK_SPEED,
                        new AttributeModifier(Item.BASE_ATTACK_SPEED_ID, (double)attackSpeed, AttributeModifier.Operation.ADD_VALUE),
                        EquipmentSlotGroup.MAINHAND
                )
                .build();
    }
}