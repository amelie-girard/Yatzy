import java.util.List;

public class DiceRolled {

    private final List<Dice> dices;

    public DiceRolled(List<Dice> dices){
        this.dices = dices;
    }

    public List<Dice> getDices() {
        return dices;
    }
}
