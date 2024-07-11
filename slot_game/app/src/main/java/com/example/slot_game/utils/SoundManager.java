package com.example.slot_game.utils;

import android.app.Activity;
import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.media.SoundPool;

import com.example.slot_game.R;

public class SoundManager {
    private MediaPlayer backgroundPlayer;
    private SoundPool soundPool;
    private int buttonSoundId;
    private boolean isBackgroundPlaying = false;
    private boolean isButtonSoundLoaded = false;


    public SoundManager(Context context) {
        // Ініціалізація MediaPlayer для фонового звуку
        backgroundPlayer = MediaPlayer.create(context, R.raw.background_sound);
        backgroundPlayer.setLooping(true); // Повторне відтворення


        AudioAttributes audioAttributes = new AudioAttributes.Builder()
                .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                .setUsage(AudioAttributes.USAGE_GAME)
                .build();

        soundPool = new SoundPool.Builder()
                .setMaxStreams(1)
                .setAudioAttributes(audioAttributes)
                .build();

        // Завантаження звуку кнопки
        buttonSoundId = soundPool.load(context, R.raw.click_sound, 1);
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                if (status == 0) {
                    isButtonSoundLoaded = true;
                }
            }
        });

    }



    // Метод для відтворення фонового звуку
    public void playBackgroundMusic() {
        if (!isBackgroundPlaying) {
            backgroundPlayer.start();
            isBackgroundPlaying = true;
        }
    }

    // Метод для зупинки фонового звуку
    public void stopBackgroundMusic() {
        if (isBackgroundPlaying) {
            backgroundPlayer.pause();
            isBackgroundPlaying = false;
        }
    }

    // Метод для відтворення звуку кнопки
    public void playButtonSound() {
        if (isButtonSoundLoaded) {
            soundPool.play(buttonSoundId, 1, 1, 0, 0, 1);
        }
    }

    // Метод для вивільнення ресурсів
    public void release() {
        if (backgroundPlayer != null) {
            backgroundPlayer.release();
            backgroundPlayer = null;
        }
        if (soundPool != null) {
            soundPool.release();
            soundPool = null;
        }
    }
}

