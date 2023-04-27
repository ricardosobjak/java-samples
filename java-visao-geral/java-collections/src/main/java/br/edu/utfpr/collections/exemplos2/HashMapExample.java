package br.edu.utfpr.collections.exemplos2;


/*


 *  Using a HashMap to store the number of words that begin with a given letter.
 */
import java.util.HashMap;

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
public class HashMapExample {

    static String[] names = {"heman", "bob", "hhh", "shawn", "scot", "shan", "keeth"};
    private static HashMap<Character, Integer> counter = new HashMap<>();
    private static Integer cnt = null;

    public static void main(String args[]) {
        for (String name : names) {
            cnt = counter.get(name.charAt(0));
            if (cnt == null) {
                counter.put(name.charAt(0), 1);
            } else {
                counter.put(name.charAt(0), cnt + 1);
            }
        }
        System.out.println("\nnumber of words beginning with each letter is shown below ");
        System.out.println(counter.toString());
    }
}
