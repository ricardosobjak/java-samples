package br.edu.utfpr.md.swing.jlist;

import java.awt.FlowLayout;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;

/**
 * Criando JList contendo uma barra de rolagem para os itens.
 *
 * @author Sobjak
 */
public class JList_02 {

    public static void main(String[] args) {
        // Instanciando um Frame
        JFrame frame = new JFrame("Swing - Exemplo com JList");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());

        DefaultListModel model = new DefaultListModel();
        JList list = new JList(model);

        for (int i = 0; i < 50; i++) {
            model.add(model.getSize(), "Item " + (i + 1));
        }

        // Criando um JScrollPane para a Jlist
        JScrollPane jscroll = new JScrollPane(list);
        
        // Adicionando o JScrollPane no painel principal
        frame.getContentPane().add(jscroll);

        // Exibindo a JFrame
        frame.setVisible(true);
    }
}
