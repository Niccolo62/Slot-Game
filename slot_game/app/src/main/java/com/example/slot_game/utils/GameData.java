package com.example.slot_game.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class GameData {
    private static final String PREF_NAME = "slot_game_data";
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private int balance;
    private int big_win;
    private int count_spin;
    private int all_lose_money;
    private int all_win_money;
    private boolean isSound;

    public boolean isSound() {
        return isSound;
    }

    public void setSound(boolean sound) {
        isSound = sound;
        saveData();
    }

    public int getAll_win_money() {
        return all_win_money;
    }

    public void setAll_win_money(int all_win_money) {
        this.all_win_money = all_win_money;
        saveData();

    }

    public int getAll_lose_money() {
        return all_lose_money;
    }

    public void setAll_lose_money(int all_lose_money) {
        this.all_lose_money = all_lose_money;
        saveData();
    }

    public int getCount_spin() {
        return count_spin;
    }

    public void setCount_spin(int count_spin) {
        this.count_spin = count_spin;
        saveData();
    }

    public int getBig_win() {
        return big_win;
    }

    public void setBig_win(int big_win) {
        this.big_win = big_win;
        saveData();
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
        saveData();
    }


    public GameData(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        loadData();
    }

    private void saveData() {
        editor.putInt("balance", balance);
        editor.putInt("big_win", big_win);
        editor.putInt("count_spin", count_spin);
        editor.putInt("all_lose_money", all_lose_money);
        editor.putInt("all_win_money", all_win_money);
        editor.putBoolean("isSound", isSound);
        editor.apply();
    }

    private void loadData() {
        balance = sharedPreferences.getInt("balance", 10000);
        big_win = sharedPreferences.getInt("big_win", 0);
        count_spin = sharedPreferences.getInt("count_spin", 0);
        all_lose_money = sharedPreferences.getInt("all_lose_money", 0);
        all_win_money = sharedPreferences.getInt("all_win_money", 0);
        isSound = sharedPreferences.getBoolean("isSound", true);
    }
}
