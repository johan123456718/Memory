package model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MemoryLogic {

    private int size;
    private List<Card> theCards;
    private Player[] thePlayers;

    public MemoryLogic() {
        size = 32;
        theCards = new ArrayList<>(size);
        thePlayers = new Player[2];
        thePlayers[0] = new Player("Player 1");
        thePlayers[1] = new Player("Player 2");
    }

    public int getSize() {
        return size;
    }

    public void initNewGame() {
        int cardId = 0;
        for (int i = 0; i < size; i++) {
            if (cardId == size / 2) {
                cardId = 0;
            }
            theCards.add(new Card(cardId++, CardStatus.CLOSED));
        }
        shuffle();
    }

    private void shuffle() {
        Collections.shuffle(theCards);
    }

    public List<Card> getCards() {
        List<Card> theCardsCopy = new ArrayList<>(size);
        theCardsCopy.addAll(theCards);
        return theCardsCopy;
    }

    public Player[] getPlayers() {
        return thePlayers;
    }

    public int flipCard(Card c) {
        c.setStatus(CardStatus.OPEN);
        return c.getCardId();
    }

    public boolean isGameOver() {
        return thePlayers[0].getPoints() + thePlayers[1].getPoints() == size / 2;
    }

    public boolean pointGained(Card c, Player p) {
        int cardId = flipCard(c);
        for (Card card : theCards) {
            if (card.getStatus().equals(CardStatus.OPEN)) {
                if (card.getCardId() == cardId) {
                    p.addPoint();
                    card.setStatus(CardStatus.TAKEN);
                    c.setStatus(CardStatus.TAKEN);
                    return true;
                } else {
                    card.setStatus(CardStatus.CLOSED);
                    c.setStatus(CardStatus.CLOSED);
                }
            }
        }
        return false;
    }

}
