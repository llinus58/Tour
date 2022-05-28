/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.form;

import BLL.DoanBLL;
import BLL.NhanVienBLL;
import BLL.TourBLL;
import DTO.DoanDTO;
import DTO.NhanVienDTO;
import DTO.TourDTO;
import com.mycompany.util.TableSetupUtil;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

/**
 *
 * @author Trieu
 */
public class ThongKeTheoTour extends javax.swing.JFrame {

    /**
     * Creates new form ThongKeTheoTour
     */
    DefaultTableModel dtm = new DefaultTableModel();
    DoanBLL db = new DoanBLL();
    public ArrayList<DoanDTO> listdoan;
    public TableRowSorter<TableModel> rowSorter = null;
    public static int idDoan;
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    public ThongKeTheoTour() {

        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        loadComBoBox();
        txtNgayBD.setEnabled(false);
        txtNgayKT.setEnabled(false);

    }

    public void loadComBoBox() {
        ArrayList<TourDTO> listtour = new TourBLL().getAll();
        cbTour.addItem("Tất cả");
        for (TourDTO tour : listtour) {
            cbTour.addItem(tour.getMaTour() + " : " + tour.getTenTour());
        }

        List<NhanVienDTO> listnhanvien = new NhanVienBLL().findAll();
        cbNhanVien.addItem("Tất cả");
        for (NhanVienDTO nhanvien : listnhanvien) {
            cbNhanVien.addItem(nhanvien.getMaNhanVien() + " : " + nhanvien.getHoTen());
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

        HinhThucThongKe = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblThongKeDoan = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        rbToanTG = new javax.swing.JRadioButton();
        rbKhoangTG = new javax.swing.JRadioButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        btnThongKe = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtNgayBD = new com.toedter.calendar.JDateChooser();
        txtNgayKT = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        cbTour = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        lbTienDV = new javax.swing.JLabel();
        lbTongTien = new javax.swing.JLabel();
        lbTienTour = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbNhanVien = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        lbTongDoan = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("BACK");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                jButton1MousePressed(evt);
            }
        });

        tblThongKeDoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID ĐOÀN", "TÊN ĐOÀN", "SỐ LƯỢNG KH", "Ngày BD", "NGÀY KT", "TIỀN TOUR", "TIỀN DỊCH VỤ", "TỔNG TIỀN"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblThongKeDoan.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tblThongKeDoan);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel1.setText("HÌNH THỨC THỐNG KÊ");

        HinhThucThongKe.add(rbToanTG);
        rbToanTG.setSelected(true);
        rbToanTG.setText("TOÀN THỜI GIAN");
        rbToanTG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbToanTGMousePressed(evt);
            }
        });

        HinhThucThongKe.add(rbKhoangTG);
        rbKhoangTG.setText("KHOẢNG THỜI GIAN");
        rbKhoangTG.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                rbKhoangTGMousePressed(evt);
            }
        });

        jLabel2.setText("TỪ NGÀY");

        jLabel3.setText("ĐẾN NGÀY");

        btnThongKe.setText("THỐNG KÊ");
        btnThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnThongKeMousePressed(evt);
            }
        });
        btnThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThongKeActionPerformed(evt);
            }
        });

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel7.setText("THỐNG KÊ");

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("TOUR");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel5.setText("Tổng tiền dịch vụ :");

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setText("Tổng tiền tour : ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Tổng tiền :");

        lbTienDV.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTienDV.setText("0.0");

        lbTongTien.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTongTien.setText("0.0");

        lbTienTour.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTienTour.setText("0.0");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel9.setText("NHÂN VIÊN");

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel10.setText("Tổng đoàn :");

        lbTongDoan.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lbTongDoan.setText("0");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(jLabel10)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(lbTongDoan))
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(39, 39, 39)
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(cbTour, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(43, 43, 43))
                                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(82, 82, 82)))
                                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(cbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGap(34, 34, 34)))))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(rbKhoangTG)
                                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(rbToanTG, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(319, 319, 319)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(43, 43, 43)))
                                .addGap(15, 15, 15)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                                        .addComponent(btnThongKe, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbTienTour)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(lbTienDV)
                        .addGap(202, 202, 202)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbTongTien)
                        .addGap(132, 132, 132))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jButton1))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(21, 21, 21)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(cbNhanVien, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(cbTour, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNgayBD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGap(6, 6, 6)
                                    .addComponent(rbToanTG))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(5, 5, 5)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(rbKhoangTG)
                                    .addComponent(btnThongKe))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(lbTongDoan))
                                .addGap(3, 3, 3)))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 319, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNgayKT, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(329, 329, 329)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel8)
                    .addComponent(lbTienDV)
                    .addComponent(lbTongTien)
                    .addComponent(jLabel6)
                    .addComponent(lbTienTour))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MousePressed
        // TODO add your handling code here:
        new Home().setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1MousePressed

    private void btnThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThongKeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnThongKeActionPerformed

    private void btnThongKeMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnThongKeMousePressed
        // TODO add your handling code here:
        int idtour = 0, idnhanvien = 0, tongdoan = 0;
        String from = "", to = "";
        double tiendv = 0.0, tientour = 0.0, tongtien = 0.0;
        SimpleDateFormat fm = new SimpleDateFormat("yyyy-MM-dd");

        if (!cbTour.getSelectedItem().equals("Tất cả")) {
            idtour = Integer.parseInt(cbTour.getSelectedItem().toString().substring(0, 1));
        }

        if (!cbNhanVien.getSelectedItem().equals("Tất cả")) {
            idnhanvien = Integer.parseInt(cbNhanVien.getSelectedItem().toString().substring(0, 1));
        }

        if (rbKhoangTG.isSelected()) {
            if (txtNgayBD.getDate() == null || txtNgayKT.getDate() == null) {
                JOptionPane.showMessageDialog(rootPane, "Hãy nhập đầy đủ thông tin !");
            } else if (!txtNgayKT.getDate().after(txtNgayBD.getDate())) {
                JOptionPane.showMessageDialog(rootPane, "Ngày kết thúc phải bằng hoặc lớn hơn ngày bắt đầu !");
            } else {
                from = fm.format(txtNgayBD.getDate()).toString();
                to = fm.format(txtNgayKT.getDate()).toString();
            }
        }
        //JOptionPane.showMessageDialog(rootPane, from + "   " + to);
        listdoan = db.ThongKeDoan(idtour, idnhanvien, from, to);
        dtm = (DefaultTableModel) tblThongKeDoan.getModel();
        dtm.setRowCount(0);
        for (DoanDTO d : listdoan) {
            int sl = db.cal_SoLuongKH(d.getId());
            double tiendv1 = db.cal_GiaDVGoiTour(d.getIdGiaTour());
            double tientour1 = db.cal_GiaCoBanTour(d.getIdGiaTour(), d.getIdTour());
            
            dtm.addRow(new Object[]{d.getId(), d.getTenDoan(), db.cal_SoLuongKH(d.getId()), d.getNgayKH()
                    , d.getNgayKT(), formatter.format(tientour1*sl)
                    , formatter.format(tiendv1*sl), formatter.format(db.cal_GoiGiaTour(d.getIdGiaTour(), d.getIdTour())*sl)});
            tiendv += tiendv1*sl;
            tientour += tientour1*sl;
            tongdoan++;
        }
        tongtien += tiendv + tientour;
        lbTongDoan.setText(String.valueOf(formatter.format(tongdoan)));
        lbTienTour.setText(String.valueOf(formatter.format(tientour)));
        lbTienDV.setText(String.valueOf(formatter.format(tiendv)));
        lbTongTien.setText(String.valueOf(formatter.format(tongtien)));
    }//GEN-LAST:event_btnThongKeMousePressed

    private void rbToanTGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbToanTGMousePressed
        // TODO add your handling code here:
        txtNgayBD.setDate(null);
        txtNgayKT.setDate(null);
        txtNgayBD.setEnabled(false);
        txtNgayKT.setEnabled(false);
    }//GEN-LAST:event_rbToanTGMousePressed

    private void rbKhoangTGMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rbKhoangTGMousePressed
        // TODO add your handling code here:
        txtNgayBD.setEnabled(true);
        txtNgayKT.setEnabled(true);
    }//GEN-LAST:event_rbKhoangTGMousePressed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup HinhThucThongKe;
    private javax.swing.JButton btnThongKe;
    private javax.swing.JComboBox<String> cbNhanVien;
    private javax.swing.JComboBox<String> cbTour;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTienDV;
    private javax.swing.JLabel lbTienTour;
    private javax.swing.JLabel lbTongDoan;
    private javax.swing.JLabel lbTongTien;
    private javax.swing.JRadioButton rbKhoangTG;
    private javax.swing.JRadioButton rbToanTG;
    private javax.swing.JTable tblThongKeDoan;
    private com.toedter.calendar.JDateChooser txtNgayBD;
    private com.toedter.calendar.JDateChooser txtNgayKT;
    // End of variables declaration//GEN-END:variables
}
