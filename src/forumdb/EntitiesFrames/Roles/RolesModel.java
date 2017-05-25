
package forumdb.EntitiesFrames.Roles;

import EntitiesClasses.Roles;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class RolesModel extends AbstractTableModel {

    List<Roles> list = new ArrayList<>();

    Connection c;

    public RolesModel(Connection c) {
        super();
        this.c = c;
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"Roles\"");
            while (rs.next()) {
                Roles item = new Roles(rs.getInt("ID_role"), rs.getString("Name_role"));

                list.add(item); // добавление очередного юзера в список
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        rowsCount = list.size();
    }

    public void updateData() {
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"Roles\"");
            list = new ArrayList<>();

            while (rs.next()) {
                Roles item = new Roles(rs.getInt("ID_role"), rs.getString("Name_role"));

                list.add(item); // добавление очередного юзера в список
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        rowsCount = list.size();
    }
    int rowsCount = 5;
    int colCount = 1;

    @Override
    public int getRowCount() {
        return rowsCount;
    }

    @Override
    public int getColumnCount() {
        return colCount;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String s = "";
        switch (columnIndex) {
            case 0:
                return list.get(rowIndex).getName_role();

        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Name";
        }
        return null;
    }

    public Roles getSelectesItem(int row) {
        return list.get(row);
    }
}
