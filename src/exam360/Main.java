package exam360;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int arrLen = in.nextInt();
        int[] arr = new int[arrLen];
        for (int i = 0; i < arrLen; i++) {
            arr[i] = in.nextInt();
        }
        int result = 0;
        boolean[] sym = new boolean[len+1];
        for(int i=1; i<len+1; i++){
            sym[i] = sub(len, arr, i, 0);
            if(sym[i] == true){
                result++;
            }
        }
        System.out.println(result);

    }

    public static boolean sub(int len, int[] arr, int start, int arrIndex){
        if(arrIndex == arr.length - 1){
            int tmp = arr[arrIndex];
            if(start + tmp <= len || start - tmp >0){
                return true;
            }else{
                return false;
            }
        }else{
            int tmp = arr[arrIndex];
            if(start+tmp <=len && start - tmp >0){
                return sub(len, arr, start+tmp, arrIndex+1)
                        || sub(len, arr, start - tmp, arrIndex + 1);

            }else if(start + tmp <= len){
                return sub(len, arr, start + tmp, arrIndex + 1);
            }else if(start - tmp > 0){
                return sub(len, arr, start-tmp, arrIndex+1);
            }else{
                return false;
            }
        }
    }
}
