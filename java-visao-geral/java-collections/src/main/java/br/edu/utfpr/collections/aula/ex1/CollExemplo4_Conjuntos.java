package br.edu.utfpr.collections.aula.ex1;

import java.util.*;

/**
 * The HashSet class implements the Set interface. It makes no guarantee that
 * the order of elements will remain constant over time. This class is not
 * synchronized and permits a null element. This class offers constant time
 * performance for the basic operations (add, remove, contains and size),
 * assuming the hash function disperses the elements properly among the buckets.
 * To prevent unsynchronized access to the Set: Set s =
 * Collections.synchronizedSet(new HashSet(�)); Below is a HashSet Example
 * showing how collections are manipulated using a HashSet
 *
 *
 */
public class CollExemplo4_Conjuntos {

    private static String names[] = {"bob", "hemanth", "hhh", "hero",
        "shawn", "bob", "mike", "Rick", "rock", "hemanth", "mike",
        "undertaker"};

    public static void main(String args[]) {
        ArrayList<String> aList = new ArrayList<>(Arrays.asList(names));
        System.out.println("O nome dos elementos são: " + aList);

        Set<String> ref = new HashSet<>(aList); // create a HashSet
        Iterator<String> i = ref.iterator();

        System.out.println();
        System.out.print("Os nomes únicos são: ");
        while (i.hasNext()) {
            System.out.print(i.next() + " ");
        }
        System.out.println();

        // CONJUNTO ORDENADO DE DADOS
        SortedSet<String> treeSet = new TreeSet<>(aList);
        System.out.println();
        System.out.println("Os nomes ordenados são: " + treeSet);
    }
}
