package firstnotrepeatchar;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int FirstNotRepeatingChar(String str){
        char[] chars = str.toCharArray();
        Map<Character, Integer> maps = new HashMap<>();
        for(int i=0; i<chars.length; i++){
            if(!maps.containsKey(chars[i])){
                maps.put(chars[i], i);
            }else{
                maps.put(chars[i], -1);
            }
        }
        int result = -1;
        for(Character c:maps.keySet()){
            if(maps.get(c) != -1){
                if(result == -1){
                    result = maps.get(c);
                }else{
                    result = result < maps.get(c)?result: maps.get(c);
                }
            }
        }

        return  result;
    }

    public static void main(String[] args){
        Solution solution = new Solution();
        String str = "asdgadsafdsgdsasfr";
        System.out.println(solution.FirstNotRepeatingChar(str));
    }
}
