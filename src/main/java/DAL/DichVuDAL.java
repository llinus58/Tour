/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DichVuDTO;
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
public class DichVuDAL {

    //DBConnectionUtil cn = new DBConnectionUtil();
    static Statement s;
    static ResultSet rs ;
    static PreparedStatement p;
    Connection conn = DBConnectionUtil.getConnection();

    public ArrayList<DichVuDTO> getList(String where, String order) throws SQLException {
        ArrayList<DichVuDTO> list = new ArrayList<>();
        DichVuDTO dv;

        ResultSet rs = readTable("dichvu", "1", "MaDichVu ASC");

        //PreparedStatement ps = new DBConnectionUtil.connection.prepareStatement(sql);
        //PreparedStatement ps;
        if (rs != null) {
            //ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                dv = new DichVuDTO();
                dv.setMaDV(rs.getInt("MaDichVu"));
                dv.setTenDV(rs.getString("TenDichVu"));
                dv.setMoTa(rs.getString("MoTa"));
                dv.setGiaDV(rs.getDouble("GiaDichVu"));
                list.add(dv);
            }
        }
        return list;
    }

    public boolean themDichVu(DichVuDTO dv) {
        String sql = "INSERT INTO DICHVU(TenDichVu,MoTa,GiaDichVu) VALUES(?,?,?)";
        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            //sm.setString(1, dv.getMaDV());
            sm.setString(1, dv.getTenDV());
            sm.setString(2, dv.getMoTa());
            sm.setDouble(3, dv.getGiaDV());

            return sm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static ResultSet readTable(String tbname, String where, String order) {
        String sql = "SELECT * FROM " + tbname + " WHERE " + where + " ORDER BY " + order;
        return doQuery(sql);
    }
    
    public boolean suaDichVu(String MaDV ,String TenDV , double Gia , String MoTa) {
        String sql = "UPDATE dichvu SET TenDichVu='"+TenDV+"' , GiaDichVu="+Gia+" , MoTa='"+MoTa+"' WHERE MaDichVu='"+MaDV+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
    public boolean xoaDichVu(String MaDV) {
        String sql = "DELETE FROM dichvu WHERE MaDichVu='"+MaDV+"'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    //run custom sql
    public static ResultSet doQuery(String sql) {
        ResultSet rs = null;
        try {
            s = DBConnectionUtil.getConnection().createStatement();
            //p =  s.prepareStatement(sql);
            rs = s.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAL.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
        return rs;
    }
    
    public static void doUpdateQuery() throws SQLException {
        
        try {
            p.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(DichVuDAL.class.getName())
                    .log(Level.SEVERE, null, ex);
        }
    }

    public void deleteDV(int iddv) {
        String sql = "DELETE FROM dichvu_tour WHERE MaDichVu='"+iddv+"'";
        try {
            if(xoaDichVu(String.valueOf(iddv))){
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.executeUpdate();
            }
      
        } catch (Exception e) {
            e.printStackTrace();
        }
       
    }

}
