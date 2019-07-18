package verifysquenceofbst;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SolutionTest {
    Solution solution = new Solution();

    @Test
    public void test1(){
        int[] seq = {1,3,2,5,8,10,9,7,6};
        int[] seq1 = {4,2,6,5,3,1};
        assertTrue(solution.VerifySquenceOfBST1(seq));
        assertFalse(solution.VerifySquenceOfBST1(seq1));
    }

}