package permutation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    ArrayList<String> strings = new ArrayList<>();

    public ArrayList<String> Permutation(String str) {
        char[] chars = str.toCharArray();
//        Arrays.sort(chars);
        recursive(chars,0);
        Collections.sort(strings);
        return strings;

    }

    private void recursive(char[] chars, int i){
        if(chars.length - i == 1){
            strings.add(new String(chars));
        }else{
            Set<Character> charSet = new HashSet<>();
            for(int j = i;j<chars.length;j++){
                if(!charSet.contains(chars[j])) {
                    charSet.add(chars[j]);
                    char[] temp = chars.clone();
                    swap(temp, i, j);
                    recursive(temp, i + 1);
                }
            }
        }
    }

    private void swap(char[] chars, int i, int j){
        char temp = chars[j];
        chars[j] = chars[i];
        chars[i] = temp;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        ArrayList<String> strings = solution.Permutation("cba");
        for(String str: strings){
            System.out.println(str);
        }
    }
}
