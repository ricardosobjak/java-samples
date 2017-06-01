package br.edu.utfpr.monitoria;

import java.util.ArrayList;
import java.util.List;

public abstract class Factory<T> {
    public abstract T create();
    
    public List<T> create(int quantidade) {
        List<T> ls = new ArrayList<>();
        for(int i=0; i<quantidade; i++) 
            ls.add(create());
        return ls;
    }
}