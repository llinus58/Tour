/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.popup;

import BLL.KhachHangBLL;
import DTO.KhachHangDTO;
import com.mycompany.util.InputValidatorUtil;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

/**
 *
 * @author Trieu
 */
public class PopUpKhachHang extends javax.swing.JFrame {

    private String action;
    private KhachHangDTO khachHang = null;
    private KhachHangBLL khachHangBLL;

    public PopUpKhachHang() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        Limit();
    }

    public PopUpKhachHang(String action) {

        initComponents();
        this.action = action;
        khachHangBLL = new KhachHangBLL();
         setLocationRelativeTo(null);
        setResizable(false);
        this.setVisible(true);
        Limit();
    }
    public void Limit(){
        txtHoTen.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtHoTen.getText().trim().length() == 30 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume();
    } 
            }
        });
        txtCMND.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtCMND.getText().trim().length() == 20 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume();
    } 
            }
        });
        txtDiaChi.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtDiaChi.getText().trim().length() == 40 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume();
    } 
            }
        });
        txtSDT.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtSDT.getText().trim().length() == 15 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume();
    } 
            }
        });
    }
    public PopUpKhachHang(String action, KhachHangDTO khachHang) {
        initComponents();
        this.action = action;
        this.khachHang = khachHang;
        khachHangBLL = new KhachHangBLL();
        setLabelText(khachHang);
        this.setVisible(true);
        setLocationRelativeTo(null);
        setResizable(false);
        Limit();
    }
 public void setLabelText(KhachHangDTO khachHang) {
        txtHoTen.setText(khachHang.getHoTen());

        if (khachHang.getGioiTinh()) {
            radioNam.setSelected(true);
        } else {
            radioNu.setSelected(true);
        }
        DCNgaySinh.setDate(khachHang.getNgaySinh());
        txtDiaChi.setText(khachHang.getDiaChi());
        txtCMND.setText(khachHang.getCMND());
        txtSDT.setText(khachHang.getSDT());

    }
 public boolean validateForm() {
  
        boolean HoTen, Sdt, DiaChi, NgaySinh,CMND; 
        ImageIcon iconCheck = new ImageIcon("check.png");
        ImageIcon iconError = new ImageIcon("error.png");
        if (InputValidatorUtil.isValidName(txtHoTen.getText(), false).isEmpty())
        {
            HoTen = true;
            lblValidateHoTen.setIcon(iconCheck);
            lblValidateHoTen.setToolTipText(null);
        } else {
            HoTen = false;
            lblValidateHoTen.setIcon(iconError);
            lblValidateHoTen.setToolTipText(InputValidatorUtil.isValidName(txtHoTen.getText(), false));
        }
        
       
     
        if (!InputValidatorUtil.isVailidPhoneNumber(txtSDT.getText()).isEmpty()) {
            Sdt = false;
            lblValidateSDT.setIcon(iconError);
            lblValidateSDT.setToolTipText(InputValidatorUtil.isVailidPhoneNumber(txtSDT.getText()));
        } else {
            Sdt = true;
            lblValidateSDT.setIcon(iconCheck);
            lblValidateSDT.setToolTipText(null);
            
            if (this.action.equals("POST")) {
                if (khachHangBLL.findBySDT(txtSDT.getText().trim()) != null) {
                    Sdt = false;
                    lblValidateSDT.setIcon(iconError);
                    lblValidateSDT.setToolTipText("Số điện thoại này đã được sử dụng");
                }
            } else if (this.action.equals("PUT")) {
                KhachHangDTO newKhachHang = khachHangBLL.findBySDT(txtSDT.getText().trim());
                if (newKhachHang != null) {
                    if (newKhachHang.getMaKH() != this.khachHang.getMaKH()) {  
                        Sdt = false;
                        lblValidateSDT.setIcon(iconError);
                        lblValidateSDT.setToolTipText("Số điện thoại này đã được sử dụng");
                    }
                }
                       
            }    
        }
        
        if (InputValidatorUtil.isVailidIdentityID(txtCMND.getText().trim()).isEmpty())  
        {
            CMND = true;
            lblValidateCMND.setIcon(iconCheck);
            lblValidateCMND.setToolTipText(null);
        } else {
            CMND = false;
            lblValidateCMND.setIcon(iconError);
            lblValidateCMND.setToolTipText(InputValidatorUtil.isVailidIdentityID(txtCMND.getText().trim()));
        }
        
        if (InputValidatorUtil.isValidBirthDate(DCNgaySinh.getDate(), 18).isEmpty())  
        {
            NgaySinh = true;
            lblValidateNgaySinh.setIcon(iconCheck);
            lblValidateNgaySinh.setToolTipText(null);
        } else {
            NgaySinh = false;
            lblValidateNgaySinh.setIcon(iconError);
            lblValidateNgaySinh.setToolTipText(InputValidatorUtil.isValidBirthDate(DCNgaySinh.getDate(),18));
        }
        
        if (InputValidatorUtil.isValidAddress(txtDiaChi.getText()).isEmpty())  
        {
           DiaChi = true;
           lblValidateDiaChi.setIcon(iconCheck);
           lblValidateDiaChi.setToolTipText(null);
        } else {
           DiaChi = false;
           lblValidateDiaChi.setIcon(iconError);
           lblValidateDiaChi.setToolTipText(InputValidatorUtil.isValidAddress(txtDiaChi.getText()));
        }
        
        if (HoTen && Sdt && NgaySinh && DiaChi && CMND)
        return true;
        else return false;
       
    }
 
 private KhachHangDTO getFormInfo() throws IOException {
        KhachHangDTO khachHang = new KhachHangDTO();
        if (this.khachHang != null) {
            khachHang.setMaKH(this.khachHang.getMaKH());
        }
        khachHang.setHoTen(txtHoTen.getText().trim());

        khachHang.setGioiTinh(radioNam.isSelected() ? true : false);
        khachHang.setNgaySinh(DCNgaySinh.getDate());
        khachHang.setDiaChi(txtDiaChi.getText().trim());
        khachHang.setSDT(txtSDT.getText().trim());
        khachHang.setCMND(txtCMND.getText().trim());

        return khachHang;
    }
 
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGioiTinh = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblGioiTinh = new javax.swing.JLabel();
        radioNam = new javax.swing.JRadioButton();
        radioNu = new javax.swing.JRadioButton();
        lblNgaySinh = new javax.swing.JLabel();
        lblDiaChi = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtDiaChi = new javax.swing.JTextArea();
        lblCMND = new javax.swing.JLabel();
        txtCMND = new javax.swing.JTextField();
        lblSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        lblValidateHoTen = new javax.swing.JLabel();
        lblValidateNgaySinh = new javax.swing.JLabel();
        lblValidateDiaChi = new javax.swing.JLabel();
        lblValidateCMND = new javax.swing.JLabel();
        lblValidateSDT = new javax.swing.JLabel();
        DCNgaySinh = new com.github.lgooddatepicker.components.DatePicker();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowFocusListener(new java.awt.event.WindowFocusListener() {
            public void windowGainedFocus(java.awt.event.WindowEvent evt) {
                formWindowGainedFocus(evt);
            }
            public void windowLostFocus(java.awt.event.WindowEvent evt) {
            }
        });

        lblHoTen.setText("HỌ TÊN");

        lblGioiTinh.setText("GIỚI TÍNH");

        btnGioiTinh.add(radioNam);
        radioNam.setSelected(true);
        radioNam.setText("NAM");

        btnGioiTinh.add(radioNu);
        radioNu.setText("NỮ");

        lblNgaySinh.setText("NGÀY SINH");

        lblDiaChi.setText("ĐỊA CHỈ");

        txtDiaChi.setColumns(20);
        txtDiaChi.setRows(5);
        jScrollPane1.setViewportView(txtDiaChi);

        lblCMND.setText("CMND");

        txtCMND.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCMNDActionPerformed(evt);
            }
        });

        lblSDT.setText("SĐT");

        txtSDT.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtSDTActionPerformed(evt);
            }
        });

        btnLuu.setText("LƯU");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("HỦY");
        btnHuy.setForeground(new java.awt.Color(255, 0, 0));
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("CẬP NHẬT KHÁCH HÀNG");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblCMND)
                            .addComponent(lblSDT)
                            .addComponent(lblNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblGioiTinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(57, 57, 57)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(DCNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(radioNam, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(radioNu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(txtCMND, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE)
                            .addComponent(txtSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 194, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(lblValidateNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(lblValidateDiaChi, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(lblValidateCMND, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(lblValidateSDT, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(lblValidateHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(29, 29, 29))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(39, 39, 39))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addComponent(jLabel1)
                .addGap(41, 41, 41)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHoTen)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValidateHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioNu, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(radioNam, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblGioiTinh))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblNgaySinh)
                            .addComponent(DCNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(lblValidateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblDiaChi)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValidateDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCMND)
                    .addComponent(txtCMND, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValidateCMND, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDT)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValidateSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 38, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
                    .addComponent(btnHuy))
                .addGap(20, 20, 20))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCMNDActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCMNDActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCMNDActionPerformed

    private void txtSDTActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtSDTActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtSDTActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
          if (validateForm())
        {
            KhachHangDTO newKhachHang = null;
            try {
                newKhachHang = getFormInfo();
            } catch (IOException ex) {
                Logger.getLogger(PopUpKhachHang.class.getName()).log(Level.SEVERE, null, ex);
            }

            if(this.action.equals("POST")) {           
                    Long newKhachHangId = khachHangBLL.save(newKhachHang);
                    if(newKhachHangId != null) {

                        JOptionPane.showMessageDialog(this, "Lưu thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                        dispose();

                    } else {
                        JOptionPane.showMessageDialog(this, "Lưu thất bại!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    }
            } else if(this.action.equals("PUT")) {
                try {    
                    khachHangBLL.update(newKhachHang);
                    JOptionPane.showMessageDialog(this, "Lưu thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch(Exception e) {
                    JOptionPane.showMessageDialog(this, "Lưu thất bại!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }else{
               
          }
    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
       dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    private void formWindowGainedFocus(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowGainedFocus
       
    }//GEN-LAST:event_formWindowGainedFocus

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker DCNgaySinh;
    private javax.swing.ButtonGroup btnGioiTinh;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCMND;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblValidateCMND;
    private javax.swing.JLabel lblValidateDiaChi;
    private javax.swing.JLabel lblValidateHoTen;
    private javax.swing.JLabel lblValidateNgaySinh;
    private javax.swing.JLabel lblValidateSDT;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNu;
    private javax.swing.JTextField txtCMND;
    private javax.swing.JTextArea txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
