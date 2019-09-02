package sort;

import java.util.Scanner;

public class JDsolution {
    static int reverseOrder = 0;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        Integer[] nums = new Integer[len];
        Integer[] tmpA = new Integer[len];
        for (int i = 0; i < len; i++) {
            int tmp = in.nextInt();
            nums[i] = tmp;
            tmpA[i] = tmp;
        }
        mergeSort(nums);
        for(int i = 0;i<len; i++){
            int tmp = 0;
            if(tmpA[i].equals(nums[i])){
                if(i - tmp > 1) {
                    reverseOrder+= 2;
                }else{
                    reverseOrder++;
                }

            }

        }

        System.out.println(reverseOrder);
    }


    private static <T extends Comparable<? super T>>
    void mergeSort(T[] a, T[] tmpArray, int left, int right) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center);
            mergeSort(a, tmpArray, center + 1, right);
            merge(a, tmpArray, left, center + 1, right);
        }
    }

    public static <T extends Comparable<? super T>>
    int mergeSort(T[] a) {
        T[] tmpArray = (T[]) new Comparable[a.length];
        int reverseOrder = 0;
        mergeSort(a, tmpArray, 0, a.length - 1);
        return reverseOrder;
    }

    private static <T extends Comparable<? super T>>
    void merge(T[] a, T[] tmpArray, int leftPos, int rightPos, int rightEnd
               ) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {

                tmpArray[tmpPos++] = a[rightPos++];
            }
        }

        while (leftPos <= leftEnd) {
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd) {
            tmpArray[tmpPos++] = a[rightPos++];
        }

        for (int i = 0; i < numElements; i++, rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }

    }
}
