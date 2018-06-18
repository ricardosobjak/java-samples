package br.edu.utfpr.sobjak.jspjstlbasic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;

public class ColecaoDeNomes implements Serializable {
    private final Collection<String> nomes = new ArrayList<>();

    public ColecaoDeNomes() {
        nomes.add("Maria");
        nomes.add("Zeca");
        nomes.add("Carlos");
    }

    public Collection<String> getNomes() {
        return nomes;
    }
}
