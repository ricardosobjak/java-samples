package br.edu.utfpr.md.swing.jlist;

import java.awt.FlowLayout;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;

/**
 * Criando JList básico com alguns itens
 * 
 * @author Sobjak
 */
public class JList_01 {

    public static void main(String[] args) {
        // Instanciando um Frame
        JFrame frame = new JFrame("Swing - Exemplo com JList");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());

        DefaultListModel model = new DefaultListModel();
        JList list = new JList(model);

        for (int i = 0; i < 50; i++) {
            model.add(i, "Item " + (i+1));
        }
        
        // Adicionando dados no início do JList de forma dinâmica:
        model.add(0, "Item inicial");
        
        // Adicionando dados no final do JList de forma dinâmica:
        model.add(model.getSize(), "Item final");

        frame.getContentPane().add(list);

        // Exibindo a JFrame
        frame.setVisible(true);
    }
}
