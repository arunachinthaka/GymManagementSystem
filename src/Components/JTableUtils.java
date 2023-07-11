package Components;

import javax.swing.JTable;
import java.util.ArrayList;

public class JTableUtils {
    public static ArrayList<Object> getSelectedColumnData(JTable table, int column) {
        ArrayList<Object> columnData = new ArrayList<>();
        int[] selectedRows = table.getSelectedRows();

        for (int row : selectedRows) {
            Object cellData = table.getValueAt(row, column);
            columnData.add(cellData);
        }

        return columnData;
    }
}
