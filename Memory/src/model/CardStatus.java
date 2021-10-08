package model;

public enum CardStatus {
    CLOSED(1), OPEN(2), TAKEN(3);

    private final int value;

    public int getValue() {
        return value;
    }

    private CardStatus(int value) {
        this.value = value;
    }
}
