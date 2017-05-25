
package forumdb.EntitiesFrames.Post;

import EntitiesClasses.Post;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class PostModel extends AbstractTableModel {

    List<Post> list = new ArrayList<>();
    Connection c;

    public PostModel(Connection c) {
        super();
        this.c = c;

        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"Post\"");

            while (rs.next()) {
                Post item = new Post(rs.getInt("ID_post"), rs.getInt("ID_cust"), rs.getInt("ID_sect"), rs.getString("Text"));

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
            ResultSet rs = statement.executeQuery("SELECT * FROM \"Post\"");
            list = new ArrayList<>();

            while (rs.next()) {
                Post item = new Post(rs.getInt("ID_post"), rs.getInt("ID_cust"), rs.getInt("ID_sect"), rs.getString("Text"));

                list.add(item); // добавление очередного юзера в список
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        rowsCount = list.size();
    }
    int rowsCount = 5;
    int colCount = 3;

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
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM \"Section\" where \"ID_sect\" = " + list.get(rowIndex).getID_sect() + ";");
                    rs.next();
                    s = rs.getString("Name_sect");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 1:
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM \"Customer\" where \"ID_cust\" = " + list.get(rowIndex).getID_cust() + ";");
                    rs.next();
                    s = rs.getString("Login");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 2:
                return list.get(rowIndex).getText();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Name_sect";
            case 1:
                return "Login";
            case 2:
                return "Text";
        }
        return null;
    }

    public Post getSelectesItem(int row) {
        return list.get(row);
    }
}
