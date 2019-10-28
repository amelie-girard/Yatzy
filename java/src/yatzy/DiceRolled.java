package yatzy;

import java.util.List;

public class DiceRolled {

    private final List<Dice> dices;

    DiceRolled(List<Dice> dices) {
        this.dices = dices;
    }

    public List<Dice> getDices() {
        return dices;
    }

    public int calculerSommeDeTousLesDes() {
        int[] sum = { 0 };
        dices.forEach(dice -> sum[0] += dice.getNumber());
        return sum[0];
    }

    public int calculerLaSommeDesDesDeNombreN(int i) {
        int[] sum = { 0 };
        dices.stream().filter(dice -> dice.getNumber() == i).forEach(dice -> sum[0] += dice.getNumber());
        return sum[0];
    }

    public boolean trouverPaireDeN(int n) {
        if (n <= 0)
            return false;
        long total = dices.stream().filter(dice -> dice.getNumber() == n).count();
        return total >= 2;
    }

    public void enleverDes(Dice dice) {
        for (int i = 0; i < dices.size(); i++) {
            if (dices.get(i).getNumber() == dice.getNumber())
                dices.set(i, new Dice(-1));
        }
    }

    public DiceRolled trierParOdreCroissant() {
        for (int i = 0; i < dices.size() - 1; i++) {
            for (int j = i + 1; j < dices.size(); j++) {
                if (dices.get(j).isLowerThan(dices.get(i))) {
                    Dice temp = new Dice(dices.get(i).getNumber());
                    dices.get(i).setNumer(dices.get(j).getNumber());
                    dices.get(j).setNumer(temp.getNumber());
                }
            }
        }
        return new DiceRolled(dices);
    }

    public int additionnerNDesDeMemeNombre(int n) {
        int counts = 1;
        DiceRolled sortedDiceRolled = trierParOdreCroissant();
        int sum = sortedDiceRolled.getDices().get(0).getNumber();
        for (int i = 0; i < sortedDiceRolled.getDices().size() - 1; i++) {
            if (counts == n) {
                return sum;
            } else if ((sortedDiceRolled.getDices().get(i).isEqual(sortedDiceRolled.getDices().get(i + 1)))) {
                counts++;
                sum += sortedDiceRolled.getDices().get(i + 1).getNumber();
            } else {
                counts = 1;
                sum = sortedDiceRolled.getDices().get(i + 1).getNumber();
            }
        }
        return counts == n ? sum : 0;
    }

    public int calculerSommeSiLesDesSeSuivent(DiceRolled sortedDiceRolled) {
        int sum = 0;
        for (int i = 0; i < sortedDiceRolled.getDices().size() - 1; i++) {
            if (sortedDiceRolled.getDices().get(i).getNumber() == (sortedDiceRolled.getDices().get(i + 1).getNumber()
                    - 1)) {
                sum += sortedDiceRolled.getDices().get(i).getNumber();
            } else {
                return 0;
            }
        }
        sum += sortedDiceRolled.getDices().get(sortedDiceRolled.getDices().size() - 1).getNumber();
        return sum;
    }

    public int calculerNombreDeDesDistinct() {
        int total = 1;
        for (int i = 0; i < dices.size() - 1; i++) {
            if (!dices.get(i).isEqual(dices.get(i + 1))) {
                total++;
            }
        }
        return total;
    }
}
