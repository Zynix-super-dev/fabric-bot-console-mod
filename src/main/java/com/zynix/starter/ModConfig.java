package com.zynix.starter;

import net.fabricmc.loader.api.FabricLoader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public final class ModConfig {
    private static final Path CONFIG_PATH = FabricLoader.getInstance().getConfigDir().resolve("starterxmod.properties");

    public static String nickname = "Player";
    public static String host = "localhost";
    public static String port = "25565";
    public static final List<String> LOGS = new ArrayList<>();

    static {
        LOGS.add("Mod ready");
    }

    private ModConfig() {
    }

    public static void load() {
        if (!Files.exists(CONFIG_PATH)) {
            return;
        }

        Properties properties = new Properties();
        try (BufferedReader reader = Files.newBufferedReader(CONFIG_PATH, StandardCharsets.UTF_8)) {
            properties.load(reader);
        } catch (IOException e) {
            addLog("Could not load config: " + e.getMessage());
            return;
        }

        nickname = properties.getProperty("nickname", nickname);
        host = properties.getProperty("host", host);
        port = properties.getProperty("port", port);
    }

    public static void save() {
        Properties properties = new Properties();
        properties.setProperty("nickname", nickname);
        properties.setProperty("host", host);
        properties.setProperty("port", port);

        try {
            Files.createDirectories(CONFIG_PATH.getParent());
            try (Writer writer = Files.newBufferedWriter(CONFIG_PATH, StandardCharsets.UTF_8)) {
                properties.store(writer, "Starter X Mod settings");
            }
            addLog("Settings saved to config file");
        } catch (IOException e) {
            addLog("Could not save config: " + e.getMessage());
        }
    }

    public static void addLog(String message) {
        String line = message == null ? "null" : message;
        if (LOGS.size() > 30) {
            LOGS.remove(0);
        }
        LOGS.add(line);
    }

    public static String getConsoleText() {
        return String.join("\n", LOGS);
    }
}
