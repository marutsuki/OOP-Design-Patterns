package gof.behavioural.templatemethod;

import lombok.extern.log4j.Log4j2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Log4j2
public class CardGamePlayerHuman extends CardGamePlayer {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Example code for a potential implementation allowing human player interactability
     */
    @Override
    protected void drawPhase() {
        var cards = draw();

        System.out.format("Your drawn cards are: %s\nPlease select a card by entering 1-%d",
                cards.toString(), CARD_DRAWS_PER_TURN);

        while (true) {
            int i = scanner.nextInt();
            if (1 <= i && i <= CARD_DRAWS_PER_TURN) {
                Card selectedCard = cards.get(i - 1);
                hand.add(selectedCard);
                log.info("{} has selected card {}", this, selectedCard);
                break;
            }
        }
    }

    /**
     * Example code for a potential implementation allowing human player interactability
     */
    @Override
    protected void setPhase() {
        outer:
        while (true) {
            System.out.println("Do you want to set a card? Y/N");
            String res = scanner.next();

            switch (res) {
                case "Y", "y" -> System.out.format("Please select a card 1-%d: %s\n", hand.toString(), hand.size());
                case "N", "n", default -> {
                    break outer;
                }
            }
            int i = scanner.nextInt();
            if (1 <= i && i <= hand.size()) {
                var selectedCard = hand.get(i - 1);
                field.add(selectedCard);
                log.info("{} has set card {} onto their own field", this, selectedCard);
                hand.remove(i - 1);
            }
        }
    }

    @Override
    protected void spellPhase() {
        // Code to let the user cast spell cards
    }

    @Override
    protected void battlePhase() {
        // Code to let user action battle commands
    }
}
