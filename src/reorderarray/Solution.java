package reorderarray;

import java.util.Arrays;

public class Solution {
    public int[] reOrderArrayInsert(int[] array){
        int odd = 0;
        for(int i = 0; i < array.length; i++){
            if((array[i] & 1) == 0 ){
                continue;
            }else{
                odd++;
            }
            for(int j = i; j >= odd; j--){
                int temp = array[j-1];
                array[j-1] = array[j];
                array[j] = temp;
            }
        }

        return array;
    }

    public int[] reOrderArray(int[] array){
        int length = array.length;
        int[] newArr = new int[length];

        int start = 0, end = length;
        for(int a:array){
            if((a&1) == 1){
                newArr[start] = a;
                start++;
            }
        }
        for(int a:array){
            if((a&1) == 0){
                newArr[start] = a;
                start++;
            }
        }

        array = newArr;

        return array;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int[] a = {1,2,3,4,5,6,7,8};
        int[] a2 = solution.reOrderArrayInsert(a);
        System.out.println(Arrays.toString(a2));
    }
}
