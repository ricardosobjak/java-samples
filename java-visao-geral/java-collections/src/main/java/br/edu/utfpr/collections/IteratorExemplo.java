package br.edu.utfpr.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Vector;

public class IteratorExemplo {

    @SuppressWarnings("all")
    public static void main(String[] args) {
        Collection strings = new Vector();

        strings.add("Alface");
        strings.add("Banana");
        strings.add("Caju");
        strings.add("Damasco");

        Iterator iterator = strings.iterator();
        while (iterator.hasNext()) {
            String string = (String) iterator.next();
            System.out.println(string);
        }
    }
}
