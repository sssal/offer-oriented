package xiaohongshu;

import java.util.ArrayList;
import java.util.Scanner;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        ArrayList<Integer[]> arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            Integer[] tmp = new Integer[2];
            tmp[0] = in.nextInt();
            tmp[1] = in.nextInt();
            arrayList.add(tmp);
        }

//        Collections.sort(arrayList, new Comparator<Integer[]>() {
//            @Override
//            public int compare(Integer[] o1, Integer[] o2) {
////                return o1.;
//            }
//        });


    }
}
