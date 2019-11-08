package xiaohongshu;

import java.util.Scanner;

public class Main1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        StringBuilder result = new StringBuilder();
        char[] chars = input.toCharArray();
        int l = 0;
//        int r = 0;
        for(int i=0; i<chars.length; i++){
            if(l != 0) {
                if (chars[i] == '(') {
                    l++;
                }else if(chars[i] == ')'){
                    l--;
                }

            }else{
                if(chars[i] == '('){
                    l++;
                }else{
                    result.append(chars[i]);
                }
            }

        }
        char[] chars1 = result.toString().toCharArray();
        StringBuilder result1 = new StringBuilder();
//        for(int i=chars1.length - 1; i>=0; i--){
//            if(chars1[i] == '<'){
//                i= i-2;
//            }else {
//                result1.append(chars[i]);
//            }
//
//        }
//        System.out.println(result1.reverse());
        for(int i=0; i<chars1.length; i++){
            if(chars1[i] == '<'){
                if(result1.length() > 0) {
                    result1.deleteCharAt(result1.length() - 1);
                }
            }else{
                result1.append(chars[i]);
            }
        }
        System.out.println(result1.toString());



    }

}
