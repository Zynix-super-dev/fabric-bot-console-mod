package com.zynix.starter;

import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.TextFieldWidget;
import net.minecraft.client.gui.widget.TextWidget;
import net.minecraft.text.Text;

public class ModConfigScreen extends Screen {
    private static final int FIELD_WIDTH = 220;

    private TextFieldWidget nickField;
    private TextFieldWidget hostField;
    private TextFieldWidget portField;
    private TextWidget consoleWidget;

    public ModConfigScreen() {
        super(Text.literal("Starter X"));
    }

    @Override
    protected void init() {
        super.init();

        int centerX = width / 2;
        int leftX = centerX - FIELD_WIDTH / 2;

        nickField = new TextFieldWidget(textRenderer, leftX, 70, FIELD_WIDTH, 20, Text.literal("Nick"));
        nickField.setText(ModConfig.nickname);
        addSelectableChild(nickField);
        addDrawableChild(nickField);

        hostField = new TextFieldWidget(textRenderer, leftX, 115, FIELD_WIDTH, 20, Text.literal("Host"));
        hostField.setText(ModConfig.host);
        addSelectableChild(hostField);
        addDrawableChild(hostField);

        portField = new TextFieldWidget(textRenderer, leftX, 160, FIELD_WIDTH, 20, Text.literal("Port"));
        portField.setText(ModConfig.port);
        addSelectableChild(portField);
        addDrawableChild(portField);

        addDrawableChild(ButtonWidget.builder(Text.literal("Save"), button -> saveSettings())
                .dimensions(centerX - 100, height - 65, 90, 20)
                .build());

        addDrawableChild(ButtonWidget.builder(Text.literal("Close"), button -> close())
                .dimensions(centerX + 10, height - 65, 90, 20)
                .build());

        consoleWidget = new TextWidget(Text.literal(ModConfig.getConsoleText()), textRenderer);
        consoleWidget.setMaxWidth(FIELD_WIDTH + 60);
        addDrawableChild(consoleWidget);
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        renderBackground(context, mouseX, mouseY, delta);

        context.drawCenteredTextWithShadow(textRenderer, "Starter X Mod", width / 2, 20, 0xFFFFFF);
        context.drawText(textRenderer, Text.literal("Nick:"), width / 2 - FIELD_WIDTH / 2 - 55, 76, 0xFFFFFF, false);
        context.drawText(textRenderer, Text.literal("Host:"), width / 2 - FIELD_WIDTH / 2 - 55, 121, 0xFFFFFF, false);
        context.drawText(textRenderer, Text.literal("Port:"), width / 2 - FIELD_WIDTH / 2 - 55, 166, 0xFFFFFF, false);

        int consoleY = 205;
        context.drawText(textRenderer, Text.literal("Console:"), width / 2 - FIELD_WIDTH / 2 - 55, consoleY, 0xFFFFFF, false);

        if (consoleWidget != null) {
            consoleWidget.setText(Text.literal(ModConfig.getConsoleText()));
            consoleWidget.setPosition(width / 2 - FIELD_WIDTH / 2, consoleY + 18);
            consoleWidget.render(context, mouseX, mouseY, delta);
        }

        super.render(context, mouseX, mouseY, delta);
    }

    private void saveSettings() {
        ModConfig.nickname = nickField.getText();
        ModConfig.host = hostField.getText();
        ModConfig.port = portField.getText();
        ModConfig.save();
        ModConfig.addLog("Values saved: " + ModConfig.nickname + " @ " + ModConfig.host + ":" + ModConfig.port);
    }
}
