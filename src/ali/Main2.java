package ali;

import java.util.HashMap;
import java.util.Scanner;

public class Main2 {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static String getIndexAndLongest(String userss, int k) {
//        String[] girls = users.split("b");
//        System.out.println(Arrays.toString(girls));

        HashMap<Integer, Integer> boyhasgirl = new HashMap<>();
        int maxboy = -1;
        int maxhasgirl = 0;
        char[] users = userss.toCharArray();
        int len = users.length;
        int pre = 0;
        int af = 0;
        int boy = -1;
        for(int i=len-1; i>0; i--){
            if(users[i] == 'g'){
                pre++;
            }else{
                break;
            }
        }
        for(int i = 0; i<len-1; i++){
            if(users[i] == 'b'){
                if(boy != -1){
                    boyhasgirl.put(boy, pre+af);
                    if(pre+af > maxhasgirl){
                        maxhasgirl = pre+af;
                        maxboy = boy;
                    }
                    pre = af;
                    af = 0;
                }
                boy = i;

            }else{
                if(boy < i){
                    af++;
                }else{
                    pre++;
                }
            }

        }
        for(int i=0; i<len-1; i++){
            if(users[i] == 'g'){
                af++;
            }else{
                break;
            }
        }
        boyhasgirl.put(boy, pre+af);


        int start = 0;
        int end = 0;
        int max = 0;
        int girl = 0;

        for(int i = 0; i<len-1; i++){
            if(users[i] == 'b'){
                max++;
                end++;
            }else{
                if(girl <= k){
                    girl++;
                }else{
                    for(int j=start; j<i; j++){
                        if(users[i] == 'g'){
//                            start =
                        }
                    }
                }
            }

        }

        return ""+ maxboy;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }
        int k = in.nextInt();
//        String[] girls = _users.split("b");
//        System.out.println(girls);
        res = getIndexAndLongest(_users, k);
        System.out.println(res);
    }
}