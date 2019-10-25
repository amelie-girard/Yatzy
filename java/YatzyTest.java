import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class YatzyTest {

    @Test
    public void chance_scores_sum_of_all_dice() {
        int expected = 15;
        Yatzy yatzy_1 = new Yatzy(2,3,4,5,1);
        int actual = yatzy_1.chance();
        assertEquals(expected, actual);
        Yatzy yatzy_2 = new Yatzy(3,3,4,5,1);
        assertEquals(16, yatzy_2.chance());
    }


    @Test public void yatzy_scores_50() {
        int expected = 50;
        int actual = new Yatzy(4,4,4,4,4).yatzy();
        assertEquals(expected, actual);
        assertEquals(50, new Yatzy(6,6,6,6,6).yatzy());
        assertEquals(0,new Yatzy(6,6,6,6,3).yatzy());
    }

    @Test public void test_1s() {
        assertTrue(new Yatzy(1,2,3,4,5).ones() == 1);
        assertEquals(2, new Yatzy(1,2,1,4,5).ones());
        assertEquals(0,new Yatzy(6,2,2,4,5).ones());
        assertEquals(4, new Yatzy(1,2,1,1,1).ones());
    }

    @Test
    public void test_2s() {
        assertEquals(4, new Yatzy(1,2,3,2,6).twos());
        assertEquals(10,new Yatzy(2,2,2,2,2).twos());
    }

    @Test
    public void test_threes() {
        assertEquals(6,new Yatzy(1,2,3,2,3).threes());
        assertEquals(12, new Yatzy(2,3,3,3,3).threes());
    }

    @Test
    public void fours_test()
    {
        assertEquals(12, new Yatzy(4,4,4,5,5).fours());
        assertEquals(8, new Yatzy(4,4,5,5,5).fours());
        assertEquals(4, new Yatzy(4,5,5,5,5).fours());
    }

    @Test
    public void fives() {
        assertEquals(10, new Yatzy(4,4,4,5,5).fives());
        assertEquals(15, new Yatzy(4,4,5,5,5).fives());
        assertEquals(20, new Yatzy(4,5,5,5,5).fives());
    }

    @Test
    public void sixes_test() {
        assertEquals(0, new Yatzy(4,4,4,5,5).sixes());
        assertEquals(6, new Yatzy(4,4,6,5,5).sixes());
        assertEquals(18, new Yatzy(6,5,6,6,5).sixes());
    }

    @Test
    public void one_pair() {
        assertEquals(6, new Yatzy(3,4,3,5,6).score_pair());
        assertEquals(10, new Yatzy(5,3,3,3,5).score_pair());
        assertEquals(12, new Yatzy(5,3,6,6,5).score_pair());
        assertEquals(0, new Yatzy(1,2,3,4,5).score_pair());
    }

    @Test
    public void two_Pair() {
        assertEquals(16,new Yatzy(3,3,5,4,5).twoPairs());
        assertEquals(16, new Yatzy(3,3,5,5,5).twoPairs());
    }

    @Test
    public void three_of_a_kind()
    {
        assertEquals(9, new Yatzy(3,3,3,4,5).threeOfaKind());
        assertEquals(15, new Yatzy(5,3,5,4,5).threeOfaKind());
        assertEquals(9, new Yatzy(3,3,3,3,5).threeOfaKind());
        assertEquals(0, new Yatzy(1,3,2,3,5).threeOfaKind());
    }

    @Test
    public void four_of_a_knd() {
        assertEquals(12, new Yatzy(3,3,3,3,5).fourOfaKind());
        assertEquals(20, new Yatzy(5,5,5,4,5).fourOfaKind());
        assertEquals(9, new Yatzy(3,3,3,3,3).threeOfaKind());
    }

    @Test
    public void smallStraight() {
        assertEquals(15, new Yatzy(1,2,3,4,5).smallStraight());
        assertEquals(15, new Yatzy(2,3,4,5,1).smallStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).smallStraight());
    }

    @Test
    public void largeStraight() {
        assertEquals(20, new Yatzy(6,2,3,4,5).largeStraight());
        assertEquals(20, new Yatzy(2,3,4,5,6).largeStraight());
        assertEquals(0, new Yatzy(1,2,2,4,5).largeStraight());
    }

    @Test
    public void fullHouse() {
        assertEquals(18, new Yatzy(6,2,2,2,6).fullHouse());
        assertEquals(0, new Yatzy(2,3,4,5,6).fullHouse());
        assertEquals(0, new Yatzy(2,2,2,2,6).fullHouse());
    }
}
