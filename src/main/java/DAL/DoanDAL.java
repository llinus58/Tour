/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.DoanDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import com.mycompany.mapper.KhachHangMapper;
import com.mycompany.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Trieu
 */
public class DoanDAL extends DAL<DoanDTO> {
    ResultSet rs;
    Connection conn = DBConnectionUtil.getConnection();
    PreparedStatement ps;
    public ArrayList<DoanDTO> findAll() {
        String sql = "SELECT * FROM DOAN";
        ArrayList<DoanDTO> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                DoanDTO d = new DoanDTO();
                d.setId(rs.getInt(1));
                d.setIdTour(rs.getInt(2));
                d.setIdGiaTour(rs.getInt(3));
                d.setTenDoan(rs.getString(4));
                d.setNgayKH(rs.getDate(5).toLocalDate());
                d.setNgayKT(rs.getDate(6).toLocalDate());
                list.add(d);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public ArrayList<DoanDTO> ThongKeDoan(int idtour , int idnv , String from , String to) {
        String tour = "" , date="" ,nhanvien= "";
        if(idtour == 0) {
            tour = "1";
        }else{
            tour ="doan.MaTour ='"+idtour+"'";
        }
        
        if(from.equals("") && to.equals("")) {
            date = "";
        }else {
            date = " AND doan.NgayKhoiHanh BETWEEN '"+from+"' AND '"+to+"'";
        }
        
        if(idnv == 0) {
            nhanvien = "";
        }else {
            nhanvien=" AND dsnhanvien_doan.MaNV="+idnv+"";
        }
        
        String sql = "SELECT * FROM DOAN,dsnhanvien_doan WHERE "+tour+" "+date+" AND dsnhanvien_doan.MaDoan=doan.MaDoan "+nhanvien+" GROUP BY doan.MaDoan";
        ArrayList<DoanDTO> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                DoanDTO d = new DoanDTO();
                d.setId(rs.getInt(1));
                d.setIdTour(rs.getInt(2));
                d.setIdGiaTour(rs.getInt(3));
                d.setTenDoan(rs.getString(4));
                d.setNgayKH(rs.getDate(5).toLocalDate());
                d.setNgayKT(rs.getDate(6).toLocalDate());
                list.add(d);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    
    public boolean insert(DoanDTO d){
        String sql = "insert into doan(matour,magiatour,tendoan,ngaykhoihanh,ngayketthuc) values(?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getIdTour());
            ps.setInt(2,d.getIdGiaTour());
            ps.setString(3, d.getTenDoan());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
            ps.setString(4, d.getNgayKH().format(formatter));
            ps.setString(5, d.getNgayKT().format(formatter));
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            
        }
        return false;
    }
    public boolean delete(int id){
        String sql = "delete from doan where madoan=?";
        try {
           ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();
            delete_dskhDoan(id);
            delete_dsnvDoan(id);
            return true;
            
        } catch (SQLException ex) {
            
        }
        return false;
    }
    public void delete_dsnvDoan(int id){
        String sql = "delete from dsnhanvien_doan where madoan=?";
        try {
           ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();

            
        } catch (SQLException ex) {
            
        }

    }
    public void delete_dskhDoan(int id){
        String sql = "delete from dskhachhang_doan where madoan=?";
        try {
           ps = conn.prepareStatement(sql);
            ps.setInt(1,id);
            ps.executeUpdate();

            
        } catch (SQLException ex) {
            
        }

    }
    public boolean update(DoanDTO d){
        String sql = "insert into doan(madoan,matour,magiatour,tendoan,ngaykhoihanh,ngayketthuc) values(?,?,?,?,?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, d.getId());
            ps.setInt(2, d.getIdTour());
            ps.setInt(3,d.getIdGiaTour());
            ps.setString(4, d.getTenDoan());
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
            ps.setString(5, d.getNgayKH().format(formatter));
            ps.setString(6, d.getNgayKT().format(formatter));
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            
        }
        return false;
    }
    public DoanDTO findDoanbyID(int id){
        String sql = "SELECT * FROM DOAN WHERE MADOAN=?";
        DoanDTO d = new DoanDTO();
        ArrayList<DoanDTO> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while(rs.next()){
               
                d.setId(rs.getInt(1));
                d.setIdTour(rs.getInt(2));
                d.setIdGiaTour(rs.getInt(3));
                d.setTenDoan(rs.getString(4));
                d.setNgayKH(rs.getDate(5).toLocalDate());
                d.setNgayKT(rs.getDate(6).toLocalDate());
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return d;
    }
 
    public String findNamebyID_Tour(int idtour){
         String sql = "SELECT TENTOUR FROM TOUR WHERE MATOUR = ?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,idtour);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getString(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }
    public Double cal_GiaCoBanTour(int idgiatour,int idtour){
        String sql = "select giacoban from giatour where magiatour=? and matour=?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,idgiatour);
            ps.setInt(2,idtour);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getDouble(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0;
    }
    
    public int cal_SoLuongKH(int madoan){
        String sql = "SELECT COUNT(dskhachhang_doan.MaKH) as soluong from dskhachhang_doan , doan "
                + "WHERE dskhachhang_doan.MaDoan=doan.MaDoan AND doan.MaDoan=?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,madoan);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    public Double cal_GiaDVGoiTour(int idgiatour){
        String sql = "SELECT sum(dichvu.GiaDichVu) as Tong\n" +
"from dichvu_tour,dichvu \n" +
"where dichvu_tour.MaDichVu=dichvu.MaDichVu and dichvu_tour.MaGiaTour=?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,idgiatour);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getDouble(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0.0;
    }
    public Double cal_GoiGiaTour(int idgiatour,int idtour){
        return cal_GiaCoBanTour(idgiatour, idtour) +  cal_GiaDVGoiTour(idgiatour);
    }
    public ArrayList<KhachHangDTO> listKH_Doan(int i){
        String sql = "SELECT dskhachhang_doan.MaKH,khachhang.HoTen,khachhang.SDT\n" +
"from dskhachhang_doan,khachhang\n" +
"where dskhachhang_doan.MaKH = khachhang.MaKH and dskhachhang_doan.MaDoan=?";
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            while(rs.next()){
                KhachHangDTO kh =new KhachHangDTO();
                kh.setMaKH(rs.getInt(1));
                kh.setHoTen(rs.getString(2));
                kh.setSDT(rs.getString(3));
                list.add(kh);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<NhanVienDTO> listNV_Doan(int i){
        String sql = "SELECT dsnhanvien_doan.MaNV,nhanvien.HoTen,nhanvien.MaVaiTro\n" +
"from dsnhanvien_doan,nhanvien\n" +
"where dsnhanvien_doan.MaNV = nhanvien.MaNV and dsnhanvien_doan.MaDoan=?";
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, i);
            rs = ps.executeQuery();
            while(rs.next()){
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNhanVien(rs.getInt(1));
                nv.setHoTen(rs.getString(2));
                nv.setMaVaiTro(rs.getInt(3));
                
                list.add(nv);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<String> fillCBTour(){
        String sql = "SELECT * FROM TOUR";
        ArrayList<String> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getInt(1)+":"+rs.getString(3));
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<Integer> listMaGiaTour(int idtour){
        String sql = "SELECT magiatour FROM giatour where matour = ?";
        ArrayList<Integer> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,idtour);
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(rs.getInt(1));
            }
            
        } catch (SQLException ex) {
            
        }
        return list;
    }
  
    
    public ArrayList<KhachHangDTO> listKH_Doan_Cothethem(int iddoan){
        DoanDTO d = findDoanbyID(iddoan);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        String bd = d.getNgayKH().format(formatter);
        String kt = d.getNgayKT().format(formatter);
        String ar="";
        
        int i = 0;
        for(String s:makhcothethem(bd,kt)){
            if(i!=makhcothethem(bd,kt).size()-1){
                ar = ar + s + ",";
            }else{
                ar = ar + s;
            }
            i++;
        }
        String sql;
        if(ar.equals("")){
            sql = "select * from khachhang";
        }else{
            sql = "select * from khachhang where makh not in("+ar+")";
        }
        
//        System.out.println(sql);
        ArrayList<KhachHangDTO> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
//            ps.setString(1, "2021-11-10");
//            ps.setString(2, "2021-11-11");
//            ps.setString(3, "2021-11-10");
//            ps.setString(4, "2021-11-11");
            rs = ps.executeQuery();
            while(rs.next()){
                KhachHangDTO kh =new KhachHangDTO();
                kh.setMaKH(rs.getInt(1));
                kh.setHoTen(rs.getString(2));
                kh.setGioiTinh(rs.getBoolean(3));
                kh.setCMND(rs.getString(6));
                kh.setSDT(rs.getString(7));
                
                    list.add(kh);
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
    public ArrayList<String> makhcothethem(String bd,String kt)
    {
        String sql = "select dskhachhang_doan.MaKH FROM dskhachhang_doan\n" +
"where dskhachhang_doan.MaDoan in (select doan.madoan from doan where ((doan.ngaykhoihanh between '"+bd+"' and '"+kt+"') or (doan.ngayketthuc between '"+bd+"' and '"+kt+"')))";
        ArrayList<String> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(String.valueOf(rs.getInt(1)));
            }
            
        } catch (SQLException ex) {
            
        }
        return list;
    }
    public ArrayList<String> manvcothethem(String bd,String kt)
    {
        String sql = "select dsnhanvien_doan.MaNV FROM dsnhanvien_doan\n" +
"where dsnhanvien_doan.MaDoan in (select doan.madoan from doan where ((doan.ngaykhoihanh between '"+bd+"' and '"+kt+"') or (doan.ngayketthuc between '"+bd+"' and '"+kt+"')))";
        ArrayList<String> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            
            rs = ps.executeQuery();
            while(rs.next()){
                list.add(String.valueOf(rs.getInt(1)));
            }
            
        } catch (SQLException ex) {
            
        }
        return list;
    }
    public ArrayList<NhanVienDTO> listNV_Doan_Cothethem(int iddoan){
        DoanDTO d = findDoanbyID(iddoan);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-M-dd");
        String bd = d.getNgayKH().format(formatter);
        String kt = d.getNgayKT().format(formatter);
        String ar="";
        
        int i = 0;
        for(String s:manvcothethem(bd,kt)){
            if(i!=manvcothethem(bd,kt).size()-1){
                ar = ar + s + ",";
            }else{
                ar = ar + s;
            }
            i++;
        }
        String sql;
        if(ar.equals("")){
            sql = "select * from nhanvien";
        }else{
            sql = "select * from nhanvien where manv not in("+ar+")";
        }
        
//        System.out.println(sql);
        ArrayList<NhanVienDTO> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
//            ps.setString(1, "2021-11-10");
//            ps.setString(2, "2021-11-11");
//            ps.setString(3, "2021-11-10");
//            ps.setString(4, "2021-11-11");
            rs = ps.executeQuery();
            while(rs.next()){
                NhanVienDTO nv = new NhanVienDTO();
                nv.setMaNhanVien(rs.getInt(1));
                nv.setHoTen(rs.getString(3));
                nv.setGioiTinh(rs.getBoolean(4));
                nv.setSDT(rs.getString(7));
                nv.setMaVaiTro(rs.getInt(2));
                
                    list.add(nv);
                
                
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }
      
      public boolean themKHvaoDoan(int idkh,int iddoan){
         String sql = "insert into dskhachhang_doan(madoan,makh) values(?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, iddoan);
            ps.setInt(2, idkh);
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            
        }
        return false;
      }
      public boolean themNVvaoDoan(int idnv,int iddoan){
         String sql = "insert into dsnhanvien_doan(madoan,manv) values(?,?)";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, iddoan);
            ps.setInt(2,idnv);
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            
        }
        return false;
      }
      public boolean xoaKHkhoiDoan(int idkh,int iddoan){
         String sql = "delete from dskhachhang_doan where madoan=? and makh=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, iddoan);
            ps.setInt(2, idkh);
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            
        }
        return false;
      }

    public boolean xoaNVkhoiDoan(int idnv, int iddoan) {
         String sql = "delete from dsnhanvien_doan where madoan=? and manv=?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, iddoan);
            ps.setInt(2, idnv);
            ps.executeUpdate();
            return true;
            
        } catch (SQLException ex) {
            
        }
        return false;
    }

    public ArrayList<DoanDTO> getDSTour(int idkh) {
       String sql = "SELECT doan.MaDoan,tour.TenTour,doan.NgayKhoiHanh,doan.NgayKetThuc\n" +
"FROM doan,tour \n" +
"where MaDoan in (select MaDoan from dskhachhang_doan WHERE MaKH =?)\n" +
"and tour.MaTour = doan.MaTour";
        ArrayList<DoanDTO> list = new ArrayList<>();
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idkh);
            rs = ps.executeQuery();
            while(rs.next()){
                DoanDTO d = new DoanDTO();
                d.setId(rs.getInt(1));
                d.setTenDoan(rs.getString(2));
                d.setNgayKH(rs.getDate(3).toLocalDate());
                d.setNgayKT(rs.getDate(4).toLocalDate());
                list.add(d);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int soTourDiDuoc(int idtour) {
         String sql = "SELECT count(*) from doan where matour = ?";
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idtour);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            Logger.getLogger(DoanDAL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
    
    
      
}
