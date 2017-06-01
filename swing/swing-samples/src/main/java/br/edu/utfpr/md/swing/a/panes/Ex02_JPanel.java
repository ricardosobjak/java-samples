package br.edu.utfpr.md.swing.a.panes;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Ex02_JPanel {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo com JPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
        
        JPanel panel1 = new JPanel();
        JPanel panel2 = new JPanel();
        JPanel panel3 = new JPanel();
        JPanel panel4 = new JPanel();
        JPanel panel5 = new JPanel();
        
        panel1.setBackground(Color.red);
        panel2.setBackground(Color.blue);
        panel3.setBackground(Color.green);
        panel4.setBackground(Color.yellow);
        panel5.setBackground(Color.orange);
                        
        frame.getContentPane().add(panel1, BorderLayout.SOUTH);
        frame.getContentPane().add(panel2, BorderLayout.NORTH);
        frame.getContentPane().add(panel3, BorderLayout.EAST);
        frame.getContentPane().add(panel4, BorderLayout.WEST);
        frame.getContentPane().add(panel5, BorderLayout.CENTER); //ou simplesmente frame.getContentPane().add(panel5)
    }
}
