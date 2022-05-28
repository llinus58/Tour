/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DichVuDTO;
import DTO.GoiTourDTO;
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
public class GoiTourDAL {

    //DBConnectionUtil cn = new DBConnectionUtil();
    Statement ps = null;
    ResultSet rs = null;
    Connection conn = DBConnectionUtil.getConnection();

    public String GoiTenTour(int matour) {
        String sql = "Select TenTour from tour where MaTour = '" + matour + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getString("TenTour");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "ERROR";
    }

    public GoiTourDTO timGoiTour(int idgiatour) {
        String sql = "Select * from giatour where MaGiaTour = '" + idgiatour + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GoiTourDTO dt = new GoiTourDTO();
                dt.setMaGiaTour(rs.getInt(1));
                dt.setMaTour(rs.getInt(2));
                dt.setGiaCoBan(rs.getDouble(3));
                return dt;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public int TongDV(int magiatour) {
        String sql = "Select count(*) as Tong from dichvu_tour where MaGiaTour = '" + magiatour + "'";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public long TongGiaDV(int magiatour) {
        String sql = "Select sum(dichvu.GiaDichVu) as Tong from dichvu_tour,dichvu\n"
                + "where dichvu_tour.MaDichVu = dichvu.MaDichVu and dichvu_tour.MaGiaTour = '" + magiatour + "'";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                return rs.getLong(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;

    }

    public ArrayList<GoiTourDTO> getList() {
        ArrayList<GoiTourDTO> list = new ArrayList<>();
        String sql = "select * from giatour";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GoiTourDTO gt = new GoiTourDTO();
                gt.setMaGiaTour(rs.getInt(1));
                gt.setMaTour(rs.getInt(2));
                gt.setGiaCoBan(rs.getDouble(3));
                list.add(gt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public boolean themDichVu(DichVuDTO dv) {
        String sql = "INSERT INTO DICHVU(MaDichVu,TenDichVu,MoTa,GiaDichVu) VALUES(?,?,?,?)";
        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            sm.setInt(1, dv.getMaDV());
            sm.setString(2, dv.getTenDV());
            sm.setString(3, dv.getMoTa());
            sm.setDouble(4, dv.getGiaDV());

            return sm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean themGoiTour(int matour, double giacoban) {
        String sql = "INSERT INTO GIATOUR(MaTour,GiaCoBan) VALUES(?,?)";
        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            sm.setInt(1, matour);
            sm.setDouble(2, giacoban);

            return sm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public int magiatourVuathem() {
        String sql = "SELECT MaGiaTour FROM giatour ORDER BY MaGiaTour DESC LIMIT 1";
        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            ResultSet rs = sm.executeQuery();
            while (rs.next()) {
                return rs.getInt(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    public void themDSDV_Tour(int magiatour, ArrayList<Integer> dssv) {
        if (dssv.size() != 0) {
            String sql = "INSERT INTO dichvu_tour(MaGiaTour,MaDichVu) VALUES";
            int count = 0;
            for (int i : dssv) {
                if (count == dssv.size() - 1) {
                    sql += "(" + magiatour + "," + i + ")";
                } else {
                    sql += "(" + magiatour + "," + i + "),";
                }
                count++;
            }

            try {
                PreparedStatement sm = conn.prepareStatement(sql);
                System.out.println(sql);
                sm.executeUpdate();

            } catch (Exception e) {
                e.printStackTrace();
            }

        }

    }

    public ArrayList<Integer> layDSDV(int idgiatour) {
        String sql = "SELECT madichvu from dichvu_tour where magiatour='" + idgiatour + "'";
        ArrayList<Integer> dsdv = new ArrayList<>();
        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            ResultSet rs = sm.executeQuery();
            while (rs.next()) {
                dsdv.add(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return dsdv;
    }

    

    public boolean xoaDSDV(int idgiatour) {
        String sql = "delete from dichvu_tour where magiatour='" + idgiatour + "'";
        if (TongDV(idgiatour) > 0) {
            try {
                PreparedStatement sm = conn.prepareStatement(sql);
                return sm.executeUpdate() > 0;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return true;
    }

    public boolean thaydoiGiaCoBan(int magiatour, double giacbmoi) {
        String sql = "update giatour set giacoban='" + giacbmoi + "' where magiatour = '" + magiatour + "'";
        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            return sm.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean checkExist(int idgoitour) {
        String sql = "select * from doan where magiatour=?";

        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            sm.setInt(1, idgoitour);
            rs = sm.executeQuery();
            while(rs.next()){
                return true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return false;
    }
    public void delete(int idgoitour) {
        String sql = "delete from giatour where magiatour=?";

        try {
            PreparedStatement sm = conn.prepareStatement(sql);
            sm.setInt(1, idgoitour);
            sm.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ArrayList<GoiTourDTO> getList(int idtour) {
        ArrayList<GoiTourDTO> list = new ArrayList<>();
        String sql = "select * from giatour where matour = ?";

        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, idtour);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                GoiTourDTO gt = new GoiTourDTO();
                gt.setMaGiaTour(rs.getInt(1)); 
                gt.setMaTour(rs.getInt(2));
                list.add(gt);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
}
