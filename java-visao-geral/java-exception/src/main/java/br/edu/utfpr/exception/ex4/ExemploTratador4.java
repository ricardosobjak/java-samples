package br.edu.utfpr.exception.ex4;

public class ExemploTratador4 {

    public static void main(String[] args) {
        LancadorDeExcecaoEX4 le = new LancadorDeExcecaoEX4();

        try {
            //le.numeroExtenso(10);
            le.numeroExtenso(5);
        } catch (MinhaExcecao e) {
            e.printStackTrace();
        }
    }
}
