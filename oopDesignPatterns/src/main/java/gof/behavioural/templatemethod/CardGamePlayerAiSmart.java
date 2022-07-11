package gof.behavioural.templatemethod;

import java.util.ArrayList;
import java.util.List;

public class CardGamePlayerAiSmart extends CardGamePlayer {
    @Override
    protected void drawPhase() {
        // Pick out the optimal card based on a heuristic
        hand.add(drawSelector(draw()));
    }

    @Override
    protected void setPhase() {
        List<Card> cardsToSet = new ArrayList<>();
        for (Card card : hand) {
            // Use a heuristic to determine if the card should be set
            if (setHeuristic(card)) {
                cardsToSet.add(card);
            }
        }
        for (Card card : cardsToSet) {
            field.add(card);
            hand.remove(card);
        }
    }

    @Override
    protected void spellPhase() {
        // Code to cast a spell based on a more complex algorithm/process
    }

    @Override
    protected void battlePhase() {
        // Code to maximize enemy card destruction
    }

    /**
     * Dummy algorithm/heuristic methods
     */
    private Card drawSelector(List<Card> cards) {
        return cards.get((int)(Math.random() * cards.size()));
    }

    private boolean setHeuristic(Card card) {
        return !(Math.random() < 0.5);
    }
}
