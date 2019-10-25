import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy {

    private static final int ONE = 1;
    private static final int TWO = 2;
    private static final int THREE = 3;
    private static final int FOUR = 4;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private List<Integer> dices;

    public Yatzy(int d1, int d2, int d3, int d4, int d5) {
        dices = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public int chance() {
        int[] total = { 0 };
        dices.forEach(dice -> total[0] += dice);
        return total[0];
    }

    public int yatzy() {
        //Si la taille de distinctDiceest egale à 1 cela signifie que tous les dés sont égaux
        List<Integer> distinctDice = dices.stream().distinct().collect(Collectors.toList());
        return distinctDice.size() == 1 ? 50 : 0;
    }

    public int ones() {
        return numberOfNs(ONE);
    }

    private int numberOfNs(int i) {
        int[] sum = { 0 };
        dices.stream().filter(dice -> dice == i).forEach(dice -> sum[0] += dice);
        return sum[0];
    }

    public int twos() {
        return numberOfNs(TWO);
    }

    public int threes() {
        return numberOfNs(THREE);
    }

    public int fours() {
        return numberOfNs(FOUR);
    }

    public int fives() {
        return numberOfNs(FIVE);
    }

    public int sixes() {
        return numberOfNs(SIX);
    }

    public int score_pair() {
        List<Integer> sortedList = dices.stream().sorted().collect(Collectors.toList());
        for (int i = sortedList.size() - 1; i > 0; i--) {
            if (find_pair_of_n(sortedList.get(i)))
                return sortedList.get(i) * 2;
        }
        return 0;
    }

    private boolean find_pair_of_n(int n) {
        int[] total = { 0 };
        dices.forEach(dice -> {
            if (dice == n)
                total[0]++;
        });
        return total[0] >= 2;
    }

    public int two_pair() {
        int nbPair = 0;
        int sum = 0;
        List<Integer> sortedList = dices.stream().sorted().collect(Collectors.toList());
        for (int i = sortedList.size() - 1; i > 0; i--) {
            if (find_pair_of_n(sortedList.get(i))) {
                sum += (sortedList.get(i) * 2);
                nbPair++;
                remove_n(sortedList.get(i));
            }
        }
        return nbPair == 2 ? sum : 0;
    }

    private void remove_n(int n) {
        for (int i = 0; i < dices.size(); i++) {
            if (dices.get(i) == n)
                dices.set(i, -1);
        }
    }

    public int four_of_a_kind() {
        int diffDices = dices.stream().distinct().collect(Collectors.toList()).size();
        List<Integer> sortedList = dices.stream().sorted().collect(Collectors.toList());
        if (diffDices > 2) {
            return 0;
        }
        return n_of_a_king(sortedList, 4);
    }

    private int n_of_a_king(List<Integer> sortedList, int n) {
        int counts = 1;
        int sum = sortedList.get(0);
        for (int i = 0; i < sortedList.size() - 1; i++) {
            if (counts == n) {
                return sum;
            } else if ((sortedList.get(i) == sortedList.get(i + 1))) {
                counts++;
                sum += sortedList.get(i + 1);
            } else {
                counts = 1;
                sum = sortedList.get(i + 1);
            }
        }
        return counts == n ? sum : 0;
    }

    public int three_of_a_kind() {
        int diffDices = dices.stream().distinct().collect(Collectors.toList()).size();
        List<Integer> sortedList = dices.stream().sorted().collect(Collectors.toList());
        if (diffDices > 3) {
            return 0;
        }
        return n_of_a_king(sortedList, 3);
    }

    public int smallStraight() {
        List<Integer> orderedList = dices.stream().sorted().collect(Collectors.toList());
        if (orderedList.get(0) != 1) {
            return 0;
        }
        return calculateSumIfFollowingDices(orderedList);
    }

    private int calculateSumIfFollowingDices(List<Integer> orderedList) {
        int sum = 0;
        for (int i = 0; i < orderedList.size() - 1; i++) {
            if (orderedList.get(i) == (orderedList.get(i + 1) - 1)) {
                sum += orderedList.get(i);
            } else {
                return 0;
            }
        }
        sum += orderedList.get(orderedList.size() - 1);
        return sum;
    }

    public int largeStraight() {
        List<Integer> orderedList = dices.stream().sorted().collect(Collectors.toList());
        if (orderedList.get(0) != 2) {
            return 0;
        }
        return calculateSumIfFollowingDices(orderedList);
    }

    public int fullHouse() {
        List<Integer> distinctDice = dices.stream().distinct().collect(Collectors.toList());
        if (distinctDice.size() == 2 && four_of_a_kind() == 0) {
            int[] sum = { 0 };
            dices.forEach(dice -> sum[0] += dice);
            return sum[0];
        } else
            return 0;
    }
}



