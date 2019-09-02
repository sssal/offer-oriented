package exam360;

import java.util.HashMap;
import java.util.Scanner;


public class Main1 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String input = in.nextLine();
        int max = 1;
        HashMap<String, Integer> hashMap = new HashMap<>();
//        for(int i=0; i<input.length(); i++){
//            for(int j=i+1; j<input.length()+1; j++){
//                String tmp = input.substring(i,j);
//                if(hashMap.containsKey(tmp)){
//                    hashMap.put(tmp, hashMap.get(tmp)+1);
//                }else{
//                    hashMap.put(tmp,1);
//                }
//            }
//        }

        for(int i=1; i<input.length()+1; i++){
            for(int j = 0; j<input.length()-i+1; j++){
                String tmp = input.substring(j, j+i);
                if(hashMap.containsKey(tmp)){
                    int tmpValue = hashMap.get(tmp) + 1;
                    max = Math.max(max, tmpValue);
                    hashMap.put(tmp, tmpValue);
                }else{
                    hashMap.put(tmp, 1);
                }

            }
            hashMap.clear();
            if(max > input.length() -i+1){
                break;
            }
        }

//        int max = 0;
//        for(int i:hashMap.values()){
//            max = Math.max(max, i);
//        }

//        List<Map.Entry<String, Integer>> list = new ArrayList<>(hashMap.entrySet());
//        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
//            @Override
//            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
//                return o2.getValue().compareTo(o1.getValue());
//            }
//        });
//        System.out.println(list.get(0).getValue());
        System.out.println(max);



    }
}
