/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.util;

import BLL.VaiTroBLL;
import DTO.VaiTroDTO;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Trieu
 */
public class VaiTroTableLoaderUtil {
    VaiTroBLL vtb = new VaiTroBLL();
    public DefaultTableModel setTable(List<VaiTroDTO> listItems, String[] listColumns){
        Vector header = new Vector();
        for(Object colName : listColumns){
             header.add(colName);
        }
        
        DefaultTableModel model = new DefaultTableModel(header,0);
        
        Vector row = null;
        for(VaiTroDTO vaiTro : listItems){
            row = new Vector();
            row.add(vaiTro.getMaVaiTro());
            row.add(vaiTro.getTenVaiTro());
            row.add(vtb.SoLuongNV(vaiTro.getMaVaiTro()));
            model.addRow(row);
        }
        
        return model;
        
    }
}
