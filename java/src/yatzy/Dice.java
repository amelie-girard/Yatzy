package yatzy;

public class Dice {

    private int number;

    Dice(int number){
        this.number = number;
    }

    public int getNumber(){
        return this.number;
    }

    public boolean isLowerThan(Dice dice) {
        return number <= dice.getNumber();
    }

    public void setNumer(int number) {
        this.number = number;
    }

    boolean isEqual(Dice dice){
        return this.number == dice.getNumber();
    }
}
