/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.util;

import DTO.TinhDTO;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Bon Nguyen
 */
public class TinhTableLoaderUtil {
    public DefaultTableModel setTable(List<TinhDTO> listItems, String[] listColumns){
        Vector header = new Vector();
        for(Object colName : listColumns){
             header.add(colName);
        }
        
        DefaultTableModel model = new DefaultTableModel(header,0);
        
        Vector row = null;
        for(TinhDTO tinh : listItems){
            row = new Vector();
            row.add(tinh.getMaTinh());
            row.add(tinh.getTenTinh());
            model.addRow(row);
        }
        
        return model;
        
    }
}
