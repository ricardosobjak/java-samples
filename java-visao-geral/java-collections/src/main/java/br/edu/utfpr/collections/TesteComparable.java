package br.edu.utfpr.collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Pessoa implements Comparable<Pessoa> {

    String uf;
    String cidade;

    Pessoa(String uf, String cidade) {
        this.uf = uf;
        this.cidade = cidade;
    }

    @Override
    public String toString() {
        return uf + "-" + cidade;
    }

    @Override
    public int compareTo(Pessoa o) {
        int uf = this.uf.compareTo(o.uf);
        int cidade = this.cidade.compareTo(o.cidade);

        System.out.println(this.toString() + "-->" + o.toString() + ": UF=" + uf + ", Cidade=" + cidade);

        if (uf < 0) {
            return -1;
        } else if (uf > 0) {
            return 1;
        } else {
            if (cidade < 0) {
                return -1;
            } else {
                return 1;
            }
        }

//		System.out.println(this.toString()+"-->"+o.toString()+": UF="+uf+", Cidade="+cidade);
//		if(uf < 0 && cidade < 0)
//			return -1;
//		else if(uf == 0 && cidade == 0)
//			return 0;
//		return 1;
    }
}

public class TesteComparable {

    public static void main(String[] args) {
        List<Pessoa> pessoas = new ArrayList<>();

        pessoas.add(new Pessoa("PR", "Medianeira"));
        pessoas.add(new Pessoa("PR", "Cascavel"));
        pessoas.add(new Pessoa("PR", "S�o Miguel"));

        pessoas.add(new Pessoa("SC", "Florianópolis"));
        pessoas.add(new Pessoa("SC", "Chapeco"));

        pessoas.add(new Pessoa("BA", "Salvador"));
        pessoas.add(new Pessoa("BA", "Barreiras"));

        Collections.sort(pessoas);

        for (Pessoa p : pessoas) {
            System.out.println(p);
        }
    }
}
