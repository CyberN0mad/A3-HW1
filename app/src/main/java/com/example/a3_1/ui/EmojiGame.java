package com.example.a3_1.ui;

import android.os.Build;
import android.widget.ImageView;

import androidx.annotation.RequiresApi;


import com.example.a3_1.ui.data.Card;
import com.example.a3_1.ui.data.Game;

import java.util.List;

public class EmojiGame {

    private final Game<String> game;

    @RequiresApi(api = Build.VERSION_CODES.R)

    public EmojiGame() {
        List<String> content = List.of("👽", "❤", "🎃", "👹", "😎");
        game = new Game<>(content);
    }

    public void choose(Card<String> card){
        game.choose(card);
    }

    public List<Card<String>> getCards(){
        return game.getCard();
    }


}
