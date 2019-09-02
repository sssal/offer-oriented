package tencent;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
//        ArrayList<>
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            a[i] = in.nextInt();
            b[i] = in.nextInt();
        }
        for(int i=1; i<n; i++){
            for(int j=i; j>0; j--){
//                int tmpPre = a[j]*j + b[j] *(n-j-1) + a[j-1] * (j-1) + b[j-1] *(n-j);
//                int tmpAf = a[j] * (j-1) + b[j] * (n-j) + a[j-1] *j + b[j-1] * (n-j - 1);

//                if(tmpPre > tmpAf){
                if(a[j-1] - a[j] + b[j] - b[j-1] < 0 )    {
                    int tmpA = a[j];
                    int tmpB = b[j];
                    a[j] = a[j -1];
                    b[j] = b[j - 1];
                    a[j - 1] = tmpA;
                    b[j - 1] = tmpB;
                }else{
                    break;
                }

            }
        }

        int result = 0;
        for(int i=0; i<n; i++){
            result += a[i]*i + b[i]*(n-i-1);
        }
        System.out.println(result);
    }
}
