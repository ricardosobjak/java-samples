package br.edu.utfpr.collections.aula.ex1;

import java.util.*;

public class CollExemplo6_Comparable {

    public static void main(String[] args) throws java.io.IOException {

        String[] names = {"Sue", "Bill", "Tom", "Dave", "Andy", "Mary", "Beth", "Bill", "Mike"};

        SortedSet<String> setNomes = new TreeSet<>(Arrays.asList(names));
        System.out.println("setNomes: " + setNomes);

        Fruta[] arrayFrutas = new Fruta[]{
            new Fruta("Melão", "Amarelo"),
            new Fruta("Banana", "Amarelo"),
            new Fruta("Laranja", "Laranja"),
            new Fruta("Caqui", "Laranja"),
            new Fruta("Morango", "Vermelho")
        };

        SortedSet<Fruta> setFrutas = new TreeSet<>();
        setFrutas.addAll(Arrays.asList(arrayFrutas));
        System.out.println("setFrutas: " + setFrutas);

    }
}

class Fruta implements Comparable<Fruta> {

    String nome;
    String cor;

    public Fruta(String nome, String cor) {
        this.nome = nome;
        this.cor = cor;
    }

    @Override
    public String toString() {
        return "{Fruta=" + nome + ", Cor=" + cor + "}";
    }

    @Override
    public int compareTo(Fruta p) {
        return this.nome.toLowerCase().compareTo(p.nome.toLowerCase());
    }
}
