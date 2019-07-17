package ispoporder;

import java.util.ArrayList;
import java.util.Arrays;

public class Solution {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int left = -1, right = -1;

        int length = pushA.length;

        for (int a : popA) {
            int index = -2;
            for (int j = 0; j < pushA.length; j++) {
                if (pushA[j] == a) {
                    index = j;
                    break;
                }
            }
            if (index == -2) {
                return false;
            }
            if (left == -1 && right == -1) {
                left = (index - 1) >= 0 ? index - 1 : -1;
                right = (index + 1) < length ? index + 1 : -1;
            } else {
                if (index == left) {
                    left = (index - 1) >= 0 ? index - 1 : -1;
                } else if (index == right) {
                    right = (index + 1) < length ? index + 1 : -1;
                } else {
                    return false;
                }

            }
        }

        return true;
    }


    public boolean IsPopOrder1(int[] pushA, int[] popA) {
        int length = popA.length;
        if (length == 0)
            return true;
        if (length == 1)
            return popA[0] == pushA[0];
        int i;
        for (i = 0; i < popA.length; i++) {
            if (popA[i] == pushA[0])
                break;
        }
        return IsPopOrder1(Arrays.copyOfRange(pushA, 1, i + 1), Arrays.copyOfRange(popA, 0, i)) &&
                IsPopOrder1(Arrays.copyOfRange(pushA, i + 1, length), Arrays.copyOfRange(popA, i + 1, length));
    }

    public boolean IsPopOrder2(int[] pushA, int[] popA) {
        ArrayList<Integer> stack = new ArrayList<>();
        int pop = 0;
        int push = -1;
        for (int a : pushA) {
            stack.add(a);
            push++;
            while (!stack.isEmpty() && popA[pop] == stack.get(push)) {
                stack.remove(push);
                push--;
                pop++;
            }
        }

        return push == -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] pushA = {1, 2, 3, 4, 5};
        int[] popA = {4, 5, 3, 2, 1};
        System.out.println(solution.IsPopOrder2(pushA, popA));
    }
}
