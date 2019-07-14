package reorderarray;

public class Solution {

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
        int[] a2 = solution.reOrderArray(a);
        System.out.println(a2);
    }
}
