package com.example.a3_1.ui;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a3_1.R;
import com.example.a3_1.ui.data.Card;


public class EmojiAdapter extends RecyclerView.Adapter<EmojiAdapter.EmojiHolder> {

    private EmojiGame game;
    private Listener listener;

    public EmojiAdapter(EmojiGame game,
                        Listener listener) {
        this.game = game;
        this.listener = listener;
    }

    @NonNull
    @Override
    public EmojiHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_card, parent, false);
        return new EmojiHolder(view, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull EmojiHolder holder, int position) {
        holder.bind(game.getCards().get(position));
    }

    @Override
    public int getItemCount() {
        return game.getCards().size();
    }


    //ViewHolder
    class EmojiHolder extends RecyclerView.ViewHolder {

        private Listener listener;
        private TextView tvCard;
        private Animation fadeIn;


        public EmojiHolder(@NonNull View itemView,
                           Listener listener) {
            super(itemView);
            this.listener = listener;
            tvCard = itemView.findViewById(R.id.tv_card);
        }

        public void bind(Card<String> card) {
            itemView.setOnClickListener(v -> {
                listener.cardClick(card);
                notifyDataSetChanged();
            });

            if (card.isFacedUp()) {

                tvCard.setBackgroundColor(Color.WHITE);
                tvCard.setText(card.getContent());

            } else {

                tvCard.setBackgroundColor(Color.BLUE);
                tvCard.setText("");

            }
        }


    }

    interface Listener {
        void cardClick(Card<String> card);
    }
}

