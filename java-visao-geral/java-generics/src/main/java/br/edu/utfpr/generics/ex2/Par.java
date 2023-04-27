package br.edu.utfpr.generics.ex2;

/**
 * Classe Genérica Par. Aceita o tipo Empregado e todos os seus subtipos.
 */
class Par<T extends Empregado> {

    T primeiro;
    T segundo;

    public Par(T a1, T a2) {
        primeiro = a1;
        segundo = a2;
    }
}