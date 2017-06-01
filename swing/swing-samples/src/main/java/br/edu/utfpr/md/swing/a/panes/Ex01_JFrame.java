package br.edu.utfpr.md.swing.a.panes;

import javax.swing.JFrame;

public class Ex01_JFrame {
    
    public static void main(String[] args) {
        // Instanciando um Frame
        JFrame frame = new JFrame("Swing - Exemplo com JFrame");
        
        /*
            Configurando a ação padrão ao fechar a janela
                -JFrame.EXIT_ON_CLOSE — Exit the application.
                -JFrame.HIDE_ON_CLOSE — Hide the frame, but keep the application running.
                -JFrame.DISPOSE_ON_CLOSE — Dispose of the frame object, but keep the application running.
                -JFrame.DO_NOTHING_ON_CLOSE — Ignore the click.
        */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Configurando o tamanho da janela
        frame.setSize(800, 600);
        
        // Iniciar o frame de forma MAXIMIZADA
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        // Exibindo a JFramw
        frame.setVisible(true);
    }
}
