package br.edu.utfpr.exception.ex4;

public class MinhaExcecao extends Exception {

    private String mensagem = "";

    public MinhaExcecao() {
        mensagem = "Houve uma exceção!";
    }

    public MinhaExcecao(String mensagem) {
        this.mensagem = mensagem;
    }

    @Override
    public String toString() {
        return mensagem;
    }
}
