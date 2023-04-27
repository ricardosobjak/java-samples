package br.edu.utfpr.collections.aula.ex1;

import java.util.*;

public class CollExemplo7_Comparator {

    public static void main(String[] args) throws java.io.IOException {

        Pessoa[] arrayPessoa = new Pessoa[]{
            new Pessoa("Ricardo", 29, 1.9f),
            new Pessoa("Fernando", 33, 1.76f),
            new Pessoa("Alice", 22, 1.69f),
            new Pessoa("Carla", 18, 1.79f),
            new Pessoa("Andreia", 18, 1.79f)};

        TreeSet<Pessoa> treePes1 = new TreeSet<>(new NomeComparator());
        treePes1.addAll(Arrays.asList(arrayPessoa));
        System.out.println(treePes1);

        TreeSet<Pessoa> treePes2 = new TreeSet<>(new IdadeComparator());
        treePes2.addAll(Arrays.asList(arrayPessoa));
        System.out.println(treePes2);

        /**
         * TreeSet classificada por altura das pessoas
         */
        // Alternativa 1: Classe interna anônima
        TreeSet<Pessoa> treePes3 = new TreeSet<>(new Comparator<Pessoa>() {
            @Override
            public int compare(Pessoa o1, Pessoa o2) {
                return o1.altura > o2.altura ? 1 : -1;
            }
        });

        // Alternativa 2: Expressão Lambda
        treePes3 = new TreeSet<>((Pessoa o1, Pessoa o2) -> o1.altura > o2.altura ? 1 : -1);
        
        // Alternativa 3: Expressão Lambda reduzida
        treePes3 = new TreeSet<>((o1, o2) -> o1.altura > o2.altura ? 1 : -1);

        treePes3.addAll(Arrays.asList(arrayPessoa));
        System.out.println("treePes3 (ASC)  : " + treePes3);
        System.out.println("treePes3 (DESC) : " + treePes3.descendingSet());

    }
}

class Pessoa {

    String nome;
    int idade;
    float altura;

    public Pessoa(String nome, int idade, float altura) {
        this.nome = nome;
        this.idade = idade;
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "{Nome=" + nome + ", Idade=" + idade + ", Altura=" + altura + "}";
    }
}

class NomeComparator implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        return o1.nome.toLowerCase().compareTo(o2.nome.toLowerCase());
    }
}

class IdadeComparator implements Comparator<Pessoa> {

    @Override
    public int compare(Pessoa o1, Pessoa o2) {
        return o1.idade > o2.idade ? 1 : -1;
    }

}
