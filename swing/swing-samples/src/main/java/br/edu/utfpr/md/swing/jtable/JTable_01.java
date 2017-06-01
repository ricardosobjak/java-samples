package br.edu.utfpr.md.swing.jtable;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JScrollPane;
import javax.swing.JTable;

/**
 * Criando JTable básico com alguns itens
 *
 * @author Sobjak
 */
public class JTable_01 {

    public static void main(String[] args) {
        // Instanciando um Frame
        JFrame frame = new JFrame("Swing - Exemplo com JTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new FlowLayout());

        String[] columnNames = {"Nome", "CPF", "Nascimento"};

        Object[][] data = {
            {"Amanda", "01235678900", "25/08/1995"},
            {"Leocir", "33355578900", "08/02/1982"},
            {"Marcos", "12125378900", "15/10/2000"},};

        JTable table = new JTable(data, columnNames);
        table.setPreferredScrollableViewportSize(new Dimension(500, 70));
        table.setFillsViewportHeight(true);

        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                printDebugData(table);
            }
        });

        JScrollPane scrollPane = new JScrollPane(table);

        frame.getContentPane().add(scrollPane);

        // Exibindo a JFrame
        frame.setVisible(true);
    }
    
    private static void printDebugData(JTable table) {
        int numRows = table.getRowCount();
        int numCols = table.getColumnCount();
        javax.swing.table.TableModel model = table.getModel();
 
        System.out.println("Value of data: ");
        for (int i=0; i < numRows; i++) {
            System.out.print("    row " + i + ":");
            for (int j=0; j < numCols; j++) {
                System.out.print("  " + model.getValueAt(i, j));
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
