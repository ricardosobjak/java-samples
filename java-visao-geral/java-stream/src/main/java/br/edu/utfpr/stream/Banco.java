package br.edu.utfpr.stream;

import java.util.ArrayList;
import java.util.Collection;

public class Banco {

    Collection<Conta> contas = new ArrayList();

    public Collection<Conta> filtroDeContas(ContaFilter filter) {
        Collection<Conta> filtradas = new ArrayList();
        for (Conta c : contas) {
            if (filter.accept(c)) {
                filtradas.add(c);
            }
        }
        return filtradas;
    }
}
