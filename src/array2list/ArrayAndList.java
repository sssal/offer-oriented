package array2list;

import java.util.ArrayList;
import java.util.Arrays;
//import java.util.Collections;
import java.util.Collections;
import java.util.List;

public class ArrayAndList {
    public static void main(String[] args) {

        int[] arr = {1, 2, 3, 4, 5, 6};
        Integer[] arr1 = {1, 2, 34, 5, 6};
        Integer[] arr2 = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            arr2[i] = arr[i];
        }

        List<Integer> list = Arrays.asList(arr1);
        List<Integer> list1 = new ArrayList<>(Arrays.asList(arr1));
        List<Integer> list2 = new ArrayList<>();
        Collections.addAll(list2, arr1);
//        list2.
//    Collections.fill(list,arr1);
    }

}
