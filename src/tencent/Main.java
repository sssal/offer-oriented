package tencent;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
        String str = in.next();
//          int a = in.nextInt();
//          int b = in.nextInt();
//          System.out.println(a + b);
        StringBuilder sb = new StringBuilder();
        String[] strings = str.split("");
        char[] chars = str.toCharArray();
        int[] lefts = new int[20];
        int divot = 0;
        for(int i = 0; i<chars.length; i++){
            char c = chars[i];
            if(c == '['){
                lefts[divot] = i;
                divot++;
            }else if(c == ']'){

            }

        }
        System.out.println(str);

    }

    private static String help(char[] chars){
        String s = chars.toString();
        String[] ss = s.split("\\|");
        int times = Integer.parseInt(ss[0]);
        String s1 = ss[1];
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<times;i++){
            sb.append(s1);
        }
        return sb.toString();
    }
}
