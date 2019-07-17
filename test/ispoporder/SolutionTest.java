package ispoporder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1(){
        int[] pusha = {1,2,3,4,5};
        int[] pop1 = {4,5,3,2,1};
        int[] pop2 = {4,3,5,1,2};
        assertTrue(solution.IsPopOrder2(pusha, pop1));
        assertFalse(solution.IsPopOrder2(pusha,pop2));
    }

}