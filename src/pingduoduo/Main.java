package pingduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        String[] input1 = input.split(";");
        int n = Integer.parseInt(input1[1]);
        String[] input2 = input1[0].split(",");
        ArrayList<Integer> nums = new ArrayList<>();
//        Integer[] nums = new Integer[input2.length];
        for(int i=0; i<input2.length; i++){
//            nums[i] = Integer.parseInt(input2[i]);
            nums.add(Integer.parseInt(input2[i]));
        }
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if(o1%2 == 0 && o2%2 != 0){
                    return -1;
                }else if(o1%2 !=0 && o2%2 == 0){
                    return 1;
                }else {
                    return o2.compareTo(o1);
                }
            }
        });
        for(int i=0; i<n-1; i++){
            System.out.print(nums.get(i)+",");
        }
        System.out.print(nums.get(n-1));


    }
}
