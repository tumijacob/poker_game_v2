package game;

import org.junit.Before;
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.*;
import static org.junit.Assert.assertNotEquals;
//import static org.junit.Assert.assertThrows;

public class DeckTest {
    private Deck deck;

    @Before
    public void setUp() {
        deck = new Deck();
    }

    @Test
    public void getSize() {
        assertEquals(52, deck.getSize());
    }

    @Test
    public void shuffle() {
        // Save the initial order of cards
        List<Card> initialOrder = new ArrayList<>(deck.getCards());

        // Shuffle the deck
        deck.shuffle();

        // Assert that the deck size hasn't changed
        assertEquals(52, deck.getSize());

        // Assert that the shuffled deck is not in the same order as the initial order
        assertNotEquals(initialOrder, deck.getCards());
    }

/*    @Test
    public void drawCard() {
        // Draw 52 cards from the deck
        Set<Card> drawnCards = new HashSet<>();
        for (int i = 0; i < 52; i++) {
            Card card = deck.drawCard();
            assertNotNull(card);
            assertFalse(drawnCards.contains(card));
            drawnCards.add(card);
        }

        // Attempt to draw another card when the deck is empty
        assertThrows(IllegalStateException.class, deck::drawCard);
    }*/

    @Test
    public void testShuffle() {
        // Create a new deck with ordered cards
        Deck orderedDeck = new Deck();

        // Shuffle the deck
        deck.shuffle();

        // Ensure that the shuffled deck is not the same as the ordered deck
        assertNotEquals(orderedDeck, deck);
    }
    @Test
    public void testShuffleDoesNotChangeDeckSize() {
        int initialSize = deck.getSize();

        deck.shuffle();

        assertEquals(initialSize, deck.getSize());
    }

    @Test(expected = IllegalStateException.class)
    public void testDrawCardFromEmptyDeck() {
        while (deck.getSize() > 0) {
            deck.drawCard();
        }

        deck.drawCard(); // This should throw IllegalStateException
    }

    @Test
    public void testDrawCard() {
        int initialSize = deck.getSize();

        Card card = deck.drawCard();

        assertNotNull(card);
        assertEquals(initialSize - 1, deck.getSize());
    }

    @Test
    public void testNewDeckOrder() {
        // Create a new deck
        Deck newDeck = new Deck();

        // Draw the same number of cards from both decks and compare their order
        int numCardsToDraw = 10;

        for (int i = 0; i < numCardsToDraw; i++) {
            Card cardFromNewDeck = newDeck.drawCard();
            Card cardFromShuffledDeck = deck.drawCard();

            assertEquals(cardFromNewDeck.getRank(), cardFromShuffledDeck.getRank());
            assertEquals(cardFromNewDeck.getSuit(), cardFromShuffledDeck.getSuit());
        }
    }

    @Test
    public void testMultipleShuffles() {
        Deck deckCopy = new Deck();

        // Shuffle the deck multiple times
        deck.shuffle();
        deck.shuffle();

        // Ensure that the shuffled deck is not the same as the initial deck or the copied deck
        assertNotEquals(deckCopy, deck);
        assertNotEquals(deckCopy, deck);
    }

    @Test
    public void testDrawAllCardsFromDeck() {
        int deckSize = deck.getSize();

        // Draw all cards from the deck
        for (int i = 0; i < deckSize; i++) {
            Card card = deck.drawCard();
            assertNotNull(card);
        }

        // The deck should be empty
        assertEquals(0, deck.getSize());
    }
}
