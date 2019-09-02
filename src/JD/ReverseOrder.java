package JD;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ReverseOrder {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int len = in.nextInt();
        int[] arr = new int[len];
        int[] tmp = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = in.nextInt();
            tmp[i] = arr[i];
        }

        Arrays.sort(tmp);
        System.out.println(Arrays.toString(tmp));
        System.out.println(Arrays.toString(arr));
//        int[] integers =null;
//        System.out.println(integers.length);
//
//        String s1 = null;
//        String s2 = null;
//        System.out.println(s1.equals(s2));
        Map map1 = new HashMap();
        Map map2 = new HashMap();
        int result = 0;
        for (int i = 0; i < len; i++) {
            if (map1.containsKey(arr[i])) {
                map1.put(arr[i], (int) map1.get(arr[i]) + 1);
            } else {
                map1.put(arr[i], 1);
            }
            if (map2.containsKey(tmp[i])) {
                map2.put(tmp[i], (int) map1.get(tmp[i]) + 1);
            } else {
                map2.put(tmp[i], 1);
            }
            if (map1.equals(map2)) {
                result++;
                map1.clear();
                map2.clear();
            }
        }
        System.out.println(result);
//        System.out.println(reverseOrderGroup1(arr));


    }

    public static int reverseOrderGroup1(int[] arr) {
        int groupNum = 0;
        int len = arr.length;
        int[] m_min = new int[len];
        Arrays.fill(m_min, Integer.MAX_VALUE);
        for (int i = len - 2; i >= 0; i--) {
            m_min[i] = Math.min(arr[i + 1], m_min[i + 1]);
        }
        int m_max = -1;
        for (int i = 0; i < len; i++) {
            if (arr[i] > m_max) {
                m_max = arr[i];
            }
            if (m_max < m_min[i]) {
                groupNum++;
                m_max = -1;
            }
        }
        return groupNum;
    }

    public static int reverseOrderGroup(int[] arr) {
        int groupNum = 0;
        int len = arr.length;


        int start = 0;
        while (start < len) {
            int min = arr[start];
            int min_index = start;
            for (int i = start; i < len; i++) {
                if (arr[i] < min) {
                    min = arr[i];
                    min_index = i;
                }
            }
            while (start < len) {
                int max = min;
                int max_index = min_index;
                for (int j = min_index - 1; j >= start; j--) {
                    if (arr[j] >= max) {
                        max = arr[j];
                        max_index = j;
                    }
                }

                int tmp_index = -1;
                for (int k = min_index + 1; k < len; k++) {
                    if (arr[k] < max) {
                        tmp_index = k;
                    }
                }
                if (tmp_index == -1) {
                    groupNum++;
                    start = min_index + 1;
                    break;
                } else {
                    min = arr[tmp_index];
                    start = min_index + 1;
                    if (start > len) {
                        groupNum++;
                    }
                    min_index = tmp_index;

                }
            }

        }
        return groupNum;
    }
}
