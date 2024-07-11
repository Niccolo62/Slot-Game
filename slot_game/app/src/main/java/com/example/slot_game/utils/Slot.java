package com.example.slot_game.utils;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import java.util.Random;

public class Slot {
    private ImageView imageView;
    private Context context;
    private int[] drawableArray;
    private Random random;

    public Slot(Context context, int[] drawableArray, Random random) {
        this.context = context;
        this.drawableArray = drawableArray;
        this.random = random;
        this.imageView = new ImageView(context);
        setupSlot();
    }

    private void setupSlot() {
        int drawableResource = drawableArray[random.nextInt(drawableArray.length)];
        imageView.setBackgroundResource(drawableResource);
        imageView.setTag(drawableResource);
    }

    public void setLayoutParams(int width, int height) {
        imageView.setLayoutParams(new LinearLayout.LayoutParams(width, height / 3));
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void reimageSlot() {
        int drawableResource = drawableArray[random.nextInt(drawableArray.length)];
        imageView.setImageResource(0);
        imageView.setBackgroundResource(drawableResource);
        imageView.setTag(drawableResource);
        imageView.clearColorFilter();
    }
}
