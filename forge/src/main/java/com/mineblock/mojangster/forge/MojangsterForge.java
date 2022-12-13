package com.mineblock.mojangster.forge;

import com.mineblock.mojangster.Mojangster;
import net.minecraftforge.fml.common.Mod;

@Mod(Mojangster.MOD_ID)
public class MojangsterForge {
    public MojangsterForge() {
        Mojangster.prelaunch();
        Mojangster.init();
//        ModLoadingContext.get().registerExtensionPoint(ConfigGuiHandler.ConfigGuiFactory.class, () -> new ConfigGuiHandler.ConfigGuiFactory((minecraft, screen) -> new ConfigurationScreen(Component.literal("Mojangster"))));
    }
}