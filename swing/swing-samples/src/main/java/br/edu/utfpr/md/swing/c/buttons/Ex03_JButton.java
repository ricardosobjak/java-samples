package br.edu.utfpr.md.swing.c.buttons;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Ex03_JButton {
        
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo com Botões");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);
        
        // Configurando o gerenciador de layout como NULL (desativando-o)
        frame.getContentPane().setLayout(null);
        
        // Instanciando os botões
        JButton button1 = new JButton("Botão 1");
        JButton button2 = new JButton("Botão 2");
        JButton button3 = new JButton("Botão 3");
        
        // Configurando o tamanho dos botões
        button1.setSize(180,200);
        button2.setSize(180,200);
        button3.setSize(180,200);
        
        // Configurando a posição e o tamanho dos botões (x, y, width, height)
        button1.setBounds(10,10,150,40);
        button2.setBounds(10,60,150,40);
        button3.setBounds(10,110,150,40);
        
        // Adicionando os botões ao painel principal do JFrame
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        frame.getContentPane().add(button3);
    }
}
