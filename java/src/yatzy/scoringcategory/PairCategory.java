package yatzy.scoringcategory;

import yatzy.DiceRolled;

public class PairCategory {

    private final DiceRolled diceRolled;

    public PairCategory(DiceRolled diceRolled){
        this.diceRolled = diceRolled;
    }

    public int calculerScorePourUnePaire() {
        DiceRolled sortedDiceRolled = diceRolled.sort();
        for (int i = sortedDiceRolled.getDices().size() - 1; i > 0; i--) {
            if (diceRolled.trouverPaireDeN(sortedDiceRolled.getDices().get(i).getNumber())){
                return sortedDiceRolled.getDices().get(i).getNumber() * 2;
            }
        }
        return 0;
    }

    public int calculerScorePourDeuxPaires() {
        int nbPair = 0;
        int sum = 0;
        DiceRolled sortedDiceRolled = diceRolled.sort();
        for (int i = sortedDiceRolled.getDices().size() - 1; i > 0; i--) {
            if (diceRolled.trouverPaireDeN(sortedDiceRolled.getDices().get(i).getNumber())) {
                sum += (sortedDiceRolled.getDices().get(i).getNumber() * 2);
                nbPair++;
                diceRolled.enleverDes(sortedDiceRolled.getDices().get(i));
            }
        }
        return nbPair == 2 ? sum : 0;
    }

}
