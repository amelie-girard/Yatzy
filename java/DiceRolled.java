import java.util.List;

public class DiceRolled {

    private final List<Dice> dices;

    DiceRolled(List<Dice> dices){
        this.dices = dices;
    }

    int calculerLaSommeDesDesDeNombreN(int i) {
        int[] sum = { 0 };
        dices.stream().filter(dice -> dice.getNumber() == i).forEach(dice -> sum[0] += dice.getNumber());
        return sum[0];
    }

}
