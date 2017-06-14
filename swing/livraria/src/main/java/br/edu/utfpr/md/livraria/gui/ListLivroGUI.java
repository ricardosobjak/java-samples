package br.edu.utfpr.md.livraria.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ListLivroGUI extends JDialog {

    private JTable table;
    private DefaultTableModel tableModel;

    private Object[][] data = {
        {"Amanda", "01235678900", "25/08/1995"},
        {"Leocir", "33355578900", "08/02/1982"},
        {"Marcos", "12125378900", "15/10/2000"},};

    public ListLivroGUI(JFrame owner) {
        super(owner);
        setLayout(new BorderLayout());

        setModal(true);
        setTitle("Livros");
        setSize(600, 400);

        add(construirPainelBotoes(), BorderLayout.NORTH);
        add(construirPainelPrincipal(), BorderLayout.CENTER);

        setVisible(true);
    }

    private JComponent construirPainelPrincipal() {
        String[] columnNames = {"Nome", "CPF", "Nascimento"};

        this.tableModel = new DefaultTableModel(data, columnNames);
        this.table = new JTable(tableModel);

        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        JScrollPane scrollPane = new JScrollPane(table);

        return scrollPane;
    }

    private JPanel construirPainelBotoes() {
        FlowLayout layout = new FlowLayout(FlowLayout.LEFT);
        JPanel painel = new JPanel(layout);

        JButton bt1 = new JButton("+");
        JButton bt2 = new JButton("Botão 2");

        painel.add(bt1);
        painel.add(bt2);

        bt1.addActionListener((e) -> {
            addLinhaTable();
        });

        bt2.addActionListener((e) -> {
            delLinhaTable();
        });

        return painel;
    }

    private void addLinhaTable() {
        tableModel.addRow(new String[]{"Nome", "0000", "12/12/2012"});
    }

    private void delLinhaTable() {
        int rows[] = table.getSelectedRows();
        for (int i = rows.length; i > 0; i--) {
            tableModel.removeRow(i);
        }
    }
}
