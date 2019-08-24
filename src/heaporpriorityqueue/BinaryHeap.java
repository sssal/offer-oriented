package heaporpriorityqueue;

import java.util.ArrayList;
import java.util.Arrays;


public class BinaryHeap {
    private static int leftChild(int parent){
        return parent*2+1;
    }


    public static <T extends Comparable<? super T>> void buildHeap(T[] arr){
        for(int i = (arr.length-1)/2; i>=0;i--){
            percolateDown(i,arr);
        }

    }

    public static <T extends Comparable<? super T>> void percolateDown(int cur, T[] arr){
        int childIndex;
        T tmp = arr[cur];
        for(;leftChild(cur)<arr.length;cur = childIndex){
            childIndex = leftChild(cur);
            if(childIndex + 1<arr.length && arr[childIndex].compareTo(arr[childIndex+1]) > 0){
                childIndex++;
            }
            if(arr[childIndex].compareTo(tmp) < 0){
                arr[cur] = arr[childIndex];
            }else{
                break;
            }
        }
        arr[cur] = tmp;

    }

    public static <T extends  Comparable<? super T>> T findMin(T[] arr){
        T min = arr[0];

        return min;
    }

    public static <T extends  Comparable<? super T>> T[] deleteMin(T[] arr){
        T min = arr[0];
        arr[0] = arr[arr.length -1];
        T[] arr1 = Arrays.copyOfRange(arr,0, arr.length - 1);
        arr = arr1;
        percolateDown(0, arr);

        return arr;
    }

    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(k>input.length || k<0){
            return list;
        }
        Integer[] inputInt = new Integer[input.length];
        for(int i = 0; i<input.length; i++){
            inputInt[i] = input[i];
        }
        buildHeap(inputInt);
        while(k>0){
            k--;
            list.add(findMin(inputInt));
            inputInt = deleteMin(inputInt);
        }

        return list;
    }

    public static void main(String[] args){
        int[] input = {4,5,1,6,2,7,3,8};
        System.out.println(GetLeastNumbers_Solution(input, 4));
    }
}
