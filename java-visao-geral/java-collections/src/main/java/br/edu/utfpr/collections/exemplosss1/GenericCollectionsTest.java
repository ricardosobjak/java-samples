package br.edu.utfpr.collections.exemplosss1;

import java.util.*;

/**
 * Exemplo que demonstra a utiliza��o de Cole��es com a utiliza��o de tipos
 * gen�ricos e sem a utiliza��o de tipos gen�rios.
 *
 */
public class GenericCollectionsTest {

    public static void main(String[] args) {

        /*
		 * LISTA CRIADA DETERMINANDO O TIPO GEN�RICO COMO "String"
         */
        List<String> ls = new ArrayList<String>();

        ls.add("Hello");
        ls.add("how");
        ls.add("are");
        ls.add("you");
        ls.add("today");

        // using iterator
        StringBuffer result = new StringBuffer();
        Iterator<String> is = ls.iterator();
        while (is.hasNext()) {
            result.append(is.next().toUpperCase()).append(' ');
        }
        result.append('?');
        System.out.println(result);

        // using for-each loop
        result = new StringBuffer();
        for (String s : ls) {
            result.append(s.toLowerCase()).append(' ');
        }
        result.append('?');
        System.out.println(result);

        /*
		 * LISTA CRIADA SEM A UTILIZA��O DE GEN�RICO
         */
        List l = new ArrayList();

        l.add("Hello");
        l.add("how");
        l.add("are");
        l.add("you");
        l.add("today");

        // using iterator
        result = new StringBuffer();
        Iterator i = l.iterator();
        while (i.hasNext()) {
            result.append(((String) i.next()).toUpperCase()).append(' ');
        }
        result.append('?');
        System.out.println(result);

        // using for-each loop
        result = new StringBuffer();
        for (Object o : l) {
            result.append(((String) o).toLowerCase()).append(' ');
        }
        result.append('?');
        System.out.println(result);

    }
}
