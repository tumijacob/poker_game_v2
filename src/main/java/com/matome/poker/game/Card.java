package com.matome.poker.game;


import com.matome.poker.game.enumerated.Rank;
import com.matome.poker.game.enumerated.Suit;

public class Card {
    private Rank rank;
    private Suit suit;

    public Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public Rank getRank() {
        return rank;
    }

    public Suit getSuit() {
        return suit;
    }

    @Override
    public String toString() {
        return rank + suit.getSymbol();
    }
}
