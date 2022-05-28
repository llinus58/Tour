/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.popup;

import BLL.DoanBLL;
import DTO.DoanDTO;
import com.mycompany.form.QuanLyDoanGUI;
import com.mycompany.util.InputValidatorUtil;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author Trieu
 */
public class PopUpSuaDoan extends javax.swing.JFrame {
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    DoanBLL db = new DoanBLL();
    public PopUpSuaDoan() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setFormSua();
        txtTenDoan.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtTenDoan.getText().trim().length() == 40 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume();
    } 
            }
        });
    }
    public void setFormSua(){
        DoanDTO d = db.findDoanbyID(QuanLyDoanGUI.idDoan);
        txtMaDoan.setText(String.valueOf(d.getId()));
        txtTenDoan.setText(d.getTenDoan());
        txtTour.setText(db.findNamebyID_Tour(d.getIdTour()));
        txtGiaTour.setText(String.valueOf(formatter.format(db.cal_GoiGiaTour(d.getIdGiaTour(), d.getIdTour()))));
        txtNgayBD.setDate(Date.from(d.getNgayKH().atStartOfDay(ZoneId.systemDefault()).toInstant()));
        txtNgayKT.setDate(Date.from(d.getNgayKT().atStartOfDay(ZoneId.systemDefault()).toInstant()));
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
        btnSua = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        lblNgayBatDau = new javax.swing.JLabel();
        txtTenDoan = new javax.swing.JTextField();
        lblTour = new javax.swing.JLabel();
        lblMaDoan = new javax.swing.JLabel();
        lblTenDoan = new javax.swing.JLabel();
        txtMaDoan = new javax.swing.JTextField();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        lblNgayKetThuc = new javax.swing.JLabel();
        lblGiaTour = new javax.swing.JLabel();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        txtTour = new javax.swing.JTextField();
        txtGiaTour = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btnSua.setText("LƯU");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnHuy.setText("HỦY");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("SỬA ĐOÀN");

        lblNgayBatDau.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgayBatDau.setText("NGÀY BẮT ĐẦU");

        lblTour.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTour.setText("TOUR");

        lblMaDoan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblMaDoan.setText("MÃ ĐOÀN");

        lblTenDoan.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblTenDoan.setText("TÊN ĐOÀN");

        txtMaDoan.setEditable(false);

        lblNgayKetThuc.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblNgayKetThuc.setText("NGÀY KẾT THÚC");

        lblGiaTour.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        lblGiaTour.setText("GIÁ TOUR");

        txtTour.setEditable(false);

        txtGiaTour.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNgayKetThuc, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgayBatDau, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(23, 23, 23)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtNgayBD, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(79, 79, 79)
                        .addComponent(btnSua, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblMaDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTour, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtMaDoan, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                            .addComponent(txtTenDoan)
                            .addComponent(txtTour)
                            .addComponent(txtGiaTour, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap(62, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(132, 132, 132))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jLabel1)
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtMaDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblMaDoan))
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTenDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblTenDoan))
                        .addGap(40, 40, 40)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblTour)
                            .addComponent(txtTour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40)
                        .addComponent(lblGiaTour))
                    .addComponent(txtGiaTour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblNgayBatDau))
                .addGap(33, 33, 33)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblNgayKetThuc, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtNgayKT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 57, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSua)
                    .addComponent(btnHuy))
                .addGap(60, 60, 60))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
        if (txtTenDoan.getText().isBlank() || txtNgayBD.getDate() == null || txtNgayKT.getDate() == null) {
            JOptionPane.showMessageDialog(rootPane, "Hay nhap day du thong tin");
        } else if (!txtNgayKT.getDate().after(txtNgayBD.getDate())) {
            JOptionPane.showMessageDialog(rootPane, "Ngay ket thuc phai giong hoac sau ngay bat dau");
        } 
        
         else if(!InputValidatorUtil.isValidName(txtTenDoan.getText(), true).isEmpty()){
             JOptionPane.showMessageDialog(rootPane, "Ten doan khong hop le");
        }
        else {
            DoanDTO dsua = db.findDoanbyID(QuanLyDoanGUI.idDoan);
            dsua.setTenDoan(txtTenDoan.getText());

            dsua.setNgayKH(txtNgayBD.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            dsua.setNgayKT(txtNgayKT.getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
            if (db.delete(dsua.getId())) {
                if (db.update(dsua)) {
                    JOptionPane.showMessageDialog(null, "Da sua thong tin");
                    dispose();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Loi xay ra");
            }
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
       dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    /**
     * @param args the command line arguments
     */
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup btnGioiTinh;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnSua;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblGiaTour;
    private javax.swing.JLabel lblMaDoan;
    private javax.swing.JLabel lblNgayBatDau;
    private javax.swing.JLabel lblNgayKetThuc;
    private javax.swing.JLabel lblTenDoan;
    private javax.swing.JLabel lblTour;
    private javax.swing.JTextField txtGiaTour;
    private javax.swing.JTextField txtMaDoan;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    private javax.swing.JTextField txtTenDoan;
    private javax.swing.JTextField txtTour;
    // End of variables declaration//GEN-END:variables
}
