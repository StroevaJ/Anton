
package forumdb.EntitiesFrames.Customer;

import EntitiesClasses.Customer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class CustomerModel extends AbstractTableModel {

    List<Customer> users = new ArrayList<>();
    Connection c;

    public CustomerModel(Connection c) {
        super();
        this.c = c;

        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"Customer\"");

            while (rs.next()) {
                Customer user = new Customer(rs.getInt("ID_cust"), rs.getString("Login"), 
                        rs.getString("Password"), rs.getInt("ID_role"), 
                        rs.getString("Family"), rs.getString("Name"), 
                        rs.getString("Patronymic"), rs.getString("Email"));

                users.add(user);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        rowsCount = users.size();
    }

    public void updateData() {
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"Customer\"");
            users = new ArrayList<>();

            while (rs.next()) {
                Customer user = new Customer(rs.getInt("ID_cust"), rs.getString("Login"), 
                        rs.getString("Password"), rs.getInt("ID_role"), 
                        rs.getString("Family"), rs.getString("Name"), 
                        rs.getString("Patronymic"), rs.getString("Email"));

                users.add(user); // добавление очередного юзера в список
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
        rowsCount = users.size();
    }
    int rowsCount = 5;
    int colCount = 7;

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
        switch (columnIndex) {
            case 0:
                return users.get(rowIndex).getLogin();
            case 1:
                return users.get(rowIndex).getPassword();
            case 2:
                String s = "";
                try {
                    Statement statement = c.createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM \"Roles\" where \"ID_role\" = " + users.get(rowIndex).getID_role() + ";");
                    rs.next();
                    s = rs.getString("Name_role");

                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
                }
                return s;
            case 3:
                return users.get(rowIndex).getFamily();
            case 4:
                return users.get(rowIndex).getName();
            case 5:
                return users.get(rowIndex).getPatronymic();
            case 6:
                return users.get(rowIndex).getEmail();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Login";
            case 1:
                return "Password";
            case 2:
                return "Role name";
            case 3:
                return "Family";
            case 4:
                return "Name";
            case 5:
                return "Patronymic";
            case 6:
                return "Email";
        }
        return null;
    }

    public Customer getSelectesUser(int row) {
        return users.get(row);
    }

}
