package reorderarray;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    private Solution solution;

    @Test
    public void test1(){
        assertEquals(new int[]{1,3,5,7,2,4,6,8},solution.reOrderArray(new int[]{1,2,3,4,5,6,7,8}));
    }

}