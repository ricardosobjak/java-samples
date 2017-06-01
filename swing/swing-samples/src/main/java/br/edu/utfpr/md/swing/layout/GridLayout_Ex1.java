package br.edu.utfpr.md.swing.layout;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class GridLayout_Ex1 {
        
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo Layouts: GridLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        frame.setSize(800, 600);
        
        // Configurando o gerenciador de layout como GridLayout
        GridLayout layout = new GridLayout(5,5);
        frame.getContentPane().setLayout(layout);
        
        
        for(int i=0; i<25; i++) {
            JLabel label = new JLabel("Label " + i);
            label.setBorder(BorderFactory.createLineBorder(Color.red));
            frame.getContentPane().add(label);
        }
        
        //frame.pack();
        frame.setVisible(true);
    }
}