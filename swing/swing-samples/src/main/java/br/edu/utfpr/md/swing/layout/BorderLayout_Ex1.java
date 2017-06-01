package br.edu.utfpr.md.swing.layout;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BorderLayout_Ex1 {
        
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo Layouts: BorderLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
        
        // Configurando o gerenciador de layout como BorderLayout
        BorderLayout layout = new BorderLayout();
        frame.getContentPane().setLayout(layout);
        
        
        // Pode-se colocar elementos em 5 posições dentro do BorderLayout
        JLabel label1 = new JLabel("Texto do Label 1");
        JLabel label2 = new JLabel("Texto do Label 2");
        JLabel label3 = new JLabel("Texto do Label 3");
        JLabel label4 = new JLabel("Texto do Label 4");
        JLabel label5 = new JLabel("Texto do Label 5");
 
        label1.setBorder(BorderFactory.createLineBorder(Color.black));
        label2.setBorder(BorderFactory.createLineBorder(Color.black));
        label3.setBorder(BorderFactory.createLineBorder(Color.black));
        label4.setBorder(BorderFactory.createLineBorder(Color.black));
        label5.setBorder(BorderFactory.createLineBorder(Color.black));
        
        frame.getContentPane().add(label1, BorderLayout.NORTH);
        frame.getContentPane().add(label2, BorderLayout.SOUTH);
        frame.getContentPane().add(label3, BorderLayout.EAST);
        frame.getContentPane().add(label4, BorderLayout.WEST);
        frame.getContentPane().add(label5, BorderLayout.CENTER);
    }
}
