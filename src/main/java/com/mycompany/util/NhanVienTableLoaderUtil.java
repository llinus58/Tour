/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import BLL.VaiTroBLL;
import DTO.NhanVienDTO;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trieu
 */
public class NhanVienTableLoaderUtil {
      private VaiTroBLL vaiTroBLL = new VaiTroBLL();
   
    public DefaultTableModel setTable(List<NhanVienDTO> listItems, String[] listColumns) {
        Vector header = new Vector();
        for(Object colName : listColumns){
            header.add(colName);
        }
        
        DefaultTableModel model = new DefaultTableModel(header, 0);
        
        Vector row = null;
        for(NhanVienDTO nhanVien : listItems) {
            row = new Vector();
            row.add(nhanVien.getMaNhanVien());
            row.add(vaiTroBLL.findById(nhanVien.getMaVaiTro()).getTenVaiTro());
            row.add(nhanVien.getHoTen());
            row.add(nhanVien.getGioiTinh() ? "Nam" : "Nữ");
            row.add(nhanVien.getNgaySinh());
            row.add(nhanVien.getDiaChi());
            row.add(nhanVien.getSDT());
             row.add(nhanVien.getTrangThai() ? "Đang rảnh" : "Đang đi tour");
          
            model.addRow(row);
        }
        
        return model;
    }
}
