/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BLL.LoaiHinhDuLichBLL;
import DTO.LoaiHinhDuLichDTO;
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
public class LoaiHinhDuLichDAL {
    Connection conn = DBConnectionUtil.getConnection();
    public ArrayList<LoaiHinhDuLichDTO> getList() {
        ArrayList<LoaiHinhDuLichDTO> list = new ArrayList<>();
        String sql = "SELECT * FROM loaidulich ";

        //PreparedStatement ps = new DBConnectionUtil.connection.prepareStatement(sql);
        //PreparedStatement ps;
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                LoaiHinhDuLichDTO t = new LoaiHinhDuLichDTO();
                t.setMaLoaiDuLich(rs.getInt("MaLoaiDuLich"));
                t.setTenLoaiDuLich(rs.getString("TenLoaiDuLich"));
                //t.setSoLuong(rs.getInt("SoLuong"));
                list.add(t);
            }
        } catch (SQLException ex) {
            Logger.getLogger(LoaiHinhDuLichDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public int SoLuongTour(int ma){
        String sql = "SELECT COUNT(tour.MaLoaiDuLich) AS soluong from tour WHERE tour.MaLoaiDuLich = '"+ma+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt("soluong");
            }
        }catch (SQLException ex) {
            Logger.getLogger(LoaiHinhDuLichDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public boolean themLoaiHinhDuLich(LoaiHinhDuLichDTO t) {
        String sql = "INSERT INTO loaidulich(TenLoaiDuLich) VALUES(?)";
        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            //sm.setString(1, t.getMaTour());
            sm.setString(1, t.getTenLoaiDuLich());

            return sm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean suaLoaiHinhDuLich(int Ma ,String Ten ) {
        String sql = "UPDATE loaidulich SET TenLoaiDuLich='"+Ten+"'WHERE MaLoaiDuLich='"+Ma+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoaLoaiHinhDuLich(int Ma) {
        String sql = "DELETE FROM loaidulich WHERE MaLoaiDuLich='"+Ma+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public String GoiTenLoaiHinhDuLich(int maloai)
    {
        String sql ="Select TenLoaiDuLich from loaidulich where MaLoaiDuLich = '"+maloai+"'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                return rs.getString("TenLoaiDuLich");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }
    
    public int GoiMaLoaiHinhDuLich(String tenloai)
    {
        String sql ="Select MaLoaiDuLich from loaidulich where TenLoaiDuLich = '"+tenloai+"'";
        
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while(rs.next())
            {
                return rs.getInt("MaLoaiDuLich");
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
