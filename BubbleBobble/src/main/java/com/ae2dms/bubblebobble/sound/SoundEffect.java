package com.ae2dms.bubblebobble.sound;

import javafx.scene.media.AudioClip;

/**
 * SoundEffect handles the game's SFX.
 * Classes that want to use SFX and play them via the play(String str) method.
 *
 * @author Ke Liu
 */
public class SoundEffect {
    /**
     * Play the target sfx file.
     *
     * @param str String type, the sfx file name.
     */
        public static void play(String str) {
            AudioClip audioClip = new AudioClip(SoundEffect.class.getResource(str).toString());
            audioClip.setVolume(0.05);
            audioClip.play();
        }
    }
