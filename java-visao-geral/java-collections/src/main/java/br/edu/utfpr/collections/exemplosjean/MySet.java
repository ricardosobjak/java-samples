package br.edu.utfpr.collections.exemplosjean;


/*
 * Esta classe � um exemplo do mau do 
 * dos princ�pios de programa��o orientada
 * a objetos e dos frameworks dispon�veis 
 * na API b�sica da linguagem.
 * Todas as opera��es de conjuntos matem�ticos
 * podem ser obtidas por meio do uso dos m�todos
 * implementados nas classes do JCF. 
 * Essa classe � uma implementa��o "caseira"
 * de um conjunto matem�tico usando arrays de 
 * tipos primitivos para armazenamento dos dados.
 * Consequentemente, n�o h� polimorfismo.
 * Compare essa classe com os mecanismos dispon�veis
 * no JCF.
 * 
 * autor: Jean Metz
 */
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class MySet {

    public static int[] difference(int[] set1, int[] set2) {
        Set s1 = new HashSet();
        Set s2 = new HashSet();
        for (int i = 0; i < set1.length; ++i) {
            s1.add(set1[i]);
        }
        for (int i = 0; i < set2.length; ++i) {
            s2.add(set2[i]);
        }
        s1.removeAll(s2);
        Iterator it = s1.iterator();
        int[] temp = new int[s1.size()];
        int index = 0;
        while (it.hasNext()) {
            temp[index++] = Integer.parseInt(it.next().toString());
        }
        return temp;
    }

    public static int[] intersection(int[] set1, int[] set2) {
        Set s1 = new HashSet();
        Set s2 = new HashSet();
        for (int i = 0; i < set1.length; ++i) {
            s1.add(set1[i]);
        }
        for (int i = 0; i < set2.length; ++i) {
            s2.add(set2[i]);
        }
        s1.retainAll(s2);
        Iterator it = s1.iterator();
        int[] temp = new int[s1.size()];
        int index = 0;
        while (it.hasNext()) {
            temp[index++] = Integer.parseInt(it.next().toString());
        }
        return temp;

    }

    public static int[] union(int[] set1, int[] set2) {
        Set s1 = new HashSet();
        Set s2 = new HashSet();
        for (int i = 0; i < set1.length; ++i) {
            s1.add(set1[i]);
        }
        for (int i = 0; i < set2.length; ++i) {
            s2.add(set2[i]);
        }
        s1.addAll(s2);
        Iterator it = s1.iterator();
        int[] temp = new int[s1.size()];
        int index = 0;
        while (it.hasNext()) {
            temp[index++] = Integer.parseInt(it.next().toString());
        }
        return temp;
    }
}
