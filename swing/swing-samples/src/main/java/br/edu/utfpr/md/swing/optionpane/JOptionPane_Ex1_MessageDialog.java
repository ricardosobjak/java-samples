package br.edu.utfpr.md.swing.optionpane;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;


public class JOptionPane_Ex1_MessageDialog {
        
    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo com JOptionPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        
        // Instanciando os botões
        JButton button1 = new JButton("Informativo");
        JButton button2 = new JButton("Alerta");
        JButton button3 = new JButton("Erro");
        
        // Configurando o tamanho dos botões
        button1.setPreferredSize(new Dimension(180, 30));
        button2.setPreferredSize(new Dimension(180, 30));
        button3.setPreferredSize(new Dimension(180, 30));
    
        // Adicionando os botões ao painel principal do JFrame
        frame.getContentPane().add(button1);
        frame.getContentPane().add(button2);
        frame.getContentPane().add(button3);
        
        
                frame.pack();
        frame.setVisible(true);

        
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Esta é uma mensagem informativa.");

            }
        });
        
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Esta é uma mensagem de alerta.", "Cuidado", JOptionPane.WARNING_MESSAGE);
            }
        });
        
        button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(frame, "Esta é uma mensagem de erro.", "Ih lascou", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
