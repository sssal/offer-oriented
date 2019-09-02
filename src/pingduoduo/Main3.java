package pingduoduo;

import java.util.Arrays;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        int[] Xi = new int[num];
        for(int i=0; i<num; i++){
            Xi[i] = in.nextInt();
        }
        Arrays.sort(Xi);
        int max = Xi[0];
        int sum = 0;
        for(int i = max; i>0; i--){
            for(int j:Xi){
                if(j<=i) {
                    sum += i * (1.0 / j);
                }else{
//                    sum += i * (1.0 - )
                }
            }
        }
    }
}
