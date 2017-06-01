package br.edu.utfpr.md.swing.optionpane;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class JOptionPane_Ex2_OptionDialog {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo com JOptionPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new FlowLayout());
        frame.setSize(300,200);

        // Instanciando os botões
        JButton button1 = new JButton("Mensagem com opções");

        // Configurando o tamanho dos botões
        button1.setPreferredSize(new Dimension(180, 30));

        // Adicionando os botões ao painel principal do JFrame
        frame.getContentPane().add(button1);

        frame.setVisible(true);

        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Custom button text
                Object[] options = {"Sim, quero muito",
                    "Não, obrigado",
                    "Não sei, estou em dúvida!"};
                int res = JOptionPane.showOptionDialog(frame,
                        "Você gostaria de ser em programador Java?",
                        "Sua carreita",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        options,
                        options[0]);
                
                System.out.println("A resposta foi: " + res);
            }
        });
    }
}
