package br.edu.utfpr.collections.exemplosjean;

import java.util.*;

public class SearchComplement {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer x, soma;
        x = 4;
        soma = 16;
        int capacity = 30;

        List<Integer> list = new ArrayList<Integer>();
        Random r = new Random(System.currentTimeMillis());
        for (int e = 0; e < capacity; ++e) {
            list.add(r.nextInt(capacity));
        }

        int diff = soma - x;
        Collections.sort(list);
        int found = Collections.binarySearch(list, diff);
        if (found >= 0) {
            System.out.println("Element found: " + list.get(found));
        } else {
            System.out.println("No complement found");
        }

    }

}
