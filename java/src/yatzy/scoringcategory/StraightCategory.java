package yatzy.scoringcategory;

import yatzy.DiceRolled;

public class StraightCategory {

    private final DiceRolled diceRolled;

    public StraightCategory(DiceRolled diceRolled){
        this.diceRolled = diceRolled;
    }

    public int smallStraight() {
        DiceRolled sortedDiceRolled = diceRolled.sort();
        if (sortedDiceRolled.getDices().get(0).getNumber() != 1) {
            return 0;
        }
        return diceRolled.calculateSumIfFollowingDices(sortedDiceRolled);
    }



    public int largeStraight() {
        DiceRolled sortedDiceRolled = diceRolled.sort();
        if (sortedDiceRolled.getDices().get(0).getNumber() != 2) {
            return 0;
        }
        return diceRolled.calculateSumIfFollowingDices(sortedDiceRolled);
    }

}
