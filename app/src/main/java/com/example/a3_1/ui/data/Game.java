package com.example.a3_1.ui.data;

import android.os.CountDownTimer;
import android.os.Handler;
import android.util.Log;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Game<Content> {
    private List<Card<Content>> cards = new ArrayList<>();

    public Game(List<Content> contents) {
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>(false, false, contents.get(i), i + 1 - 1));
            cards.add(new Card<>(false, false, contents.get(i), i * 2 + 1));
        }
        Collections.shuffle(cards);
    }

    public void choose(Card<Content> card) {

        card.setFacedUp(!card.isFacedUp());
        if (card.isFacedUp()) {
            findPairs(card);
        }

    }

    private void findPairs(Card<Content> card) {
        for (Card<Content> searchCard : cards) {
            Log.e("TAG", "for each is running: ");

            if (
                    searchCard.isFacedUp()
                            && searchCard.getId() != card.getId()
                            && searchCard.equals(card)) {

                card.setMatched(true);
                searchCard.setMatched(true);

                removeCard();
                Log.e("TAG", "MATCH!");
                return;

            } else if (

                    searchCard.isFacedUp()
                            && searchCard.getId() != card.getId()
                            && searchCard.getContent() != card.getContent()) {

                android.os.Handler handler = new Handler();
                handler.postDelayed(() -> {

                    card.setFacedUp(false);
                    searchCard.setFacedUp(false);
                    Log.e("TAG", "we are in else if");

                }, 300);
            }
        }
    }
    private void removeCard() {
        Log.e("TAG", "removeCard: method is working  ");

        List<Card<Content>> resultCards = new ArrayList<>(cards);
        for (Card<Content> c : cards) {
            if (c.isMatched()) {
                resultCards.remove(c);
            }
        }
        cards.clear();
        cards.addAll(resultCards);
    }

    public List<Card<Content>> getCard() {
        return cards;
    }
}
