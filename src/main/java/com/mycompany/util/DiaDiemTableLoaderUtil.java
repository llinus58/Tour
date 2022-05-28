/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import BLL.TinhBLL;
import DTO.DiaDiemDTO;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bon Nguyen
 */
public class DiaDiemTableLoaderUtil {
    private TinhBLL tinhBLL = new TinhBLL();
   
    public DefaultTableModel setTable(List<DiaDiemDTO> listItems, String[] listColumns) {
        Vector header = new Vector();
        for(Object colName : listColumns){
            header.add(colName);
        }
        
        DefaultTableModel model = new DefaultTableModel(header, 0);
        
        Vector row = null;
        for(DiaDiemDTO diaDiem : listItems) {
            row = new Vector();
            row.add(diaDiem.getMaDiaDiem());
            
            row.add(diaDiem.getTenDiaDiem());
            row.add(tinhBLL.findById(diaDiem.getMaTinh()).getTenTinh());
            row.add(diaDiem.getDiaChi());
            row.add(diaDiem.getGioiThieu());
          
            model.addRow(row);
        }
        
        return model;
    }
}
