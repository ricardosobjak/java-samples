package br.edu.utfpr.md.swing.layout;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class FlowLayout_Ex1 {
        
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo Layouts: FlowLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
        
        // Configurando o gerenciador de layout como FlowLayout
        FlowLayout layout = new FlowLayout(FlowLayout.CENTER, 50, 10);
        frame.getContentPane().setLayout(layout);
        
        
        for(int i=0; i<10; i++) {
            JLabel label = new JLabel("Label " + i);
            label.setBounds(10+i*50, 10+i*50, 150, 40); //Essa config é desconsiderada
            label.setOpaque(true);
            label.setBackground(new Color(i*20));
            label.setForeground(Color.white);
            frame.getContentPane().add(label);
        }

    }
}
