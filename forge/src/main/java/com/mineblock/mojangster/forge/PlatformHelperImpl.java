package com.mineblock.mojangster.forge;

import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.loading.FMLPaths;

import java.nio.file.Path;
import java.text.MessageFormat;

public class PlatformHelperImpl {
    public static Path getGameDir() {
        return FMLPaths.GAMEDIR.get();
    }

    public static String getVersion() {
        var meta = ModLoadingContext.get().getActiveContainer().getModInfo();
        return MessageFormat.format("{0}.{1}.{2}", meta.getVersion().getMajorVersion(), meta.getVersion().getMinorVersion(), meta.getVersion().getIncrementalVersion());
    }
}
