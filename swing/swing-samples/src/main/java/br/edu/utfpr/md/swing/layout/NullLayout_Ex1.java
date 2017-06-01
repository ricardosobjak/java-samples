package br.edu.utfpr.md.swing.layout;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class NullLayout_Ex1 {
        
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo Layouts: NullLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
        
        // Configurando o gerenciador de layout como NULL (desativando-o)
        frame.getContentPane().setLayout(null);
        
        for(int i=0; i<10; i++) {
            JLabel label = new JLabel("Label " + i);
            label.setBounds(10+i*50, 10+i*50, 150, 40);
            label.setOpaque(true);
            label.setBackground(new Color(i*20));
            label.setForeground(Color.white);
            frame.getContentPane().add(label);
        }

    }
}
