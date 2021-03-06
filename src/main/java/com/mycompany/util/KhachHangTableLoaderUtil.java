/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import DTO.KhachHangDTO;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trieu
 */
public class KhachHangTableLoaderUtil {
    public DefaultTableModel setTable(List<KhachHangDTO> listItems, String[] listColumns) {
        Vector header = new Vector();
        for(Object colName : listColumns){
            header.add(colName);
        }
        
        DefaultTableModel model = new DefaultTableModel(header, 0);
        
        Vector row = null;
        for(KhachHangDTO khachHang : listItems) {
            row = new Vector();
            row.add(khachHang.getMaKH());
            row.add(khachHang.getHoTen());
            row.add(khachHang.getGioiTinh() ? "Nam" : "Nữ");
            row.add(khachHang.getNgaySinh());
            row.add(khachHang.getDiaChi());
            row.add(khachHang.getCMND());
            row.add(khachHang.getSDT());
               
            
            model.addRow(row);
        }
        
        return model;
    }
}
