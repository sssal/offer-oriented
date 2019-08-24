package sort;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class QuickSort {
    private static final int CUTOFF = 10;

    public static void quickSortMini(Integer[] items){
        int[] ints = {1,2};
//        int[] ints1 = new int[]{};
        Integer[] integers = new Integer[]{};
//        List<Integer> integers =  Arrays.asList(ints);
        List<Integer> arrayList = new ArrayList<>();
        List<Integer> integerList = Arrays.asList(integers);
        List<Integer> itemList = new ArrayList<>(Arrays.asList(items));
        List<Integer> integerList1 = new ArrayList<>(integerList);

        Collections.addAll(arrayList,integers);

        if(integerList.getClass() == itemList.getClass()){
            System.out.println(true);
        }
        if(integerList1.getClass() == itemList.getClass()){
            System.out.println(true);
            System.out.println(integerList.getClass());
            System.out.println(integerList1.getClass());
            System.out.println(itemList.getClass());
        }
        quickSortMini(itemList);
        items = itemList.toArray(items);
    }

    public static void quickSortMini(List<Integer> items){
        if(items.size() > 1){
            List<Integer> smaller = new ArrayList<>();
            List<Integer> same = new ArrayList<>();
            List<Integer> larger = new ArrayList<>();

            int pivot = items.get(0);
            for(int i : items){
                if(i < pivot){
                    smaller.add(i);
                }else if(i == pivot){
                    same.add(i);
                }else{
                    larger.add(i);
                }
            }

            quickSortMini(smaller);
            quickSortMini(larger);

            items.clear();
            items.addAll(smaller);
            items.addAll(same);
            items.addAll(larger);
        }

    }
    public static <T extends Comparable<? super T>> void quickSort(T[] a) {
        quickSort(a, 0, a.length - 1);
    }

    private static <T extends Comparable<? super T>> void quickSort(T[] a, int left, int right) {
        if (left + CUTOFF > right) {
            T pivot = median3(a, left, right);
            int i = left + 1, j = right - 2;
            while (i < j) {
                while (a[i].compareTo(pivot) < 0) {
                    i++;
                }
                while (a[j].compareTo(pivot) > 0) {
                    j--;
                }
                if (i < j) {
                    swap(a, i, j);
                }
            }
            swap(a, i, right - 1);
            quickSort(a, left, i - 1);
            quickSort(a, i + 1, right);


        } else {
            insertSort(a, left, right);
        }
    }

    /**
     * @return pivot
     */
    private static <T extends Comparable<? super T>> T median3( T[] a, int left, int right) {
        int center = (left + right) / 2;

        if (a[left].compareTo(a[center]) > 0) {
            swap(a, left, center);
        }
        if (a[left].compareTo(a[right]) > 0) {
            swap(a, left, right);
        }
        if (a[center].compareTo(a[right]) > 0) {
            swap(a, center, right);
        }

        swap(a, center, right - 1);
        return a[right - 1];
    }

    public static <T extends Comparable<? super T>> void swap( T[] a, int index1, int index2) {
        T temp = a[index1];
        a[index1] = a[index2];
        a[index2] = temp;
    }

    public static <T extends Comparable<? super T>> void insertSort(T[] a){
        insertSort(a, 0, a.length -1);
    }
    private static <AnyType extends Comparable<? super AnyType>> void insertSort(AnyType[] a,int left, int right) {
        for(int i = left + 1; i<=right; i++){
            AnyType temp = a[i];
            int j;
            for(j = i; j> left; j--){
                if(temp.compareTo(a[j-1]) < 0){
                    a[j] = a[j-1];
                }else{
                    break;
                }
            }
            a[j] = temp;
        }
    }

    public static void main(String[] args){
        QuickSort quickSort = new QuickSort();
        Integer[] ints = {3,5,1,2,5,6};
        Integer[] integers = {1,3,5,8,4,34,4,3,64,3,7,6,8,63,12,43,46,3,12,4,56,34,6,8,23,4,6,22};
        insertSort(ints);
//        quickSort(integers);
        quickSortMini(integers);

        System.out.println(Arrays.toString(ints));
        System.out.println(Arrays.toString(integers));


    }

}
