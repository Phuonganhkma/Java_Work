package de_tai__so_5;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class NhapThongTinKhachHangForm extends javax.swing.JFrame {

    DefaultTableModel tableModel;
    int id = 0;
    List<khachHang> danhSachKhachHang = new ArrayList<>();
    DocGhiFile dc = new DocGhiFile();
    private static final String curentDir = System.getProperty("user.dir");
    private static final String separator = File.separator;
    private static final String PATH_FILE_CSV = curentDir + separator + "data" + separator + "KhachHang.csv";
    public static File f = new File(PATH_FILE_CSV);

    public NhapThongTinKhachHangForm() {
        this.dispose();
        initComponents();
        this.setLocationRelativeTo(null);
        tableModel = (DefaultTableModel) tblKhachHang.getModel();

        if (f.exists()) {
            try {
                danhSachKhachHang = dc.docFile();
                String ma = danhSachKhachHang.get(danhSachKhachHang.size() - 1).getMaKhachHang();
                id = Integer.parseInt(ma.substring(2)) + 1;
                hienThi(danhSachKhachHang);
            } catch (CsvValidationException ex) {
                Logger.getLogger(NhapThongTinKhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public void resetForm() {
        if (f.exists()) {
            try {
                danhSachKhachHang = dc.docFile();
                String ma = danhSachKhachHang.get(danhSachKhachHang.size() - 1).getMaKhachHang();
                id = Integer.parseInt(ma.substring(2)) + 1;
                hienThi(danhSachKhachHang);
            } catch (CsvValidationException ex) {
                Logger.getLogger(NhapThongTinKhachHangForm.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }
    
    public void hienThi(List<khachHang> danhSachKhachHang) {
        tableModel.setRowCount(0);
        for (khachHang item : danhSachKhachHang) {
            String maKhachHang = item.getMaKhachHang();
            String hoTen = item.getHoTen();
            String soDt = item.getSDT();
            int tuoi = item.getTuoi();
            String cmnd = item.getCMND();
            String pttt = item.getPhuongThucThanhToan();
            tableModel.addRow(new Object[]{maKhachHang, hoTen, soDt, tuoi, cmnd, pttt});
        }
    }

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
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ButunReset3 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        txtTuoi = new javax.swing.JTextField();
        txtSDT = new javax.swing.JTextField();
        boxPhuongThuThanhToan = new javax.swing.JComboBox<>();
        ButunReset = new javax.swing.JButton();
        buttunLuu = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        ButunReset1 = new javax.swing.JButton();
        ButunReset2 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        ButunReset6 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();

        ButunReset3.setBackground(new java.awt.Color(204, 204, 204));
        ButunReset3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButunReset3.setText("Chỉnh sửa");
        ButunReset3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButunReset3ActionPerformed(evt);
            }
        });

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBackground(new java.awt.Color(48, 62, 80));
        jPanel1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Họ và tên:");

        txtHoTen.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtHoTenFocusLost(evt);
            }
        });
        txtHoTen.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtHoTenMouseClicked(evt);
            }
        });
        txtHoTen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtHoTenActionPerformed(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Số CMND:");

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Số điện thoại:");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Tuổi:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Phương thức thanh toán:");

        txtCMND.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtCMNDFocusLost(evt);
            }
        });
        txtCMND.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtCMNDMouseClicked(evt);
            }
        });
        txtCMND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCMNDActionPerformed(evt);
            }
        });

        txtTuoi.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtTuoiFocusLost(evt);
            }
        });
        txtTuoi.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtTuoiMouseClicked(evt);
            }
        });
        txtTuoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTuoiActionPerformed(evt);
            }
        });

        txtSDT.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                txtSDTMouseDragged(evt);
            }
        });
        txtSDT.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtSDTFocusLost(evt);
            }
        });
        txtSDT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                txtSDTMouseClicked(evt);
            }
        });
        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        boxPhuongThuThanhToan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        boxPhuongThuThanhToan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Thanh toan bang tien mat", "Thanh toan thanh the", "" }));
        boxPhuongThuThanhToan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxPhuongThuThanhToanActionPerformed(evt);
            }
        });

        ButunReset.setBackground(new java.awt.Color(204, 204, 204));
        ButunReset.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButunReset.setIcon(new javax.swing.ImageIcon("D:\\img\\new.png")); // NOI18N
        ButunReset.setText("Reset");
        ButunReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButunResetActionPerformed(evt);
            }
        });

        buttunLuu.setBackground(new java.awt.Color(204, 204, 204));
        buttunLuu.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        buttunLuu.setIcon(new javax.swing.ImageIcon("D:\\img\\thêm.png")); // NOI18N
        buttunLuu.setText("Thêm Khách Hàng");
        buttunLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttunLuuActionPerformed(evt);
            }
        });

        tblKhachHang.setBackground(new java.awt.Color(0, 0, 0));
        tblKhachHang.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tblKhachHang.setForeground(new java.awt.Color(255, 255, 255));
        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ tên", "SĐT", "Tuổi", "Số CMND", "PTTT"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                true, true, true, false, true, true
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);
        if (tblKhachHang.getColumnModel().getColumnCount() > 0) {
            tblKhachHang.getColumnModel().getColumn(2).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(3).setResizable(false);
            tblKhachHang.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        ButunReset1.setBackground(new java.awt.Color(204, 204, 204));
        ButunReset1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButunReset1.setIcon(new javax.swing.ImageIcon("D:\\img\\timkiem1.png")); // NOI18N
        ButunReset1.setText("Tìm kiếm");
        ButunReset1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButunReset1MouseClicked(evt);
            }
        });
        ButunReset1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButunReset1ActionPerformed(evt);
            }
        });

        ButunReset2.setBackground(new java.awt.Color(204, 204, 204));
        ButunReset2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButunReset2.setIcon(new javax.swing.ImageIcon("D:\\img\\chinhSua.png")); // NOI18N
        ButunReset2.setText("Chỉnh sửa");
        ButunReset2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                ButunReset2MouseClicked(evt);
            }
        });
        ButunReset2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ButunReset2ActionPerformed(evt);
            }
        });

        ButunReset6.setBackground(new java.awt.Color(204, 204, 204));
        ButunReset6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        ButunReset6.setIcon(new javax.swing.ImageIcon("D:\\img\\save.png")); // NOI18N
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

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Chỉnh Sửa");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(19, 19, 19)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel7)
                            .addComponent(jLabel8)
                            .addComponent(jLabel6)
                            .addComponent(jLabel5))
                        .addGap(31, 31, 31)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 310, Short.MAX_VALUE)
                            .addComponent(boxPhuongThuThanhToan, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(156, 156, 156)
                        .addComponent(buttunLuu)
                        .addGap(105, 105, 105)
                        .addComponent(ButunReset6)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 908, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(112, 112, 112)
                        .addComponent(ButunReset, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(136, 136, 136)
                        .addComponent(ButunReset1)
                        .addGap(142, 142, 142)
                        .addComponent(ButunReset2)
                        .addGap(127, 127, 127)
                        .addComponent(jButton1)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addComponent(jSeparator1)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(73, 73, 73)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel5))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel6)))
                        .addGap(12, 12, 12)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTuoi, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(boxPhuongThuThanhToan, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ButunReset2)
                        .addComponent(ButunReset1)
                        .addComponent(ButunReset)
                        .addComponent(buttunLuu)
                        .addComponent(ButunReset6)))
                .addGap(190, 190, 190))
        );

        jPanel2.setBackground(new java.awt.Color(248, 148, 6));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setText("Nhập thông tin Khách hàng");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(606, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(627, 627, 627))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(25, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 435, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtHoTenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtHoTenActionPerformed

    }//GEN-LAST:event_txtHoTenActionPerformed

    private void txtCMNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCMNDActionPerformed

    }//GEN-LAST:event_txtCMNDActionPerformed

    private void txtTuoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTuoiActionPerformed

    }//GEN-LAST:event_txtTuoiActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed

    }//GEN-LAST:event_txtSDTActionPerformed

    private void boxPhuongThuThanhToanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxPhuongThuThanhToanActionPerformed

    }//GEN-LAST:event_boxPhuongThuThanhToanActionPerformed

    private void ButunResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButunResetActionPerformed
        txtHoTen.setText("");
        txtCMND.setText("");
        txtSDT.setText("");
        txtTuoi.setText("");
        boxPhuongThuThanhToan.setSelectedIndex(0);
        resetForm();
        
    }//GEN-LAST:event_ButunResetActionPerformed

    private void buttunLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttunLuuActionPerformed
        String maKhachHang = "KH" + id++;
        System.out.println(maKhachHang);
        String HotenKhachHang = txtHoTen.getText();
        int tuoi = Integer.parseInt(txtTuoi.getText());
        String scmnd = txtCMND.getText();
        String sdt = txtSDT.getText();
        String phuongTTT = boxPhuongThuThanhToan.getSelectedItem().toString();
        khachHang kh = new khachHang(maKhachHang, HotenKhachHang, sdt, tuoi, scmnd, phuongTTT);
        danhSachKhachHang.add(kh);
        tableModel.addRow(new Object[]{maKhachHang, HotenKhachHang, sdt, tuoi, scmnd, phuongTTT});
    }//GEN-LAST:event_buttunLuuActionPerformed
   

    private void txtHoTenMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtHoTenMouseClicked

    }//GEN-LAST:event_txtHoTenMouseClicked

    private void txtCMNDMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtCMNDMouseClicked

    }//GEN-LAST:event_txtCMNDMouseClicked

    private void txtSDTMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSDTMouseDragged

    }//GEN-LAST:event_txtSDTMouseDragged

    private void txtSDTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtSDTMouseClicked

    }//GEN-LAST:event_txtSDTMouseClicked

    private void txtTuoiMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_txtTuoiMouseClicked

    }//GEN-LAST:event_txtTuoiMouseClicked

    private void ButunReset1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButunReset1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ButunReset1ActionPerformed

    private void ButunReset2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButunReset2ActionPerformed
 
    }//GEN-LAST:event_ButunReset2ActionPerformed

    private void ButunReset3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButunReset3ActionPerformed
       
    }//GEN-LAST:event_ButunReset3ActionPerformed

    private void ButunReset1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButunReset1MouseClicked
       //chỉnh sửa lại tìm kiếm form
        LocKhachHangForm.main();
    }//GEN-LAST:event_ButunReset1MouseClicked

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed

    }//GEN-LAST:event_formWindowClosed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing

    }//GEN-LAST:event_formWindowClosing
//xửa lý ngoại lệ
    private void txtHoTenFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtHoTenFocusLost

        if (extractNumber(txtHoTen.getText()) == 0) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập đúng định dạng tên không chứa số; Ví du: Nguyễn Văn A");
            txtHoTen.requestFocus();
        }
    }//GEN-LAST:event_txtHoTenFocusLost

    private void txtCMNDFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtCMNDFocusLost
        //Xử lý số chướng minh nhân dân 
        if (extractNumber(txtCMND.getText()) == 1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập số chứng minh nhân dân  đúng định dạng");
            txtCMND.requestFocus();
        }

    }//GEN-LAST:event_txtCMNDFocusLost

    private void txtSDTFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtSDTFocusLost
        if (extractNumber(txtSDT.getText()) == 1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập đúng định dạng số điện thoại");
            txtSDT.requestFocus();
        }
    }//GEN-LAST:event_txtSDTFocusLost

    private void txtTuoiFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtTuoiFocusLost

        if (extractNumber(txtTuoi.getText()) == 1) {
            JOptionPane.showMessageDialog(rootPane, "Hãy nhập Tuổi đúng định dạng");
            txtTuoi.requestFocus();
        }
    }//GEN-LAST:event_txtTuoiFocusLost

    private void ButunReset6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ButunReset6ActionPerformed
     
    }//GEN-LAST:event_ButunReset6ActionPerformed

    private void ButunReset6MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButunReset6MouseClicked
        f.delete();
        dc.ghiFile(danhSachKhachHang);
    }//GEN-LAST:event_ButunReset6MouseClicked

    private void ButunReset2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_ButunReset2MouseClicked
   
        ChinhSuaForm.main();
        this.dispose();
    }//GEN-LAST:event_ButunReset2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
      Collections.sort(danhSachKhachHang, new TuoiComparator());
        hienThi(danhSachKhachHang);
    }//GEN-LAST:event_jButton1MouseClicked
    
    public static void main() {
        
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NhapThongTinKhachHangForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NhapThongTinKhachHangForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton ButunReset;
    private javax.swing.JButton ButunReset1;
    private javax.swing.JButton ButunReset2;
    private javax.swing.JButton ButunReset3;
    private javax.swing.JButton ButunReset6;
    private javax.swing.JComboBox<String> boxPhuongThuThanhToan;
    private javax.swing.JButton buttunLuu;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSDT;
    private javax.swing.JTextField txtTuoi;
    // End of variables declaration//GEN-END:variables
}
