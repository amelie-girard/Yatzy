package yatzy;

import yatzy.scoringcategory.PairCategory;
import yatzy.scoringcategory.SimpleNumberCategory;
import yatzy.scoringcategory.StraightCategory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy {


    private List<Integer> dices;
    private DiceRolled diceRolled;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public Yatzy(DiceRolled diceRolled){
        this.diceRolled = diceRolled;
    }

    int chance() {
        int[] total = { 0 };
        dices.forEach(dice -> total[0] += dice);
        return total[0];
    }

    public int yatzy() {
        //Si la taille de distinctDiceest egale à 1 cela signifie que tous les dés sont égaux
        List<Integer> distinctDice = dices.stream().distinct().collect(Collectors.toList());
        return distinctDice.size() == 1 ? 50 : 0;
    }

    int calculerScoreSiCategorieSimple(DiceNumberEnum number){
        SimpleNumberCategory simpleNumberCategory = new SimpleNumberCategory(diceRolled);
        switch(number) {
        case UN : return simpleNumberCategory.calculerLaSommeDesDesDeNombreUn();
        case DEUX : return simpleNumberCategory.calculerLaSommeDesDesDeNombreDeux();
        case TROIS : return simpleNumberCategory.calculerLaSommeDesDesDeNombreTrois();
        case QUATRE: return simpleNumberCategory.calculerLaSommeDesDesDeNombreQuatre();
        case CINQ : return simpleNumberCategory.calculerLaSommeDesDesDeNombreCinq();
        case SIX : return simpleNumberCategory.calculerLaSommeDesDesDeNombreSix();
        default: return 0;
        }

    }

    int calculerScorePourUnePaire(){
        PairCategory pairCategory = new PairCategory(diceRolled);
        return pairCategory.calculerScorePourUnePaire();
    }

    int calculerScorePourDeuxPaires(){
        PairCategory pairCategory = new PairCategory(diceRolled);
        return pairCategory.calculerScorePourDeuxPaires();
    }


     int fourOfaKind() {
        return diceRolled.additionnerNDesDeMemeNombre(4);
    }

    int threeOfaKind() {
        return diceRolled.additionnerNDesDeMemeNombre(3);
    }

    int smallStraight() {
        StraightCategory straightCategory = new StraightCategory(diceRolled);
        return straightCategory.smallStraight();
    }



    int largeStraight() {
        StraightCategory straightCategory = new StraightCategory(diceRolled);
        return straightCategory.largeStraight();
    }

    int fullHouse() {
        List<Integer> distinctDice = dices.stream().distinct().collect(Collectors.toList());
        if (distinctDice.size() == 2 && fourOfaKind() == 0) {
            int[] sum = { 0 };
            dices.forEach(dice -> sum[0] += dice);
            return sum[0];
        } else
            return 0;
    }
}



