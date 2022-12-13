package com.mineblock.mojangster.fabric;

import net.fabricmc.loader.api.FabricLoader;

import java.nio.file.Path;

public class PlatformHelperImpl {
    public static Path getGameDir() {
        return FabricLoader.getInstance().getGameDir();
    }

    public static String getVersion() {
        return FabricLoader.getInstance().getModContainer("mojangster").get().getMetadata().getVersion().getFriendlyString();
    }
}
