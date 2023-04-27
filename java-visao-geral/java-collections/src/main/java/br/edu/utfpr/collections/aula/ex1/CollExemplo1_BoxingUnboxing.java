package br.edu.utfpr.collections.aula.ex1;

/**
 * Exemplo de AUTOBOXING e AUTO-UNBOXING
 *
 */
public class CollExemplo1_BoxingUnboxing {

    public static void main(String[] args) {
        Integer[] integers = new Integer[5]; //Cria um arra de Integer

        // Conversão BOXING, converte uma tipo primitivo para uma classe
        // enpacotadora correnspondente
        integers[0] = new Integer(10);

        Integer objValue = integers[0]; // Obtém o objeto Integer, operação natural

        // Conversão UNBOXING, converte um objeto de uma classe enpacotadora de um tipo
        // em um valor do tipo primitivo correspondente.
        int intValue1 = integers[0].intValue(); // UNBOXING

        integers[1] = 50; // AUTOBOXING

        int intValue2 = integers[1]; // AUTO-UNBOXING 
    }
}
