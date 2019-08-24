package getleastnum;

import java.util.ArrayList;

public class Solution {
    public ArrayList<Integer> GetLeastNumber_Solution(int[] input, int k){
        ArrayList<Integer> integers = new ArrayList<>();
        for(int i = 1;i<input.length;i++){
            int temp = input[i];
            for(int j = i-1; j >= 0; j--) {

                if (temp < input[j]) {
                    input[j+1] = input[j];
                    input[j] = temp;
                }else{
                    break;
                }
            }
        }
        return integers;
    }

    public static void main(String[] args){
        int[] in = {4,5,1,6,2,7,3,8};
        Solution solution = new Solution();
        solution.GetLeastNumber_Solution(in,4);
    }
}
