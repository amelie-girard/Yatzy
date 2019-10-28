package yatzy.scoringcategory;

import yatzy.DiceRolled;

public class StraightCategory {

    private final DiceRolled diceRolled;

    public StraightCategory(DiceRolled diceRolled) {
        this.diceRolled = diceRolled;
    }

    public int calculerPetiteSuite() {
        DiceRolled sortedDiceRolled = diceRolled.trierParOdreCroissant();
        if (sortedDiceRolled.getDices().get(0).getNumber() != 1) {
            return 0;
        }
        return diceRolled.calculerSommeSiLesDesSeSuivent(sortedDiceRolled);
    }

    public int calculerGrandeSuite() {
        DiceRolled sortedDiceRolled = diceRolled.trierParOdreCroissant();
        if (sortedDiceRolled.getDices().get(0).getNumber() != 2) {
            return 0;
        }
        return diceRolled.calculerSommeSiLesDesSeSuivent(sortedDiceRolled);
    }

    public int calculerScorePourFull() {
        DiceRolled sortedDiceRolled = diceRolled.trierParOdreCroissant();
        int numberOfDistinctDice = sortedDiceRolled.calculerNombreDeDesDistinct();
        NofKindCategory nofKindCategory = new NofKindCategory(diceRolled);
        if (numberOfDistinctDice == 2 && nofKindCategory.calculerScorePourCarre() == 0) {
            int[] sum = { 0 };
            diceRolled.getDices().forEach(dice -> sum[0] += dice.getNumber());
            return sum[0];
        } else
            return 0;
    }

}
