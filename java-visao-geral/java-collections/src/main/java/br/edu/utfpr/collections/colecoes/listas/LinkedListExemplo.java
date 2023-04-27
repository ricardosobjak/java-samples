package br.edu.utfpr.collections.colecoes.listas;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * As listas encadeadas em Java (LinkedList) ajudam a minimizar o custo de
 * inser��o e remo��o de itens no meio da lista.
 *
 * @author Ricardo
 *
 */
public class LinkedListExemplo {

    public static void main(String[] args) {
        List<String> list = new LinkedList<>();

        list.add("Alface");
        list.add("Banana");
        list.add("Caju");

        ListIterator<String> iterator = list.listIterator();
        System.out.println(iterator.next()); //Visita o primeiro elemento
        System.out.println(iterator.next()); //Visita o segundo elemento
        System.out.println(iterator.previous()); //Visita o primeiro elemento

        iterator.add("Mel�o");

        for (String s : list) {
            System.out.println(s);
        }

    }
}
