package jinji;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String a = in.nextLine();
        String b = in.nextLine();
        StringBuilder result = new StringBuilder();
        int addvence = 0;
        if(a.length()<b.length()){
            String tmp = a;
            a = b;
            b = tmp;
        }
        int lasta = a.length() - 1;
        int lastb = b.length() - 1;
        while(lastb >=0){
            if(a.charAt(lasta) == '0' && b.charAt(lastb) == '0'){
                if(addvence == 0){
                    result.append("0");
                }else {
                    result.append("1");
                    addvence = 0;
                }
            }else if(a.charAt(lasta) == '0' && b.charAt(lastb) == '1'){
                if(addvence == 0){
                    result.append("1");
                }else {
                    result.append("0");
                    addvence = 1;
                }
            }else if(a.charAt(lasta) == '1' && b.charAt(lastb) == '0'){
                if(addvence == 0){
                    result.append("1");
                }else {
                    result.append("0");
                    addvence = 1;
                }
            }else if(a.charAt(lasta) == '1' && b.charAt(lastb) == '1'){
                if(addvence == 0){
                    result.append("0");
                    addvence = 1;
                }else {
                    result.append("1");
                    addvence = 1;
                }
            }
            lastb--;
            lasta--;

        }
        while(lasta >=0){
            if(addvence == 1){
                if(a.charAt(lasta) == '1'){
                    result.append("0");
                    addvence = 1;
                }else{
                    result.append("1");
                    addvence = 0;
                }
            }else {
                result.append(a.charAt(lasta));
            }
            lasta--;
        }
        if(addvence == 1){
            result.append("1");
        }
        System.out.println(result.reverse());
    }
}
