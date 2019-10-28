package yatzy.scoringcategory;

import yatzy.DiceRolled;

public class NofKindCategory {

    private final DiceRolled diceRolled;

    public NofKindCategory(DiceRolled diceRolled){
        this.diceRolled = diceRolled;
    }

    public int calculerScorePourCarre() {
        return diceRolled.additionnerNDesDeMemeNombre(4);
    }

    public int calculerScorePourBrelan() {
        return diceRolled.additionnerNDesDeMemeNombre(3);
    }
}
