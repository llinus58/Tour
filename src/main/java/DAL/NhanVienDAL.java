/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.NhanVienDTO;
import com.mycompany.mapper.NhanVienMapper;
import java.util.List;

/**
 *
 * @author Trieu
 */
public class NhanVienDAL extends DAL<NhanVienDTO>{
     public List<NhanVienDTO> findAll(){
       String sql = "SELECT * FROM NHANVIEN";
      return query(sql, new NhanVienMapper());
   }
  
  
    public List<NhanVienDTO> findByStatus(boolean status) {
        String sql = "SELECT * FROM NHANVIEN WHERE TRANGTHAI = ?";
        return query(sql, new NhanVienMapper(), status);
    }
  public NhanVienDTO findById(int id) {
        String sql = "SELECT * FROM NHANVIEN WHERE MANV = ?";
        List<NhanVienDTO> nhanVien = query(sql, new NhanVienMapper(), id);
        
        
        
        if(nhanVien.isEmpty()){
            return null;
        }        
        
           return nhanVien.get(0);
        
    }
  
  public NhanVienDTO findBySdt(String sdt) {
        String sql = "SELECT * FROM NHANVIEN WHERE SDT = ?";
        List<NhanVienDTO> nhanVien = query(sql, new NhanVienMapper(), sdt);
        return nhanVien.isEmpty() ? null : nhanVien.get(0);
    }
  
  public Long save(NhanVienDTO nhanVien) {
        String sql = "INSERT INTO NHANVIEN(MAVAITRO,HOTEN, GIOITINH, NGAYSINH, DIACHI, SDT, TRANGTHAI) VALUES(?, ?, ?, ?, ?, ?, ?)";
        return insert(sql, nhanVien.getMaVaiTro(), nhanVien.getHoTen(), nhanVien.getGioiTinh(), nhanVien.getNgaySinh(), nhanVien.getDiaChi(), 
                nhanVien.getSDT(), nhanVien.getTrangThai());
  
  }
  
  public void update(NhanVienDTO nhanVien){
      String sql = "UPDATE nhanvien SET MaVaiTro = ?, HoTen = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?," 
              + "SDT = ?, TrangThai = ?  WHERE MaNV = ?";
      update(sql,nhanVien.getMaVaiTro(),nhanVien.getHoTen(),nhanVien.getGioiTinh(),
      nhanVien.getNgaySinh(),nhanVien.getDiaChi(),nhanVien.getSDT(),nhanVien.getTrangThai()
              ,nhanVien.getMaNhanVien());
  }
  
  
  public void updateStatus(boolean status, int id) {
        String sql = "UPDATE NHANVIEN SET TRANGTHAI = ? WHERE MANV = ?";
        update(sql, status, id);
    }
  
  public void delete(int id){
      String sql = "DELETE FROM NHANVIEN WHERE MANV = ? ";
      update(sql,id);
      delete_KhoiDoan(id);
  }
  public void delete_KhoiDoan(int id){
      String sql = "DELETE FROM dsnhanvien_doan WHERE MANV = ? ";
      update(sql,id);
  }
}
