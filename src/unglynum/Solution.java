package unglynum;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int getUglyNumber(int index){
        int i = 1;
        while(index > 0){
            int temp = i;
            while(temp % 3 == 0){
                temp = temp / 3;
            }
            while(temp % 5 == 0){
                temp = temp / 5;
            }
            while (temp % 2 == 0) {
                temp = temp /2;
            }
            if(temp == 1){
                index --;
            }
            i++;

        }

        return i - 1;
    }

    public int getUglyNumber1(int index){
        int i2 = 0,
            i3 = 0,
            i5 = 0;
        int result = 1;
        List<Integer> list = new ArrayList<>();
        list.add(1);
        for(int i=1; i<index; i++){
            result = Integer.min(list.get(i2)*2, Integer.min(list.get(i3) * 3, list.get(i5)*5));
            list.add(result);
            if(result == list.get(i2)*2){
                i2++;
            }
            if (result == list.get(i3) * 3) {
                i3++;
            }
            if (result == list.get(i5) * 5) {
                i5++;
            }
        }
        return list.get(index-1);

    }

    public static void main(String[] args){
        Solution solution = new Solution();
        int index = 11;
        System.out.println(solution.getUglyNumber(index));
        System.out.println(solution.getUglyNumber1(index));
    }
}
