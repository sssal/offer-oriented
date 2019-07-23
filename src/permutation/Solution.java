package permutation;

import java.util.*;

public class Solution {
    private ArrayList<String> strings = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
        recursive(chars, 0);
        Collections.sort(strings);
        return strings;

    }

    private void recursive(char[] chars, int i) {
        if (chars.length - i == 1) {
            strings.add(new String(chars));
        } else {
            Set<Character> charSet = new HashSet<>();
            for (int j = i; j < chars.length; j++) {
                if (!charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    char[] temp = chars.clone();
                    swap(temp, i, j);
                    recursive(temp, i + 1);
                }
            }
        }
    }

    private void swap(char[] chars, int i, int j) {
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }

    public ArrayList<String> PerMutationNoRecursive(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals("")) {
            return new ArrayList<String>();
        }
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        ArrayList<String> strings = new ArrayList<>();
        strings.add(new String(chars));
        while (true) {
            int i;
            int llabel = -1;
            for (i = chars.length - 1; i > 0; i--) {
                if (chars[i] > chars[i - 1]) {
                    llabel = i - 1;
                    break;
                }
            }
            if (llabel == -1) {
                break;
            }
            int j = chars.length - 1;
            while (chars[j] <= chars[llabel]) {
                j--;
            }
            int rlabel = j;
            char temp = chars[llabel];
            chars[llabel] = chars[rlabel];
            chars[rlabel] = temp;
            for (int l = llabel + 1, r = chars.length - 1; l <= r; l++, r--) {
                temp = chars[l];
                chars[l] = chars[r];
                chars[r] = temp;
            }

            strings.add(new String(chars));
        }

        return strings;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ArrayList<String> strings = solution.PerMutationNoRecursive("");
        for (String str : strings) {
            System.out.println(str);
        }


    }
}
