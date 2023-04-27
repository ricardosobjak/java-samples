package br.edu.utfpr.collections.exercicios.banco;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/*
 * Classe que representa os clientes do Banco
 */
class Cliente {

    String nome;
    String cpf;

    public Cliente(String nome, String cpf) {
        this.nome = nome;
        this.cpf = cpf;
    }
}

/*
 * Classe abstrata que representa as contas do Banco
 */
abstract class Conta {

    Cliente cliente;
    int numero;
    float saldo;

    public Conta(Cliente c, int numero, float saldo) {
        this.cliente = c;
        this.saldo = saldo;
        this.numero = numero;
    }
}

class ContaCorrente extends Conta {

    public ContaCorrente(Cliente c, int numero, float saldo) {
        super(c, numero, saldo);
    }
}

class Poupanca extends Conta {

    public Poupanca(Cliente c, int numero, float saldo) {
        super(c, numero, saldo);
    }
}

class Banco {

    Map<String, Cliente> clientes = new HashMap<>();
    Collection<Conta> contas = new HashSet<>();

    public void addConta(Conta c) {
        this.contas.add(c);
    }

    public Collection<Poupanca> getPoupancas() {
        Collection<Poupanca> poupancas = new HashSet<>();
        Iterator<Conta> iterator = contas.iterator();
        while (iterator.hasNext()) {
            Conta c = iterator.next();
            if (c instanceof Poupanca) {
                poupancas.add((Poupanca) c);
            }
        }
        return poupancas;
    }
}

public class ExercicioBanco {

}
