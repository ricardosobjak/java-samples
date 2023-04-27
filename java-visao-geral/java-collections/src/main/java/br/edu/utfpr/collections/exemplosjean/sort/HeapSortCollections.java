package br.edu.utfpr.collections.exemplosjean.sort;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class HeapSortCollections {

    public static <E> List<E> heapSort(Collection<E> c) {
        Queue<E> queue = new PriorityQueue<>(c);
        List<E> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            result.add(queue.remove());
        }

        return result;
    }

    /**
     * @param args
     */
    public static void main(String[] args) {

        int capacity = 20;
        List<Double> list = new ArrayList<>(capacity);
        Random r = new Random(System.currentTimeMillis());
        for (int e = 0; e < capacity; ++e) {
            list.add(r.nextDouble());
        }

        System.out.println(list);

        long sTime = System.currentTimeMillis();
        heapSort(list); // Heap Sort implemented with Collections Framework infra.
        long eTime = System.currentTimeMillis() - sTime;

        System.out.println("Heap sort elapsed time millis: " + eTime);
        System.out.println(list);
    }

}
