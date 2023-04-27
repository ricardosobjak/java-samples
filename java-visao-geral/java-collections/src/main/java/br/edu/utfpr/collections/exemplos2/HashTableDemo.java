package br.edu.utfpr.collections.exemplos2;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Enumeration;
import java.util.Hashtable;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

// Demonstrates the Hashtable class of the java.util package.
/**
 * HashTable is synchronized. Iterator in the HashMap is fail-safe while the
 * enumerator for the Hashtable isn�t. Hashtable doesn�t allow nulls Below is a
 * HashTable Example showing how collections are manipulated using a HashTable
 */
public class HashTableDemo extends JFrame {

    public HashTableDemo() {
        super("Hashtable Sourcecode Example");

        final JLabel jlbStatus = new JLabel();
        final Hashtable hashTable = new Hashtable();
        final JTextArea display = new JTextArea(4, 20);

        display.setEditable(false);
        JPanel jplNorth = new JPanel();
        jplNorth.setLayout(new BorderLayout());
        JPanel jplNorthSub = new JPanel();
        jplNorthSub.add(new JLabel("Name (Key)"));

        final JTextField jtfFirstName = new JTextField(8);
        jplNorthSub.add(jtfFirstName);
        jplNorthSub.add(new JLabel("Phone No"));

        final JTextField jtfPhone = new JTextField(8);
        jplNorthSub.add(jtfPhone);
        jplNorth.add(jplNorthSub, BorderLayout.NORTH);
        jplNorth.add(jlbStatus, BorderLayout.SOUTH);

        JPanel jplSouth = new JPanel();
        jplSouth.setLayout(new GridLayout(2, 5));

        JButton jbnAdd = new JButton("Add");
        jbnAdd.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String strNum = jtfPhone.getText().trim();
                String strName = jtfFirstName.getText().trim();
                if ((strNum != null && strNum.equals(""))
                        || (strName != null && strName.equals(""))) {
                    JOptionPane.showMessageDialog(HashTableDemo.this,
                            "Please enter both Name and Phone No");
                    return;
                }
                int num = 0;
                try {
                    num = Integer.parseInt(strNum);
                } catch (NumberFormatException ne) {
                    ne.printStackTrace();
                }
                EmployeeDetails emp = new EmployeeDetails(strName, num);
                Object val = hashTable.put(strName, emp);
                if (val == null) {
                    jlbStatus.setText("Added: " + emp.toString());
                } else {
                    jlbStatus.setText("Added: " + emp.toString()
                            + "; Replaced: " + val.toString());
                }
            }
        });
        jplSouth.add(jbnAdd);

        JButton jbnGet = new JButton("Get");
        jbnGet.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object val = hashTable.get(jtfFirstName.getText().trim());
                if (val != null) {
                    jlbStatus.setText("Get: " + val.toString());
                } else {
                    jlbStatus.setText("Get: " + jtfFirstName.getText()
                            + " not in table");
                }
            }
        });
        jplSouth.add(jbnGet);

        JButton jbnRemove = new JButton("Remove Name");
        jbnRemove.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                Object val = hashTable.remove(jtfFirstName.getText()
                        .trim());
                if (val != null) {
                    jlbStatus.setText("Remove: " + val.toString());
                } else {
                    jlbStatus.setText("Remove: " + jtfFirstName.getText()
                            + " not in table");
                }
            }
        });
        jplSouth.add(jbnRemove);

        JButton jbnIsEmpty = new JButton("Empty ?");
        jbnIsEmpty.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jlbStatus.setText("Empty: " + hashTable.isEmpty());
            }
        });
        jplSouth.add(jbnIsEmpty);

        JButton jbnContains = new JButton("Contains key");
        jbnContains.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                jlbStatus.setText("Contains key: "
                        + hashTable.containsKey(jtfFirstName.getText().trim()));
            }
        });
        jplSouth.add(jbnContains);

        JButton jbnClear = new JButton("Clear table");
        jbnClear.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                hashTable.clear();
                jlbStatus.setText("HashTable Emptied");
            }
        });
        jplSouth.add(jbnClear);

        JButton jbnDisplay = new JButton("List objects");
        jbnDisplay.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                StringBuffer buf = new StringBuffer();
                for (Enumeration enume = hashTable.elements();
                        enume.hasMoreElements();) {
                    buf.append(enume.nextElement()).append('\n');
                }
                display.setText(buf.toString());
            }
        });
        jplSouth.add(jbnDisplay);

        JButton jbnKeys = new JButton("List keys");
        jbnKeys.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                StringBuffer buf = new StringBuffer();
                for (Enumeration enume = hashTable.keys(); enume.hasMoreElements();) {
                    buf.append(enume.nextElement()).append('\n');
                }
                JOptionPane.showMessageDialog(null, buf.toString(),
                        "Display Keys of HashTable ", JOptionPane.PLAIN_MESSAGE);
            }
        });
        jplSouth.add(jbnKeys);

        Container c = getContentPane();
        c.add(jplNorth, BorderLayout.NORTH);
        c.add(new JScrollPane(display), BorderLayout.CENTER);
        c.add(jplSouth, BorderLayout.SOUTH);
        setSize(540, 300);
        setVisible(true);
    }

    public static void main(String args[]) {
        HashTableDemo hashTableDemo = new HashTableDemo();
        hashTableDemo.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}

class EmployeeDetails {

    private String name;
    private int phoneNp;

    public EmployeeDetails(String fName, int phNo) {
        name = fName;
        phoneNp = phNo;
    }

    public String toString() {
        return name + " " + phoneNp;
    }
}
