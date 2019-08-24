package sort;

import java.util.Arrays;

public class MergeSort {
    int reverseOrder = 0;

    private static <T extends Comparable<? super T>>
    void mergeSort(T[] a, T[] tmpArray, int left, int right, int reverseOrder) {
        if (left < right) {
            int center = (left + right) / 2;
            mergeSort(a, tmpArray, left, center, reverseOrder);
            mergeSort(a, tmpArray, center + 1, right, reverseOrder);
            merge(a, tmpArray, left, center + 1, right, reverseOrder);
        }
    }

    public static <T extends Comparable<? super T>>
    int mergeSort(T[] a) {
        T[] tmpArray = (T[]) new Comparable[a.length];
        int reverseOrder = 0;
        mergeSort(a, tmpArray, 0, a.length - 1, reverseOrder);
        return reverseOrder;
    }

    private static <T extends Comparable<? super T>>
    void merge(T[] a, T[] tmpArray, int leftPos, int rightPos, int rightEnd,
               int reverseOrder) {
        int leftEnd = rightPos - 1;
        int tmpPos = leftPos;
        int numElements = rightEnd - leftPos + 1;

        while (leftPos <= leftEnd && rightPos <= rightEnd) {
            if (a[leftPos].compareTo(a[rightPos]) <= 0) {
                tmpArray[tmpPos++] = a[leftPos++];
            } else {
                reverseOrder += leftEnd - leftPos + 1;
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

    public static void main(String[] args) {
        Integer[] arr = {1, 4, 7, 2, 5, 8, 3, 6, 9};
        int num = mergeSort(arr);
        System.out.println(Arrays.toString(arr));
        System.out.println(num);
    }
}

class Solution {


}