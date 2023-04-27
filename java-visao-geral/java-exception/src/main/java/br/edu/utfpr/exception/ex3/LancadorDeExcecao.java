package br.edu.utfpr.exception.ex3;

import javax.management.InvalidAttributeValueException;

public class LancadorDeExcecao {

    public void testeDeExcessao1(int num) throws Exception {
        if (num < 0) {
            throw new Exception("Valor menor do que zero.");
        }
    }

    public void testeDeExcessao2(int num) throws InvalidAttributeValueException {
        if (num > 100) {
            throw new InvalidAttributeValueException("Número maior do que 100");
        }
    }
}
