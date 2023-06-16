package game;

public class PokerGame {

    public static void main(String[] args) {
        Deck deck = new Deck();
        deck.shuffle();

        System.out.println("Shuffling ... Shuffling ... Shuffling ...");

        Hand hand = new Hand();
        hand.dealCards(deck, 5);

        System.out.print("Your hand: ");
        for (Card card : hand.getCards()) {
            System.out.print(card + " ");
        }
        System.out.println();

        System.out.println("Hand Strength: " + hand.getHandStrength().getDisplayName());
    }
}
