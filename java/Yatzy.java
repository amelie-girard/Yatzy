import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Yatzy {

    protected List<Integer> dices;
    public Yatzy(int d1, int d2, int d3, int d4, int d5)
    {
        dices = Arrays.asList(d1, d2, d3, d4, d5);
    }

    public int chance()
    {
        int []total = {0};
      dices.forEach( dice -> total[0] += dice);
        return total[0];
    }

    public int yatzy()
    {
        //Si la taille de distinctDiceest egale à 1 cela signifie que tous les dés sont égaux
        List<Integer> distinctDice = dices.stream().distinct().collect(Collectors.toList());
        return distinctDice.size() == 1 ? 50 : 0;
    }

    public int ones()
    {
        int []sum = {0};
        dices.stream().filter(dice -> dice == 1).forEach( dice -> sum[0]+= dice);
        return sum[0];
    }

    public int twos()
    {
        int []sum = {0};
        dices.stream().filter(dice -> dice == 2).forEach( dice -> sum[0]+= dice);
        return sum[0];
    }

    public int threes()
    {
        int []sum = {0};
        dices.stream().filter(dice -> dice == 3).forEach( dice -> sum[0]+= dice);
        return sum[0];
    }

    public int fours()
    {
        int []sum = {0};
        dices.stream().filter(dice -> dice == 4).forEach( dice ->sum[0]+= dice);
        return sum[0];
    }

    public int fives()
    {
        int []sum = {0};
        dices.stream().filter(dice -> dice == 5).forEach( dice ->sum[0]+= dice);
        return sum[0];
    }

    public int sixes()
    {
        int []sum = {0};
        dices.stream().filter(dice -> dice == 6).forEach( dice -> sum[0]+= dice);
        return sum[0];
    }

    public static int score_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int at;
        for (at = 0; at != 6; at++)
            if (counts[6-at-1] >= 2)
                return (6-at)*2;
        return 0;
    }

    public static int two_pair(int d1, int d2, int d3, int d4, int d5)
    {
        int[] counts = new int[6];
        counts[d1-1]++;
        counts[d2-1]++;
        counts[d3-1]++;
        counts[d4-1]++;
        counts[d5-1]++;
        int n = 0;
        int score = 0;
        for (int i = 0; i < 6; i += 1)
            if (counts[6-i-1] >= 2) {
                n++;
                score += (6-i);
            }
        if (n == 2)
            return score * 2;
        else
            return 0;
    }

    public int four_of_a_kind()
    {
        int diffDices = dices.stream().distinct().collect(Collectors.toList()).size();
        List<Integer> sortedList = dices.stream().sorted().collect(Collectors.toList());
        if(diffDices >2){
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
                sum += sortedList.get(i+1);
            } else {
                counts = 1;
                sum = sortedList.get(i+1);
            }

        }
        return counts == n ? sum : 0;
    }

    public  int three_of_a_kind()
    {
      int diffDices = dices.stream().distinct().collect(Collectors.toList()).size();
      List<Integer> sortedList = dices.stream().sorted().collect(Collectors.toList());
        if(diffDices >3){
            return 0;
        }
        return n_of_a_king(sortedList, 3);
    }

    public int smallStraight()
    {
        List<Integer> orderedList = dices.stream().sorted().collect(Collectors.toList());
        if(orderedList.get(0) != 1) {
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

    public  int largeStraight()
    {
        List<Integer> orderedList = dices.stream().sorted().collect(Collectors.toList());
        if(orderedList.get(0) != 2) {
            return 0;
        }
        return calculateSumIfFollowingDices(orderedList);
    }


    public  int fullHouse()
    {
        List<Integer> distinctDice = dices.stream().distinct().collect(Collectors.toList());
        if (distinctDice.size() == 2 && four_of_a_kind() == 0){
            int []sum = {0};
            dices.forEach(dice -> sum[0] += dice);
            return sum[0];
        } else
            return 0;

    }
}



