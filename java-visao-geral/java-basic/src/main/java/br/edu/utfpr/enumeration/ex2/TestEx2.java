package br.edu.utfpr.enumeration.ex2;

public class TestEx2 {

    public static void main(String[] args) {
        Computer c1 = new Computer();
        c1.setState(PowerState.ON);

        System.out.println(c1.getState());
    }
}
