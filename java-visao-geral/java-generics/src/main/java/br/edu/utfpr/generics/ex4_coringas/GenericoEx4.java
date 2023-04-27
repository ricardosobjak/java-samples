package br.edu.utfpr.generics.ex4_coringas;

class Duas {

    int x, y;

    Duas(int a, int b) {
        x = a;
        y = b;
    }
}

class Tres extends Duas {

    int z;

    Tres(int a, int b, int c) {
        super(a, b);
        z = c;
    }
}

class Quatro extends Tres {

    int t;

    Quatro(int a, int b, int c, int d) {
        super(a, b, c);
        t = d;
    }
}

/**
 * Classe Genérica que aceita qualquer tipo de Classe ou Interface que extenda
 * de "Duas".
 *
 * @param <T>
 */
class Generica<T extends Duas> {

    T[] coords;

    Generica(T[] o) {
        coords = o;
    }
}

/**
 * Classe que demonstra a utilização de Coringas em tipos genéricos.
 *
 */
public class GenericoEx4 {

    /**
     * M�todo que faz a impress�o de todos os valores contidos no array dentro
     * da classe "Generica". O m�todo deve receber como par�metro, um objeto da
     * classe "Generica<?>", ou seja, qualquer objeto "Generica" instanciado
     * como um subtipo de "Duas".
     *
     * @param c
     */
    static void showDuas(Generica<?> c) {
        System.out.println("Coordenadas X Y:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
        }
        System.out.println();
    }

    /**
     * M�todo que faz a impress�o de todos os valores contidos no array dentro
     * de uma classe "Generica". O m�todo deve receber como par�metro, um objeto
     * da classe "Generica<? extends Tres>", ou seja, qualquer objeto "Generica"
     * instanciado como um subtipo de "Tres".
     *
     * @param c
     */
    static void showTres(Generica<? extends Tres> c) {
        System.out.println("Coordenadas X Y Z:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z);
        }
        System.out.println();
    }

    /**
     * M�todo que faz a impress�o de todos os valores contidos no array dentro
     * de uma classe "Generica". O m�todo deve receber como par�metro, um objeto
     * da classe "Generica<? extends Quatro>", ou seja, qualquer objeto
     * "Generica" instanciado como um subtipo de "Quatro".
     *
     * @param c
     */
    static void showTodas(Generica<? extends Quatro> c) {
        System.out.println("Coordenadas X Y Z T:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y + " " + c.coords[i].z + " " + c.coords[i].t);
        }
        System.out.println();
    }

    /**
     * M�todo que faz a impress�o de todos os valores contidos no array dentro
     * de uma classe "Generica". O m�todo deve receber como par�metro, apenas
     * objetos da classe "Generica<Duas>".
     *
     * @param c
     */
    static void showSemCoringa(Generica<Duas> c) {
        System.out.println("Coordenadas X Y:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
        }
        System.out.println();
    }

    /**
     * M�todo que faz a impress�o de todos os valores contidos no array dentro
     * de uma classe "Generica". O m�todo deve receber como par�metro, um objeto
     * da classe "Generica<? super Tres>", ou seja, qualquer objeto "Generica"
     * instanciado como uma classe "Tres" ou de seus supertipos.
     *
     * @param c
     */
    static void showSuperTres(Generica<? super Tres> c) {
        System.out.println("Coordenadas X Y:");
        for (int i = 0; i < c.coords.length; i++) {
            System.out.println(c.coords[i].x + " " + c.coords[i].y);
        }
        System.out.println();
    }

    public static void main(String args[]) {
        //Instanciação de arrays com objetos das classes do modelo (Duas, Tres ou Quatro)
        Duas array2d[] = {new Duas(0, 0), new Duas(7, 9), new Duas(18, 4), new Duas(-1, -23)};
        Quatro array4d[] = {new Quatro(1, 2, 3, 4), new Quatro(6, 8, 14, 8), new Quatro(22, 9, 4, 9), new Quatro(3, -2, -23, 17)};

        //Instanciação de Classes gen�ricas que aceitam qualquer subtipo de "Duas"
        Generica<Duas> generica2d = new Generica<>(array2d);
        Generica<Quatro> generica4d = new Generica<>(array4d);

        /* ---------------------------------------------------------
        * Casos de testes de invocação de m�todos com coringas
        * --------------------------------------------------------- */
        //// 1º caso: Método que não utiliza conringas
        System.out.println("SHOW CASO 1: Conteúdo de generica2d sem coringa.");
        showSemCoringa(generica2d); //OK, aceita apenas Ge
        //showSemCoringa(generica4d);

        //// 2º caso: Método que utiliza conringas 
        System.out.println("SHOW CASO 2: Conteúdo de generica2d com coringa.");
        showDuas(generica2d); // OK, funciona! O Método aceita qualquer "Generica" de qualquer tipo (desde que respeite o tipo importo pela classe Generica)

        //// 3� caso: M�todo que utiliza coringas com limite superior (Aceita T e seus descendentes)
        System.out.println("SHOW CASO 3: Conte�do de generica4d, por tr�s m�todos com coringas.");
        // These are all OK.
        showDuas(generica4d); //OK! O m�todo showDuas aceita uma Gen�rica<?>, o generica4d atende a condi��o
        showTres(generica4d); //OK! O m�todo showTres aceita uma Gen�rica<? extends Tres>, o generica4d atende a condi��o
        showTodas(generica4d); //OK! O m�todo showTodas aceita uma Gen�rica<? extends Quatro>, o generica4d atende a condi��o

        //// 4� caso: casos que n�o podem ser utilizados
        System.out.println("SHOW CASO 4: Conte�do de generica3d.");
        //Generica<Tres> generica3d = new Generica<Tres>(array2d); //N�o pode! Pois Dois[] n�o extends Tres
        Generica<Tres> generica3d = new Generica<Tres>(array4d); //Pode! Instanciar uma classe Generica<Tres>, com um Quatro[], pois Quatro extends Tres.

        showDuas(generica3d); //OK! Pois "showDuas(<Generica<?>)" aceita um objeto "Generica<Tres>".
        showTres(generica3d); // OK! Pois "showTres(Generica<? extends Tres>)" aceita um objeto "Generica<Tres>".
        //showTodas(generica3d); //N�o pode! Pois "showTodas(Generica<? extends Quatro>)" n�o aceita um objeto "Generica<Tres>".

        //// 5� caso: imposi��o de limite inferior (aceita T e todos os seus ascendentes)
        System.out.println("SHOW CASO 5: Gen�rico com limite inferior (super)");
        showSuperTres(generica2d); //OK! Pois "showSuperTres(Generica<? super Tres>)" aceita "Generica<Tres>".
        showSuperTres(generica3d); //OK! Pois "showSuperTres(Generica<? super Tres>)" aceita "Generica<Dois>".
        // showSuperTres(generica4d); //N�o pode! Pois "showSuperTres(Generica<? super Tres>)" n�o aceita "Generica<Quatro>".

        //// Referenciando tipos gen�ricos
        //Generica<? extends Tres> genCor1 = generica2d; // Fail! 
        Generica<? extends Duas> genCor2 = generica3d; // OK!
        //Generica<? super Tres> genCor3 = generica4d; // Fail!
    }
}
