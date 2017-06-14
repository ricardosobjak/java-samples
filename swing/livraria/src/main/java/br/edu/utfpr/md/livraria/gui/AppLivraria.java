package br.edu.utfpr.md.livraria.gui;

import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class AppLivraria extends JFrame {
    public static final AppLivraria INSTANCE;
    
    static {
        INSTANCE = new AppLivraria();
    }
    
    public static AppLivraria getInstance() {
        return INSTANCE;
    }

    public AppLivraria() {
        super("Gestor de livraria");
        setSize(800,600);
        
        //Criando o painel contendo os botões de ação
        getContentPane().add(createActionBar());
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Iniciar o frame de forma MAXIMIZADA
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        setVisible(true);
        
    }

    private JPanel createActionBar() {
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        JPanel panel = new JPanel(layout);
                       
        JButton btCadLivro = new JButton("Cadastrar Livro");
        JButton btListLivro = new JButton("Listar Livro");
        
        btCadLivro.addActionListener(e -> {
            FormLivroGUI gui = new FormLivroGUI(AppLivraria.this);
        });
        
        panel.add(btCadLivro);
        panel.add(btListLivro);
        
        return panel;
    }
    
    public static void main(String[] args) {
        
    }
}
