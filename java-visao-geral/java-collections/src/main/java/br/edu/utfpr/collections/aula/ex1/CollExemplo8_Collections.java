package br.edu.utfpr.collections.aula.ex1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CollExemplo8_Collections {

    public static void main(String[] args) {
        Integer[] array1 = new Integer[]{5, 10, 2, 34, 23, 2, 67, 44};
        Integer[] array2 = new Integer[]{5, 23, 10, 2};

        // Lista de Inteiros criada de forma enpacotada
        // O método Arrays.asList retorna um empacotador List entorno do Array.
        List<Integer> lista1 = new ArrayList<>(Arrays.asList(array1));
        List<Integer> lista2 = new ArrayList<>(Arrays.asList(array2));

        System.out.println("Lista recém criada: " + lista1);

        // Ordenando a Lista
        Collections.sort(lista1);
        System.out.println(lista1);

        // Busca binária na Lista, tem que estar ordenada
        System.out.println(Collections.binarySearch(lista1, 34));

        // Embaralhando a lisa
        Collections.shuffle(lista1);
        System.out.println(lista1);

        // Cria um objeto imutável de 10 posições contendo a palavra "DEFAULT"
        List<String> settings = Collections.nCopies(10, "DEFAULT");
        System.out.println(settings);

        // Cria um Set imutável com o objeto especificado (singletonList, singletonMap)
        Set<String> setImmutable = Collections.singleton("DEFAULT");
        //setImmutable.clear(); // Fail
        System.out.println(setImmutable);

        // SUBINTERVALOS
        // Obtendo o subintervalo de uma lista
        List<Integer> grupo1 = lista1.subList(0, 3);

        /*
		 * Para conjuntos classificados: subSet, headSet, tailSet
		 * Para mapas classificados: subMap, headMap, headSet
         */
        // Ações aplicadas ao subintervalo refletirão sobre a lista como um todo
        grupo1.clear();
        System.out.println(lista1);

        /**
         * VISUALIZAÇÕES DE COLEÇÃO NÃO MODIFICÁVEIS
         */
        List<Integer> viewLista1 = Collections.unmodifiableList(lista1);
        //viewLista1.clear(); //Fail

        /**
         * VISUALIZAÇÕES DE COLEÇÃO SINCRONIZADAS Serve para determinar o acesso
         * seguro à coleção, quando acessada de forma concorrente entre várias
         * Threads.
         */
        List<Integer> syncLista1 = Collections.synchronizedList(lista2);
        syncLista1.add(99);

        /**
         * VISUALIZAÇÕES VERIFICADAS -
         */
        /**
         * OPERAÇÕES EM VOLUME
         *
         */
        System.out.println("INTERSEÇÃO: ");
        Set<Integer> intersec = new HashSet<>(lista1);
        System.out.println("Lista: " + intersec);
        intersec.retainAll(lista2);
        System.out.println("Lista com intersecção dos elementos: " + intersec);

        //System.out.println( Collections.disjoint(c1, c2));
    }
}
