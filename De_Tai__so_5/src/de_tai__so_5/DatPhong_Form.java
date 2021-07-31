/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de_tai__so_5;

import com.opencsv.exceptions.CsvValidationException;
import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author phuon
 */
public class DatPhong_Form extends javax.swing.JFrame {

    /**
     * Creates new form DatPhong_Form
     */
    DefaultTableModel tableModel;
    int id = 0;
    private static final String curentDir = System.getProperty("user.dir");
    private static final String separator = File.separator;
    private static final String PATH_FILE_CSV_DATPHONG = curentDir + separator + "data" + separator + "DatPhong.csv";
    DocGhiFile dc = new DocGhiFile();
    List<DatPhong> danhSacgDatPhong = new ArrayList<>();
    List<khachHang> danhSachKhaHang = new ArrayList<>();
    List<Phong> danhSacgPhong = new ArrayList<>();

    File f = new File(PATH_FILE_CSV_DATPHONG);

    public DatPhong_Form() {
        initComponents();
        this.setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tblDatPhong.getModel();
        if (f.exists()) {
            try {
                danhSacgDatPhong = dc.docFileDatPhong();
                danhSacgPhong = dc.docFilePhong();
                System.out.println(danhSacgPhong);
                danhSachKhaHang = dc.docFile();
                hienThi(danhSacgDatPhong);
                String ma = danhSacgDatPhong.get(danhSacgDatPhong.size() - 1).getMaDatPhong();
                id = Integer.parseInt(ma.substring(3)) + 1;
            } catch (CsvValidationException ex) {
                Logger.getLogger(DatPhong_Form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(DatPhong_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void hienThi(List<DatPhong> danhSachDatPhong) {
        tableModel.setRowCount(0);
        for (DatPhong item : danhSachDatPhong) {
            String maDatPhong = item.getMaDatPhong();
            String maphong = item.getMaPhong();
            String maKhachHang = item.getMaKhachHang();
            Date ngayDat = item.getNgayDat();
            String ngayDat1 = df.format(ngayDat);
            Date ngayTra = item.getNgayTra();
            String ngayTra1 = df.format(ngayTra);

            int tongTien = item.getTongTien();
            tableModel.addRow(new Object[]{maDatPhong, maphong, maKhachHang, ngayDat1, ngayTra1, tongTien});
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

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        ButunReset = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblDatPhong = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        txtMaPhong = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtTongTien = new javax.swing.JTextField();
        buttunLuu1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtMaKhachHang = new javax.swing.JTextField();
        ButunReset6 = new javax.swing.JButton();
        txtNgayTra = new com.toedter.calendar.JDateChooser();
        txtNgayDat = new com.toedter.calendar.JDateChooser();
        btnChinhSuaPhong = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(248, 148, 6));

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(51, 51, 51));
        jLabel8.setText("Đặt Phòng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(596, 596, 596)
                .addComponent(jLabel8)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel8)
                .addGap(441, 441, 441))
        );

        jPanel3.setBackground(new java.awt.Color(48, 62, 80));
        jPanel3.setForeground(new java.awt.Color(255, 255, 255));
        jPanel3.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ButunReset.setBackground(new java.awt.Color(204, 204, 204));
        ButunReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButunReset.setText("Reset");
        ButunReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButunResetMouseClicked(evt);
            }
        });
        ButunReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButunResetActionPerformed(evt);
            }
        });

        tblDatPhong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblDatPhong.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã Đặt Phòng", "Mã Phòng", "Mã Khách Hàng", "Ngày Đặt", "Ngày Trả", "Tổng Tiền"
            }
        ));
        jScrollPane1.setViewportView(tblDatPhong);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Ngày Đặt:");

        txtMaPhong.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtMaPhongFocusLost(evt);
            }
        });
        txtMaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaPhongActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Mã Đặt Phòng");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Ngày Trả:");

        jLabel16.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Tổng Tiền");

        buttunLuu1.setBackground(new java.awt.Color(204, 204, 204));
        buttunLuu1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttunLuu1.setText("Thêm Khách Hàng");
        buttunLuu1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttunLuu1ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Mã Khách Hàng");

        txtMaKhachHang.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMaKhachHangActionPerformed(evt);
            }
        });

        ButunReset6.setBackground(new java.awt.Color(204, 204, 204));
        ButunReset6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButunReset6.setText("Lưu ");
        ButunReset6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButunReset6MouseClicked(evt);
            }
        });
        ButunReset6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButunReset6ActionPerformed(evt);
            }
        });

        btnChinhSuaPhong.setBackground(new java.awt.Color(204, 204, 204));
        btnChinhSuaPhong.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        btnChinhSuaPhong.setText("Chỉnh sửa ");
        btnChinhSuaPhong.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnChinhSuaPhongMouseClicked(evt);
            }
        });
        btnChinhSuaPhong.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnChinhSuaPhongActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel16)
                                .addGap(83, 83, 83)
                                .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(40, 40, 40)
                                .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel1)
                                            .addComponent(jLabel15))
                                        .addGap(51, 51, 51))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                                        .addComponent(jLabel3)
                                        .addGap(84, 84, 84)))
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayTra, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtNgayDat, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 344, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(39, 39, 39)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 893, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(28, 28, 28)
                        .addComponent(buttunLuu1)
                        .addGap(58, 58, 58)
                        .addComponent(ButunReset6, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(51, 51, 51)
                        .addComponent(ButunReset)
                        .addGap(161, 161, 161)
                        .addComponent(btnChinhSuaPhong)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaPhong, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaKhachHang, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtNgayDat, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGap(18, 18, 18)))
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel15)
                            .addComponent(txtNgayTra, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(txtTongTien, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap(15, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(31, 31, 31)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ButunReset)
                    .addComponent(buttunLuu1)
                    .addComponent(ButunReset6)
                    .addComponent(btnChinhSuaPhong))
                .addContainerGap())
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    public void resetForm() {
        if (!f.exists()) {
            try {
                danhSacgDatPhong = dc.docFileDatPhong();
//                danhSacgPhong = dc.docFilePhong();
//                danhSachKhaHang = dc.docFile();
                hienThi(danhSacgDatPhong);
                String ma = danhSacgDatPhong.get(danhSacgDatPhong.size() - 1).getMaDatPhong();
                id = Integer.parseInt(ma.substring(3)) + 1;
            } catch (CsvValidationException ex) {
                Logger.getLogger(DatPhong_Form.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ParseException ex) {
                Logger.getLogger(DatPhong_Form.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    private void ButunResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButunResetActionPerformed
        txtMaPhong.setText("");
        txtMaKhachHang.setText("");
        txtTongTien.setText("");
        Date date = java.util.Calendar.getInstance().getTime();
        txtNgayDat.setDate(date);
        txtNgayTra.setDate(date);
        resetForm();
    }//GEN-LAST:event_ButunResetActionPerformed

    private void txtMaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaPhongActionPerformed
        //xử lý ngoại lệ 


    }//GEN-LAST:event_txtMaPhongActionPerformed
    DateFormat df = new SimpleDateFormat("dd-MM-yyyy");
    private void buttunLuu1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttunLuu1ActionPerformed

        String MaDatPhong = "MDP" + id++;
        String MaPhong = txtMaPhong.getText();
        String maKhachHang = txtMaKhachHang.getText();
        Date NgayDat = txtNgayDat.getDate();
        String ngayDat = df.format(NgayDat);
        Date NgayTra = txtNgayTra.getDate();
        String ngayTra = df.format(NgayTra);

        int TongTIen = Integer.parseInt(txtTongTien.getText());
        DatPhong datPhong = new DatPhong(MaDatPhong, MaPhong, maKhachHang, NgayDat, NgayTra, TongTIen);
        danhSacgDatPhong.add(datPhong);
        tableModel.addRow(new Object[]{MaDatPhong, MaPhong, maKhachHang, ngayDat, ngayTra, TongTIen});

    }//GEN-LAST:event_buttunLuu1ActionPerformed

    private void txtMaKhachHangActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMaKhachHangActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMaKhachHangActionPerformed

    private void ButunReset6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButunReset6MouseClicked

        f.delete();
        dc.ghiFileDatPhong(danhSacgDatPhong);

    }//GEN-LAST:event_ButunReset6MouseClicked
    public int extractNumber(String str) {
        if (str == null) {
            return -1;
        }
        boolean found = false;
        for (int i = 0; i < str.length(); i++) {
            char dt = str.charAt(i);
            if (dt == '0' || dt == '1' || dt == '2' || dt == '3' || dt == '4' || dt == '5' || dt == '6' || dt == '7' || dt == '8' || dt == '9') {
                found = true;
                break;
            }
        }
        if (found == false) {
            return 1;
        } else {
            return 0;
        }
    }

    private void ButunReset6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButunReset6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButunReset6ActionPerformed

    private void btnChinhSuaPhongActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnChinhSuaPhongActionPerformed
        ChinhSuaDatPhong.main();
    }//GEN-LAST:event_btnChinhSuaPhongActionPerformed

    private void btnChinhSuaPhongMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnChinhSuaPhongMouseClicked
//        ChinhSuaDatPhong.main();
    }//GEN-LAST:event_btnChinhSuaPhongMouseClicked

    private void ButunResetMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButunResetMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_ButunResetMouseClicked

    private void txtMaPhongFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtMaPhongFocusLost
        for (Phong item : danhSacgPhong) {
            if (txtMaPhong.getText() != item.getMaPhong()) {
                JOptionPane.showMessageDialog(rootPane, "Hay nhập đúng định dạng mã phòng ví dụ: MP10");
            }
        }

    }//GEN-LAST:event_txtMaPhongFocusLost

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(DatPhong_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(DatPhong_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(DatPhong_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(DatPhong_Form.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new DatPhong_Form().setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButunReset;
    private javax.swing.JButton ButunReset6;
    private javax.swing.JButton btnChinhSuaPhong;
    private javax.swing.JButton buttunLuu1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblDatPhong;
    private javax.swing.JTextField txtMaKhachHang;
    private javax.swing.JTextField txtMaPhong;
    private com.toedter.calendar.JDateChooser txtNgayDat;
    private com.toedter.calendar.JDateChooser txtNgayTra;
    private javax.swing.JTextField txtTongTien;
    // End of variables declaration//GEN-END:variables
}
