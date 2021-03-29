

import javax.print.DocFlavor;
import javax.swing.*;
import javax.swing.table.TableColumn;

import java.awt.*;

public class ShowSectiiInfo extends JDialog {
    private JTable sectiiTable;
    private String[][] data;
    private String[] columnNames;

    public ShowSectiiInfo(String[][] data, String[] columnNames) {
        this.data = data;
        this.columnNames = columnNames;

        sectiiTable = new JTable(data, columnNames);
        add(new JScrollPane(sectiiTable, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED));
        sectiiTable.getTableHeader().setReorderingAllowed(false);

        sectiiTable.setPreferredScrollableViewportSize(new Dimension(430,210));
        sectiiTable.getColumnModel().getColumn(0).setPreferredWidth(10);
        sectiiTable.getColumnModel().getColumn(1).setPreferredWidth(100);

        setLayout(new FlowLayout());
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        pack();
        setVisible(true);
    }
}
