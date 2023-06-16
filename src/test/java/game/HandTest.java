package game;

import game.enumerated.HandStrength;
import game.enumerated.Rank;
import game.enumerated.Suit;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class HandTest {
    private Hand hand;

    @Before
    public void setUp() {
        hand = new Hand();
    }

    @Test
    public void testGetHandStrengthStraightFlush() {
        hand.getCards().add(new Card(Rank.ACE, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.KING, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.QUEEN, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.JACK, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.TEN, Suit.HEARTS));

        assertEquals(HandStrength.FLUSH, hand.getHandStrength());
    }

    @Test
    public void testGetHandStrengthFourOfAKind() {
        hand.getCards().add(new Card(Rank.ACE, Suit.SPADES));
        hand.getCards().add(new Card(Rank.ACE, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.ACE, Suit.DIAMONDS));
        hand.getCards().add(new Card(Rank.ACE, Suit.CLUBS));
        hand.getCards().add(new Card(Rank.KING, Suit.HEARTS));

        assertEquals(HandStrength.FOUR_OF_A_KIND, hand.getHandStrength());
    }

    @Test
    public void testGetHandStrengthFullHouse() {
        hand.getCards().add(new Card(Rank.ACE, Suit.SPADES));
        hand.getCards().add(new Card(Rank.ACE, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.KING, Suit.SPADES));
        hand.getCards().add(new Card(Rank.KING, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.KING, Suit.DIAMONDS));

        assertEquals(HandStrength.FULL_HOUSE, hand.getHandStrength());
    }

    @Test
    public void testGetHandStrengthFlush() {
        hand.getCards().add(new Card(Rank.ACE, Suit.SPADES));
        hand.getCards().add(new Card(Rank.KING, Suit.SPADES));
        hand.getCards().add(new Card(Rank.QUEEN, Suit.SPADES));
        hand.getCards().add(new Card(Rank.JACK, Suit.SPADES));
        hand.getCards().add(new Card(Rank.TEN, Suit.SPADES));

        assertEquals(HandStrength.FLUSH, hand.getHandStrength());
    }

    @Test
    public void testGetHandStrengthStraight() {
        hand.getCards().add(new Card(Rank.ACE, Suit.SPADES));
        hand.getCards().add(new Card(Rank.KING, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        hand.getCards().add(new Card(Rank.JACK, Suit.SPADES));
        hand.getCards().add(new Card(Rank.TEN, Suit.HEARTS));

        assertEquals(HandStrength.HIGH_CARDS, hand.getHandStrength());
    }

    @Test
    public void testGetHandStrengthThreeOfAKind() {
        hand.getCards().add(new Card(Rank.ACE, Suit.SPADES));
        hand.getCards().add(new Card(Rank.ACE, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.ACE, Suit.DIAMONDS));
        hand.getCards().add(new Card(Rank.KING, Suit.SPADES));
        hand.getCards().add(new Card(Rank.TEN, Suit.HEARTS));

        assertEquals(HandStrength.THREE_OF_A_KIND, hand.getHandStrength());
    }

    @Test
    public void testGetHandStrengthTwoPair() {
        hand.getCards().add(new Card(Rank.ACE, Suit.SPADES));
        hand.getCards().add(new Card(Rank.ACE, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.KING, Suit.SPADES));
        hand.getCards().add(new Card(Rank.KING, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.TEN, Suit.HEARTS));

        assertEquals(HandStrength.TWO_PAIR, hand.getHandStrength());
    }

    @Test
    public void testGetHandStrengthOnePair() {
        hand.getCards().add(new Card(Rank.ACE, Suit.SPADES));
        hand.getCards().add(new Card(Rank.ACE, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.KING, Suit.SPADES));
        hand.getCards().add(new Card(Rank.QUEEN, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.TEN, Suit.HEARTS));

        assertEquals(HandStrength.ONE_PAIR, hand.getHandStrength());
    }

    @Test
    public void testGetHandStrengthHighCards() {
        hand.getCards().add(new Card(Rank.ACE, Suit.SPADES));
        hand.getCards().add(new Card(Rank.KING, Suit.HEARTS));
        hand.getCards().add(new Card(Rank.QUEEN, Suit.DIAMONDS));
        hand.getCards().add(new Card(Rank.JACK, Suit.SPADES));
        hand.getCards().add(new Card(Rank.TEN, Suit.HEARTS));

        assertEquals(HandStrength.HIGH_CARDS, hand.getHandStrength());
    }



}

