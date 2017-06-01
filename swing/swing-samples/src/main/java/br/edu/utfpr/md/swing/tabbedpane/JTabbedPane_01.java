package br.edu.utfpr.md.swing.tabbedpane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.KeyEvent;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

/**
 * Criando JTabbedPane básico
 *
 * @author Sobjak
 */
public class JTabbedPane_01 {

    public static void main(String[] args) {
        // Instanciando um Frame
        JFrame frame = new JFrame("Swing - Exemplo com JTabbedPane");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JTabbedPane tabbedPane = new JTabbedPane();

        JComponent panel1 = new JPanel();
        panel1.add(new Label("TAB 1"));
        tabbedPane.addTab("Tab 1", panel1);
        tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);

        JComponent panel2 = new JPanel();
        panel2.add(new Label("TAB 2"));
        tabbedPane.addTab("Tab 2", panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);

        JComponent panel3 = new JPanel();
        panel3.add(new Label("TAB 3"));
        tabbedPane.addTab("Tab 3", panel3);
        tabbedPane.setMnemonicAt(2, KeyEvent.VK_3);

        JComponent panel4 = new JPanel();
        panel4.add(new Label("TAB 4"));
        panel4.setPreferredSize(new Dimension(410, 50));
        tabbedPane.addTab("Tab 4", panel4);
        tabbedPane.setMnemonicAt(3, KeyEvent.VK_4);
        
        
        frame.getContentPane().add(tabbedPane, BorderLayout.CENTER);

        // Exibindo a JFrame
        frame.setVisible(true);
    }

}
