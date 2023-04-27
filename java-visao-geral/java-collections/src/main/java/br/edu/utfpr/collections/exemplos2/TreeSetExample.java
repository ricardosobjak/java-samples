package br.edu.utfpr.collections.exemplos2;

import java.util.Set;
import java.util.TreeSet;
import java.util.Iterator;

/**
 * public class TreeSet<E>
 * extends AbstractSet<E>
 * implements SortedSet<E>, Cloneable, Serializable
 *
 * This class implements the Set interface and guarantees that the sorted set
 * will be in ascending element order, sorted according to the natural order of
 * the elements or by the comparator provided at set creation time, depending on
 * which constructor is used. This implementation not synchronized provides
 * guaranteed log(n) time cost for the basic operations (add, remove and
 * contains). To prevent unsynchronized access to the Set.: SortedSet s =
 * Collections.synchronizedSortedSet(new TreeSet(..));
 *
 * Below is a TreeSet Example showing how collections are manipulated using a
 * TreeSet
 *
 */
public class TreeSetExample {

    public static void main(String[] args) {
        Set treeSet = new TreeSet();

        // the treeset stores Integer objects into the TreeSet
        treeSet.add(4);
        treeSet.add(5);
        treeSet.add(3);
        treeSet.add(1);
        treeSet.add(2);
        treeSet.add(4); // false

        System.out.print("Os elementos deste TreeSet são : ");
        Iterator i = treeSet.iterator();
        while (i.hasNext()) {
            System.out.print(i.next() + "\t");
        }
    }
}
