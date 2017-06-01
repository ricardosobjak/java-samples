package br.edu.utfpr.md.swing.layout;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JFrame;

public class GridBagLayout_Ex1 {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Swing - Exemplo Layouts: GridBagLayout");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(800, 600);

        // Configurando o gerenciador de layout como GridBagLayout
        GridBagLayout layout = new GridBagLayout();
        frame.getContentPane().setLayout(layout);

        GridBagConstraints c = new GridBagConstraints();

        JButton button;
        

        //natural height, maximum width

        // Botão 1
        button = new JButton("Button 1");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 0;
        c.gridy = 0;
        frame.getContentPane().add(button, c);

        // Botão 2
        button = new JButton("Button 2");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 1;
        c.gridy = 0;
        frame.getContentPane().add(button, c);

        // Botão 3
        button = new JButton("Button 3");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridx = 2;
        c.gridy = 0;
        frame.getContentPane().add(button, c);

        // Botão 4
        button = new JButton("Long-Named Button 4");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 100;      //make this component tall
        c.weightx = 0.0;
        c.gridwidth = 3;
        c.gridx = 0;
        c.gridy = 1;
        frame.getContentPane().add(button, c);

        // Botão 5
        button = new JButton("Button 5");
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.anchor = GridBagConstraints.PAGE_END; //bottom of space
        c.insets = new Insets(10, 0, 0, 0);  //top padding
        c.gridx = 1;       //aligned with button 2
        c.gridwidth = 2;   //2 columns wide
        c.gridy = 2;       //third row
        frame.getContentPane().add(button, c);

        frame.pack();
        frame.setVisible(true);
    }
}
