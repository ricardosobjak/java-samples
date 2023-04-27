package br.edu.utfpr.exception.ex4;

public class LancadorDeExcecaoEX4 {

    public void numeroExtenso(int num) throws MinhaExcecao {
        switch (num) {
            case 1:
                System.out.println("UM");
                break;
            case 2:
                System.out.println("DOIS");
                break;
            case 3:
                System.out.println("TRÊS");
                break;
            case 4:
                System.out.println("QUATRO");
                break;
            case 5:
                System.out.println("CINCO");
                break;
            default:
                throw new MinhaExcecao("Número desconhecido");
        }
    }
}
