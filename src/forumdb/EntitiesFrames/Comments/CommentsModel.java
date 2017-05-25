
package forumdb.EntitiesFrames.Comments;

import EntitiesClasses.Comments;
import EntitiesClasses.Customer;
import EntitiesClasses.Post;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class CommentsModel extends AbstractTableModel {

    List<Comments> list = new ArrayList<>();
    Connection c;

    public CommentsModel(Connection c) {
        super();
        this.c = c;
        updateData();
    }

    public void updateData() {
        list = getComment();
        rowsCount = list.size();
    }
    int rowsCount = 100;
    int colCount = 4;

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
                return list.get(rowIndex).getComment();
            case 1:
                return PostModel.getPostById(list.get(rowIndex).getID_post()).getText();
            case 2:
                return getCommentById(list.get(rowIndex).getID_com()).getComment();
            case 3:
                return CustomerModel.getCustomerById(list.get(rowIndex).getID_cust()).getLogin();
        }
        return null;
    }

    @Override
    public String getColumnName(int column) {
        switch (column) {
            case 0:
                return "Comment text";
            case 1:
                return "Post";
            case 2:
                return "Prev comment";
            case 3:
                return "User login";
        }
        return null;
    }

    public Comments getSelectesItem(int row) {
        return list.get(row);
    }
    
    public Comments getCommentById(int id) throws SQLException {
        Statement statement = c.createStatement();
        ResultSet rs = statement.executeQuery("SELECT * FROM \"Comment\" where \"ID_com\"=" + id + ";");
        rs.next();    
        return new Comments(rs.getInt("ID_com"), rs.getInt("ID_post"), rs.getInt("ID_cust"), rs.getInt("ID_prev"), rs.getString("Comment"));
    }
    
    public DefaultComboBoxModel getComboBoxModelByPostId(int id) throws SQLException {
        List<Comments> tmp = new ArrayList<>();
        tmp.add(null);
         try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"Comments\" where \"ID_post\" = " + id);
            while (rs.next()) {
                Comments item = new Comments(rs.getInt("ID_com"), rs.getInt("ID_post"), rs.getInt("ID_cust"), rs.getInt("ID_prev"), rs.getString("Comment"));
                tmp.add(item);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
         return new DefaultComboBoxModel(tmp.toArray());
    }
    
    public List<Comments> getComment() {
        List<Comments> tmp = new ArrayList<>();
         try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"Comments\"");
            while (rs.next()) {
                Comments item = new Comments(rs.getInt("ID_com"), rs.getInt("ID_post"), rs.getInt("ID_cust"), rs.getInt("ID_prev"), rs.getString("Comment"));
                tmp.add(item);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
        }
         return tmp;
    }
    
    public  void update(Comments comment) throws SQLException {
        Statement statement = c.createStatement();
        statement.executeUpdate("insert into \"Comments\" (\"ID_post\", \"ID_cust\", \"ID_prev\", \"Comment\") values ('" + 
                        comment.getID_post() + "','" + comment.getID_cust()  +
                        "'," + comment.getID_prev() + " ,'" + comment.getComment() + "');");
    }
    
    public void create(Comments comment) throws SQLException {
        Statement statement = c.createStatement();
        statement.executeUpdate("update \"Comments\" set \"ID_post\"='" + comment.getID_post() + 
                        "', \"ID_cust\"='" + comment.getID_cust() + 
                        "', \"ID_prev\"=" + comment.getID_prev() + 
                        ", \"Comment\"='" + comment.getComment() + "' where \"ID_com\"=" + comment.getID_com()+ ";");
    }
}
