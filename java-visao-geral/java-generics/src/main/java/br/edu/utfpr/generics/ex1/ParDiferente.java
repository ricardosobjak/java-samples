package br.edu.utfpr.generics.ex1;

/**
 * Classe genérica Par<T,U>. Esta classe é capaz de manipular qualquer tipo "T"
 * e "U". O "T" e o "U" são substituídos e tratados como uma classe ou interface
 * existente real.
 *
 * @param <T>
 * @param <U>
 */
class ParDiferente<T, U> {

    T primeiro; // Utilizado como identificados de atributo
    U segundo;  // Utilizado como identificados de atributo

    /**
     * No construtor da classe está definido que um objeto "Par<T>", deve ser
     * instanciado passando-se, como parâmetro, dois objetos de tipo T.
     *
     * @param a1
     * @param a2
     */
    public ParDiferente(T a1, U a2) {
        primeiro = a1;
        segundo = a2;
    }
}
