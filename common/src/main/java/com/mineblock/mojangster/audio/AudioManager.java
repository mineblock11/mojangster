package com.mineblock.mojangster.audio;

import com.mineblock.mojangster.Mojangster;
import com.mineblock.mojangster.config.MojangsterConfig;
import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Objects;

public class AudioManager {
    private static final HashMap<String, Clip> CLIPS = new HashMap<>();

    public static void init() throws LineUnavailableException, IOException, UnsupportedAudioFileException {
        Clip defaultClip = AudioSystem.getClip();
        AudioInputStream defaultStream = AudioSystem.getAudioInputStream(Mojangster.soundPath.toFile());
        defaultClip.open(defaultStream);
        defaultClip.addLineListener((LineEvent event) -> {
            if (event.getType() == LineEvent.Type.STOP) {
                defaultClip.setMicrosecondPosition(0);
            }
        });
        CLIPS.put("default.wav", defaultClip);

        for (final File fileEntry : Objects.requireNonNull(Mojangster.customs.toFile().listFiles())) {
            if (fileEntry.getName().endsWith(".wav")) {
                Clip clip = AudioSystem.getClip();
                AudioInputStream inputStream = AudioSystem.getAudioInputStream(fileEntry);
                clip.open(inputStream);
                clip.addLineListener((LineEvent event) -> {
                    if (event.getType() == LineEvent.Type.STOP) {
                        clip.setMicrosecondPosition(0);
                    }
                });
                CLIPS.put(fileEntry.getName(), clip);
            }
        }
    }

    public static void play(String id) {
        Clip clip = CLIPS.get(id);
        if (!MojangsterConfig.getInstance().playSound)
            return;
        if (Objects.isNull(clip)) {
//            Mojangster.OVERLAY_INSTANCE.addEndListener(() -> {
//                return Minecraft.getInstance().getToasts().addToast(
//                        new SystemToast(SystemToast.SystemToastIds.PACK_LOAD_FAILURE, Component.literal("Sound not found."), Component.literal("Couldn't find " + id + " in the /mojank/custom folder.")));
//            });
            return;
        }
        clip.start();
    }
}
