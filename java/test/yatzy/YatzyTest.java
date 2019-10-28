package yatzy;

import org.junit.jupiter.api.Test;
import yatzy.scoringcategory.CategoryEnum;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class YatzyTest {

    @Test
    void chance_scores_sum_of_all_dice() {
        int expected = 15;
        Yatzy yatzy_1 = new Yatzy(buildDiceRolled(2, 3, 4, 5, 1));
        int actual = yatzy_1.score(CategoryEnum.CHANCE);
        assertEquals(expected, actual);
        Yatzy yatzy_2 = new Yatzy(buildDiceRolled(3, 3, 4, 5, 1));
        assertEquals(16, yatzy_2.score(CategoryEnum.CHANCE));
    }

    @Test
    void yatzy_scores_50() {
        int expected = 50;
        int actual = new Yatzy(buildDiceRolled(4, 4, 4, 4, 4)).score(CategoryEnum.YATZY);
        assertEquals(expected, actual);
        assertEquals(50, new Yatzy(buildDiceRolled(6, 6, 6, 6, 6)).score(CategoryEnum.YATZY));
        assertEquals(0, new Yatzy(buildDiceRolled(6, 6, 6, 6, 3)).score(CategoryEnum.YATZY));
    }

    @Test
    void test_1s() {
        assertTrue(new Yatzy(buildDiceRolled(1, 2, 3, 4, 5)).score(CategoryEnum.ONES) == 1);
        assertEquals(2, new Yatzy(buildDiceRolled(1, 2, 1, 4, 5)).score(CategoryEnum.ONES));
        assertEquals(0, new Yatzy(buildDiceRolled(6, 2, 2, 4, 5)).score(CategoryEnum.ONES));
        assertEquals(4, new Yatzy(buildDiceRolled(1, 2, 1, 1, 1)).score(CategoryEnum.ONES));
    }

    private DiceRolled buildDiceRolled(int a, int b, int c, int d, int e) {
        return new DiceRolled(Arrays.asList(new Dice(a), new Dice(b), new Dice(c), new Dice(d), new Dice(e)));
    }

    @Test
    void test_2s() {
        assertEquals(4, new Yatzy(buildDiceRolled(1, 2, 3, 2, 6)).score(CategoryEnum.TWOS));
        assertEquals(10, new Yatzy(buildDiceRolled(2, 2, 2, 2, 2)).score(CategoryEnum.TWOS));
    }

    @Test
    void test_threes() {
        assertEquals(6, new Yatzy(buildDiceRolled(1, 2, 3, 2, 3)).score(CategoryEnum.THREES));
        assertEquals(12,
                new Yatzy(buildDiceRolled(2, 3, 3, 3, 3)).score(CategoryEnum.THREES));
    }

    @Test
    void fours_test() {
        assertEquals(12,
                new Yatzy(buildDiceRolled(4, 4, 4, 5, 5)).score(CategoryEnum.FOURS));
        assertEquals(8,
                new Yatzy(buildDiceRolled(4, 4, 5, 5, 5)).score(CategoryEnum.FOURS));
        assertEquals(4,
                new Yatzy(buildDiceRolled(4, 5, 5, 5, 5)).score(CategoryEnum.FOURS));
    }

    @Test
    void fives() {
        assertEquals(10, new Yatzy(buildDiceRolled(4, 4, 4, 5, 5)).score(CategoryEnum.FIVES));
        assertEquals(15, new Yatzy(buildDiceRolled(4, 4, 5, 5, 5)).score(CategoryEnum.FIVES));
        assertEquals(20, new Yatzy(buildDiceRolled(4, 5, 5, 5, 5)).score(CategoryEnum.FIVES));
    }

    @Test
    void sixes_test() {
        assertEquals(0, new Yatzy(buildDiceRolled(4, 4, 4, 5, 5)).score(CategoryEnum.SIXES));
        assertEquals(6, new Yatzy(buildDiceRolled(4, 4, 6, 5, 5)).score(CategoryEnum.SIXES));
        assertEquals(18, new Yatzy(buildDiceRolled(6, 5, 6, 6, 5)).score(CategoryEnum.SIXES));
    }

    @Test
    void one_pair() {
        assertEquals(6, new Yatzy(buildDiceRolled(3, 4, 3, 5, 6)).score(CategoryEnum.ONE_PAIR));
        assertEquals(10, new Yatzy(buildDiceRolled(5, 3, 3, 3, 5)).score(CategoryEnum.ONE_PAIR));
        assertEquals(12, new Yatzy(buildDiceRolled(5, 3, 6, 6, 5)).score(CategoryEnum.ONE_PAIR));
        assertEquals(0, new Yatzy(buildDiceRolled(1, 2, 3, 4, 5)).score(CategoryEnum.ONE_PAIR));
    }

    @Test
    void two_Pair() {
        assertEquals(16, new Yatzy(buildDiceRolled(3, 3, 5, 4, 5)).score(CategoryEnum.TWO_PAIR));
        assertEquals(16, new Yatzy(buildDiceRolled(3, 3, 5, 5, 5)).score(CategoryEnum.TWO_PAIR));
    }

    @Test
    void three_of_a_kind() {
        assertEquals(9, new Yatzy(buildDiceRolled(3, 3, 3, 4, 5)).score(CategoryEnum.THREE_OF_KIND));
        assertEquals(15, new Yatzy(buildDiceRolled(5, 3, 5, 4, 5)).score(CategoryEnum.THREE_OF_KIND));
        assertEquals(9, new Yatzy(buildDiceRolled(3, 3, 3, 3, 5)).score(CategoryEnum.THREE_OF_KIND));
        assertEquals(0, new Yatzy(buildDiceRolled(1, 3, 2, 3, 5)).score(CategoryEnum.THREE_OF_KIND));
    }

    @Test
    void four_of_a_knd() {
        assertEquals(12, new Yatzy(buildDiceRolled(3, 3, 3, 3, 5)).score(CategoryEnum.FOUR_OF_KIND));
        assertEquals(20, new Yatzy(buildDiceRolled(5, 5, 5, 4, 5)).score(CategoryEnum.FOUR_OF_KIND));
        assertEquals(9, new Yatzy(buildDiceRolled(3, 3, 3, 3, 3)).score(CategoryEnum.THREE_OF_KIND));
        assertEquals(0, new Yatzy(buildDiceRolled(3, 3, 1, 3, 2)).score(CategoryEnum.FOUR_OF_KIND));
    }

    @Test
    void smallStraight() {
        assertEquals(15, new Yatzy(buildDiceRolled(1, 2, 3, 4, 5)).score(CategoryEnum.SMALL_STRAIGHT));
        assertEquals(15, new Yatzy(buildDiceRolled(2, 3, 4, 5, 1)).score(CategoryEnum.SMALL_STRAIGHT));
        assertEquals(0, new Yatzy(buildDiceRolled(2, 2, 3, 4, 5)).score(CategoryEnum.SMALL_STRAIGHT));
    }

    @Test
    void largeStraight() {
        assertEquals(20, new Yatzy(buildDiceRolled(6, 2, 3, 4, 5)).score(CategoryEnum.LARGE_STRAIGHT));
        assertEquals(20, new Yatzy(buildDiceRolled(2, 3, 4, 5, 6)).score(CategoryEnum.LARGE_STRAIGHT));
        assertEquals(0, new Yatzy(buildDiceRolled(1, 2, 2, 4, 5)).score(CategoryEnum.LARGE_STRAIGHT));
    }

   @Test
    void fullHouse() {
        assertEquals(18, new Yatzy(buildDiceRolled(6, 2, 2, 2, 6)).score(CategoryEnum.FULL_HOUSE));
        assertEquals(0, new Yatzy(buildDiceRolled(2, 3, 4, 5, 6)).score(CategoryEnum.FULL_HOUSE));
        assertEquals(0, new Yatzy(buildDiceRolled(2, 2, 2, 2, 6)).score(CategoryEnum.FULL_HOUSE));
    }
}
