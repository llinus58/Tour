/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.popup;

import BLL.NhanVienBLL;
import BLL.VaiTroBLL;
import DTO.NhanVienDTO;
import DTO.VaiTroDTO;
import com.mycompany.util.InputValidatorUtil;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.border.MatteBorder;
import javax.swing.plaf.basic.BasicArrowButton;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.plaf.basic.BasicComboPopup;
import javax.swing.plaf.basic.ComboPopup;

/**
 *
 * @author Trieu
 */
public class PopUpNhanVien extends javax.swing.JFrame {

    private String action;
    private NhanVienDTO nhanVien = null;
    private NhanVienBLL nhanVienBLL;
    private VaiTroBLL vaiTroBLL;

    public PopUpNhanVien(String action) {
        initComponents();

        this.action = action;
        nhanVienBLL = new NhanVienBLL();
        vaiTroBLL = new VaiTroBLL();
//        CustomWindow();
        setComboBox(comboBoxVaiTro, getVaiTroItems());

        setLocationRelativeTo(null);
        setResizable(false);
        radioDangRanh.setVisible(false);
        radioDangDiTour.setVisible(false);
        this.setVisible(true);
        Limit();
    }

    public PopUpNhanVien() {
        initComponents();
//        CustomWindow();
        setLocationRelativeTo(null);
        setResizable(false);
        radioDangRanh.setVisible(false);
        radioDangDiTour.setVisible(false);
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
        txtSDT.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtSDT.getText().trim().length() == 12 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
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
    }
    public PopUpNhanVien(String action, NhanVienDTO nhanVien) {
        initComponents();
        this.action = action;
        setLocationRelativeTo(null);
        setResizable(false);
        this.nhanVien = nhanVien;
        nhanVienBLL = new NhanVienBLL();
        vaiTroBLL = new VaiTroBLL();
//        CustomWindow();
        setComboBox(comboBoxVaiTro, getVaiTroItems());
        radioDangRanh.setVisible(false);
        radioDangDiTour.setVisible(false);

        setLabelText(nhanVien);
        Limit();
        this.setVisible(true);
    }

    private NhanVienDTO getFormInfo() throws IOException {
        NhanVienDTO nhanVien = new NhanVienDTO();
        if (this.nhanVien != null) {
            nhanVien.setMaNhanVien(this.nhanVien.getMaNhanVien());
        }
        nhanVien.setHoTen(txtHoTen.getText().trim());

        nhanVien.setGioiTinh(radioNam.isSelected() ? true : false);
        nhanVien.setNgaySinh(DCNgaySinh.getDate());
        nhanVien.setDiaChi(txtDiaChi.getText().trim());
        nhanVien.setSDT(txtSDT.getText().trim());

        String selectedVaiTro = comboBoxVaiTro.getSelectedItem().toString();
        int idVaiTro = Integer.parseInt(selectedVaiTro.substring(0, selectedVaiTro.indexOf(" - ")));

        nhanVien.setMaVaiTro(idVaiTro);
        nhanVien.setTrangThai(radioDangRanh.isSelected() ? true : false);

        return nhanVien;
    }

    public void setComboBox(JComboBox<String> comboBox, String[] listItems) {
        comboBox.setModel(new DefaultComboBoxModel<>(listItems));
    }

    public String[] getVaiTroItems() {
        List<VaiTroDTO> vaiTroLists = vaiTroBLL.findAll();
        String[] vaiTroItems = new String[vaiTroLists.size()];
        int index = 0;
        for (VaiTroDTO vt : vaiTroLists) {
            vaiTroItems[index] = vt.getMaVaiTro() + " - " + vt.getTenVaiTro();
            ++index;
        }
        return vaiTroItems;
    }

    public String getVaiTroItemName(VaiTroDTO vaiTro) {
        return vaiTro.getMaVaiTro() + " - " + vaiTro.getTenVaiTro();
    }

    public void center() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width / 2 - this.getSize().width / 2, dim.height / 2 - this.getSize().height / 2);
    }

    public void setLabelText(NhanVienDTO nhanVien) {
        txtHoTen.setText(nhanVien.getHoTen());
        DCNgaySinh.setDate(nhanVien.getNgaySinh());
        if (nhanVien.getGioiTinh()) {
            radioNam.setSelected(true);
        } else {
            radioNu.setSelected(true);
        }
        txtSDT.setText(nhanVien.getSDT());
        txtDiaChi.setText(nhanVien.getDiaChi());

        comboBoxVaiTro.setSelectedItem(getVaiTroItemName(vaiTroBLL.findById(nhanVien.getMaVaiTro())));
        if (nhanVien.getTrangThai()) {
            radioDangRanh.setSelected(true);
        } else {
            radioDangDiTour.setSelected(true);
        }

    }

    public boolean validateForm() {

        boolean HoTen, Sdt = false, DiaChi, NgaySinh;
        ImageIcon iconCheck = new ImageIcon("check.png");
        ImageIcon iconError = new ImageIcon("error.png");
        if (InputValidatorUtil.isValidName(txtHoTen.getText(), false).isEmpty()) {
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
                if (nhanVienBLL.findBySDT(txtSDT.getText().trim()) != null) {
                    Sdt = false;
                    lblValidateSDT.setIcon(iconError);
                    lblValidateSDT.setToolTipText("Số điện thoại này đã được sử dụng");
                }
            } else if (this.action.equals("PUT")) {
                NhanVienDTO newNhanVien = nhanVienBLL.findBySDT(txtSDT.getText().trim());
                if (newNhanVien != null) {
                    if (newNhanVien.getMaNhanVien() != this.nhanVien.getMaNhanVien()) {
                        Sdt = false;
                        lblValidateSDT.setIcon(iconError);
                        lblValidateSDT.setToolTipText("Số điện thoại này đã được sử dụng");
                    }
                }

            }
        }

        if (InputValidatorUtil.isValidBirthDate(DCNgaySinh.getDate(), 18).isEmpty()) {
            NgaySinh = true;
            lblValidateNgaySinh.setIcon(iconCheck);
            lblValidateNgaySinh.setToolTipText(null);
        } else {
            NgaySinh = false;
            lblValidateNgaySinh.setIcon(iconError);
            lblValidateNgaySinh.setToolTipText(InputValidatorUtil.isValidBirthDate(DCNgaySinh.getDate(), 18));
        }

        if (InputValidatorUtil.isValidAddress(txtDiaChi.getText()).isEmpty()) {
            DiaChi = true;
            lblValidateDiaChi.setIcon(iconCheck);
            lblValidateDiaChi.setToolTipText(null);
        } else {
            DiaChi = false;
            lblValidateDiaChi.setIcon(iconError);
            lblValidateDiaChi.setToolTipText(InputValidatorUtil.isValidAddress(txtDiaChi.getText()));
        }

        if (HoTen && Sdt && NgaySinh && DiaChi) {
            return true;
        } else {
            return false;
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

        btnGioiTinh = new javax.swing.ButtonGroup();
        btnTrangThai = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        lblHoTen = new javax.swing.JLabel();
        txtHoTen = new javax.swing.JTextField();
        lblVaiTro = new javax.swing.JLabel();
        lblGioiTinh = new javax.swing.JLabel();
        radioNam = new javax.swing.JRadioButton();
        radioNu = new javax.swing.JRadioButton();
        lblNgaySinh = new javax.swing.JLabel();
        lblSDT = new javax.swing.JLabel();
        txtSDT = new javax.swing.JTextField();
        lblDiaChi = new javax.swing.JLabel();
        txtDiaChi = new javax.swing.JTextField();
        btnLuu = new javax.swing.JButton();
        btnHuy = new javax.swing.JButton();
        comboBoxVaiTro = new javax.swing.JComboBox<>();
        DCNgaySinh = new com.github.lgooddatepicker.components.DatePicker();
        lblValidateHoTen = new javax.swing.JLabel();
        lblValidateNgaySinh = new javax.swing.JLabel();
        lblValidateSDT = new javax.swing.JLabel();
        lblValidateDiaChi = new javax.swing.JLabel();
        radioDangRanh = new javax.swing.JRadioButton();
        radioDangDiTour = new javax.swing.JRadioButton();
        lblTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        lblHoTen.setText("HỌ TÊN");
        lblHoTen.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblVaiTro.setText("VAI TRÒ");
        lblVaiTro.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblGioiTinh.setText("GIỚI TÍNH");
        lblGioiTinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnGioiTinh.add(radioNam);
        radioNam.setSelected(true);
        radioNam.setText("NAM");

        btnGioiTinh.add(radioNu);
        radioNu.setText("NỮ");

        lblNgaySinh.setText("NGÀY SINH");
        lblNgaySinh.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblSDT.setText("SỐ ĐIỆN THOẠI");
        lblSDT.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        lblDiaChi.setText("ĐỊA CHỈ");
        lblDiaChi.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N

        btnLuu.setText("LƯU");
        btnLuu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLuuActionPerformed(evt);
            }
        });

        btnHuy.setText("HỦY");
        btnHuy.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHuyActionPerformed(evt);
            }
        });

        comboBoxVaiTro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboBoxVaiTroActionPerformed(evt);
            }
        });

        btnTrangThai.add(radioDangRanh);
        radioDangRanh.setSelected(true);
        radioDangRanh.setText("Đang rảnh");

        btnTrangThai.add(radioDangDiTour);
        radioDangDiTour.setText("Đang đi tour");

        lblTitle.setText("CẬP NHẬT NHÂN VIÊN");
        lblTitle.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(53, 53, 53)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(40, 40, 40)
                        .addComponent(btnLuu, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(btnHuy, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblGioiTinh, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(radioDangRanh, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(26, 26, 26)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtHoTen, javax.swing.GroupLayout.DEFAULT_SIZE, 170, Short.MAX_VALUE)
                                    .addComponent(DCNgaySinh, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(lblValidateHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(0, 0, Short.MAX_VALUE)
                                        .addComponent(lblValidateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(24, 24, 24)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(comboBoxVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(radioDangDiTour, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addComponent(radioNam, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(radioNu, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(40, 40, 40)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblValidateSDT, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblValidateDiaChi, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitle)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblHoTen)
                    .addComponent(lblValidateHoTen, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNgaySinh)
                    .addComponent(DCNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValidateNgaySinh, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGioiTinh)
                    .addComponent(radioNam)
                    .addComponent(radioNu))
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblSDT)
                    .addComponent(txtSDT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValidateSDT, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDiaChi)
                    .addComponent(txtDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblValidateDiaChi, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblVaiTro)
                    .addComponent(comboBoxVaiTro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(52, 52, 52)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radioDangDiTour)
                    .addComponent(radioDangRanh))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnLuu)
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

    private void comboBoxVaiTroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboBoxVaiTroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_comboBoxVaiTroActionPerformed

    private void btnLuuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLuuActionPerformed
        // TODO add your handling code here:
        if (validateForm()) {
            NhanVienDTO newNhanVien = null;
            try {
                newNhanVien = getFormInfo();
            } catch (IOException ex) {
                Logger.getLogger(PopUpNhanVien.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (this.action.equals("POST")) {
                Long newNhanVienId = nhanVienBLL.save(newNhanVien);
                if (newNhanVienId != null) {

                    JOptionPane.showMessageDialog(this, "Lưu thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(this, "Lưu thất bại!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                }
            } else if (this.action.equals("PUT")) {
                try {
                    nhanVienBLL.update(newNhanVien);
                    JOptionPane.showMessageDialog(this, "Lưu thành công!!!", "Thông báo", JOptionPane.INFORMATION_MESSAGE);
                    dispose();
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(this, "Lưu thất bại!!!", "Thông báo", JOptionPane.ERROR_MESSAGE);
                    e.printStackTrace();
                }
            }
        }

    }//GEN-LAST:event_btnLuuActionPerformed

    private void btnHuyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHuyActionPerformed
        dispose();
    }//GEN-LAST:event_btnHuyActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DatePicker DCNgaySinh;
    private javax.swing.ButtonGroup btnGioiTinh;
    private javax.swing.JButton btnHuy;
    private javax.swing.JButton btnLuu;
    private javax.swing.ButtonGroup btnTrangThai;
    private javax.swing.JComboBox<String> comboBoxVaiTro;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblDiaChi;
    private javax.swing.JLabel lblGioiTinh;
    private javax.swing.JLabel lblHoTen;
    private javax.swing.JLabel lblNgaySinh;
    private javax.swing.JLabel lblSDT;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JLabel lblVaiTro;
    private javax.swing.JLabel lblValidateDiaChi;
    private javax.swing.JLabel lblValidateHoTen;
    private javax.swing.JLabel lblValidateNgaySinh;
    private javax.swing.JLabel lblValidateSDT;
    private javax.swing.JRadioButton radioDangDiTour;
    private javax.swing.JRadioButton radioDangRanh;
    private javax.swing.JRadioButton radioNam;
    private javax.swing.JRadioButton radioNu;
    private javax.swing.JTextField txtDiaChi;
    private javax.swing.JTextField txtHoTen;
    private javax.swing.JTextField txtSDT;
    // End of variables declaration//GEN-END:variables
}
