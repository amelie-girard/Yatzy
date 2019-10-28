package yatzy;

import yatzy.scoringcategory.*;

public class Yatzy {

    private DiceRolled diceRolled;
    private SimpleNumberCategory simpleNumberCategory;
    private NofKindCategory nofKindCategory;
    private PairCategory pairCategory;
    private StraightCategory straightCategory;

    public Yatzy(DiceRolled diceRolled) {
        this.diceRolled = diceRolled;
        simpleNumberCategory = new SimpleNumberCategory(diceRolled);
        nofKindCategory = new NofKindCategory(diceRolled);
        pairCategory = new PairCategory(diceRolled);
        straightCategory = new StraightCategory(diceRolled);
    }

    int score(CategoryEnum catgoryEnum) {
        switch (catgoryEnum) {
        case CHANCE:
            return simpleNumberCategory.chance();
        case YATZY:
            return simpleNumberCategory.yatzy();
        case ONES:
            return simpleNumberCategory.calculerLaSommeDesDesDeNombreUn();
        case TWOS:
            return simpleNumberCategory.calculerLaSommeDesDesDeNombreDeux();
        case THREES:
            return simpleNumberCategory.calculerLaSommeDesDesDeNombreTrois();
        case FOURS:
            return simpleNumberCategory.calculerLaSommeDesDesDeNombreQuatre();
        case FIVES:
            return simpleNumberCategory.calculerLaSommeDesDesDeNombreCinq();
        case SIXES:
            return simpleNumberCategory.calculerLaSommeDesDesDeNombreSix();
        case ONE_PAIR:
            return pairCategory.calculerScorePourUnePaire();
        case TWO_PAIR:
            return pairCategory.calculerScorePourDeuxPaires();
        case FOUR_OF_KIND:
            return nofKindCategory.calculerScorePourCarre();
        case THREE_OF_KIND:
            return nofKindCategory.calculerScorePourBrelan();
        case SMALL_STRAIGHT:
            return straightCategory.calculerPetiteSuite();
        case LARGE_STRAIGHT:
            return straightCategory.calculerGrandeSuite();
        case FULL_HOUSE:
            return straightCategory.calculerScorePourFull();
        default:
            return 0;
        }
    }

}



