package com.zynix.starter;

import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.option.KeyBinding;
import net.minecraft.client.util.InputUtil;

public final class Keybinds {
    public static KeyBinding OPEN_MENU;

    private Keybinds() {
    }

    public static void register() {
        OPEN_MENU = KeyBindingHelper.registerKeyBinding(new KeyBinding(
                "key.starterxmod.open_menu",
                InputUtil.Type.KEYSYM,
                InputUtil.fromTranslationKey("key.keyboard.x").getCode(),
                "key.category.starterxmod.main"
        ));
    }
}
