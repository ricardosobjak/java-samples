package br.edu.utfpr.collections.exemplosjean.basicCollections;

import java.util.*;

public class CollectionIteratorsDemo {

    /**
     * in spite of removing elements, list iterator allows the modification of
     * individual elements that belongs to the list
     */
    static void listTrimLI(List<String> strings) {
        for (ListIterator<String> lit = strings.listIterator(); lit.hasNext();) {
            lit.set(lit.next().trim());
        }
    }

    /**
     * Can remove elements from the list but not set/modify individual elements
     */
    static void listTrimI(List<String> strings) {
        for (Iterator<String> it = strings.iterator(); it.hasNext();) {
            it.next().trim();
        }
    }

    /**
     * Does not modify the String elements at all
     */
    static void listTrimEF(List<String> strings) {
        for (String s : strings) {
            s.trim();
        }
    }

    /**
     *
     * The enhanced for statement does not allow you to modify the List. Using
     * an Iterator allows you to delete elements, but not replace an existing
     * element or add a new one. That leaves ListIterator.
     */
    public static void main(String[] args) {
        List<String> l = Arrays.asList(" red ", " white ", " blue ");

        System.out.println("Original List:");
        for (String s : l) {
            System.out.format("\"%s\"%n", s);
        }

        System.out.println("---");
        System.out.println("List trimmed, using enhanced for loop for traversal:");
        listTrimEF(l);
        for (String s : l) {
            System.out.format("\"%s\"%n", s);
        }
        System.out.println("---");

        System.out.println("List trimmed, using iterator for traversal:");
        listTrimI(l);
        for (String s : l) {
            System.out.format("\"%s\"%n", s);
        }
        System.out.println("---");

        System.out.println("List trimmed, using listIterator for traversal:");
        listTrimLI(l);
        for (String s : l) {
            System.out.format("\"%s\"%n", s);
        }
        System.out.println("---");
    }

}
