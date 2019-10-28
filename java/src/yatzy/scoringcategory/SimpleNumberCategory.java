package yatzy.scoringcategory;

import yatzy.DiceNumberEnum;
import yatzy.DiceRolled;

public class SimpleNumberCategory {

    private final DiceRolled diceRolled;

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
