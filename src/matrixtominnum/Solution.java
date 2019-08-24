package matrixtominnum;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    public String PringMinNumber(int[] numbers){
//        List<char[]> chars = new ArrayList<>();
//        for(int num:numbers){
//            chars.add(String.valueOf(num).toCharArray());
//        }
        ArrayList<String> list = new ArrayList<>();
//        Arrays.stream(numbers).forEach(list::add);
        for(int num:numbers){
            list.add(String.valueOf(num));
        }
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String s1 = o1 + o2;
                String s2 = o2 + o1;

                return s1.compareTo(s2);
            }
        });
        StringBuilder sb = new StringBuilder();
        for(String s: list){
            sb.append(s);
        }
        return sb.toString();
    }

    public static void main(String[] args){
        int[] nums = {3, 32, 321};
        Solution solution = new Solution();
        System.out.println(solution.PringMinNumber(nums));
    }
}
