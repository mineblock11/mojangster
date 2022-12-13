package com.mineblock.mojangster.fabric;

import com.mineblock.mojangster.Mojangster;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.entrypoint.PreLaunchEntrypoint;

public class MojangsterFabric implements ModInitializer, PreLaunchEntrypoint {
    @Override
    public void onInitialize() {
        Mojangster.init();
    }

    @Override
    public void onPreLaunch() {
        Mojangster.prelaunch();
    }
}