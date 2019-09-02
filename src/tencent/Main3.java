package tencent;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] nNums = new int[n+1];
        int nsum = 0;
        for(int i= 1; i<=n; i++){
            nNums[i] = in.nextInt();
            nsum +=nNums[i];
        }
        int[] mNums = new int[n+1];
        mNums[0] = m;
        int[] has = new int[n+1];
        int time = 0;
        while(nsum >0){
            time++;


        }

        System.out.println();
    }
}
