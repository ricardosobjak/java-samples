package br.edu.utfpr.generics.ex1;

import java.util.Date;

public class GenericoEx1 {

    public static void main(String[] args) {
        // Declaração de um array de Strings
        String[] palavras = {"juca", "bom", "a", "pequeno", "alface"};

        // Instanciando um Par<String>
        Par<String> mm = ArrayAlg.minmax(palavras);

        System.out.println(mm.primeiro);
        System.out.println(mm.segundo);

        Par<String> parString = new Par<>("Lima", "Limão"); //OK! Os dois parâmetros são do tipo String.
        Par<Date> parDatas = new Par<>(new Date(), new Date()); //OK! Os dois parâmetors são do tipo java.util.Date
        //Par<String> parStringData = new Par<String>("Data", new Date()); //Fail! O segundo par�metro n�o � do tipo String.

        ParDiferente<String, Date> parStringData = new ParDiferente<>("Data", new Date()); //OK 
    }
}

/**
 * Classe Utilitária
 *
 */
class ArrayAlg {

    /**
     * Método genérico: Retorna o elemento que está na posição central do array.
     *
     * @param a
     * @return
     */
    public static <T> T getMeio(T[] a) {
        return a[a.length / 2];
    }

    /**
     * Este método retorna um objeto "Par<T>" contendo o valor mínimo e o máximo
     * de um array de subtipos de Comparable.
     *
     * @param a
     * @return
     */
    public static <T extends Comparable<T>> Par<T> minmax(T[] a) {
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
