

import javax.print.DocFlavor;
        import javax.swing.*;
        import java.awt.*;

public class ShowPacient extends JDialog {
    private JTable pacientTable;
    private String[][] data;
    private String[] columnNames;

    public ShowPacient(String[][] data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;

        pacientTable = new JTable(data, columnNames);
        add(new JScrollPane(pacientTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        setLayout(new FlowLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}
