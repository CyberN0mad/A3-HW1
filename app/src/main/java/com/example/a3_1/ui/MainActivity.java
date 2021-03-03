package com.example.a3_1.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.a3_1.R;
import com.example.a3_1.ui.data.Card;


public class MainActivity extends AppCompatActivity implements EmojiAdapter.Listener {

    private static final String TAG = "main";
    private RecyclerView recyclerView;
    private EmojiAdapter adapter;
    private EmojiGame game;
    private TextView textOver;

    @RequiresApi(api = Build.VERSION_CODES.R)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOver = findViewById(R.id.textOver);
        recyclerView = findViewById(R.id.rv_card);
        game = new EmojiGame();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(getApplicationContext(),3);
        recyclerView.setLayoutManager(gridLayoutManager);
        adapter = new EmojiAdapter(game, this);
        recyclerView.setAdapter(adapter);
    }


    @Override
    public void cardClick(Card<String> card) {
        game.choose(card);
        Log.e(TAG, "cardClick: "+ card.getId());
        adapter.notifyDataSetChanged();

        if (game.getCards().isEmpty()){
            Animation fadeIn;
            fadeIn = AnimationUtils.loadAnimation(this,  R.anim.fade_in);

            textOver.setAnimation(fadeIn);
            textOver.setVisibility(View.VISIBLE);
            textOver.setText("The game is over");
        }
    }
}