package br.edu.utfpr.collections.aula.ex1;

/*
 *  Using a HashMap to store the number of words that begin with a given letter.
 */
import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 *
 * The java HashMap class does not guarantee that the order will remain constant
 * over time. This implementation provides constant-time performance for the
 * basic operations (get and put), assuming the hash function disperses the
 * elements properly among the buckets. The HashMap implementation is not
 * synchronized. If multiple threads access this map concurrently, and at least
 * one of the threads modifies the map structurally, it must be synchronized
 * externally. To prevent unsynchronized access to the Map: Map m =
 * Collections.synchronizedMap(new HashMap(�));
 *
 * Below is a HashMap Example used to store the number of words that begin with
 * a given letter
 *
 */
public class CollExemplo5_Mapas {

    public static void main(String args[]) {
        Map<String, String> setPessoas = new HashMap<>();

        setPessoas.put("043.733.812-11", "Rafael");
        setPessoas.put("241.123.129-21", "Julia");
        setPessoas.put("111.111.111-11", "Carla");
        setPessoas.put("222.222.222-22", "Flavio");
        setPessoas.put("241.123.129-21", "Marcos");
        setPessoas.put("555.555.555-55", "Rafael");

        // Imprime todas as entradas
        System.out.println(setPessoas.toString());

        // Remove uma entrada 
        setPessoas.remove("111.111.111-11");

        //Substitui o objeto anterirmente adicionado
        setPessoas.put("555.555.555-55", "Leonardo");
        System.out.println(setPessoas);

        // Pesquisa por um valor
        System.out.println(setPessoas.get("222.222.222-22"));

        System.out.println("\n\nImprimindo todas as chaves:");
        for (String key : setPessoas.keySet()) {
            System.out.println("\t" + key);
        }

        System.out.println("\n\nImprimindo todos os valores");
        for (String v : setPessoas.values()) {
            System.out.println("\t" + v);
        }

        // Manipulando todas as entradas por Map.Entry
        System.out.println("\n\nImprimindo todas as chaves e valores");
        for (Map.Entry<String, String> entry : setPessoas.entrySet()) {
            String key = entry.getKey();
            String val = entry.getValue();
            System.out.println("\t" + key + "=" + val);
        }

        // --------------------------------------------------------------------------
        // Exemplo com a Classe "TreeMap<K, V>"
        // Chaves classificadas
        // --------------------------------------------------------------------------
        System.out.println();
        SortedMap<String, String> mapPessoas = new TreeMap<>(setPessoas);

        System.out.println(mapPessoas);

    }
}
