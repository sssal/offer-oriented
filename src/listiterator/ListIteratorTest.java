package listiterator;

import java.util.*;

public class ListIteratorTest {
    public static void main(String[] args){
        List<String> staff = new LinkedList<>();

        staff.add("Amy");
        staff.add("Bob");
        staff.add("Carl");

        ListIterator<String> iter = staff.listIterator();
        iter.next();
        iter.add("Juliet");

        System.out.println(staff);
    }
}
