package com.mineblock.mojangster;

import com.sun.jdi.InvocationException;
import dev.architectury.injectables.annotations.ExpectPlatform;
import org.apache.commons.lang3.NotImplementedException;

import java.nio.file.Path;

public class PlatformHelper {
    @ExpectPlatform
    public static Path getGameDir() {
        throw new NotImplementedException();
    }

    @ExpectPlatform
    public static String getVersion() {
        throw new NotImplementedException();
    }
}
