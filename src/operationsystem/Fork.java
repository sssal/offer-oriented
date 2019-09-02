package operationsystem;

//import jdk.internal.misc.VM;

public class Fork {


    public static void main(String[] args) {
        Integer i1 = -129;
        Integer i2 = -129;
        Integer i3 = Integer.valueOf(-129);
//        String integerCacheHighPropValue =
//                VM.getSavedProperty("java.lang.Integer.IntegerCache.high");
        System.out.println(i1 == i2);
    }
}

