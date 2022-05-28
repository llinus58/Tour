/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.form;

import BLL.DoanBLL;
import BLL.GoiTourBLL;
import BLL.KhachHangBLL;
import BLL.LoaiHinhDuLichBLL;
import DAL.TourDAL;
import DTO.DoanDTO;
import DTO.GoiTourDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import DTO.TourDTO;
import com.mycompany.util.KhachHangTableLoaderUtil;
import com.mycompany.util.TableSetupUtil;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class TimKiem extends javax.swing.JFrame {
     String[] columnNames = {
        "ID KHÁCH HÀNG",
        "HỌ TÊN",
        "GIỚI TÍNH",
        "NGÀY SINH",
        "ĐỊA CHỈ",
        "CMND",
        "SDT"};
    private TableRowSorter<TableModel> rowSorterKH,rowSorterTour,rowSorterDoan;
    private KhachHangBLL khachHangBLL = new KhachHangBLL();
    private DoanBLL db = new DoanBLL();
    DefaultTableModel dtmKH = new DefaultTableModel();
    DefaultTableModel dtmTour = new DefaultTableModel();
    DefaultTableModel dtmGoiTour = new DefaultTableModel();
    DefaultTableModel dtmDoan = new DefaultTableModel();
    DefaultTableModel dtmDSKH_Doan = new DefaultTableModel();
    DefaultTableModel dtmDSNV_Doan = new DefaultTableModel();
    private GoiTourBLL gb = new GoiTourBLL();
    DecimalFormat formatter = new DecimalFormat("###,###,###");
    public TimKiem(){
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        setUp();
        txtKH.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtKH.getText().trim().length() == 8 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume();
    }               
                if (String.valueOf(evt.getKeyChar()).matches("[^A-Za-z0-9 -]")) {
                    evt.consume();
                }
            }
        });
        txtTour.addKeyListener(new KeyAdapter() {
            public void keyTyped(KeyEvent evt) {
                if (txtKH.getText().trim().length() == 8 || evt.getKeyChar() == java.awt.event.KeyEvent.VK_BACK_SPACE) {
        evt.consume();
    }               
                if (String.valueOf(evt.getKeyChar()).matches("[^A-Za-z0-9 -]")) {
                    evt.consume();
                }
            }
        });
    }
    public void setUp(){
        lbSearchKH.setIcon(new ImageIcon("search.png"));
        lbSearchTour.setIcon(new ImageIcon("search.png"));
        lbSearchDoan.setIcon(new ImageIcon("search.png"));
        loadTableKH();
        loadTableTour();
        loadTableDoan();
        rowSorterKH = TableSetupUtil.setTableFilter(tblKhachHang, txtKH);
        rowSorterTour = TableSetupUtil.setTableFilter(tblTour, txtTour);
        rowSorterDoan = TableSetupUtil.setTableFilter(tblDoan, txtDoan);
    }
    public void loadTableKH() {
        tblKhachHang.setModel(new KhachHangTableLoaderUtil().setTable(khachHangBLL.findAll(), this.columnNames));
        
    }
    public void loadTable_DSTourKH(int idkh){
        ArrayList<DoanDTO> list = db.getDSTour(idkh);
        dtmKH = (DefaultTableModel) tblDSTourKH.getModel();
        dtmKH.setRowCount(0);
        int i = 0;
        for(DoanDTO d : list){
            
            dtmKH.addRow(new Object[]{(i+1),d.getId(),d.getTenDoan(),d.getNgayKH(),d.getNgayKT()});
            i++;
        }
        txtKH_SoTourDaDi.setText(String.valueOf(i));
    }
    public void loadTableTour(){
        ArrayList<TourDTO> list = new TourDAL().getList();
        dtmTour = (DefaultTableModel) tblTour.getModel();
        dtmTour.setRowCount(0);
        for (TourDTO t : list) {
            dtmTour.addRow(new Object[]{t.getMaTour(), t.getTenTour(), new LoaiHinhDuLichBLL().goitenLoaiHinhDuLich(t.getMaLoaiHinhDuLich())});
        }
        
    }
    public void loadTable_GoiTour(int idtour){
        ArrayList<GoiTourDTO> list = gb.getList(idtour);
        dtmGoiTour = (DefaultTableModel) tblDSGoiGia.getModel();
        dtmGoiTour.setRowCount(0);
        int i = 0;
        for (GoiTourDTO t : list) {
            dtmGoiTour.addRow(new Object[]{i+1,t.getMaGiaTour(),formatter.format(db.cal_GoiGiaTour(t.getMaGiaTour(), t.getMaTour()))});
            i++;
        }
        txtTour_SoTourDaDi.setText(String.valueOf(db.soTourDiDuoc(idtour)));
    }
    public void loadTableDoan(){
        ArrayList<DoanDTO> listdoan = db.findAll();
        dtmDoan = (DefaultTableModel) tblDoan.getModel();
        dtmDoan.setRowCount(0);
        for(DoanDTO d : listdoan){
            dtmDoan.addRow(new Object[]{d.getId(),db.findNamebyID_Tour(d.getIdTour()),d.getTenDoan(),d.getNgayKH(),d.getNgayKT()});
        }
       
    }
    public void loadTable_DSNV(int iddoan){
        ArrayList<NhanVienDTO> list = db.listNV_Doan(iddoan);
        dtmDSNV_Doan = (DefaultTableModel) tblDSNV_Doan.getModel();
        dtmDSNV_Doan.setRowCount(0);
        for(NhanVienDTO d : list){
            dtmDSNV_Doan.addRow(new Object[]{d.getMaNhanVien(),d.getHoTen()});
        }
        txtSLNV_Doan.setText(String.valueOf(list.size()));
    }
    public void loadTable_DSKH(int iddoan){
        ArrayList<KhachHangDTO> list = db.listKH_Doan(iddoan);
        dtmDSKH_Doan = (DefaultTableModel) tblDSKH_Doan.getModel();
        dtmDSKH_Doan.setRowCount(0);      
        for(KhachHangDTO d : list){
            dtmDSKH_Doan.addRow(new Object[]{d.getMaKH(),d.getHoTen()});        
        }
        txtSLKH_Doan.setText(String.valueOf(list.size()));
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollBar1 = new javax.swing.JScrollBar();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tabPanel = new javax.swing.JTabbedPane();
        tabKH = new javax.swing.JPanel();
        txtKH = new javax.swing.JTextField();
        lbSearchKH = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblKhachHang = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        txtKH_SoTourDaDi = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblDSTourKH = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        tabTour = new javax.swing.JPanel();
        txtTour = new javax.swing.JTextField();
        jScrollPane3 = new javax.swing.JScrollPane();
        tblTour = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        tblDSGoiGia = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtTour_SoTourDaDi = new javax.swing.JTextField();
        lbSearchTour = new javax.swing.JLabel();
        tabDoan = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tblDoan = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tblDSKH_Doan = new javax.swing.JTable();
        jScrollPane8 = new javax.swing.JScrollPane();
        tblDSNV_Doan = new javax.swing.JTable();
        txtDoan = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        lbSearchDoan = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtSLKH_Doan = new javax.swing.JTextField();
        txtSLNV_Doan = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("TÌM KIẾM THÔNG TIN");

        txtKH.setToolTipText("");

        tblKhachHang.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tblKhachHang.getTableHeader().setReorderingAllowed(false);
        tblKhachHang.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblKhachHangMousePressed(evt);
            }
        });
        jScrollPane1.setViewportView(tblKhachHang);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Số Tour đã đi");

        txtKH_SoTourDaDi.setEditable(false);

        tblDSTourKH.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã đoàn", "Tên tour", "Ngày KH", "Ngày KT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSTourKH.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tblDSTourKH);
        if (tblDSTourKH.getColumnModel().getColumnCount() > 0) {
            tblDSTourKH.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblDSTourKH.getColumnModel().getColumn(1).setPreferredWidth(30);
            tblDSTourKH.getColumnModel().getColumn(2).setHeaderValue("Giá Tour cơ bản");
            tblDSTourKH.getColumnModel().getColumn(3).setHeaderValue("Tổng số dịch vụ");
        }

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Danh sách Tour đã đi");

        javax.swing.GroupLayout tabKHLayout = new javax.swing.GroupLayout(tabKH);
        tabKH.setLayout(tabKHLayout);
        tabKHLayout.setHorizontalGroup(
            tabKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabKHLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabKHLayout.createSequentialGroup()
                        .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSearchKH, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(tabKHLayout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(tabKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 508, Short.MAX_VALUE)
                            .addGroup(tabKHLayout.createSequentialGroup()
                                .addGroup(tabKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addGroup(tabKHLayout.createSequentialGroup()
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtKH_SoTourDaDi, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addContainerGap())))))
        );
        tabKHLayout.setVerticalGroup(
            tabKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabKHLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(tabKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbSearchKH, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtKH, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 452, Short.MAX_VALUE)
                    .addGroup(tabKHLayout.createSequentialGroup()
                        .addGroup(tabKHLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtKH_SoTourDaDi, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 393, Short.MAX_VALUE)))
                .addContainerGap())
        );

        tabPanel.addTab("Tìm kiếm thông tin Khách hàng", tabKH);

        txtTour.setToolTipText("");

        tblTour.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên Tour", "Loại hình du lịch"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblTour.getTableHeader().setReorderingAllowed(false);
        tblTour.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblTourMousePressed(evt);
            }
        });
        jScrollPane3.setViewportView(tblTour);

        tblDSGoiGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "STT", "Mã gói", "Tổng tiền gói"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSGoiGia.getTableHeader().setReorderingAllowed(false);
        jScrollPane4.setViewportView(tblDSGoiGia);
        if (tblDSGoiGia.getColumnModel().getColumnCount() > 0) {
            tblDSGoiGia.getColumnModel().getColumn(0).setPreferredWidth(20);
            tblDSGoiGia.getColumnModel().getColumn(1).setPreferredWidth(30);
        }

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Danh sách các gói giá Tour");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Số Tour các đoàn đã đi được");

        txtTour_SoTourDaDi.setEditable(false);

        javax.swing.GroupLayout tabTourLayout = new javax.swing.GroupLayout(tabTour);
        tabTour.setLayout(tabTourLayout);
        tabTourLayout.setHorizontalGroup(
            tabTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTourLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabTourLayout.createSequentialGroup()
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(tabTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(tabTourLayout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtTour_SoTourDaDi, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE)))
                    .addGroup(tabTourLayout.createSequentialGroup()
                        .addComponent(txtTour, javax.swing.GroupLayout.PREFERRED_SIZE, 205, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lbSearchTour, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        tabTourLayout.setVerticalGroup(
            tabTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabTourLayout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addGroup(tabTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtTour)
                    .addComponent(lbSearchTour, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(tabTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(tabTourLayout.createSequentialGroup()
                        .addGroup(tabTourLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(txtTour_SoTourDaDi, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 402, Short.MAX_VALUE))
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 451, Short.MAX_VALUE))
                .addContainerGap())
        );

        tabPanel.addTab("Tìm kiếm thông tin Tour", tabTour);

        tblDoan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Tên Tour", "Tên Đoàn", "Ngày BD", "Ngày KT"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                tblDoanMousePressed(evt);
            }
        });
        jScrollPane5.setViewportView(tblDoan);

        tblDSKH_Doan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã KH", "Họ tên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSKH_Doan.getTableHeader().setReorderingAllowed(false);
        jScrollPane6.setViewportView(tblDSKH_Doan);
        if (tblDSKH_Doan.getColumnModel().getColumnCount() > 0) {
            tblDSKH_Doan.getColumnModel().getColumn(0).setMinWidth(60);
            tblDSKH_Doan.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        tblDSNV_Doan.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mã NV", "Họ tên"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblDSNV_Doan.getTableHeader().setReorderingAllowed(false);
        jScrollPane8.setViewportView(tblDSNV_Doan);
        if (tblDSNV_Doan.getColumnModel().getColumnCount() > 0) {
            tblDSNV_Doan.getColumnModel().getColumn(0).setMinWidth(60);
            tblDSNV_Doan.getColumnModel().getColumn(0).setMaxWidth(60);
        }

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("DANH SÁCH KHÁCH HÀNG");

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("DANH SÁCH NHÂN VIÊN");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Số lượng khách hàng");

        txtSLKH_Doan.setEditable(false);

        txtSLNV_Doan.setEditable(false);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Số lượng nhân viên");

        javax.swing.GroupLayout tabDoanLayout = new javax.swing.GroupLayout(tabDoan);
        tabDoan.setLayout(tabDoanLayout);
        tabDoanLayout.setHorizontalGroup(
            tabDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(tabDoanLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(tabDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabDoanLayout.createSequentialGroup()
                        .addComponent(txtDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbSearchDoan, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(26, 26, 26)
                .addGroup(tabDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(tabDoanLayout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSLKH_Doan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(tabDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addGroup(tabDoanLayout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtSLNV_Doan, javax.swing.GroupLayout.PREFERRED_SIZE, 49, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 292, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        tabDoanLayout.setVerticalGroup(
            tabDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, tabDoanLayout.createSequentialGroup()
                .addGroup(tabDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(tabDoanLayout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(tabDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbSearchDoan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(tabDoanLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(txtDoan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 562, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(tabDoanLayout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(tabDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(txtSLKH_Doan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel9)
                            .addComponent(txtSLNV_Doan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(tabDoanLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 520, Short.MAX_VALUE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.Alignment.TRAILING))))
                .addContainerGap())
        );

        tabPanel.addTab("Tìm kiếm thông tin về Đoàn", tabDoan);

        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(413, 413, 413)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(tabPanel)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addGap(22, 22, 22))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 544, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new Home().setVisible(true);
        dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void tblKhachHangMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblKhachHangMousePressed
       int i = tblKhachHang.getSelectedRow();
       int idkh = Integer.parseInt(String.valueOf(tblKhachHang.getValueAt(i, 0)));
        loadTable_DSTourKH(idkh);
    }//GEN-LAST:event_tblKhachHangMousePressed

    private void tblTourMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblTourMousePressed
        int i = tblTour.getSelectedRow();
       int idtour = Integer.parseInt(String.valueOf(tblTour.getValueAt(i, 0)));
        loadTable_GoiTour(idtour);
    }//GEN-LAST:event_tblTourMousePressed

    private void tblDoanMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblDoanMousePressed
       int i = tblDoan.getSelectedRow();
       int iddoan = Integer.parseInt(String.valueOf(tblDoan.getValueAt(i, 0)));
       loadTable_DSNV(iddoan);
       loadTable_DSKH(iddoan);
    }//GEN-LAST:event_tblDoanMousePressed

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollBar jScrollBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JLabel lbSearchDoan;
    private javax.swing.JLabel lbSearchKH;
    private javax.swing.JLabel lbSearchTour;
    private javax.swing.JPanel tabDoan;
    private javax.swing.JPanel tabKH;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JPanel tabTour;
    private javax.swing.JTable tblDSGoiGia;
    private javax.swing.JTable tblDSKH_Doan;
    private javax.swing.JTable tblDSNV_Doan;
    private javax.swing.JTable tblDSTourKH;
    private javax.swing.JTable tblDoan;
    private javax.swing.JTable tblKhachHang;
    private javax.swing.JTable tblTour;
    private javax.swing.JTextField txtDoan;
    private javax.swing.JTextField txtKH;
    private javax.swing.JTextField txtKH_SoTourDaDi;
    private javax.swing.JTextField txtSLKH_Doan;
    private javax.swing.JTextField txtSLNV_Doan;
    private javax.swing.JTextField txtTour;
    private javax.swing.JTextField txtTour_SoTourDaDi;
    // End of variables declaration//GEN-END:variables

}
