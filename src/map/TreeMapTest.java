package map;


import java.util.*;

public class TreeMapTest {
    public static void main(String[] args) {
        String s1 = "Hello Java";
        String s2 = s1;
        s1.toUpperCase();
        s2.toLowerCase();
        System.out.println(s1);
        System.out.println(s2);


        TreeMap<String, ArrayList<Integer>> treeMap = new TreeMap<>(

        );
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr.add(1);
        treeMap.put("a", arr);
        ArrayList<Integer> arr1 = new ArrayList<Integer>();
        arr1.add(2);
        treeMap.put("b", arr1);
        ArrayList<Integer> arr2 = new ArrayList<Integer>();

//        Arrays.asList(new int[]{4});
        arr2.add(3);
        Integer[] integers = arr2.toArray(new Integer[]{});
        System.out.println(Arrays.toString(integers));
        treeMap.put("c", arr2);
//        Integer[] arr3 = {4};
        treeMap.put("e", new ArrayList<>(Arrays.asList(4)));
        treeMap.put("d", new ArrayList<>(Arrays.asList(5)));
        Set<Map.Entry<String, ArrayList<Integer>>> mapEntries = treeMap.entrySet();
        List<Map.Entry<String, ArrayList<Integer>>> list = new ArrayList<>(mapEntries);
        Collections.sort(list, new Comparator<Map.Entry<String, ArrayList<Integer>>>() {
            @Override
            public int compare(Map.Entry<String, ArrayList<Integer>> o1, Map.Entry<String, ArrayList<Integer>> o2) {
                return 0;
            }
        });


//        System.out.println(list);
//        Map.Entry<String, ArrayList<Integer>>[] entries = mapEntries.toArray(new Map.Entry<String, ArrayList<Integer>>[0]);
        System.out.println(mapEntries.toArray());
        Set<String> sets = treeMap.keySet();
        String[] strings = sets.toArray(new String[0]);

        //java.lang.ClassCastException
        String[] strings1 = (String[]) sets.toArray();

        System.out.println(treeMap.keySet());
        System.out.println(treeMap.values());
        System.out.println(treeMap.entrySet());

    }


}
