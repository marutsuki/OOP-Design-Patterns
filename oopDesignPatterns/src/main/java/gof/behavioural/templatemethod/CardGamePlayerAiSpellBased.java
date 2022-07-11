package gof.behavioural.templatemethod;

public class CardGamePlayerAiSpellBased extends CardGamePlayer {
    @Override
    protected void drawPhase() {
        Card selectedCard = null;
        var cards = draw();
        for (Card card : cards) {
            if (card.type().equals(CardType.SPELL)) {
                selectedCard = card;
            }
        }
        hand.add(selectedCard == null ? cards.get(0) : selectedCard);
    }

    @Override
    protected void setPhase() {
        // Set cards, prioritizing spell cards
    }

    @Override
    protected void spellPhase() {
        // Cast spells, potentially add other side effects for being a Spell Based AI
    }

    @Override
    protected void battlePhase() {
        // Action battle commands
    }
}
