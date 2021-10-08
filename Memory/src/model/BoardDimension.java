package model;

public enum BoardDimension {
    EIGHT(8), SIXTEEN(16), THIRTY_TWO(32);

    private final int value;

    public int getValue() {
        return value;
    }

    private BoardDimension(int value) {
        this.value = value;
    }
}
