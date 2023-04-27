package br.edu.utfpr.enumeration.ex1;

public class Computer {

    public static final int POWER_OFF = 0;
    public static final int POWER_ON = 1;
    public static final int POWER_SUSPEND = 2;

    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
