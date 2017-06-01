package br.edu.utfpr.md.swing.optionpane;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOptionPane_Ex3_InputDialog {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo com JOptionPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(300, 200);

        // Instanciando os botões
        JButton button1 = new JButton("JOptionPane com caixa de seleção");
        JButton button2 = new JButton("JOptionPane com caixa de texto");

        // Configurando o tamanho dos botões
        button1.setPreferredSize(new Dimension(250, 30));
        button2.setPreferredSize(new Dimension(250, 30));

        // Adicionando os botões ao painel principal do JFrame
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);

        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] possibilities = {"Dormir", "Estudar", "Correr"};
                String res = (String) JOptionPane.showInputDialog(
                        frame, "O que você quer fazer agora?",
                        "Escolha uma opção:",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        possibilities,
                        "Estudar");
                
                System.out.println("A resposta foi: " + res);
            }
        });
        
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Object[] possibilities = {"Dormir", "Estudar", "Correr"};
                String res = (String) JOptionPane.showInputDialog(
                        frame, "O que você quer fazer agora?",
                        "Escolha uma opção:",
                        JOptionPane.INFORMATION_MESSAGE,
                        null,
                        null,
                        "Estudar");
                
                System.out.println("A resposta foi: " + res);
            }
        });
    }
}
