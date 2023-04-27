package br.edu.utfpr.exception.ex2;

public class ExemploTratador2 {

    public static void main(String[] args) {
        int numerador = 5;          //variável inteiro com valor 5
        int denominador = 0;        //variável inteiro com valor 0
        int vetor[] = {120, 50};    //array de inteiros de tamanho 2

        try {
            int res = numerador / denominador;
            vetor[30] = 2;
        } catch (ArithmeticException e) {
            System.out.println("Dividiu por zero.");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Acessou uma posição inesistente no array");
        }
    }
}
