package tencent;

import java.util.Scanner;

public class Main4 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int day = in.nextInt();
        int[] scores = new int[day];
        for(int i = 0; i<day ; i++){
            scores[i] = in.nextInt();
        }

        int max = 0;
        for(int i=0; i< day; i++){
            for(int j=i; j<day; j++){
                int min = scores[i];
                int sum = scores[i];
                for(int m=i+1; m<=j; m++){
                    min = Math.min(min, scores[m]);
                    sum += scores[m];
                }
                max = Math.max(max, min*sum);

            }
        }

        System.out.println(max);
    }
}
