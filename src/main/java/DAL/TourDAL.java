/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.LoaiHinhDuLichBLL;
import DTO.TourDTO;
import com.mycompany.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class TourDAL {

    Statement ps = null;
    ResultSet rs = null;
    Connection conn = DBConnectionUtil.getConnection();
    
    
    //public ArrayList<LoaiHinhDu>

    public ArrayList<TourDTO> getList() {
        ArrayList<TourDTO> list = new ArrayList<>();
        String sql = "select * from Tour";

        //PreparedStatement ps = new DBConnectionUtil.connection.prepareStatement(sql);
        //PreparedStatement ps;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                TourDTO t = new TourDTO();
                t.setMaTour(rs.getInt("MaTour"));
                t.setMaLoaiHinhDuLich(rs.getInt("MaLoaiDuLich"));
                t.setTenTour(rs.getString("TenTour"));
                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public TourDTO getTour(int id) {
        TourDTO t = new TourDTO();
        String sql = "select * from Tour where MaTour = ?";

        //PreparedStatement ps = new DBConnectionUtil.connection.prepareStatement(sql);
        //PreparedStatement ps;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                
                t.setMaTour(rs.getInt("MaTour"));
                t.setMaLoaiHinhDuLich(rs.getInt("MaLoaiDuLich"));
                t.setTenTour(rs.getString("TenTour"));
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return t;
    }
    public boolean themTour(TourDTO t) {
        String sql = "INSERT INTO TOUR(MaLoaiDuLich,TenTour) VALUES(?,?)";
        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            //sm.setString(1, t.getMaTour());
            sm.setInt(1, t.getMaLoaiHinhDuLich());
            sm.setString(2, t.getTenTour());

            return sm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean suaTour(int MaTour ,String TenTour  ,int MaLoaiDL) {
        String sql = "UPDATE tour SET TenTour='"+TenTour+"' , MaLoaiDuLich='"+MaLoaiDL+"' WHERE MaTour='"+MaTour+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public void xoaTour(int MaTour) {
        String sql = "DELETE FROM Tour WHERE MaTour='"+MaTour+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        xoaTourkhoiGoiGia(MaTour);
        xoaTourkhoiDSDD(MaTour);
    }
    public void xoaTourkhoiGoiGia(int MaTour) {
        String sql = "DELETE FROM giatour WHERE MaTour='"+MaTour+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public void xoaTourkhoiDSDD(int MaTour) {
        String sql = "DELETE from dsdiadiem_tour WHERE MaTour='"+MaTour+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
           
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    public boolean checkExist(int idtour) {
        String sql = "Select * from doan where MaTour = ?";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idtour);
            rs = ps.executeQuery();
            while(rs.next()){
            return true; 
        }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
