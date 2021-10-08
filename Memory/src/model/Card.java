package model;

public class Card {

    private int cardId;
    public CardStatus type;

    public Card(int cardId, CardStatus type) {
        this.cardId = cardId;
        this.type = type;
    }

    public CardStatus getStatus() {
        return type;
    }

    public void setStatus(CardStatus type) {
        this.type = type;
    }

    public int getCardId() {
        return cardId;
    }

    public boolean isIdentical(Card another) {
        return this.getCardId() == another.getCardId();
    }

    @Override
    public String toString() {
        return "Card [cardId= " + cardId + ", type= " + type + "]";
    }
}
