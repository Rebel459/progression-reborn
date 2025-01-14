package net.legacy.progression_reborn.datafix;

import com.mojang.datafixers.schemas.Schema;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.progression_reborn.PRConstants;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.datafix.schemas.NamespacedSchema;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.QuiltDataFixerBuilder;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.QuiltDataFixes;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.SimpleFixes;

public class PRDataFixer {
	public static final int DATA_VERSION = 4189;

	private PRDataFixer() {
		throw new UnsupportedOperationException("PRDataFixer contains only static declarations.");
	}

	public static void applyDataFixes(final @NotNull ModContainer mod) {
		var builder = new QuiltDataFixerBuilder(DATA_VERSION);
		builder.addSchema(0, QuiltDataFixes.BASE_SCHEMA);

		Schema schemaV1 = builder.addSchema(1, NamespacedSchema::new);

		// Waxed Copper Gear

		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_copper_helmet to copper_helmet",
				PRConstants.id("waxed_copper_helmet"),
				PRConstants.id("copper_helmet"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_copper_chestplate to copper_chestplate",
				PRConstants.id("waxed_copper_chestplate"),
				PRConstants.id("copper_chestplate"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_copper_leggings to copper_leggings",
				PRConstants.id("waxed_copper_leggings"),
				PRConstants.id("copper_leggings"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_copper_boots to copper_boots",
				PRConstants.id("waxed_copper_boots"),
				PRConstants.id("copper_boots"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_copper_sword to copper_sword",
				PRConstants.id("waxed_copper_sword"),
				PRConstants.id("copper_sword"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_copper_axe to copper_axe",
				PRConstants.id("waxed_copper_axe"),
				PRConstants.id("copper_axe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_copper_pickaxe to copper_pickaxe",
				PRConstants.id("waxed_copper_pickaxe"),
				PRConstants.id("copper_pickaxe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_copper_shovel to copper_shovel",
				PRConstants.id("waxed_copper_shovel"),
				PRConstants.id("copper_shovel"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_copper_hoe to copper_hoe",
				PRConstants.id("waxed_copper_hoe"),
				PRConstants.id("copper_hoe"),
				schemaV1
		);

		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_exposed_copper_helmet to copper_helmet",
				PRConstants.id("waxed_exposed_copper_helmet"),
				PRConstants.id("copper_helmet"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_exposed_copper_chestplate to copper_chestplate",
				PRConstants.id("waxed_exposed_copper_chestplate"),
				PRConstants.id("copper_chestplate"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_exposed_copper_leggings to copper_leggings",
				PRConstants.id("waxed_exposed_copper_leggings"),
				PRConstants.id("copper_leggings"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_exposed_copper_boots to copper_boots",
				PRConstants.id("waxed_exposed_copper_boots"),
				PRConstants.id("copper_boots"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_exposed_copper_sword to copper_sword",
				PRConstants.id("waxed_exposed_copper_sword"),
				PRConstants.id("copper_sword"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_exposed_copper_axe to copper_axe",
				PRConstants.id("waxed_exposed_copper_axe"),
				PRConstants.id("copper_axe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_exposed_copper_pickaxe to copper_pickaxe",
				PRConstants.id("waxed_exposed_copper_pickaxe"),
				PRConstants.id("copper_pickaxe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_exposed_copper_shovel to copper_shovel",
				PRConstants.id("waxed_exposed_copper_shovel"),
				PRConstants.id("copper_shovel"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_exposed_copper_hoe to copper_hoe",
				PRConstants.id("waxed_exposed_copper_hoe"),
				PRConstants.id("copper_hoe"),
				schemaV1
		);

		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_weathered_copper_helmet to copper_helmet",
				PRConstants.id("waxed_weathered_copper_helmet"),
				PRConstants.id("copper_helmet"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_weathered_copper_chestplate to copper_chestplate",
				PRConstants.id("waxed_weathered_copper_chestplate"),
				PRConstants.id("copper_chestplate"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_weathered_copper_leggings to copper_leggings",
				PRConstants.id("waxed_weathered_copper_leggings"),
				PRConstants.id("copper_leggings"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_weathered_copper_boots to copper_boots",
				PRConstants.id("waxed_weathered_copper_boots"),
				PRConstants.id("copper_boots"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_weathered_copper_sword to copper_sword",
				PRConstants.id("waxed_weathered_copper_sword"),
				PRConstants.id("copper_sword"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_weathered_copper_axe to copper_axe",
				PRConstants.id("waxed_weathered_copper_axe"),
				PRConstants.id("copper_axe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_weathered_copper_pickaxe to copper_pickaxe",
				PRConstants.id("waxed_weathered_copper_pickaxe"),
				PRConstants.id("copper_pickaxe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_weathered_copper_shovel to copper_shovel",
				PRConstants.id("waxed_weathered_copper_shovel"),
				PRConstants.id("copper_shovel"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_weathered_copper_hoe to copper_hoe",
				PRConstants.id("waxed_weathered_copper_hoe"),
				PRConstants.id("copper_hoe"),
				schemaV1
		);

		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_oxidized_copper_helmet to copper_helmet",
				PRConstants.id("waxed_oxidized_copper_helmet"),
				PRConstants.id("copper_helmet"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_oxidized_copper_chestplate to copper_chestplate",
				PRConstants.id("waxed_oxidized_copper_chestplate"),
				PRConstants.id("copper_chestplate"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_oxidized_copper_leggings to copper_leggings",
				PRConstants.id("waxed_oxidized_copper_leggings"),
				PRConstants.id("copper_leggings"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_oxidized_copper_boots to copper_boots",
				PRConstants.id("waxed_oxidized_copper_boots"),
				PRConstants.id("copper_boots"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_oxidized_copper_sword to copper_sword",
				PRConstants.id("waxed_oxidized_copper_sword"),
				PRConstants.id("copper_sword"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_oxidized_copper_axe to copper_axe",
				PRConstants.id("waxed_oxidized_copper_axe"),
				PRConstants.id("copper_axe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_oxidized_copper_pickaxe to copper_pickaxe",
				PRConstants.id("waxed_oxidized_copper_pickaxe"),
				PRConstants.id("copper_pickaxe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_oxidized_copper_shovel to copper_shovel",
				PRConstants.id("waxed_oxidized_copper_shovel"),
				PRConstants.id("copper_shovel"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix waxed_oxidized_copper_hoe to copper_hoe",
				PRConstants.id("waxed_oxidized_copper_hoe"),
				PRConstants.id("copper_hoe"),
				schemaV1
		);

		// Stone Tool Variants

		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix deepslate_sword to stone_sword",
				PRConstants.id("deepslate_sword"),
				ResourceLocation.withDefaultNamespace("stone_sword"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix deepslate_axe to stone_axe",
				PRConstants.id("deepslate_axe"),
				ResourceLocation.withDefaultNamespace("stone_axe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix deepslate_pickaxe to stone_pickaxe",
				PRConstants.id("deepslate_pickaxe"),
				ResourceLocation.withDefaultNamespace("stone_pickaxe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix deepslate_shovel to stone_shovel",
				PRConstants.id("deepslate_shovel"),
				ResourceLocation.withDefaultNamespace("stone_shovel"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix deepslate_hoe to stone_hoe",
				PRConstants.id("deepslate_hoe"),
				ResourceLocation.withDefaultNamespace("stone_hoe"),
				schemaV1
		);

		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix blackstone_sword to stone_sword",
				PRConstants.id("blackstone_sword"),
				ResourceLocation.withDefaultNamespace("stone_sword"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix blackstone_axe to stone_axe",
				PRConstants.id("blackstone_axe"),
				ResourceLocation.withDefaultNamespace("stone_axe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix blackstone_pickaxe to stone_pickaxe",
				PRConstants.id("blackstone_pickaxe"),
				ResourceLocation.withDefaultNamespace("stone_pickaxe"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix blackstone_shovel to stone_shovel",
				PRConstants.id("blackstone_shovel"),
				ResourceLocation.withDefaultNamespace("stone_shovel"),
				schemaV1
		);
		SimpleFixes.addItemRenameFix(
				builder,
				"Datafix blackstone_hoe to stone_hoe",
				PRConstants.id("blackstone_hoe"),
				ResourceLocation.withDefaultNamespace("stone_hoe"),
				schemaV1
		);

		QuiltDataFixes.buildAndRegisterFixer(mod, builder);
	}

}
