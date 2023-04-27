package br.edu.utfpr.generics.ex3;

import java.io.Serializable;

/**
 * Classe genérica Par. Esta classe é capaz de manipular qualquer tipo T, desde
 * que este seja um subtipo de Comparable<T> e Serializable. O "T" é substituído
 * e tratado como uma classe ou interface existente.
 *
 * @param <T>
 */
class Par<T extends Comparable & Serializable> {

    T primeiro; // Utilizado como identificados de atributo
    T segundo;  // Utilizado como identificados de atributo

    /**
     * No construtor da classe está definido que um objeto desta classe, deve
     * ser instanciado passando-se, como parâmetro, dois objetos de tipo T.
     *
     * @param a1
     * @param a2
     */
    Par(T a1, T a2) {
        primeiro = a1;
        segundo = a2;
    }
}

public class GenericoEx3 {

    public static void main(String[] args) {
        String[] palavras = {"juca", "bom", "a", "pequeno", "alface"};

        Par<String> mm = ArrayAlg.minmax(palavras);
        System.out.println(mm.primeiro);
        System.out.println(mm.segundo);

        //Par<Object> parObj = new Par<Object>(new Object(), new Object()); // Fail! Object n�o atende os requisitos da classe gen�rica
    }
}

class ArrayAlg {

    public static <T extends Comparable & Serializable> Par<T> minmax(T[] a) {
        if (a == null || a.length == 0) {
            return null;
        }
        T min = a[0];
        T max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0) {
                min = a[i];
            }
            if (max.compareTo(a[i]) < 0) {
                max = a[i];
            }
        }

        return new Par<T>(min, max);
    }
}
