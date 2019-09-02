package pingduoduo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int times = in.nextInt();
        String[] mei = new String[times];
        String[] bai = new String[times];
        for(int i=0; i<times; i++){
            mei[i] = in.nextLine();
            bai[i] = in.nextLine();
        }
//        StringBuilder test = new StringBuilder();
//        test.append
//        ArrayList<>

    }

    ArrayList<ArrayList<String>> result = new ArrayList<>();

    public void help(ArrayList<Integer> mei, ArrayList<Integer> bai){
        LinkedList<Integer> sub = new LinkedList<>();
        for(int i=0; i<mei.size(); i++){
            if(bai.contains(mei.get(i))){
                sub.addFirst(mei.get(i));
                if(isSub(bai, sub)){

                }
            }
        }
    }

    public boolean isSub(ArrayList<Integer> bai, LinkedList<Integer> sub){
        for(int i=0; i<bai.size(); i++){
            if(bai.get(i) == sub.get(0)){
                for(int j=1; j<sub.size(); j++){
                    if(sub.get(j) != bai.get(i+j)){
                        return false;
                    }
                }
                return true;

            }

        }
        return false;
    }
}