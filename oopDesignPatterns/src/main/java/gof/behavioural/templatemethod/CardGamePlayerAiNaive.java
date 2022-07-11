package gof.behavioural.templatemethod;

import lombok.extern.log4j.Log4j2;

import java.util.List;

@Log4j2
public class CardGamePlayerAiNaive extends CardGamePlayer {
    @Override
    protected void drawPhase() {
        var cards = draw();
        // Naively draw the first card
        hand.add(cards.get(0));
    }

    @Override
    protected void setPhase() {
        // Naively sets as many cards down as possible in order
        while (hand.size() > 0) {
            if (field.size() == MAXIMUM_CARDS_ON_FIELD) {
                break;
            }
            field.add(hand.get(0));
            hand.remove(0);
        }
    }

    @Override
    protected void spellPhase() {
        // Naively casts as many spell cards as possible in order
    }

    @Override
    protected void battlePhase() {
        // Naively battles with their cards, whether they win or not
    }
}
