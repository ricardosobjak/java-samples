package br.edu.utfpr.md.swing.a.panes;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Ex03_JDialog {

    public static class MeuDialog extends JDialog {

        public MeuDialog(JFrame parent, String title, String message) {
            super(parent, title);
            System.out.println("creating the window..");
            
            this.setLocation(400, 400);

            // Create a message
            JPanel messagePane = new JPanel();
            messagePane.add(new JLabel(message));

            // get content pane, which is usually the
            // Container of all the dialog's components.
            this.getContentPane().add(messagePane);

            // Create a button
            JPanel buttonPane = new JPanel();
            JButton button = new JButton("Fechar");
            buttonPane.add(button);
            
            button.addActionListener(event -> {
                System.out.println("Fechando a Janela");
                dispose();
            });
            
            this.getContentPane().add(buttonPane, BorderLayout.PAGE_END);
            this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);

            this.pack();
            this.setVisible(true);
        }

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo com JPanel");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setSize(800, 600);

        new MeuDialog(frame, "Caixa de diálogo", "Criando uma caixa de diálogo personalizada");
    }
}
