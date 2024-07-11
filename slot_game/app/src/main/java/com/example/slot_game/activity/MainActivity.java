package com.example.slot_game.activity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.animation.LinearInterpolator;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.slot_game.utils.FullscreenModeUtil;
import com.example.slot_game.R;

public class MainActivity extends AppCompatActivity {
    private ObjectAnimator animator_loading;
    private ProgressBar progress_bar;
    private Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FullscreenModeUtil.enableFullscreenMode(this);
        setContentView(R.layout.activity_main);
        progress_bar = findViewById(R.id.progress_bar);
        intent = new Intent(this, GameActivity.class);
        start_animation_loading();
    }

    private void start_animation_loading() {
        animator_loading = ObjectAnimator.ofInt(progress_bar, "progress", 0, 100);
        animator_loading.setDuration(3500);
        animator_loading.setInterpolator(new LinearInterpolator());
        animator_loading.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                startActivity(intent);
                super.onAnimationEnd(animation);
            }
        });
        animator_loading.start();
    }

    private void resume_animation_loading() {
        if (animator_loading != null && animator_loading.isPaused()) {
            animator_loading.resume();
        }
    }

    private void pause_animation_loading() {
        if (animator_loading != null && animator_loading.isRunning()) {
            animator_loading.pause();
        }
    }

    @Override
    protected void onResume() {
        FullscreenModeUtil.enableFullscreenMode(this);
        resume_animation_loading();
        start_animation_loading();
        super.onResume();
    }

    @Override
    protected void onPause() {
        pause_animation_loading();
        super.onPause();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        return true;
    }
}