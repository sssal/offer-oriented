package isBTree;
import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String nums = in.nextLine();
        if(nums.equals("None")){
            System.out.println("True");
        }else{String[] str = nums.split(",");
            int[] ints = new int[str.length];
            for(int i=0; i<str.length;i++){
                ints[i] = Integer.parseInt(str[i]);
            }
            if(isBT(ints)){
                System.out.println("True");
            }else{
                System.out.println("False");
            }
        }
    }

    public static boolean isBT(int[] arr){
        int i = arr.length/2 - 1;
        for(;i>=0;i--){
            if(arr[i] > arr[left(i)] && arr[i] <arr[right(i)]){
                if(i%2 == 0){
                    arr[i] = arr[left(i)];
                }else{
                    arr[i] = arr[right(i)];
                }
            }else{
                return false;
            }
        }
        return true;
    }

    public static int left(int p){
        return p*2+1;
    }

    public static int right(int p){
        return p*2+2;
    }
}
