package gof.behavioural.templatemethod;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

@Log4j2
public abstract class CardGamePlayer {

    protected CardGamePlayer opponent;
    protected static final int MAXIMUM_CARDS_ON_FIELD = 5;
    protected static final int CARD_DRAWS_PER_TURN = 3;
    protected Deque<Card> deck;
    protected List<Card> hand;
    protected List<Card> field;

    public void turn() {
        drawPhase();
        setPhase();
        spellPhase();
        battlePhase();
        setPhaseTwo();
        endTurn();
    }

    protected List<Card> draw() {
        List<Card> drawnCards = new ArrayList<>();
        for (int i = 0; i < CARD_DRAWS_PER_TURN - 1; ++i) {
            drawnCards.add(deck.poll());
        }
        return drawnCards;
    }
    protected abstract void drawPhase();

    protected abstract void setPhase();

    protected abstract void spellPhase();

    protected abstract void battlePhase();

    protected void setPhaseTwo() {
        setPhase();
    }

    protected void endTurn() {
        log.info("{} has ended their turn", this);
    }
}
