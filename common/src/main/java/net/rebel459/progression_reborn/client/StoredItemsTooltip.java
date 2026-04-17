package net.rebel459.progression_reborn.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Font;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.tooltip.ClientTooltipComponent;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class StoredItemsTooltip implements ClientTooltipComponent {
    private static final float SCALE = 0.75F;
    private static final int ICON_SIZE = 12;
    private static final int ENTRY_GAP = 5;
    private static final int ROW_GAP = 3;
    private static final int TEXT_GAP = 2;
    private static final int BOTTOM_PADDING = 4;
    private static final int MAX_COLUMNS = 4;
    private static final int MAX_ROWS_EXPANDED = 4;

    private final Tooltip tooltip;

    public StoredItemsTooltip(Tooltip tooltip) {
        this.tooltip = tooltip;
    }

    @Override
    public int getHeight(Font font) {
        int rows = this.tooltip.expanded() ? (int) Math.ceil(this.visibleEntries() / (double) MAX_COLUMNS) : 1;
        return Math.max(ICON_SIZE, rows * ICON_SIZE + Math.max(0, rows - 1) * ROW_GAP) + BOTTOM_PADDING;
    }

    @Override
    public int getWidth(Font font) {
        if (!this.tooltip.expanded()) {
            int width = 0;
            int visibleEntries = Math.min(MAX_COLUMNS, this.tooltip.entries().size());
            for (int i = 0; i < visibleEntries; i++) {
                width += this.entryWidth(font, this.tooltip.entries().get(i)) + ENTRY_GAP;
            }
            return Math.max(0, width - ENTRY_GAP);
        }

        int width = 0;
        int rowWidth = 0;

        int visibleEntries = this.visibleEntries();
        for (int i = 0; i < visibleEntries; i++) {
            if (i > 0 && i % MAX_COLUMNS == 0) {
                width = Math.max(width, rowWidth - ENTRY_GAP);
                rowWidth = 0;
            }
            rowWidth += this.entryWidth(font, this.tooltip.entries().get(i)) + ENTRY_GAP;
        }

        return Math.max(width, Math.max(0, rowWidth - ENTRY_GAP));
    }

    @Override
    public void extractImage(Font font, int x, int y, int w, int h, GuiGraphicsExtractor graphics) {
        int drawX = x;
        int drawY = y;
        int visibleEntries = this.visibleEntries();

        for (int i = 0; i < visibleEntries; i++) {
            Tooltip.Entry entry = this.tooltip.entries().get(i);
            if (this.tooltip.expanded() && i > 0 && i % MAX_COLUMNS == 0) {
                drawX = x;
                drawY += ICON_SIZE + ROW_GAP;
            }

            ItemStack stack = entry.stack();
            graphics.pose().pushMatrix();
            graphics.pose().translate(drawX, drawY);
            graphics.pose().scale(SCALE, SCALE);
            graphics.item(stack, 0, 0);
            graphics.pose().popMatrix();

            graphics.pose().pushMatrix();
            graphics.pose().translate(drawX + ICON_SIZE + TEXT_GAP, drawY + 3);
            graphics.pose().scale(SCALE, SCALE);
            graphics.text(font, Integer.toString(entry.count()), 0, 0, -1, true);
            graphics.pose().popMatrix();

            drawX += this.entryWidth(font, entry) + ENTRY_GAP;
        }
    }

    private int entryWidth(Font font, Tooltip.Entry entry) {
        return ICON_SIZE + TEXT_GAP + Math.round(font.width(Integer.toString(entry.count())) * SCALE);
    }

    private int visibleEntries() {
        if (!this.tooltip.expanded()) {
            return Math.min(MAX_COLUMNS, this.tooltip.entries().size());
        }
        return Math.min(MAX_COLUMNS * MAX_ROWS_EXPANDED, this.tooltip.entries().size());
    }

    public record Tooltip(List<Tooltip.Entry> entries, boolean expanded) implements TooltipComponent {
        public record Entry(ItemStack stack, int count) { }
    }

    public static boolean hasKeyDown() {
        return Minecraft.getInstance().hasShiftDown();
    }
}
