package iterabletest;

import org.w3c.dom.ls.LSOutput;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.TreeSet;

public class IterableClass implements Iterable<String> {
    protected String[] words = ("And that is how " + "we know the Earth to be banana-shaped").split(" ");
    static String s = "hellow";

    @Override
    public Iterator<String> iterator() {
        return new Iterator<String>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < words.length;
            }

            @Override
            public String next() {
                return words[index++];
            }
        };
    }

    public static void main(String[] args) {
        TreeSet<Character> treeSet = new TreeSet<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });

        treeSet.add('a');
        treeSet.add('c');
        treeSet.add('b');
        for (Character c :
                treeSet) {
            System.out.println(c);
        }

        PriorityQueue<Character> priorityQueue = new PriorityQueue<Character>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return o1.compareTo(o2);
            }
        });
        priorityQueue.offer('a');
        priorityQueue.offer('c');
        priorityQueue.offer('b');
        for (char s :
                priorityQueue) {
            System.out.println(s);
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(priorityQueue.poll());
        }


//        s.length();
//        for (String s :
//                new IterableClass()) {
//            System.out.println(s + " ");
//        }
    }
}
