package jinji;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {


        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < chars.length; i++){
            if(hashMap.containsKey(chars[i])){
                int tmp = hashMap.get(chars[i]);
                hashMap.put(chars[i], tmp+1);
            }else{
                hashMap.put(chars[i], 1);
            }
        }
        for(char c = 'Z'; c>='A'; c--){
            if(hashMap.containsKey(c)){
                int tmp = hashMap.get(c);
                if(tmp>=3 &&tmp<=5){
                    result.append(c);
                }
            }
        }
        if(result.length() == 0){
            System.out.println("no");
        }else{
            System.out.println(result);
        }


    }
}
