package br.edu.utfpr.enumeration.ex1;

public class TestEx1 {

    public static void main(String[] args) {
        Computer c1 = new Computer();
        c1.setState(Computer.POWER_ON);

        System.out.println(c1.getState());

        c1.setState(33);
        System.out.println(c1.getState());
    }
}
