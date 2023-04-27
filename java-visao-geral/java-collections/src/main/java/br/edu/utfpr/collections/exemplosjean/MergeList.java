package br.edu.utfpr.collections.exemplosjean;

import java.util.*;

public class MergeList {

    /**
     * @param args
     */
    public static void main(String[] args) {
        int capacity = 10;
        List<Double> list1 = new ArrayList<Double>(capacity);
        List<Double> list2 = new ArrayList<Double>(capacity);
        Random r = new Random(System.currentTimeMillis());
        for (int e = 0; e < capacity; ++e) {
            list1.add(r.nextDouble());
            list2.add(r.nextDouble());
        }
        Collections.shuffle(list2, new Random(System.currentTimeMillis()));

        List<Double> list3 = new ArrayList<Double>(list1);
        list3.addAll(list2);
        Collections.sort(list3);
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(list3);
    }

}
