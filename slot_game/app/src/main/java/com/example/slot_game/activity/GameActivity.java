package com.example.slot_game.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.media.AudioManager;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.slot_game.utils.FullscreenModeUtil;
import com.example.slot_game.utils.GameData;
import com.example.slot_game.R;
import com.example.slot_game.utils.Slot;
import com.example.slot_game.utils.SlotCombination;
import com.example.slot_game.utils.SoundManager;

import java.util.ArrayList;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener {
    private LinearLayout l1, l2, l3, l4, l5;
    private ImageView info, minus, plus, spin, sound;
    private TextView bet, balance;
    private Intent intent;
    private GameData gameData;
    private int bet_count = 0, win_count = 0;
    private Random random = new Random();
    private int array[] = {R.drawable.s1, R.drawable.s2, R.drawable.s3,
            R.drawable.s4, R.drawable.s5, R.drawable.s6, R.drawable.s7};

    private AudioManager audioManager;
    private ArrayList<Slot> slotArray = new ArrayList<>();
    private ObjectAnimator an_l1, an_l2, an_l3, an_l4, an_l5;
    private SoundManager soundManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullscreenModeUtil.enableFullscreenMode(this);
        setContentView(R.layout.activity_game);
        init();
        loading();
    }

    private void init() {
        l1 = findViewById(R.id.l1);
        l2 = findViewById(R.id.l2);
        l3 = findViewById(R.id.l3);
        l4 = findViewById(R.id.l4);
        l5 = findViewById(R.id.l5);
        info = findViewById(R.id.info);
        minus = findViewById(R.id.minus);
        plus = findViewById(R.id.plus);
        spin = findViewById(R.id.spin);
        bet = findViewById(R.id.bet);
        balance = findViewById(R.id.balance);
        sound = findViewById(R.id.sound);
        intent = new Intent(this, StatActivity.class);
        gameData = new GameData(this);
        bet_count = 10;
        bet.setText("BET\n" + bet_count + "");
        balance.setText("BALANCE\n" + gameData.getBalance() + "");
        info.setOnClickListener(this);
        spin.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);
        sound.setOnClickListener(this);
        audioManager = (AudioManager) getSystemService(Context.AUDIO_SERVICE);
        setVolumeControlStream(AudioManager.STREAM_MUSIC);
        soundManager = new SoundManager(this);
        if (gameData.isSound()) {
            soundManager.playBackgroundMusic();
        }

        set_sound_status();
    }

    private void loading() {
        l1.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                l1.getViewTreeObserver().removeOnGlobalLayoutListener(this);
                create_slots(l1);
                create_slots(l2);
                create_slots(l3);
                create_slots(l4);
                create_slots(l5);
            }
        });
    }

    private void create_slots(LinearLayout layout) {

        for (int i = 0; i < 50; i++) {
            Slot slot = new Slot(this, array, random);
            slot.setLayoutParams(layout.getWidth(), layout.getHeight());

            ImageView img = slot.getImageView();
            img.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    for (int i = 0; i < slotArray.size(); i++) {
                        if (slotArray.get(i).getImageView() == img) {
                            Toast.makeText(GameActivity.this, i + "", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
            slotArray.add(slot);
            layout.addView(img);
        }
    }

    private void re_image_slots() {
        for (int i = 0; i < slotArray.size(); i++) {
            if (i >= 47 && i < 50) {
                slotArray.get(i).reimageSlot();
            } else if (i >= 97 && i < 100) {
                slotArray.get(i).reimageSlot();
            } else if (i >= 147 && i < 150) {
                slotArray.get(i).reimageSlot();
            } else if (i >= 197 && i < 200) {
                slotArray.get(i).reimageSlot();
            } else if (i >= 247 && i < 250) {
                slotArray.get(i).reimageSlot();
            }
        }

    }

    private void start_animation() {

        re_image_slots();
        spin.setEnabled(false);
        gameData.setCount_spin(gameData.getCount_spin() + 1);
        an_l1 = ObjectAnimator.ofInt(l1, "scrollY", 0, (l1.getHeight() / 3) * 47);
        an_l1.setInterpolator(new AccelerateDecelerateInterpolator());
        an_l1.setDuration(2000);
        an_l1.start();

        an_l2 = ObjectAnimator.ofInt(l2, "scrollY", 0, (l2.getHeight() / 3) * 47);
        an_l2.setInterpolator(new AccelerateDecelerateInterpolator());
        an_l2.setDuration(2200);
        an_l2.start();

        an_l3 = ObjectAnimator.ofInt(l3, "scrollY", 0, (l3.getHeight() / 3) * 47);
        an_l3.setInterpolator(new AccelerateDecelerateInterpolator());
        an_l3.setDuration(2400);
        an_l3.start();

        an_l4 = ObjectAnimator.ofInt(l4, "scrollY", 0, (l4.getHeight() / 3) * 47);
        an_l4.setInterpolator(new AccelerateDecelerateInterpolator());
        an_l4.setDuration(2600);
        an_l4.start();

        an_l5 = ObjectAnimator.ofInt(l5, "scrollY", 0, (l5.getHeight() / 3) * 47);
        an_l5.setInterpolator(new AccelerateDecelerateInterpolator());
        an_l5.setDuration(2800);
        an_l5.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                spin.setEnabled(true);
                win_count = 0;
                SlotCombination slotCombination = new SlotCombination(slotArray, GameActivity.this);
                win_count = slotCombination.win_money(bet_count);
                //Log.d("TAG", "onAnimationEnd: " + win_count);
                for (Slot slot : slotArray) {
                    if ((int) slot.getImageView().getTag() == 1) {
                        slot.getImageView().setImageResource(R.drawable.green);
                    }

                }
                if (win_count != 0) {
                    gameData.setAll_win_money(gameData.getAll_win_money() + win_count);
                    if (win_count > gameData.getBig_win()) {
                        gameData.setBig_win(win_count);
                    }
                } else {
                    gameData.setAll_lose_money(gameData.getAll_lose_money() + bet_count);
                    gameData.setBalance(gameData.getBalance() - bet_count);
                }
                gameData.setBalance(gameData.getBalance() + win_count);
                balance.setText("BALANCE\n" + gameData.getBalance() + "");
                super.onAnimationEnd(animation);
            }
        });
        an_l5.start();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.spin:
                if (gameData.isSound()) {
                    soundManager.playButtonSound();
                }
                if (gameData.getBalance() <= 0) {
                    gameData.setBalance(10000);
                    balance.setText("BALANCE\n" + gameData.getBalance() + "");
                }
                start_animation();
                break;
            case R.id.plus:
                if (gameData.isSound()) {
                    soundManager.playButtonSound();
                }
                bet_count += 10;
                if (bet_count > 100) {
                    bet_count = 10;
                }
                bet.setText("BET\n" + bet_count + "");
                break;
            case R.id.minus:
                if (gameData.isSound()) {
                    soundManager.playButtonSound();
                }
                bet_count -= 10;
                if (bet_count <= 0) {
                    bet_count = 100;
                }
                bet.setText("BET\n" + bet_count + "");
                break;
            case R.id.info:
                if (gameData.isSound()) {
                    soundManager.playButtonSound();
                }
                startActivity(intent);
                break;
            case R.id.sound:
                if (gameData.isSound()) {
                    gameData.setSound(false);
                    sound.setImageResource(R.drawable.sound_off);
                    soundManager.stopBackgroundMusic();
                } else {
                    gameData.setSound(true);
                    sound.setImageResource(R.drawable.sound_on);
                    soundManager.playBackgroundMusic();
                }
                break;
        }
    }

    private void set_sound_status() {
        if (!gameData.isSound()) {
            sound.setImageResource(R.drawable.sound_off);
        } else {
            sound.setImageResource(R.drawable.sound_on);
        }
    }


    @Override
    protected void onPause() {
        if (an_l1 != null && an_l1.isRunning()) {
            an_l1.pause();
        }

        if (an_l2 != null && an_l2.isRunning()) {
            an_l2.pause();
        }

        if (an_l3 != null && an_l3.isRunning()) {
            an_l3.pause();
        }

        if (an_l4 != null && an_l4.isRunning()) {
            an_l4.pause();
        }

        if (an_l5 != null && an_l5.isRunning()) {
            an_l5.pause();
        }
        soundManager.stopBackgroundMusic();
        super.onPause();
    }

    @Override
    protected void onResume() {
        if (an_l1 != null && an_l1.isPaused()) {
            an_l1.resume();
        }

        if (an_l2 != null && an_l2.isPaused()) {
            an_l2.resume();
        }

        if (an_l3 != null && an_l3.isPaused()) {
            an_l3.resume();
        }

        if (an_l4 != null && an_l4.isPaused()) {
            an_l4.resume();
        }

        if (an_l5 != null && an_l5.isPaused()) {
            an_l5.resume();
        }
        if (gameData.isSound()) {
            soundManager.playBackgroundMusic();
        }

        FullscreenModeUtil.enableFullscreenMode(this);
        super.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        soundManager.release();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        switch (keyCode) {
            case KeyEvent.KEYCODE_VOLUME_UP:

                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_RAISE, AudioManager.FLAG_SHOW_UI);
                return true;
            case KeyEvent.KEYCODE_VOLUME_DOWN:

                audioManager.adjustStreamVolume(AudioManager.STREAM_MUSIC,
                        AudioManager.ADJUST_LOWER, AudioManager.FLAG_SHOW_UI);
                return true;
            default:
                return true;
        }
    }
}

