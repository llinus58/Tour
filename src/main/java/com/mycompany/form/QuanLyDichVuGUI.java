/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.form;

import BLL.DichVuBLL;
import DAL.DichVuDAL;
import DTO.DichVuDTO;
import com.mycompany.util.InputValidatorUtil;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trieu
 */
public class QuanLyDichVuGUI extends javax.swing.JFrame {

    /**
     * Creates new form QuanLyDichVuGUI
     */
    public static ArrayList<DichVuDTO> listdv = new ArrayList<>();
    public static DefaultTableModel modeldichvu;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    DichVuBLL dvb = new DichVuBLL();
    public QuanLyDichVuGUI() throws SQLException {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);

        modeldichvu = (DefaultTableModel) tblDichVu.getModel();

        LocListDV();
        txtTenDV.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtTenDV.getText().trim().length() == 30 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume();
    } 
            }
        });
        txtGiaDV.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtGiaDV.getText().trim().length() == 8 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume();
    } 
            }
        });
        txtMoTa.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtMoTa.getText().trim().length() == 50 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume();
    } 
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblDichVu = new javax.swing.JTable();
        btnXoa = new javax.swing.JButton();
        btnSua = new javax.swing.JButton();
        btnThem = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        txtMaDV = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtTenDV = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtGiaDV = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtMoTa = new javax.swing.JTextArea();
        btnBack = new javax.swing.JButton();
        lblMaTour1 = new javax.swing.JLabel();
        btnReset = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tblDichVu.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "T??N D???CH V???", "TH??NG TIN DV", "GI?? D???CH V???"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDichVu.getTableHeader().setReorderingAllowed(false);
        tblDichVu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDichVuMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblDichVu);

        btnXoa.setForeground(new java.awt.Color(153, 0, 0));
        btnXoa.setText("X??A");
        btnXoa.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnXoaMousePressed(evt);
            }
        });
        btnXoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnXoaActionPerformed(evt);
            }
        });

        btnSua.setText("S???A");
        btnSua.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSuaActionPerformed(evt);
            }
        });

        btnThem.setText("TH??M");
        btnThem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThemActionPerformed(evt);
            }
        });

        jLabel1.setText("M?? D???CH V???");

        txtMaDV.setEditable(false);

        jLabel2.setText("T??N D???CH V???");

        jLabel3.setText("GI?? D???CH V???");

        jLabel4.setText("M?? T???");

        txtMoTa.setColumns(20);
        txtMoTa.setRows(5);
        jScrollPane2.setViewportView(txtMoTa);

        btnBack.setText("BACK");
        btnBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnBackMousePressed(evt);
            }
        });

        lblMaTour1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        lblMaTour1.setText("QU???N L?? D???CH V???");

        btnReset.setText("RESET");
        btnReset.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnResetMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 581, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnBack, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(lblMaTour1)
                        .addGap(94, 94, 94)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtTenDV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 156, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtGiaDV, javax.swing.GroupLayout.Alignment.TRAILING))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(btnXoa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnThem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnSua, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnReset)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(18, 18, 18)
                        .addComponent(txtMaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtTenDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtGiaDV, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(btnThem)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnSua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnXoa))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnBack)
                            .addComponent(lblMaTour1))
                        .addGap(42, 42, 42)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 409, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnBackMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnBackMousePressed
        // TODO add your handling code here:
        new Home().setVisible(true);
        this.setVisible(false);

    }//GEN-LAST:event_btnBackMousePressed

    private void tblDichVuMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDichVuMousePressed
        // TODO add your handling code here:
        int i = tblDichVu.getSelectedRow();
        if (i >= 0) {
            txtMaDV.setText(String.valueOf(modeldichvu.getValueAt(i, 0)));
            txtTenDV.setText(String.valueOf(modeldichvu.getValueAt(i, 1)));
            txtMoTa.setText(String.valueOf(modeldichvu.getValueAt(i, 2)));
            txtGiaDV.setText(String.valueOf(modeldichvu.getValueAt(i, 3)).replace(",", ""));
        }
    }//GEN-LAST:event_tblDichVuMousePressed

    private void btnSuaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnSuaMousePressed
        
    }//GEN-LAST:event_btnSuaMousePressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        ResetTxt();
    }//GEN-LAST:event_jButton1MousePressed

    private void btnXoaMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnXoaMousePressed
      
    }//GEN-LAST:event_btnXoaMousePressed

    private void btnThemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThemActionPerformed
       if (txtTenDV.getText().isEmpty() || txtMoTa.getText().isEmpty() || txtGiaDV.getText().isEmpty()) {
                JOptionPane.showMessageDialog(rootPane, "Chua nhap du thong tin");
        }
        else if(!InputValidatorUtil.isValidName(txtTenDV.getText(), true).isEmpty()){
             JOptionPane.showMessageDialog(rootPane, "Ten dich vu khong hop le");
        }
        
         else if(!InputValidatorUtil.isVailidNumber(txtGiaDV.getText()).isEmpty()){
             JOptionPane.showMessageDialog(rootPane, "Gia dich vu khong hop le");
        }
          else if(!InputValidatorUtil.isValidAddress(txtMoTa.getText()).isEmpty()){
             JOptionPane.showMessageDialog(rootPane, "Mo ta khong khong hop le");
        }
        else
        {
             DichVuDTO dv = new DichVuDTO();
            //dv.setMaDV("");
            dv.setTenDV(txtTenDV.getText());
            dv.setMoTa(txtMoTa.getText());
            dv.setGiaDV(Double.parseDouble(txtGiaDV.getText()));
//            JOptionPane.showMessageDialog(rootPane, txtTenDV);
//            JOptionPane.showMessageDialog(rootPane, txtMoTa);
//            JOptionPane.showMessageDialog(rootPane, txtGiaDV);
            try {
                if (new DichVuBLL().themDichVu(dv)) {
                    JOptionPane.showMessageDialog(rootPane, "Da them");
                    ResetTxt();
                    LocListDV();
                } else {
                    JOptionPane.showMessageDialog(rootPane, "ERROR");
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyDichVuGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_btnThemActionPerformed

    private void btnSuaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSuaActionPerformed
       
        if(!InputValidatorUtil.isValidName(txtTenDV.getText(), true).isEmpty()){
             JOptionPane.showMessageDialog(rootPane, "Ten dich vu khong hop le");
        }
        
         else if(!InputValidatorUtil.isVailidNumber(txtGiaDV.getText()).isEmpty()){
             JOptionPane.showMessageDialog(rootPane, "Gia dich vu khong hop le");
        }
          else if(!InputValidatorUtil.isValidAddress(txtMoTa.getText()).isEmpty()){
             JOptionPane.showMessageDialog(rootPane, "Mo ta khong khong hop le");
        }
        
        else if (!txtTenDV.getText().isEmpty() || !txtMoTa.getText().isEmpty() || !txtGiaDV.getText().isEmpty()) {
            //DichVuDTO dv = new DichVuDTO();
            String MaDV = txtMaDV.getText();
            String TenDV = txtTenDV.getText();
            String MoTa = txtMoTa.getText();
            double Gia = Double.parseDouble(txtGiaDV.getText());
//            JOptionPane.showMessageDialog(rootPane, txtTenDV);
//            JOptionPane.showMessageDialog(rootPane, txtMoTa);
//            JOptionPane.showMessageDialog(rootPane, txtGiaDV);
            try {
                int conf = JOptionPane.showConfirmDialog(rootPane, "B???n c?? ch???c ch???n mu???n s???a D???CH V??? n??y ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
                if (conf == JOptionPane.YES_OPTION) {
                    if (new DichVuBLL().suaDV(MaDV, TenDV, Gia, MoTa)) {
                        JOptionPane.showMessageDialog(rootPane, "Sua thanh cong");
                        ResetTxt();
                        LocListDV();
                    } else {
                        JOptionPane.showMessageDialog(rootPane, "ERROR");
                    }
                }
            } catch (SQLException ex) {
                Logger.getLogger(QuanLyDichVuGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Chua nhap du thong tin");
        }
    }//GEN-LAST:event_btnSuaActionPerformed

    private void btnResetMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnResetMousePressed
        // TODO add your handling code here:
        ResetTxt();
    }//GEN-LAST:event_btnResetMousePressed

    private void btnXoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnXoaActionPerformed
        int i = tblDichVu.getSelectedRow();
        if (i < 0) {
            JOptionPane.showMessageDialog(rootPane, "Chon dong can thuc hien");
        } else {
            
               int iddv = Integer.parseInt(String.valueOf(tblDichVu.getValueAt(tblDichVu.getSelectedRow(),0)));
               String ten = String.valueOf(tblDichVu.getValueAt(tblDichVu.getSelectedRow(),1));
               int conf = JOptionPane.showConfirmDialog(rootPane, "Thao tac se xoa dich vu nay khoi cac gia tour hien co ?", "Confirm", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (conf == JOptionPane.YES_OPTION) {
               dvb.delete(iddv);
               JOptionPane.showMessageDialog(rootPane, "Xoa thanh cong");
                   try {
                       LocListDV();
                       ResetTxt();
                   } catch (SQLException ex) {
                       Logger.getLogger(QuanLyDichVuGUI.class.getName()).log(Level.SEVERE, null, ex);
                   }
            
            }
            
            //DichVuDTO dv = new DichVuDTO();
            
        }
    }//GEN-LAST:event_btnXoaActionPerformed

    public void LocListDV() throws SQLException {
        modeldichvu.setRowCount(0);
        listdv = new DichVuBLL().getAll("1", "MaDichVu ASC");
        for (DichVuDTO dv : listdv) {
            modeldichvu.addRow(new Object[]{dv.getMaDV(), dv.getTenDV(), dv.getMoTa(), String.valueOf(formatter.format(dv.getGiaDV()))});
        }
    }

    public void ResetTxt() {
        txtMaDV.setText("");
        txtTenDV.setText("");
        txtGiaDV.setText("");
        txtMoTa.setText("");
    }

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnReset;
    private javax.swing.JButton btnSua;
    private javax.swing.JButton btnThem;
    private javax.swing.JButton btnXoa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblMaTour1;
    private javax.swing.JTable tblDichVu;
    private javax.swing.JTextField txtGiaDV;
    private javax.swing.JTextField txtMaDV;
    private javax.swing.JTextArea txtMoTa;
    private javax.swing.JTextField txtTenDV;
    // End of variables declaration//GEN-END:variables
}
