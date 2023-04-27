package br.edu.utfpr.exception.ex3;

import javax.management.InvalidAttributeValueException;

public class ExemploTratador3 {

    public static void main(String[] args) {
        LancadorDeExcecao le1 = new LancadorDeExcecao();

        try {
            le1.testeDeExcessao1(-1);
        } catch (Exception e) {
            e.printStackTrace();
        }

        try {
            le1.testeDeExcessao2(200);
        } catch (InvalidAttributeValueException e) {
            e.printStackTrace();
        }
    }
}
