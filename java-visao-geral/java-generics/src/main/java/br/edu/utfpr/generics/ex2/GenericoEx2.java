package br.edu.utfpr.generics.ex2;

// Classes de teste da aplicação
public class GenericoEx2 {

    public static void main(String[] args) {

        // Instanciação dos Objetos de domínio do problema
        Empregado e1 = new Empregado("Juca");
        Empregado e2 = new Empregado("Tião");
        Gerente g1 = new Gerente("Zé");
        Gerente g2 = new Gerente("Tuco");

        //Instanciação das classes genéricas utilitárias
        Par<Empregado> par1 = new Par<>(e1, e2);	//OK! Par de Empregados
        Par<Empregado> par2 = new Par<>(e1, g1);	//OK! Par de Empregado/Gerente
        Par<Empregado> par3 = new Par<>(g1, g2);        //OK! Par de Gerentes
        Par<Gerente> par4 = new Par<>(g1, g2);          //OK! Par de Gerentes
        //ParCoringa<Gerente> par5 = new ParCoringa<Gerente>(e1, e2); //FAIL! Par de Empregados

        /* -----------------------------------------------------
        * CASOS DE TESTES COM CLASSES GENÉRICAS NA APLICAÇÃO
        * ----------------------------------------------------- */
        //// 1º CASO: Explorando o método Print.printEmpregadoModo1
        Print.<Par>printEmpregadoModo1(par1); //OK! Mas apresenta "Unchecked Warwing", pois o parâmetros pode ser tanto Par<Empregado>, quanto Par<Gerente>.
        Print.<Par<Empregado>>printEmpregadoModo1(par2); //OK!
        Print.printEmpregadoModo1(par3); //OK, simplificado. Determina que o tipo � Par<Empregado> com base no parâmetro passado.
        //Print.printEmpregadoModo1(par4); //Fail! Pois o parâmetro é um Par
        Print.<Par>printEmpregadoModo1(par4); //OK! Apesar de par4 ser Par<Gerente> funciona, mas apresenta "Unchecked Warning".
        //Print.<Par<Gerente>>printEmpregadoModo1(par4); //Fail! Pois Par<Gerente> não herda do tipo Par<Empregado> genérico.
        //Print.<Par<Empregado>>printEmpregadoModo1(par4); //Fail!

        //// 2º CASO: Explorando o método printEmpregadoModo2
        Print.printEmpregadoModo2(par1);  //OK! Passando um Par<Empregado>
        Print.printEmpregadoModo2(par2);  //OK! Passando um Par<Empregado>
        Print.printEmpregadoModo2(par3);  //OK! Passando um Par<Empregado>
        //Print.printEmpregadoModo2(par4); //Fail! Passando um Par<Gerente>

        //// 3º CASO: Explorando o método printGerenteModo1
        // Print.printGerenteModo1(par1);  //Fail! Passando um Par<Empregado>
        Print.printGerenteModo1(par4); //OK! Passando um Par<Gerente>

        //// 4º CASO: Solução para método que aceite tanto "Par<Empregado>", quanto "Par<Gerente>". Uso de Coringas!
        Print.printEmpregadoCoringaModo1(par1);  //OK! Passando um "Par<Empregado>". Aceita qualquer tipo genérico de Par.
        Print.printEmpregadoCoringaModo1(par4);  //OK! Passando um "Par<Gerente>". Aceita qualquer tipo genérico de Par.

        Print.printEmpregadoCoringaModo2(par1);  //OK! Passando um "Par<Empregado>". Aceita "Empregado" e seus subtipos.
        Print.printEmpregadoCoringaModo2(par4);  //OK! Passando um "Par<Gerente>". Aceita "Gerente", pois é subtipo de "Empregado".

        Print.printEmpregadoCoringaModo3(par1);  //OK! Passando um "Par<Empregado>". Aceita um "Empregado" e seus supertipos.
        //Print.printEmpregadoCoringaModo3(par4);  //Fail! Passando um "Par<Gerente>". Pois "Gerente" não é um supertipo de "Empregado".
    }

}

class Print {

    /**
     * Este método aceita genéricos que extendam da classe "Par<Empregado>".
     *
     * @param a
     */
    public static <T extends Par<Empregado>> void printEmpregadoModo1(T a) {
        printAll(a);
    }

    /**
     * Este método aceita genéricos que extendam da classe "Par<Empregado>".
     *
     * @param a
     */
    public static void printEmpregadoModo2(Par<Empregado> a) {
        printAll(a);
    }

    /**
     * Este método aceita genéricos que extendam da classe "Par<Gerente>".
     *
     * @param a
     */
    public static <T extends Par<Gerente>> void printGerenteModo1(T a) {
        printAll(a);
    }

    /**
     * Aceita um Par genérico de qualquer tipo (<?>).
     *
     * @param a
     */
    public static void printEmpregadoCoringaModo1(Par<?> a) {
        printAll(a);
    }

    /**
     * Aceita um Par genérico de qualquer tipo que extenda de Empregado
     * (Par<? extends Empregado>)
     *
     * @param a
     */
    public static void printEmpregadoCoringaModo2(Par<? extends Empregado> a) {
        printAll(a);
    }

    /**
     * Aceita um Par genérico de qualquer tipo do qual o Empregado extende
     * (Par<? super Empregado>).
     *
     * @param a
     */
    public static void printEmpregadoCoringaModo3(Par<? super Empregado> a) {
        printAll(a);
    }

    public static void printAll(Par a) {
        System.out.println("Primeiro: " + a.getClass().getSimpleName() + ": " + a.primeiro);
        System.out.println("Segundo: " + a.getClass().getSimpleName() + ": " + a.segundo);
        System.out.println();
    }
}
