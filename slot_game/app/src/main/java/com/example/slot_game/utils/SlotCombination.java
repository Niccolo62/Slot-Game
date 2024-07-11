package com.example.slot_game.utils;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.widget.ImageView;

import com.example.slot_game.R;

import java.util.ArrayList;

public class SlotCombination {

    private ArrayList<Slot> slotArray;
    private Context context;

    public SlotCombination(ArrayList<Slot> slotArray, Context context) {
        this.slotArray = slotArray;
        this.context = context;
    }

    public int win_money(int bet) {
        int multiplier = 0;

        if ((int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(48).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(49).getImageView().getTag()) {
            multiplier++; //vertical line
            slotArray.get(47).getImageView().setTag(1);
            slotArray.get(48).getImageView().setTag(1);
            slotArray.get(49).getImageView().setTag(1);
        }
        if ((int) slotArray.get(97).getImageView().getTag() == (int) slotArray.get(98).getImageView().getTag() &&
                (int) slotArray.get(97).getImageView().getTag() == (int) slotArray.get(99).getImageView().getTag()) {
            multiplier++; //vertical line
            slotArray.get(97).getImageView().setTag(1);
            slotArray.get(98).getImageView().setTag(1);
            slotArray.get(99).getImageView().setTag(1);
        }
        if ((int) slotArray.get(147).getImageView().getTag() == (int) slotArray.get(148).getImageView().getTag() &&
                (int) slotArray.get(147).getImageView().getTag() == (int) slotArray.get(149).getImageView().getTag()) {
            multiplier++; //vertical line
            slotArray.get(147).getImageView().setTag(1);
            slotArray.get(148).getImageView().setTag(1);
            slotArray.get(149).getImageView().setTag(1);
        }
        if ((int) slotArray.get(197).getImageView().getTag() == (int) slotArray.get(198).getImageView().getTag() &&
                (int) slotArray.get(197).getImageView().getTag() == (int) slotArray.get(199).getImageView().getTag()) {
            multiplier++; //vertical line
            slotArray.get(197).getImageView().setTag(1);
            slotArray.get(198).getImageView().setTag(1);
            slotArray.get(199).getImageView().setTag(1);
        }
        if ((int) slotArray.get(247).getImageView().getTag() == (int) slotArray.get(248).getImageView().getTag() &&
                (int) slotArray.get(247).getImageView().getTag() == (int) slotArray.get(249).getImageView().getTag()) {
            multiplier++; //vertical line
            slotArray.get(247).getImageView().setTag(1);
            slotArray.get(248).getImageView().setTag(1);
            slotArray.get(249).getImageView().setTag(1);
        }

        if ((int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(97).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(147).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(197).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(247).getImageView().getTag()) {
            multiplier++; //horizonal line
            slotArray.get(47).getImageView().setTag(1);
            slotArray.get(97).getImageView().setTag(1);
            slotArray.get(147).getImageView().setTag(1);
            slotArray.get(197).getImageView().setTag(1);
            slotArray.get(247).getImageView().setTag(1);
        }

        if ((int) slotArray.get(48).getImageView().getTag() == (int) slotArray.get(98).getImageView().getTag() &&
                (int) slotArray.get(48).getImageView().getTag() == (int) slotArray.get(148).getImageView().getTag() &&
                (int) slotArray.get(48).getImageView().getTag() == (int) slotArray.get(198).getImageView().getTag() &&
                (int) slotArray.get(48).getImageView().getTag() == (int) slotArray.get(248).getImageView().getTag()) {
            multiplier++; //horizonal line
            slotArray.get(48).getImageView().setTag(1);
            slotArray.get(98).getImageView().setTag(1);
            slotArray.get(148).getImageView().setTag(1);
            slotArray.get(198).getImageView().setTag(1);
            slotArray.get(248).getImageView().setTag(1);
        }

        if ((int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(99).getImageView().getTag() &&
                (int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(149).getImageView().getTag() &&
                (int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(199).getImageView().getTag() &&
                (int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(249).getImageView().getTag()) {
            multiplier++; //horizonal line
            slotArray.get(49).getImageView().setTag(1);
            slotArray.get(99).getImageView().setTag(1);
            slotArray.get(149).getImageView().setTag(1);
            slotArray.get(199).getImageView().setTag(1);
            slotArray.get(249).getImageView().setTag(1);
        }

        if ((int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(97).getImageView().getTag() &&
                (int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(149).getImageView().getTag() &&
                (int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(197).getImageView().getTag() &&
                (int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(249).getImageView().getTag()) {
            multiplier++; //zig zag
            slotArray.get(49).getImageView().setTag(1);
            slotArray.get(97).getImageView().setTag(1);
            slotArray.get(149).getImageView().setTag(1);
            slotArray.get(197).getImageView().setTag(1);
            slotArray.get(249).getImageView().setTag(1);
        }

        if ((int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(99).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(147).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(199).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(247).getImageView().getTag()) {
            multiplier++; //zig zag
            slotArray.get(47).getImageView().setTag(1);
            slotArray.get(99).getImageView().setTag(1);
            slotArray.get(147).getImageView().setTag(1);
            slotArray.get(199).getImageView().setTag(1);
            slotArray.get(247).getImageView().setTag(1);
        }

        if ((int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(98).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(149).getImageView().getTag()) {
            multiplier++;
            slotArray.get(47).getImageView().setTag(1);
            slotArray.get(98).getImageView().setTag(1);
            slotArray.get(149).getImageView().setTag(1);

        }
        if ((int) slotArray.get(97).getImageView().getTag() == (int) slotArray.get(148).getImageView().getTag() &&
                (int) slotArray.get(97).getImageView().getTag() == (int) slotArray.get(199).getImageView().getTag()) {
            multiplier++;
            slotArray.get(97).getImageView().setTag(1);
            slotArray.get(148).getImageView().setTag(1);
            slotArray.get(199).getImageView().setTag(1);
        }
        if ((int) slotArray.get(147).getImageView().getTag() == (int) slotArray.get(198).getImageView().getTag() &&
                (int) slotArray.get(147).getImageView().getTag() == (int) slotArray.get(249).getImageView().getTag()) {
            multiplier++;
            slotArray.get(147).getImageView().setTag(1);
            slotArray.get(198).getImageView().setTag(1);
            slotArray.get(249).getImageView().setTag(1);
        }
        if ((int) slotArray.get(247).getImageView().getTag() == (int) slotArray.get(198).getImageView().getTag() &&
                (int) slotArray.get(247).getImageView().getTag() == (int) slotArray.get(149).getImageView().getTag()) {
            multiplier++;
            slotArray.get(247).getImageView().setTag(1);
            slotArray.get(198).getImageView().setTag(1);
            slotArray.get(149).getImageView().setTag(1);
        }
        if ((int) slotArray.get(197).getImageView().getTag() == (int) slotArray.get(148).getImageView().getTag() &&
                (int) slotArray.get(197).getImageView().getTag() == (int) slotArray.get(99).getImageView().getTag()) {
            multiplier++;
            slotArray.get(197).getImageView().setTag(1);
            slotArray.get(148).getImageView().setTag(1);
            slotArray.get(99).getImageView().setTag(1);
        }
        if ((int) slotArray.get(147).getImageView().getTag() == (int) slotArray.get(98).getImageView().getTag() &&
                (int) slotArray.get(147).getImageView().getTag() == (int) slotArray.get(49).getImageView().getTag()) {
            multiplier++;
            slotArray.get(147).getImageView().setTag(1);
            slotArray.get(98).getImageView().setTag(1);
            slotArray.get(49).getImageView().setTag(1);
        }
        if ((int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(97).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(147).getImageView().getTag()) {
            multiplier++;
            slotArray.get(47).getImageView().setTag(1);
            slotArray.get(97).getImageView().setTag(1);
            slotArray.get(147).getImageView().setTag(1);
        }

        if ((int) slotArray.get(48).getImageView().getTag() == (int) slotArray.get(98).getImageView().getTag() &&
                (int) slotArray.get(48).getImageView().getTag() == (int) slotArray.get(148).getImageView().getTag()) {
            multiplier++;
            slotArray.get(48).getImageView().setTag(1);
            slotArray.get(98).getImageView().setTag(1);
            slotArray.get(148).getImageView().setTag(1);
        }
        if ((int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(99).getImageView().getTag() &&
                (int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(149).getImageView().getTag()) {
            multiplier++;
            slotArray.get(49).getImageView().setTag(1);
            slotArray.get(99).getImageView().setTag(1);
            slotArray.get(149).getImageView().setTag(1);
        }
        if ((int) slotArray.get(97).getImageView().getTag() == (int) slotArray.get(147).getImageView().getTag() &&
                (int) slotArray.get(97).getImageView().getTag() == (int) slotArray.get(197).getImageView().getTag()) {
            multiplier++;
            slotArray.get(97).getImageView().setTag(1);
            slotArray.get(147).getImageView().setTag(1);
            slotArray.get(197).getImageView().setTag(1);
        }
        if ((int) slotArray.get(147).getImageView().getTag() == (int) slotArray.get(197).getImageView().getTag() &&
                (int) slotArray.get(147).getImageView().getTag() == (int) slotArray.get(247).getImageView().getTag()) {
            multiplier++;
            slotArray.get(147).getImageView().setTag(1);
            slotArray.get(197).getImageView().setTag(1);
            slotArray.get(247).getImageView().setTag(1);
        }

        if ((int) slotArray.get(98).getImageView().getTag() == (int) slotArray.get(148).getImageView().getTag() &&
                (int) slotArray.get(98).getImageView().getTag() == (int) slotArray.get(198).getImageView().getTag()) {
            multiplier++;
            slotArray.get(98).getImageView().setTag(1);
            slotArray.get(148).getImageView().setTag(1);
            slotArray.get(198).getImageView().setTag(1);
        }
        if ((int) slotArray.get(148).getImageView().getTag() == (int) slotArray.get(198).getImageView().getTag() &&
                (int) slotArray.get(148).getImageView().getTag() == (int) slotArray.get(248).getImageView().getTag()) {
            multiplier++;
            slotArray.get(148).getImageView().setTag(1);
            slotArray.get(198).getImageView().setTag(1);
            slotArray.get(248).getImageView().setTag(1);
        }
        if ((int) slotArray.get(98).getImageView().getTag() == (int) slotArray.get(148).getImageView().getTag() &&
                (int) slotArray.get(98).getImageView().getTag() == (int) slotArray.get(198).getImageView().getTag()) {
            multiplier++;
            slotArray.get(98).getImageView().setTag(1);
            slotArray.get(148).getImageView().setTag(1);
            slotArray.get(198).getImageView().setTag(1);
        }
        if ((int) slotArray.get(149).getImageView().getTag() == (int) slotArray.get(199).getImageView().getTag() &&
                (int) slotArray.get(149).getImageView().getTag() == (int) slotArray.get(249).getImageView().getTag()) {
            multiplier++;
            slotArray.get(149).getImageView().setTag(1);
            slotArray.get(199).getImageView().setTag(1);
            slotArray.get(249).getImageView().setTag(1);
        }

        if ((int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(97).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(147).getImageView().getTag() &&
                (int) slotArray.get(47).getImageView().getTag() == (int) slotArray.get(197).getImageView().getTag()) {
            multiplier++;
            slotArray.get(47).getImageView().setTag(1);
            slotArray.get(97).getImageView().setTag(1);
            slotArray.get(147).getImageView().setTag(1);
            slotArray.get(197).getImageView().setTag(1);
        }

        if ((int) slotArray.get(48).getImageView().getTag() == (int) slotArray.get(98).getImageView().getTag() &&
                (int) slotArray.get(48).getImageView().getTag() == (int) slotArray.get(148).getImageView().getTag() &&
                (int) slotArray.get(48).getImageView().getTag() == (int) slotArray.get(198).getImageView().getTag()) {
            multiplier++;
            slotArray.get(48).getImageView().setTag(1);
            slotArray.get(98).getImageView().setTag(1);
            slotArray.get(148).getImageView().setTag(1);
            slotArray.get(198).getImageView().setTag(1);
        }

        if ((int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(99).getImageView().getTag() &&
                (int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(149).getImageView().getTag() &&
                (int) slotArray.get(49).getImageView().getTag() == (int) slotArray.get(199).getImageView().getTag()) {
            multiplier++;
            slotArray.get(49).getImageView().setTag(1);
            slotArray.get(99).getImageView().setTag(1);
            slotArray.get(149).getImageView().setTag(1);
            slotArray.get(199).getImageView().setTag(1);
        }

        if ((int) slotArray.get(97).getImageView().getTag() == (int) slotArray.get(147).getImageView().getTag() &&
                (int) slotArray.get(97).getImageView().getTag() == (int) slotArray.get(197).getImageView().getTag() &&
                (int) slotArray.get(97).getImageView().getTag() == (int) slotArray.get(247).getImageView().getTag()) {
            multiplier++;
            slotArray.get(97).getImageView().setTag(1);
            slotArray.get(147).getImageView().setTag(1);
            slotArray.get(197).getImageView().setTag(1);
            slotArray.get(247).getImageView().setTag(1);
        }

        if ((int) slotArray.get(98).getImageView().getTag() == (int) slotArray.get(148).getImageView().getTag() &&
                (int) slotArray.get(98).getImageView().getTag() == (int) slotArray.get(198).getImageView().getTag() &&
                (int) slotArray.get(98).getImageView().getTag() == (int) slotArray.get(248).getImageView().getTag()) {
            multiplier++;
            slotArray.get(98).getImageView().setTag(1);
            slotArray.get(148).getImageView().setTag(1);
            slotArray.get(198).getImageView().setTag(1);
            slotArray.get(248).getImageView().setTag(1);
        }

        if ((int) slotArray.get(99).getImageView().getTag() == (int) slotArray.get(149).getImageView().getTag() &&
                (int) slotArray.get(99).getImageView().getTag() == (int) slotArray.get(199).getImageView().getTag() &&
                (int) slotArray.get(99).getImageView().getTag() == (int) slotArray.get(249).getImageView().getTag()) {
            multiplier++;
            slotArray.get(99).getImageView().setTag(1);
            slotArray.get(149).getImageView().setTag(1);
            slotArray.get(199).getImageView().setTag(1);
            slotArray.get(249).getImageView().setTag(1);
        }
        return bet * multiplier * 5;
    }
}
