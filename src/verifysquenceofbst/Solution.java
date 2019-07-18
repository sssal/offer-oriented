package verifysquenceofbst;

import java.util.Arrays;

public class Solution {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence.length == 0) {
            return false;
        }
        if (sequence.length <= 2) {
            return true;
        }

        int length = sequence.length;
        int root = sequence[length - 1];
        int index = 0;
        for (; index < length - 1; index++) {
            if (sequence[index] > root) {
                break;
            }
        }
        int interval = index;
        for (; index < length - 1; index++) {
            if (sequence[index] < root) {
                return false;
            }
        }
        if (interval == 0) {
            return VerifySquenceOfBST(Arrays.copyOfRange(sequence, interval, length - 1));
        }
        if (interval == length - 1) {
            return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, length - 1));
        }
        return VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, interval))
                && VerifySquenceOfBST(Arrays.copyOfRange(sequence, interval, length - 1));
    }

    public boolean VerifySquenceOfBST1(int[] sequence) {
        int length = sequence.length;

        if (length == 0) {
            return false;
        }

        int i = 0;
        while (length > 2) {
            while (sequence[i] < sequence[length - 1]) {
                i++;
            }
            while (sequence[i] > sequence[length - 1]) {
                i++;
            }
            if (i < length - 1) {
                return false;
            }
            length--;
            i = 0;

        }

        return true;
    }

}
