package com.example.slot_game.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.slot_game.R;
import com.example.slot_game.utils.FullscreenModeUtil;
import com.example.slot_game.utils.GameData;

public class StatActivity extends AppCompatActivity {
    private TextView balance, best_win, spins_number, coins_lost, coins_win;
    private ImageView back;
    private GameData gameData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);
        FullscreenModeUtil.enableFullscreenMode(this);
        balance = findViewById(R.id.balance);
        best_win = findViewById(R.id.best_win);
        spins_number = findViewById(R.id.spins_number);
        coins_lost = findViewById(R.id.coins_lost);
        coins_win = findViewById(R.id.coins_win);
        back = findViewById(R.id.back);
        gameData = new GameData(this);

        balance.setText(getString(R.string.balance) + " " + gameData.getBalance());
        best_win.setText(getString(R.string.best_win) + " " + gameData.getBig_win());
        spins_number.setText(getString(R.string.spins_number) + " " + gameData.getCount_spin());
        coins_lost.setText(getString(R.string.total_number_of_coins_lost) + " " + gameData.getAll_lose_money());
        coins_win.setText(getString(R.string.total_number_of_coins_won) + " " + gameData.getAll_win_money());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void onResume() {
        FullscreenModeUtil.enableFullscreenMode(this);
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }
}