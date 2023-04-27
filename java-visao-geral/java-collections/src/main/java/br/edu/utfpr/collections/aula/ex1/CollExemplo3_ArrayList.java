package br.edu.utfpr.collections.aula.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

/**
 * public class ArrayList<E>
 * extends AbstractList<E>
 * implements List<E>, RandomAccess, Cloneable, Serializable
 *
 * Resizable-array implementation of the List interface. A java ArrayList is
 * used to store an �ordered� group of elements where duplicates are allowed.
 * Implements all optional list operations, and permits all elements, including
 * null. This class is similar to Vector, except that it is unsynchronized. The
 * size, isEmpty, get, set, iterator, and listIterator operations run in
 * constant time. ArrayList�s give great performance on get() and set() methods,
 * but do not perform well on add() and remove() methods when compared to a
 * LinkedList. An ArrayList capacity is the size of the array used to store the
 * elements in the list. As elements are added to an ArrayList, its capacity
 * grows automatically. It is an Array based implementation where elements of
 * the List can be accessed directly through get() method. To prevent
 * unsynchronized access to the list: List list =
 * Collections.synchronizedList(new ArrayList(�));
 *
 * Below is an ArrayList Example showing how collections are manipulated using
 * an ArrayList
 *
 */
public class CollExemplo3_ArrayList {

    public static void main(String[] args) {
        // Instanciação de ArrayList
        List arraylistA = new ArrayList();
        List arraylistB = new ArrayList();

        // Adicionando elementos no ArrayList
        for (int i = 0; i < 5; i++) {
            arraylistA.add(i);
        }

        arraylistB.add("utilizando");
        arraylistB.add("java");
        arraylistB.add("collections");
        arraylistB.add(".");
        arraylistB.add("com");
        arraylistB.add("java");
        arraylistB.add("utfpr");

        String[] pal = {"java", "Ball", "Frisbee"};
        arraylistB.addAll(Arrays.asList(pal));

        // Iterando sobre o ArrayList para mostrar o seu conte�do.
        Iterator i1 = arraylistA.iterator();
        System.out.print("ArrayList arraylistA --> ");
        while (i1.hasNext()) {
            System.out.print(i1.next() + " , ");
        }
        System.out.println();

        System.out.print("ArrayList arraylistA --> ");
        for (int j = 0; j < arraylistA.size(); j++) {
            System.out.print(arraylistA.get(j) + " , ");
        }
        System.out.println();

        Iterator i2 = arraylistB.iterator();
        System.out.println("ArrayList arraylistB --> ");
        while (i2.hasNext()) {
            System.out.print(i2.next() + " , ");
        }
        System.out.println();
        System.out.println();

        System.out.println("Using ListIterator to retrieve ArrayList Elements");
        System.out.println();

        ListIterator li1 = arraylistA.listIterator();
        //       next(), hasPrevious(), hasNext(), hasNext() nextIndex() can be used with a
        //        ListIterator interface implementation
        System.out.println("ArrayList arraylistA --> ");
        while (li1.hasNext()) {
            System.out.print(li1.next() + " , ");
        }
        System.out.println();

        // Searching for an element in the ArrayList
        int index = arraylistB.indexOf("java");
        System.out.println("'java' foi encontrada na posi��o : " + index);

        int lastIndex = arraylistB.lastIndexOf("java");
        System.out.println("'java' foi encontrada na posi��o  : " + lastIndex + " from the last");
        System.out.println();

        // Obtendo uma subLista a partir da lista original
        List subList = arraylistA.subList(3, arraylistA.size());

        System.out.println("Nova Sub-Lista(arraylistA) a partir �ndice 3 at� "
                + arraylistA.size() + ": " + subList);
        System.out.println();

        // Classificando o ArrayList
        System.out.print("ArrayList arraylistA CLASSIFICADO --> ");
        Collections.sort(arraylistA);
        System.out.print(arraylistA);
        System.out.println();

        // INVERTENDO o ArrayList
        System.out.print("ArrayList arraylistA REVERSO --> ");
        Collections.reverse(arraylistA);
        System.out.println(arraylistA);
        System.out.println();

        // Verificando se o ArrayList est� vazio
        System.out.println("O arraylistA est� vazio?   " + arraylistA.isEmpty());
        System.out.println();

        // Verificando a Igualdade entre os ArrayLists
        ArrayList arraylistC = new ArrayList(arraylistA);
        System.out.println("arraylistA.equals(arraylistC)? " + arraylistA.equals(arraylistC));
        System.out.println();

        // Embaralhando os elementos do ArrayList de forma Randômica
        Collections.shuffle(arraylistA, new Random());
        System.out.print("ArrayList arraylistA depois de randomizar os elementos --> ");
        i1 = arraylistA.iterator();
        while (i1.hasNext()) {
            System.out.print(i1.next() + " , ");
        }

        System.out.println();
        System.out.println();

        // Convertendo um ArrayList para um Array
        Object[] array = arraylistA.toArray();
        for (int i = 0; i < array.length; i++) {
            System.out.println("Array Element [" + i + "] = " + array[i]);
        }
        System.out.println();

        // Clearing ArrayList Elements
        arraylistA.clear();
        System.out.println("arraylistA after clearing  : " + arraylistA);
        System.out.println();

    }
}
