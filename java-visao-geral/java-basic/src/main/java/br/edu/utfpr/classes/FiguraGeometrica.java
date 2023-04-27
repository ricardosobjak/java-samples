package br.edu.utfpr.classes;

public abstract class FiguraGeometrica {

    private int lados;

    public FiguraGeometrica() {
    }

    public FiguraGeometrica(int lados) {
        this.lados = lados;
    }

    public int getLados() {
        return lados;
    }

    public void setLados(int lados) {
        this.lados = lados;
    }

}
