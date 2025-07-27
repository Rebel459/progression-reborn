package net.legacy.progression_reborn.datafix;

import com.mojang.datafixers.schemas.Schema;
import net.fabricmc.loader.api.ModContainer;
import net.legacy.progression_reborn.PRConstants;
import net.minecraft.util.datafix.schemas.NamespacedSchema;
import org.jetbrains.annotations.NotNull;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.QuiltDataFixerBuilder;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.QuiltDataFixes;
import org.quiltmc.qsl.frozenblock.misc.datafixerupper.api.SimpleFixes;

public final class PRDataFixer {
	public static final int DATA_VERSION = 1;

	public static void applyDataFixes(final @NotNull ModContainer mod) {
		var builder = new QuiltDataFixerBuilder(DATA_VERSION);
		builder.addSchema(0, QuiltDataFixes.BASE_SCHEMA);

		Schema schemaV1 = builder.addSchema(1, NamespacedSchema::new);
		SimpleFixes.addItemRenameFix(builder, "Rename diamond_nugget to diamond_shard", PRConstants.id("diamond_nugget"), PRConstants.id("diamond_shard"), schemaV1);
	}
}