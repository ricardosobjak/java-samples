package br.edu.utfpr.exception.ex1;

import javax.swing.JOptionPane;

/**
 * Exemplo de Tratamento de Exceções
 *
 * O programa faz a leitura de um valor a partir de uma JOptionPane, depois
 * converte o valor lido em um n�mero inteiro.
 *
 * Se for lido um valor diferente de n�mero, ser� lan�ado uma exce��o
 *
 * @author Ricardo Sobjak
 *
 */
public class ExemploTratador1 {

    public static void main(String[] args) {
        int numero = -1;

        //Abre a janela e armazena o valor lido na variável res
        String res = JOptionPane.showInputDialog("Informe um número");

        /**
         * CONVERSÃO COM TRATAMENTO DE EXCEÇÃO
         */
        //Tenta executar o que está no try, se der alguma exceção, passa-se ao catch
        try {
            numero = Integer.valueOf(res);
        } catch (NumberFormatException e) {
            numero = 0;
            JOptionPane.showMessageDialog(null, "Houve erro na tentativa de converter o número! ERRO: " + e.getMessage());
        } finally {
            System.out.println("Conversão de String pra int");
            System.out.println(numero);
        }

        /**
         * CONVERSÃO SEM TRATAMENTO DE EXCEÇÃO
         */
        //transforma a String res na variável número
        numero = Integer.valueOf(res);
    }
}
