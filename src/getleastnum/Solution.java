package getleastnum;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> result = new ArrayList<>();
        if (k > input.length || k < 0) {
            return result;
        }
        for (int i = 0; i < k; i++) {
            int index = i;
            for (int j = i + 1; j < input.length; j++) {
                if (input[j] < input[index]) {
                    index = j;
                }
            }
            int temp = input[i];
            input[i] = input[index];
            input[index] = temp;
            result.add(input[i]);
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 1, 6, 2, 7, 3, 8};
        Solution solution = new Solution();
        System.out.println(solution.GetLeastNumbers_Solution(arr, 4));
    }
}
