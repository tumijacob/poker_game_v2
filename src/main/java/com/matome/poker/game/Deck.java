package com.matome.poker.game;

import com.matome.poker.game.enumerated.Rank;
import com.matome.poker.game.enumerated.Suit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Deck {
    private List<Card> cards;
    private Random random;

    public Deck() {
        cards = new ArrayList<>();
        random = new Random();

        for (Suit suit : Suit.values()) {
            for (Rank rank : Rank.values()) {
                cards.add(new Card(rank, suit));
            }
        }
    }

    public void shuffle() {
        int n = cards.size();
        for (int i = n - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            swapCards(i, j);
        }
    }

    private void swapCards(int i, int j) {
        Card temp = cards.get(i);
        cards.set(i, cards.get(j));
        cards.set(j, temp);
    }

    public Card drawCard() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("The Deck is empty");
        }
        return cards.remove(0);
    }

    public int getSize() {
        return cards.size();
    }

    public List<Card> getCards () {
        return cards;
    }
}
