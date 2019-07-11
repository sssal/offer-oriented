package fastpower;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution = new Solution();

    @Test
    public void test1() {
        assertEquals(solution.Power(1, 2), Math.pow(1, 2));
    }

    @Test
    public void test2() {
        assertEquals(solution.Power(-1, 2), Math.pow(-1, 2));
    }

    @Test
    public void test3() {
        assertEquals(solution.Power(-1, -2), Math.pow(-1, -2));
    }

    @Test
    public void test4() {
        assertEquals(solution.Power(-1, -5), Math.pow(-1, -5));
    }

    @Test
    public void test5() {
        assertEquals(solution.Power(-1, 0), Math.pow(-1, 0));
    }

    @Test
    public void test() {
        assertEquals(Math.pow(-1, 0), solution.Power(-1, 0));
    }

    @Test
    public void testBaseZero() {
        assertEquals(Math.pow(0, 0), solution.Power(0, 0));
    }

    @Test
    public void testBaseZero1() {
        assertEquals(Math.pow(0, 2), solution.Power(0, 2));
    }

    @Test
    public void testBaseZero2() {
        assertEquals(Math.pow(0, -2), solution.Power(0, -2));
    }

    @Test
    public void test6() {
        assertEquals(Math.pow(2, -3), solution.Power(2, -3));
    }
}