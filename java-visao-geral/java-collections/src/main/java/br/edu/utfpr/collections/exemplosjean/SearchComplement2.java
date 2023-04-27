package br.edu.utfpr.collections.exemplosjean;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SearchComplement2 {

    /**
     * @param args
     */
    public static void main(String[] args) {
        Integer soma = 163;
        int capacity = 3000;

        List<Integer> list = new ArrayList<Integer>();
        Random r = new Random(System.currentTimeMillis());
        for (int e = 0; e < capacity; ++e) {
            list.add(r.nextInt(capacity));
        }
        Collections.sort(list);
        int found = -1;
        for (int i = 0; i < list.size(); ++i) {
            int diff = Math.abs(soma - list.get(i));

            found = Collections.binarySearch(list.subList(i + 1, list.size()), diff);
            if (found >= 0) {
                System.out.format("Elements found:  (%d + %d) = %d] %n", list.get(i), list.get(i + 1 + found), soma);
                break;
            }
        }
        if (found < 0) {
            System.out.format("There is no x and y such that x + y = %d", soma);
        }

    }

}
