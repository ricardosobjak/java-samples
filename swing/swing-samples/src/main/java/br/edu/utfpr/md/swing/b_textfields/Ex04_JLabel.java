package br.edu.utfpr.md.swing.b_textfields;

import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;


public class Ex04_JLabel {
        
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo com Labels");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
        
        // Configurando o gerenciador de layout como FlowLayout
        frame.getContentPane().setLayout(new FlowLayout());
        
        // Instanciando os labels
        JLabel label1 = new JLabel("Texto do Label 1");
        JLabel label2 = new JLabel("Texto do Label 2");
        JLabel label3 = new JLabel("Texto do Label 3");
        
        // Configurando a posição e o tamanho dos botões (x, y, width, height)
        label1.setBounds(10,10,150,40);
        label2.setBounds(10,60,150,40);
        label3.setBounds(10,110,150,40);
        
        // Modificando a cor de fundo do label
        label1.setOpaque(true);
        label2.setOpaque(true);
        label1.setBackground(Color.red);
        label2.setBackground(Color.green);
        label3.setBackground(Color.blue); //Este continuará sem cor de background, pois o opaque=false
        
        // Adicionando os botões ao painel principal do JFrame
        frame.getContentPane().add(label1);
        frame.getContentPane().add(label2);
        frame.getContentPane().add(label3);
    }
}
