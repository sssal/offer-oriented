package tencent;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nNums = new int[n];
        int[] mNums = new int[m];
        for (int i = 0; i < n; i++) {
            nNums[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            mNums[i] = in.nextInt();
        }
        int n1 =0;
        int n2 = 0;
        for(int i:nNums){
            if(i%2 == 0){
                n2++;
            }else{
                n1++;
            }
        }
        int m1 =0;
        int m2 = 0;
        for(int i:mNums){
            if(i%2 == 0){
                m2++;
            }else{
                m1++;
            }
        }

        int result = 0;
        result = Math.min(n1, m2) + Math.min(n2,m1);
        System.out.println(result);
    }
}
