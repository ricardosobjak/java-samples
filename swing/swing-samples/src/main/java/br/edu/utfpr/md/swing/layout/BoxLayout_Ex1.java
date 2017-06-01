package br.edu.utfpr.md.swing.layout;

import java.awt.Color;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class BoxLayout_Ex1 {
        
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo Layouts: BoxLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
        
        // Configurando o gerenciador de layout como BoxLayout
        BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS);
        //BoxLayout layout = new BoxLayout(frame.getContentPane(), BoxLayout.X_AXIS);
        
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
