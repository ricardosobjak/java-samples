package br.edu.utfpr.collections.exemplosjean;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

public class WordFrequency {

    public static void main(String[] args) {
        Map<String, Integer> m = new LinkedHashMap<String, Integer>();
        System.out.println("Original words:");
        System.out.println(Arrays.asList(args));

        // Initialize frequency table from command line
        for (String a : args) {
            Integer freq = m.get(a);
            m.put(a, (freq == null) ? 1 : freq + 1);
        }

        System.out.println(m.size() + " distinct words!");

        System.out.println("----");
        System.out.println("Sorted list (appearing order) of word");
        System.out.println(m);

        System.out.println("----");
        System.out.println("List of word and frequencies in no particular order");
        System.out.println(new HashMap<String, Integer>(m));

        System.out.println("----");
        System.out.println("Sorted list (alphabeticaly) of word");
        System.out.println(new TreeMap<String, Integer>(m));
    }
}
