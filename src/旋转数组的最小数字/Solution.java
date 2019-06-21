package 旋转数组的最小数字;

import java.util.ArrayList;

public class Solution {
    public int minNumberInRotateArray(int[] array){
        int length = array.length;
        int min;
        if(length==0){
            return 0;
        }else{
            int pre=array[length-1];
            int now;
            for(int i = length-2; i >= 0; i--){
                now = array[i];
                if(now > pre)
                    break;
                else
                    pre = now;
            }
            min = pre;
        }

        return min;
    }

    public int minNumberInRotateArrayDichotomize(int[] array){
        if (array == null || array.length == 0) {
            return 0;
        }else {
            int length = array.length;

            int left, right, mid;

            left = 0;
            right = length-1;
            mid = (left + right)/2;

            while(left!=right-1){

                if(array[mid]>=array[left]&&array[mid]>=array[right]){
                    left = mid;
                }else if (array[mid]<=array[left]&&array[mid]<=array[right]){
                    right = mid;
                }else{
                    System.out.println("wrong");
                }
                mid = (left + right)/2;
            }

            return array[right];

        }
    }


    public static void main(String[] args){
        int[] arrays1 = {3,4,5,1,2};
        int[] arrays4 = {3,4,5,2,2,2};
        int[] arrays2 = {};
        int[] arrays3 = {2,1};
        System.out.println(new Solution().minNumberInRotateArrayDichotomize(arrays4));
    }
}
