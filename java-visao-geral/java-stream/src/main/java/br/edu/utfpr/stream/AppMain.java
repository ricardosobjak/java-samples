package br.edu.utfpr.stream;

import static java.lang.System.out;
import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * EXEMPLO: Filtrando contas bancárias
 *
 * Modo 1: Modo primitivo, antes de Java 8 Mod0 2: Utilizando uma expressão
 * Lambda Modo 3: Função filter do API Stream do Java
 */
public class AppMain {

    public static void main(String[] args) {

        Banco banco = new Banco();

        Conta[] contas = {
            new Conta("0001", 1100),
            new Conta("0002", 10000),
            new Conta("0003", 0),
            new Conta("0004", -50),
            new Conta("0005", 22000),
            new Conta("0006", 3500),
            new Conta("0007", 72000)
        };

        banco.contas = Arrays.asList(contas);

        /**
         * Modo1: Comandos necessários para chamar o método filtroDeContas (Java
         * menor que 8)
         *
         * Ex: Filtrar as contas com saldo acima de 10000.
         */
        Collection<Conta> filtradas1 = banco.filtroDeContas(new ContaFilter() {
            public boolean accept(Conta c) {
                return c.getSaldo() >= 10000;
            }
        });
        System.out.println("Filtradas (Java < 8): " + filtradas1);

        /**
         * Modo 2: Uso de expressão Lambda (Java 8)
         *
         * Exemplo: mostrar contas com saldo 0 ou negativo
         */
        Collection<Conta> filtradas2 = banco.filtroDeContas((Conta c) -> c.getSaldo() <= 0);
        System.out.println("Filtradas com Lambda (Java >= 8): " + filtradas2);

        /**
         * Modo 3: Aplicando funções de stream.
         *
         * Ex: Filtrando Contas com saldo positivo
         */
        Stream<Conta> stream = banco.contas.stream(); // Obter o stream da coleção
        System.out.println("Filtradas com Stream (1): ");
        stream
                .filter(c -> c.getSaldo() > 0) // Aplicando a função de filtro
                .forEach(c -> System.out.println(c.getNumero())); //Interagindo com os resultados filtrados

        System.out.println("Filtradas com Stream (2): ");
        banco.contas.stream()
                .filter(c -> c.getSaldo() > 0) // Aplicando a função de filtro
                .forEach(System.out::println); //Interagindo com os resultados filtrados

        System.out.println("Filtradas com Stream (2): ");

        float total = banco.contas.stream()
                .map(conta -> conta.getSaldo())
                .reduce(0F, (subtotal, elemento) -> subtotal + elemento);
        System.out.println("Saldo do Banco: " + total);

        float total2 = banco.contas.stream()
                .map(conta -> conta.getSaldo())
                .reduce(0F, Float::sum);

        System.out.println("Saldo do Banco: " + total2);

        /**
         * Usando um combinador
         *
         * Simplificando, se usarmos fluxos sequenciais e os tipos de argumentos
         * do acumulador e os tipos de sua implementação corresponderem, não
         * precisaremos usar um combinador.
         */
        float total3 = banco.contas.stream().reduce(0F, (subtotal, conta) -> subtotal + conta.getSaldo(), (a, b) -> a * b);
        float total4 = banco.contas.stream().reduce(0F, (subtotal, conta) -> subtotal + conta.getSaldo(), Float::sum);
        System.out.println("Saldo do Banco: " + total3);
    }

}
