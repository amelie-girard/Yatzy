public class SimpleNumberCategory {

    private final DiceRolled diceRolled;

    public SimpleNumberCategory(DiceRolled diceRolled){
        this.diceRolled = diceRolled;
    }

    int calculerLaSommeDesDesDeNombreUn() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.UN.getValue());
    }

    int calculerLaSommeDesDesDeNombreDeux() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.DEUX.getValue());
    }

    int calculerLaSommeDesDesDeNombreTrois() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.TROIS.getValue());
    }

    int calculerLaSommeDesDesDeNombreQuatre() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.QUATRE.getValue());
    }

    int calculerLaSommeDesDesDeNombreCinq() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.CINQ.getValue());
    }

    int calculerLaSommeDesDesDeNombreSix() {
        return diceRolled.calculerLaSommeDesDesDeNombreN(DiceNumberEnum.SIX.getValue());
    }
}
