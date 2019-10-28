package yatzy;

public enum DiceNumberEnum {

    UN(1), DEUX(2), TROIS(3), QUATRE(4), CINQ(5), SIX(6);

    private int value;

    DiceNumberEnum(int number) {
        this.value = number;
    }

    public int getValue() {
        return value;
    }
}
