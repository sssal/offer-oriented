package jinji;

import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main3 {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> user= new ArrayList<>();
        ArrayList<Long> time = new ArrayList<>();
        ArrayList<Integer> state = new ArrayList<>();

//        int inputTime = 100;
        while(in.hasNext()){
            String input = in.nextLine();
            String[] inputs = input.split(",");
            if(inputs.length != 3){
                break;
            }
            user.add(Integer.parseInt(inputs[0]));
            time.add(Long.parseLong(inputs[1]));
            state.add(Integer.parseInt(inputs[2]));
        }
//        System.out.println(user);
        TreeMap<Integer, Long> hashMap = new TreeMap<>();
        boolean[] finded = new boolean[user.size()];
        for(int i=0; i<user.size(); i++){
            if(!finded[i]) {
                finded[i] = true;
                int tmpUser = user.get(i);
                long tmpTime = time.get(i);
                int tmpState = state.get(i);
                if(tmpState == 1){
                    continue;
                }
                long afTime = 0;
                long sumTime = 0;
                for(int j = i; j<user.size(); j++){
                    if(user.get(j) == tmpUser){
                        if(state.get(j) == 1){
                            finded[j] = true;
                            afTime = time.get(j);
                            sumTime = afTime - tmpTime;
                            break;

                        }
                    }
                }

                if(sumTime !=0) {
                    if (hashMap.containsKey(tmpUser)) {
                        long tmp = hashMap.get(tmpUser);
                        hashMap.put(tmpUser, tmp+sumTime);
                    } else {
                        hashMap.put(tmpUser, sumTime);
                    }
                }
            }
        }

        for (Map.Entry<Integer,Long> s:hashMap.entrySet()) {
            System.out.println(s.getKey() + "," + s.getValue());
        }

    }
}
