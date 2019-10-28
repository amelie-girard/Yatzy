package yatzy.scoringcategory;

import yatzy.DiceNumberEnum;
import yatzy.DiceRolled;

public class SimpleNumberCategory {

    private final DiceRolled diceRolled;

    public int chance() {
        return diceRolled.calculerSommeDeTousLesDes();
    }

    public int yatzy() {
        //Si la taille de distinctDiceest egale à 1 cela signifie que tous les dés sont égaux
        return diceRolled.calculerNombreDeDesDistinct() == 1 ? 50 : 0;
    }

    public SimpleNumberCategory(DiceRolled diceRolled){
        this.diceRolled = diceRolled;
    }

    public int calculerLaSommeDesDesDeNombreUn() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.UN.getValue());
    }

    public int calculerLaSommeDesDesDeNombreDeux() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.DEUX.getValue());
    }

    public int calculerLaSommeDesDesDeNombreTrois() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.TROIS.getValue());
    }

    public int calculerLaSommeDesDesDeNombreQuatre() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.QUATRE.getValue());
    }

    public int calculerLaSommeDesDesDeNombreCinq() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.CINQ.getValue());
    }

    public int calculerLaSommeDesDesDeNombreSix() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.SIX.getValue());
    }
}
