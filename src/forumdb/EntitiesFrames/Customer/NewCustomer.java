
package forumdb.EntitiesFrames.Customer;

import EntitiesClasses.Roles;
import EntitiesClasses.Customer;
import Help.JTextFieldLimit;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.text.AbstractDocument;

public class NewCustomer extends javax.swing.JDialog {

    Connection c;
    Customer editUser;
    List<Roles> statuses;

    public NewCustomer(java.awt.Frame parent, boolean modal, Connection c) {
        super(parent, modal);
        initComponents();

        ((AbstractDocument) login.getDocument()).setDocumentFilter(new JTextFieldLimit(16));
        ((AbstractDocument) password.getDocument()).setDocumentFilter(new JTextFieldLimit(16));
        ((AbstractDocument) second.getDocument()).setDocumentFilter(new JTextFieldLimit(32));
        ((AbstractDocument) first.getDocument()).setDocumentFilter(new JTextFieldLimit(32));
        ((AbstractDocument) patr.getDocument()).setDocumentFilter(new JTextFieldLimit(32));
        ((AbstractDocument) mail.getDocument()).setDocumentFilter(new JTextFieldLimit(32));
        this.c = c;
        statuses = new ArrayList<>();
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"Roles\"");
            while (rs.next()) {
                Roles tmp = new Roles(rs.getInt("ID_role"), rs.getString("Name_role"));
                statuses.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        status.setModel(new DefaultComboBoxModel(statuses.toArray()));
    }

    public NewCustomer(java.awt.Frame parent, boolean modal, Connection c, Customer u) {
        super(parent, modal);
        initComponents();
        ((AbstractDocument) login.getDocument()).setDocumentFilter(new JTextFieldLimit(16));
        ((AbstractDocument) password.getDocument()).setDocumentFilter(new JTextFieldLimit(16));
        ((AbstractDocument) second.getDocument()).setDocumentFilter(new JTextFieldLimit(32));
        ((AbstractDocument) first.getDocument()).setDocumentFilter(new JTextFieldLimit(32));
        ((AbstractDocument) patr.getDocument()).setDocumentFilter(new JTextFieldLimit(32));
        ((AbstractDocument) mail.getDocument()).setDocumentFilter(new JTextFieldLimit(32));
        this.c = c;
        editUser = u;

        statuses = new ArrayList<>();
        try {
            Statement statement = c.createStatement();
            ResultSet rs = statement.executeQuery("SELECT * FROM \"Roles\"");
            while (rs.next()) {
                Roles tmp = new Roles(rs.getInt("ID_role"), rs.getString("Name_role"));
                statuses.add(tmp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(NewCustomer.class.getName()).log(Level.SEVERE, null, ex);
        }
        status.setModel(new DefaultComboBoxModel(statuses.toArray()));
        fillFields();
    }

    private void fillFields() {
        login.setText(editUser.getLogin());
        password.setText(editUser.getPassword());
        mail.setText(editUser.getEmail());

        for (Roles s : statuses) {
            if (s.getID_role() == editUser.getID_role()) {
                status.setSelectedItem((s));
            }
        }

        second.setText(editUser.getFamily());
        first.setText(editUser.getName());
        patr.setText(editUser.getPatronymic());
    }

    public boolean check() {
        if ("".equals(login.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Login cannot be empty");
            return false;
        }
        if ("".equals(password.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Password cannot be empty");
            return false;
        }
        if ("".equals(mail.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Mail cannot be empty");
            return false;
        }
        if ("".equals(second.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Second name cannot be empty");
            return false;
        }
        if ("".equals(first.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "First name cannot be empty");
            return false;
        }
        if ("".equals(patr.getText())) {
            JOptionPane.showMessageDialog(new JFrame(), "Patronymic cannot be empty");
            return false;
        }
        return true;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        login = new javax.swing.JTextField();
        mail = new javax.swing.JTextField();
        second = new javax.swing.JTextField();
        first = new javax.swing.JTextField();
        patr = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        status = new javax.swing.JComboBox<>();
        password = new javax.swing.JPasswordField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("New user");

        mail.setToolTipText("");

        jButton1.setText("Done");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel1.setText("Login");

        jLabel2.setText("Password");

        jLabel3.setText("Mail");

        jLabel5.setText("Status");

        jLabel6.setText("Second name");

        jLabel7.setText("First name");

        jLabel8.setText("Patronymic");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8))
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(patr, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE)
                            .addComponent(first)
                            .addComponent(second)
                            .addComponent(mail)
                            .addComponent(login)
                            .addComponent(status, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(password))))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(login, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(status, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(second, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(first, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(patr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(37, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (!check()) {
            return;
        }
        try {
            // TODO add your handling code here:
            Statement statement = c.createStatement();
            if (editUser == null) {
                statement.executeUpdate("insert into \"Customer\" (\"Login\", \"Password\","
                        + "\"ID_role\", \"Family\", \"Name\", \"Patronymic\", \"Email\") values ('" +
                        login.getText() +
                        "','" + password.getText() + 
                        "','" + ((Roles) status.getSelectedItem()).getID_role()+ 
                        "','" + second.getText() + "','" + first.getText() +
                        "','" + patr.getText()  + "','" + mail.getText() + "');");
            } else {
                statement.executeUpdate("update \"Customer\" set \"Login\"='" + login.getText() + 
                        "',\"Password\"='" + password.getText()+ "',\"ID_role\"='" + 
                        ((Roles) status.getSelectedItem()).getID_role() + 
                        "',\"Family\"='" + second.getText() + "',\"Name\"='" + first.getText() + "',\"Patronymic\"='" + 
                        patr.getText()+ "',\"Email\"='" + mail.getText()  + "' where \"ID_cust\"=" + editUser.getID_cust()  + ";");
            }

        } catch (SQLException ex) {
            if (ex.getMessage().contains("Customer_Login_key")) {
                JOptionPane.showMessageDialog(new JFrame(), "This login already exist");
            } else {
                JOptionPane.showMessageDialog(new JFrame(), ex.getMessage());
            }
            return;
        }
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(NewUser.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                NewUser dialog = new NewUser(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField first;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JTextField login;
    private javax.swing.JTextField mail;
    private javax.swing.JPasswordField password;
    private javax.swing.JTextField patr;
    private javax.swing.JTextField second;
    private javax.swing.JComboBox<String> status;
    // End of variables declaration//GEN-END:variables
}
