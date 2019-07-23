package morethanhalfnum;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int MoreThanHalfNum_Solution(int[] array){
        Map<Integer,Integer> map = new HashMap<>();
        for(int a:array){
            if(map.containsKey(a)){
                map.put(a,(map.get(a)+1));
            }else {
                map.put(a,1);
            }
            if(map.get(a) > array.length/2){
                return a;
            }
        }

        return 0;
    }

    public int solution2(int[] array){
        if(array == null || array.length == 0){
            return 0;
        }
        int num = 0,
                label = array[0];
        for(int a:array){
            if(num == 0){
                label = a;
                num = 1;
                continue;
            }
            if(a == label){
                num ++;
            }else{
                num --;
            }
        }
        if(num > 0){
            num = 0;
            for(int a:array){
                if(a == label){
                    num++;
                }
            }
        }
        if(num > array.length/2){
            return label;
        }
        return 0;

    }

    public static void main(String[] args){
        int[] array = {1};
        int[] array1 = {1,2,2,3,4,2,2};
        Solution solution = new Solution();
        System.out.println(solution.MoreThanHalfNum_Solution(array));
        System.out.println(solution.solution2(array1));
    }
}
