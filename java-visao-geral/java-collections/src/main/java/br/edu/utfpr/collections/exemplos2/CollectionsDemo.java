package br.edu.utfpr.collections.exemplos2;

import java.util.*;

/**
 * Note: Concrete Classes for the Map is shown in the previous section. Standard
 * utility methods and algorithms
 *
 * Standard utility methods and algorithms
 *
 * that can be used to perform various operations on collections, such as
 * sorting, searching or creating customized collections.
 *
 * How are Collections Used
 *
 * The collections stores object references, rather than objects themselves.
 * Hence primitive values cannot be stored in a collection directly. They need
 * to be encapsulated (using wrapper classes) into an Object prior to storing
 * them into a Collection (such as HashSet, HashMap etc). The references are
 * always stored as type Object. Thus, when you retrieve an element from a
 * collection, you get an Object rather then the actual type of the collection
 * stored in the database. Hence we need to downcast it to the Actual Type while
 * retrieving an element from a collection. One of the capabilities of the
 * Collection Framework is to create a new Collection object and populate it
 * with the contents of an existing Collection object of a same or different
 * actual type. Below is an example program showing the storing and retrieving
 * of a few Collection Types
 *
 */
public class CollectionsDemo {

    public static void main(String[] args) {
        List a1 = new ArrayList();
        a1.add("Beginner");
        a1.add("Java");
        a1.add("tutorial");
        System.out.println(" ArrayList Elements");
        System.out.print("\t" + a1);

        List l1 = new LinkedList();
        l1.add("Beginner");
        l1.add("Java");
        l1.add("tutorial");
        System.out.println();
        System.out.println(" LinkedList Elements");
        System.out.print("\t" + l1);

        Set s1 = new HashSet(); // or new TreeSet() will order the elements;
        s1.add("Beginner");
        s1.add("Java");
        s1.add("Java");
        s1.add("tutorial");
        System.out.println();
        System.out.println(" Set Elements");
        System.out.print("\t" + s1);

        Map m1 = new HashMap(); // or new TreeMap() will order based on keys
        m1.put("Windows", "98");
        m1.put("Win", "XP");
        m1.put("Beginner", "Java");
        m1.put("Tutorial", "Site");
        System.out.println();
        System.out.println(" Map Elements");
        System.out.print("\t" + m1);
    }
}
