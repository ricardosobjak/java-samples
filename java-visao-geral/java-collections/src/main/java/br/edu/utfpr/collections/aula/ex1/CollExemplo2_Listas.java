package br.edu.utfpr.collections.aula.ex1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollExemplo2_Listas {

    public static void main(String[] args) {
        List<String> arrayl1 = new ArrayList<>();
        arrayl1.add("Zara");
        arrayl1.add("Mahnaz");
        arrayl1.add("Ayan");
        System.out.println(" Elemntos do ArrayList: \t" + arrayl1);

        List<String> linkedl1 = new LinkedList<>();
        linkedl1.add("Zara");
        linkedl1.add("Mahnaz");
        linkedl1.add("Ayan");
        System.out.println(" Elementos do LinkedList: \t" + linkedl1);

        Vector<String> vector1 = new Vector<>();
        vector1.add("Maçã");
        vector1.add("Banana");
        vector1.add("Uva");
        vector1.add("Mel�o");
        System.out.println(" Elementos do Vector: \t" + vector1);
    }
}
