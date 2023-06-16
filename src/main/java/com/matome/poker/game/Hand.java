package com.matome.poker.game;

import com.matome.poker.game.enumerated.HandStrength;
import com.matome.poker.game.enumerated.Rank;
import com.matome.poker.game.enumerated.Suit;
import com.matome.poker.game.exception.InsufficientCardsException;

import java.util.*;

public class Hand {
    private List<Card> cards;

    public Hand() {
        this.cards = new ArrayList<>();
    }

    public void dealCards(Deck deck, int numOfCards) {
        try {
            if (deck == null) {
                throw new IllegalArgumentException("Invalid deck provided");
            }

            if (numOfCards <= 0) {
                throw new IllegalArgumentException("Invalid number of cards: " + numOfCards);
            }

            if (deck.getSize() < numOfCards) {
                throw new InsufficientCardsException("Not enough cards in the deck to deal");
            }

            for (int i = 0; i < numOfCards; i++) {
                Card card = deck.drawCard();
                cards.add(card);
            }
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (InsufficientCardsException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }



    public List<Card> getCards() {
        return cards;
    }

    public HandStrength getHandStrength() {
        // Check for specific hand combinations in decreasing order of rank

        if (hasStraightFlush()) {
            return HandStrength.STRAIGHT_FLUSH;
        }
        if (hasFourOfAKind()) {
            return HandStrength.FOUR_OF_A_KIND;
        }
        if (hasFullHouse()) {
            return HandStrength.FULL_HOUSE;
        }
        if (hasFlush()) {
            return HandStrength.FLUSH;
        }
        if (hasStraight()) {
            return HandStrength.STRAIGHT;
        }
        if (hasThreeOfAKind()) {
            return HandStrength.THREE_OF_A_KIND;
        }
        if (hasTwoPair()) {
            return HandStrength.TWO_PAIR;
        }
        if (hasOnePair()) {
            return HandStrength.ONE_PAIR;
        }

        // If none of the specific combinations match, it is a high card hand
        return HandStrength.HIGH_CARDS;
    }


    private boolean hasStraightFlush() {
        // Check if all cards have the same suit
        Suit firstSuit = cards.get(0).getSuit();

        for (Card card : cards) {
            if (card.getSuit() != firstSuit) {
                return false;
            }
        }
        // Sort the cards in ascending order of rank
        Collections.sort(cards, Comparator.comparingInt(c -> c.getRank().ordinal()));

        // Check if the ranks form a consecutive sequence
        for (int i = 1; i < cards.size(); i++) {
            Rank currentRank = cards.get(i).getRank();
            Rank previousRank = cards.get(i - 1).getRank();

            if (currentRank.ordinal() != previousRank.ordinal() + 1) {
                return false;
            }
        }
        return true;
    }

    private boolean hasFourOfAKind() {
        Map<Rank, Integer> rankCountMap = new HashMap<>();

        for (Card card : cards) {
            Rank rank = card.getRank();
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }

        for (int count : rankCountMap.values()) {
            if (count == 4) {
                return true;
            }
        }

        return false;
    }

    private boolean hasFullHouse() {
        Map<Rank, Integer> rankCountMap = new HashMap<>();

        for (Card card : cards) {
            Rank rank = card.getRank();
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }

        boolean hasThreeOfAKind = false;
        boolean hasPair = false;

        for (int count : rankCountMap.values()) {
            if (count == 3) {
                hasThreeOfAKind = true;
            } else if (count == 2) {
                hasPair = true;
            }
        }

        return hasThreeOfAKind && hasPair;
    }

    private boolean hasFlush() {
        Suit firstSuit = cards.get(0).getSuit();

        for (Card card : cards) {
            if (card.getSuit() != firstSuit) {
                return false;
            }
        }
        return true;
    }

    private boolean hasStraight() {
        List<Rank> ranks = new ArrayList<>();
        for (Card card : cards) {
            ranks.add(card.getRank());
        }
        Collections.sort(ranks);
        for (int i = 1; i < ranks.size(); i++) {
            if (ranks.get(i) != ranks.get(i - 1)) {
                return false;
            }
        }
        return true;
    }

    private boolean hasThreeOfAKind() {
        Map<Rank, Integer> rankCountMap = new HashMap<>();

        for (Card card : cards) {
            Rank rank = card.getRank();
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }

        for (int count : rankCountMap.values()) {
            if (count == 3) {
                return true;
            }
        }

        return false;
    }

    private boolean hasTwoPair() {
        Map<Rank, Integer> rankCountMap = new HashMap<>();

        for (Card card : cards) {
            Rank rank = card.getRank();
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }

        int pairCount = 0;

        for (int count : rankCountMap.values()) {
            if (count == 2) {
                pairCount++;
            }
        }

        return pairCount >= 2;
    }

    private boolean hasOnePair() {
        Map<Rank, Integer> rankCountMap = new HashMap<>();

        for (Card card : cards) {
            Rank rank = card.getRank();
            rankCountMap.put(rank, rankCountMap.getOrDefault(rank, 0) + 1);
        }

        for (int count : rankCountMap.values()) {
            if (count == 2) {
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString() {
        return "Hand{" +
                "cards=" + cards +
                '}';
    }
}
