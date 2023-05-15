/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab4_canhan;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import lab4_canhan.NHANVIEN;

/**
 *
 * @author Admin
 */
public class QLNV extends javax.swing.JFrame {

    Vector rowheader = null;
    DefaultTableModel model = null;

    public static String setMANV() {
        return LOGIN.getMANV();
    }

    public static String setHOTEN() {
        return LOGIN.getHOTEN();
    }

    public static String setEMAIL() {
        return LOGIN.getEMAIL();
    }

    public static String setLUONG() {
        return AES256.decrypt(LOGIN.getLUONG());
    }

    public static String setTENDN() {
        return LOGIN.getTENDN();
    }

    public static String setMATKHAU() {
        return LOGIN.getMATKHAU();
    }

    public QLNV() {
        initComponents();
        this.setLocationRelativeTo(null);
        rowheader = new Vector();
        rowheader.add("MANV");
        rowheader.add("HOTEN");
        rowheader.add("EMAIL");
        rowheader.add("LUONG");
        model = new DefaultTableModel(rowheader, 0);
        jTable1_sinhvien.setModel(model);
        show_nv();
        txtmanvlogin.setText(setMANV());
        txthotenlogin.setText(setHOTEN());
        txtemaillogin.setText(setEMAIL());
        txtluonglogin.setText(setLUONG());
        txttendnlogin.setText(setTENDN());
        txtmatkhaulogin.setText("*******");
        txtmanv.setEditable(false);

    }

//    private void listnv() {
//        Vector rowdata = null;
//        try {
//            String query3 = "SELECT MANV,HOTEN,EMAIL,LUONG FROM NHANVIEN";
//            DBAccess db = new DBAccess();
//            ResultSet rs = db.Query(query3);
//            while (rs.next()) {
//                rowdata = new Vector();
//                rowdata.add(rs.getString(1));
//                rowdata.add(rs.getString(2));
//                rowdata.add(rs.getString(3));
//                rowdata.add(rs.getString(4));            
//                model.addRow(rowdata);
//
//            }
//        } catch (Exception e) {
//            JOptionPane.showMessageDialog(this, e.getMessage());
//        }
//    }
    public ArrayList<NHANVIEN> nvList() {
        ArrayList<NHANVIEN> nvList = new ArrayList<>();
        try {
            DBAccess db = new DBAccess();
            String query1 = "SELECT MANV,HOTEN,EMAIL,LUONG FROM NHANVIEN";
            ResultSet rs = db.Query(query1);
            NHANVIEN nv;
            while (rs.next()) {
                nv = new NHANVIEN(rs.getString("MANV"), rs.getString("HOTEN"), rs.getString("EMAIL"), rs.getString("LUONG"));
                nvList.add(nv);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);

        }
        return nvList;

    }

    public void show_nv() {
        ArrayList<NHANVIEN> list = nvList();
        DefaultTableModel model = (DefaultTableModel) jTable1_sinhvien.getModel();
        Object[] row = new Object[4];
        for (int i = 0; i < list.size(); i++) {
            row[0] = list.get(i).getMANV();
            row[1] = list.get(i).getHOTEN();
            row[2] = list.get(i).getEMAIL();
            row[3] = list.get(i).getLUONG();
//            row[4] = list.get(i).getLOP();
//            row[5] = list.get(i).getTENDN();
//            row[6] = list.get(i).getMATKHAU();
            model.addRow(row);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtmanvlogin = new javax.swing.JTextField();
        txtemaillogin = new javax.swing.JTextField();
        txttendnlogin = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        txthotenlogin = new javax.swing.JTextField();
        txtluonglogin = new javax.swing.JTextField();
        txtmatkhaulogin = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btnupdate = new javax.swing.JButton();
        btnadd = new javax.swing.JButton();
        btndelete = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        txtmanv = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txthoten = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtemail = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtluong = new javax.swing.JTextField();
        btnclose = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1_sinhvien = new javax.swing.JTable();

        jLabel1.setText("jLabel1");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Quản lí nhân viên");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên đăng nhập", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(255, 0, 51))); // NOI18N
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel5.setText("Mã NV");
        jPanel1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 70, 90, 20));

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel6.setText("Email");
        jPanel1.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 110, 50, -1));

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel8.setText("Tên Đăng nhập");
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 160, -1, -1));

        txtmanvlogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtmanvlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 420, -1));

        txtemaillogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtemaillogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailloginActionPerformed(evt);
            }
        });
        jPanel1.add(txtemaillogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 420, -1));

        txttendnlogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txttendnlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 160, 420, -1));

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel10.setText("Họ tên");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 70, -1, -1));

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel11.setText("Lương");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 120, -1, -1));

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel12.setText("Mật khẩu");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 170, -1, 20));

        txthotenlogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txthotenlogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 60, 420, -1));

        txtluonglogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        txtluonglogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtluongloginActionPerformed(evt);
            }
        });
        jPanel1.add(txtluonglogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 110, 420, -1));

        txtmatkhaulogin.setFont(new java.awt.Font("Dialog", 0, 14)); // NOI18N
        jPanel1.add(txtmatkhaulogin, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, 420, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 1290, 240));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Thông tin nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel2.setForeground(new java.awt.Color(255, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        btnupdate.setBackground(new java.awt.Color(255, 153, 0));
        btnupdate.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        btnupdate.setForeground(new java.awt.Color(255, 255, 255));
        btnupdate.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/convert-3213.png"))); // NOI18N
        btnupdate.setText("Sửa/lOAD");
        btnupdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnupdateActionPerformed(evt);
            }
        });
        jPanel2.add(btnupdate, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 320, 140, 50));

        btnadd.setBackground(new java.awt.Color(51, 255, 0));
        btnadd.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btnadd.setForeground(new java.awt.Color(255, 255, 255));
        btnadd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/add-user-302 (1).png"))); // NOI18N
        btnadd.setText("Thêm");
        btnadd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnaddActionPerformed(evt);
            }
        });
        jPanel2.add(btnadd, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 320, 116, 50));

        btndelete.setBackground(new java.awt.Color(255, 51, 51));
        btndelete.setFont(new java.awt.Font("Arial Black", 1, 14)); // NOI18N
        btndelete.setForeground(new java.awt.Color(255, 255, 255));
        btndelete.setIcon(new javax.swing.ImageIcon(getClass().getResource("/anh/user-logout-304 (2).png"))); // NOI18N
        btndelete.setText("Xóa");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });
        jPanel2.add(btndelete, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 320, 100, 50));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Mã NV");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(70, 90, -1, -1));

        txtmanv.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtmanv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtmanvActionPerformed(evt);
            }
        });
        jPanel2.add(txtmanv, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 90, 150, 30));
        txtmanv.getAccessibleContext().setAccessibleName("");

        jLabel2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Họ tên");
        jPanel2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 140, -1, -1));

        txthoten.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txthoten.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txthotenActionPerformed(evt);
            }
        });
        jPanel2.add(txthoten, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, 150, 30));

        jLabel3.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Email");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, -1, -1));

        txtemail.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        txtemail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtemailActionPerformed(evt);
            }
        });
        jPanel2.add(txtemail, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, 150, 30));

        jLabel4.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Lương");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 250, -1, -1));

        txtluong.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jPanel2.add(txtluong, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 150, 30));

        btnclose.setBackground(new java.awt.Color(0, 0, 0));
        btnclose.setFont(new java.awt.Font("Arial Black", 1, 12)); // NOI18N
        btnclose.setForeground(new java.awt.Color(255, 255, 255));
        btnclose.setText("Thoát");
        btnclose.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btncloseActionPerformed(evt);
            }
        });
        jPanel2.add(btnclose, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 90, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 280, 440, 470));

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Danh sách nhân viên", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Dialog", 1, 18), new java.awt.Color(255, 0, 0))); // NOI18N
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jTable1_sinhvien.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        jTable1_sinhvien.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "MASV", "HOTEN", "EMAIL", "LUONG"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1_sinhvien.setRowHeight(30);
        jTable1_sinhvien.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1_sinhvienMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1_sinhvien);

        jPanel3.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 830, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 850, 470));

        getAccessibleContext().setAccessibleDescription("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnaddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnaddActionPerformed
//        int row = jTable1_sinhvien.getSelectedRow();
////        MALOPadd = (jTable1_sinhvien.getModel().getValueAt(row, 4).toString());
        new addUser().setVisible(true);

    }//GEN-LAST:event_btnaddActionPerformed

    private void btncloseActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btncloseActionPerformed
        dispose();
    }//GEN-LAST:event_btncloseActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed

        int opt = JOptionPane.showConfirmDialog(this, "Bạn có muốn xóa không");
        try {
            if (opt == 0) {    
                DBAccess db = new DBAccess();
                int row = jTable1_sinhvien.getSelectedRow();
                String value = (jTable1_sinhvien.getModel().getValueAt(row, 0).toString());
                String query ="DELETE FROM NHANVIEN WHERE MANV='"+value+"'";
                db.Update(query);
                DefaultTableModel model = (DefaultTableModel) jTable1_sinhvien.getModel();
                model.setRowCount(0);
                show_nv();
                JOptionPane.showMessageDialog(this, "Delete Seccessfully");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btndeleteActionPerformed

    // update du lieu tu feild sang table 
    private void btnupdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnupdateActionPerformed

        try {
            DBAccess db = new DBAccess();
            String manv = txtmanv.getText();
            String hoten = txthoten.getText();
            String email = txtemail.getText();
            String luong = AES256.encrypt(txtluong.getText());
            String query = "EXEC SP_UPDATE '"+manv+"','"+hoten+"','"+email+"','"+luong+"'";            
            db.Update(query);          
            DefaultTableModel model = (DefaultTableModel) jTable1_sinhvien.getModel();
            model.setRowCount(0);
            show_nv();
            JOptionPane.showMessageDialog(null, "Update Sucessfully");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_btnupdateActionPerformed

    private void txthotenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txthotenActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txthotenActionPerformed
// xet click table de hien thi qua file txt field
    private void jTable1_sinhvienMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1_sinhvienMouseClicked

        int index = jTable1_sinhvien.getSelectedRow();
        txtmanv.setText((String) (model.getValueAt(index, 0)));
        txthoten.setText((String) (model.getValueAt(index, 1)));
        txtemail.setText((String) (model.getValueAt(index, 2)));
        txtluong.setText((String) (model.getValueAt(index, 3)));
//        txtmalop.setText((String) (model.getValueAt(index, 4)));
//        txttenDN.setText((String) (model.getValueAt(index, 5)));
//        txtmatkhau.setText((String) (model.getValueAt(index, 6)));

    }//GEN-LAST:event_jTable1_sinhvienMouseClicked

    private void txtmanvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtmanvActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtmanvActionPerformed

    private void txtemailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailActionPerformed

    private void txtluongloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtluongloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtluongloginActionPerformed

    private void txtemailloginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtemailloginActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtemailloginActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new QLNV().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnadd;
    private javax.swing.JButton btnclose;
    private javax.swing.JButton btndelete;
    private javax.swing.JButton btnupdate;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1_sinhvien;
    private javax.swing.JTextField txtemail;
    private javax.swing.JTextField txtemaillogin;
    private javax.swing.JTextField txthoten;
    private javax.swing.JTextField txthotenlogin;
    private javax.swing.JTextField txtluong;
    private javax.swing.JTextField txtluonglogin;
    private javax.swing.JTextField txtmanv;
    private javax.swing.JTextField txtmanvlogin;
    private javax.swing.JTextField txtmatkhaulogin;
    private javax.swing.JTextField txttendnlogin;
    // End of variables declaration//GEN-END:variables
 private void While(boolean next) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
