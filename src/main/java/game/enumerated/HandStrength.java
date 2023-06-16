package game.enumerated;

public enum HandStrength {
    STRAIGHT_FLUSH("Straight Flush"),
    FOUR_OF_A_KIND("Four of a Kind"),
    FULL_HOUSE("Full House"),
    FLUSH("Flush"),
    STRAIGHT("Straight"),
    THREE_OF_A_KIND("Three of a Kind"),
    TWO_PAIR("Two Pair"),
    ONE_PAIR("One Pair"),
    HIGH_CARDS("High Cards");

    private final String displayName;

    HandStrength(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}

/*import com.github.javapoker.poker.hand.HandEvaluator;
        import com.github.javapoker.poker.hand.HandType;

// ...

public HandStrength getHandStrength() {
        HandEvaluator evaluator = new HandEvaluator();
        HandType handType = evaluator.evaluate(getCards());

        // Convert the HandType to the corresponding HandStrength enum value
        switch (handType) {
        case STRAIGHT_FLUSH:
        return HandStrength.STRAIGHT_FLUSH;
        case FOUR_OF_A_KIND:
        return HandStrength.FOUR_OF_A_KIND;
        case FULL_HOUSE:
        return HandStrength.FULL_HOUSE;
        case FLUSH:
        return HandStrength.FLUSH;
        case STRAIGHT:
        return HandStrength.STRAIGHT;
        case THREE_OF_A_KIND:
        return HandStrength.THREE_OF_A_KIND;
        case TWO_PAIR:
        return HandStrength.TWO_PAIR;
        case ONE_PAIR:
        return HandStrength.ONE_PAIR;
default:
        return HandStrength.HIGH_CARDS;
        }
        }*/

