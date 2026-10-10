package com.zynix.starter;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;

public class StarterMod implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ModConfig.load();
        Keybinds.register();

        ClientTickEvents.END_CLIENT_TICK.register(client -> {
            if (Keybinds.OPEN_MENU.wasPressed()) {
                client.execute(() -> client.setScreen(new ModConfigScreen()));
                ModConfig.addLog("Menu opened with X");
            }
        });

        ModConfig.addLog("Starter X Mod initialized");
    }
}
