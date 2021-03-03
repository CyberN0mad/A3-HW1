package com.example.a3_1.ui.data;

import java.util.Objects;

public class Card<CardContent> {

    private boolean isFacedUp;
    private boolean isMatched;
    private CardContent content;
    private int id;

    public Card(CardContent content) {
        this.content = content;
    }

    public Card(boolean isFacedUp,
                boolean isMatched,
                CardContent content,
                int id) {
        this.isFacedUp = isFacedUp;
        this.isMatched = isMatched;
        this.content = content;
        this.id = id;
    }


    public boolean isFacedUp() {
        return isFacedUp;
    }

    public void setFacedUp(boolean facedUp) {
        isFacedUp = facedUp;
    }

    public boolean isMatched() {
        return isMatched;
    }

    public void setMatched(boolean matched) {
        isMatched = matched;
    }

    public CardContent getContent() {
        return content;
    }

    public void setContent(CardContent content) {
        this.content = content;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card<?> card = (Card<?>) o;
        return Objects.equals(content, card.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isFacedUp, isMatched, content, id);
    }

    @Override
    public String toString() {
        return "Card{" +
                "isFacedUp=" + isFacedUp +
                ", isMatched=" + isMatched +
                ", content=" + content +
                ", id=" + id +
                '}';
    }
}
