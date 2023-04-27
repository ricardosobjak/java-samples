package br.edu.utfpr.collections.filas;

import java.util.PriorityQueue;
import java.util.Queue;

class Paciente implements Comparable<Paciente> {

    int ficha;
    String nome;
    Gravidade gravidade;

    public Paciente(int ficha, String nome, Gravidade gravidade) {
        this.ficha = ficha;
        this.nome = nome;
        this.gravidade = gravidade;
    }

    @Override
    public String toString() {
        return "(" + ficha + "-" + nome + ", Gravidade=" + gravidade + ")";
    }

    @Override
    public int compareTo(Paciente o) {
        return o.gravidade.getValor() - this.gravidade.getValor();
    }
}

enum Gravidade {
    MINIMA(0), PEQUENA(1), MEDIA(2), ALTA(3), ALTISSIMA(4);

    private int valor;

    private Gravidade(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}

public class ExemploPriorityQueue_Pacientes {

    public static void main(String[] args) {
        // INSTANCIA��O DA FILA DE PRIORIDADES
        Queue<Paciente> fila = new PriorityQueue<>();

        // Pacientes são adicionados na fila
        fila.offer(new Paciente(1, "Alberto", Gravidade.MEDIA));
        fila.offer(new Paciente(2, "Juca", Gravidade.MEDIA));
        fila.offer(new Paciente(3, "Ana", Gravidade.MEDIA));
        fila.offer(new Paciente(4, "Matheus", Gravidade.MINIMA));
        fila.offer(new Paciente(5, "Sergio", Gravidade.PEQUENA));
        fila.offer(new Paciente(6, "Alice", Gravidade.ALTISSIMA));

        // Pacientes são retirados da fila
        while (!fila.isEmpty()) {
            Paciente p = fila.poll();
            System.out.println(p);
        }
    }
}
