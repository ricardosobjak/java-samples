package br.edu.utfpr.md.livraria.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class FormLivroGUI extends JDialog {

    public FormLivroGUI(JFrame owner) {
        super(owner);
        setLayout(new BorderLayout());
        
        setModal(true);
        setTitle("Cadastro de livros");
        setSize(600,400);
        
        add(construirPainelBotoes(), BorderLayout.NORTH);
        add(construirPainelPrincipal(), BorderLayout.CENTER);
        
        setVisible(true);
    }
    
    private JPanel construirPainelPrincipal() {
        GridBagLayout layout = new GridBagLayout();
        JPanel painel = new JPanel(layout);

        GridBagConstraints c = new GridBagConstraints();
        c.anchor = GridBagConstraints.NORTHWEST; //Determina onde o componente deve ser alinhado
        c.insets = new Insets(5, 2, 2, 2);  // Definindo o espaçamento interno entre os componentes
        
        // Criando o rótulo do campo ID
        JLabel lId = new JLabel("ID");
        c.gridy = 0;     // linha
        c.gridx = 0;     // coluna
        c.gridwidth = 1; // quantidade de células
        c.weightx = 0;   // peso para expansão do componente na horizontal
        painel.add(lId, c);
        
        // Criando o campo ID
        JTextField tId = new JTextField();
        tId.setPreferredSize(new Dimension(100,20));
        tId.setMinimumSize(new Dimension(100,20));
        c.gridy = 0;     // linha
        c.gridx = 1;     // coluna
        c.gridwidth = 1; // quantidade de células
        c.weightx = 1;   // peso para expansão do componente na horizontal
        painel.add(tId, c);
       
        // Criando o rótulo do campo Título
        JLabel lTitulo = new JLabel("Título");
        c.gridy = 1;     // linha
        c.gridx = 0;     // coluna
        c.gridwidth = 1; // quantidade de células
        c.weightx = 0;   // peso para expansão do componente na horizontal
        painel.add(lTitulo, c);
        
        // Criando o campo Título
        JTextField tTitulo = new JTextField();
        tTitulo.setPreferredSize(new Dimension(300,20));
        c.fill = GridBagConstraints.HORIZONTAL; // Preencher o espaço restante na Horizontal
        c.gridy = 1;       // linha
        c.gridx = 1;       // coluna
        c.gridwidth = 2;   // quantidade de células
        c.weightx = 0.5;  // peso para expansão do componente na horizontal
        painel.add(tTitulo, c);
        
        // Criando um componente para preencher o espaço restante no painel
        JPanel restante = new JPanel();
        c.fill = GridBagConstraints.BOTH; // Preencher o espaço restante na horizontal e vertical
        c.gridy = 5;     // linha
        c.gridx = 0;     // coluna
        c.gridwidth = 2; // quantidade de células
        c.weighty = 1;
        c.weightx = 1;
        painel.add(restante, c);
        
        return painel;
    }
    
    private JPanel construirPainelBotoes() {
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        JPanel painel = new JPanel(layout);
        
        JButton bt1 = new JButton("Botão 1");
        JButton bt2 = new JButton("Botão 2");
        
        painel.add(bt1);
        painel.add(bt2);
        
        return painel;
    }
}
