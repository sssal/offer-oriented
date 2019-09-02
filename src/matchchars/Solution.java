package matchchars;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
//        char[] pattern = {'b','*', 'c', '*'};
//        System.out.println(matchNull(pattern, 0));


        Scanner in = new Scanner(System.in);
        String str = in.nextLine();
        char[] chars = str.toCharArray();
        String pattern = in.nextLine();
        char[] patterns = pattern.toCharArray();
//        System.out.println(chars.length);
//        System.out.println(pattern.length());

        System.out.println(match(chars, patterns));

    }

    public static boolean match(char[] str, char[] pattern) {
        if (pattern == null && str != null) {
            return false;
        }
        if (str == null && pattern == null) {
            return true;
        }


        return match(str, 0, pattern, 0);
    }

    public static boolean match(char[] str, int i, char[] pattern, int j) {
        if (j >= pattern.length) {
            if (str == null || i >= str.length) {
                return true;
            } else {
                return false;
            }
        }
        if (str == null || i >= str.length) {
            if (j + 1 < pattern.length) {
                if (pattern[j + 1] == '*') {
                    return match(str, i, pattern, j + 2);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        } else {
            if (j + 1 < pattern.length) {
                if (pattern[j + 1] == '*') {
                    if (str[i] == pattern[j] || pattern[j] == '.') {
                        return match(str, i, pattern, j + 2) || match(str, i + 1, pattern, j);
                    } else {
                        return match(str, i, pattern, j + 2);
                    }
                } else {
                    if (str[i] == pattern[j] || pattern[j] == '.') {
                        return match(str, i + 1, pattern, j + 1);
                    } else {
                        return false;
                    }
                }
            } else {
                if (str[i] == pattern[j] || pattern[j] == '.') {
                    return match(str, i + 1, pattern, j + 1);
                } else {
                    return false;
                }
            }
        }

    }

//    public static boolean matchNull(char[] pattern, int start){
//
//        Character tmp = null;
//        for(int i = start; i<pattern.length; i++){
//            char c = pattern[i];
//            if(c == '.'){
//                return false;
//            }else{
//                i++;
//                c = pattern[i];
//                if(c != '*'){
//                    return false;
//                }
//            }
//
//        }
//        return true;
//    }
}
