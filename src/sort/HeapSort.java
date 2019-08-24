package sort;

import java.util.Arrays;

public class HeapSort {
    private static int leftChild(int i) {
        return i * 2 + 1;
    }

    private static <T extends Comparable<? super T>> void percDown(T[] a,int i, int n){
        int child;
        T tmp;

        for(tmp = a[i]; leftChild(i) < n; i = child){
            child = leftChild(i);
            if(child != n-1 && a[child].compareTo(a[child+1])<0){
                child++;
            }
            if(tmp.compareTo(a[child]) < 0){
                a[i] = a[child];
            }else{
                break;
            }
        }
        a[i] = tmp;
    }

    public static <T extends Comparable<? super T>> void heapsort(T[] a){
        for(int i = a.length/2 - 1; i>=0; i--){
            percDown(a,i,a.length);
        }
        for(int i = a.length -1; i>0; i--){
            QuickSort.swap(a,0, i);
            percDown(a, 0 ,i );
        }
    }

    public static void main(String[] args){
        Integer[] arr = {1,2,5,3,4};
        heapsort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
