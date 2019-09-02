package pingduoduo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main4 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();

        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=1; i<=n; i++){
            for(int j=1; j<=m; j++){
                nums.add(i*j);
            }
        }
        Collections.sort(nums);
        System.out.println(nums.get(nums.size() - k));
    }
}
