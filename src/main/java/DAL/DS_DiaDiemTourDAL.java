/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import com.mycompany.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class DS_DiaDiemTourDAL {
    Connection conn = DBConnectionUtil.getConnection();
    
    public ArrayList getDSDiaDiem(int maTour) {
        ArrayList<String> list = new ArrayList<>();
        String sql = "SELECT diadiem.TenDiaDiem FROM diadiem,dsdiadiem_tour,tour "
                + "WHERE dsdiadiem_tour.MaTour=tour.MaTour AND dsdiadiem_tour.MaTour="+maTour+" AND diadiem.MaDiaDiem=dsdiadiem_tour.MaDiaDiem";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                list.add(rs.getString("TenDiaDiem"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DS_DiaDiemTourDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;

    }
    
    public boolean themDS_DiaDiemTour(int maTour , int maDiaDiem) {
        String sql = "INSERT INTO dsdiadiem_tour(MaTour,MaDiaDiem) VALUES(?, ?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt( 1, maTour);
            ps.setInt( 2, maDiaDiem);
            return ps.executeUpdate() > 0;
            
        } catch (SQLException ex) {
            Logger.getLogger(DS_DiaDiemTourDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
    public int timMaDiaDiem(String tendiadiem)
    {
        String sql = "SELECT MaDiaDiem FROM diadiem WHERE TenDiaDiem = '"+tendiadiem+"' ";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                return rs.getInt("MaDiaDiem");
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DS_DiaDiemTourDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;

    }
    
    public boolean xoaDS_DiaDiemTour(int maTour , int maDiaDiem) {
        String sql = "DELETE FROM dsdiadiem_tour WHERE MaTour="+maTour+" AND MaDiaDiem="+maDiaDiem+"";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            Logger.getLogger(DS_DiaDiemTourDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
        
    }
    
}
