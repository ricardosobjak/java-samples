package br.edu.utfpr.generics.ex1;

/**
 * Classe genérica Par. Esta classe é capaz de manipular qualquer tipo T. O "T"
 * é substituído e tratado como uma classe ou interface existente real.
 *
 * @param <T>
 */
class Par<T> {

    T primeiro; // Utilizado como identificados de atributo
    T segundo;  // Utilizado como identificados de atributo

    /**
     * No construtor da classe está definido que um objeto "Par<T>", deve ser
     * instanciado passando-se, como parâmetro, dois objetos de tipo T.
     *
     * @param a1
     * @param a2
     */
    Par(T a1, T a2) {
        primeiro = a1;
        segundo = a2;
    }
}
