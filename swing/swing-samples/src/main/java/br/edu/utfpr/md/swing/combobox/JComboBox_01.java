package br.edu.utfpr.md.swing.combobox;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/**
 * Criando JComboBox básico com alguns itens
 * 
 * @author Sobjak
 */
public class JComboBox_01 {

    public static void main(String[] args) {
        // Instanciando um Frame
        JFrame frame = new JFrame("Swing - Exemplo com JComboBox");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());

        
        String[] petStrings = { "Bird", "Cat", "Dog", "Rabbit", "Pig" };
        JComboBox petList = new JComboBox(petStrings);
        petList.addItem("Other");
        
        
        petList.setSelectedIndex(2); //Selecionando um item padrão

        // Configurando ação 
        petList.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("Selecionou o " + petList.getSelectedItem() + ". Index: " + petList.getSelectedIndex());
            }
        });
        

        frame.getContentPane().add(petList);

        // Exibindo a JFrame
        frame.pack();
        frame.setVisible(true);
    }
}
