public enum DiceNumberEnum {

    UN(1),
    DEUX(2),
    TROIS(3),
    QUATRE(4),
    CINQ(5),
    SIX(6);

    private int number;

    DiceNumberEnum(int number) {
        this.number = number;
    }

    public int getNumber(){
        return number;
    }
}
