/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.NhanVienDAL;
import DTO.NhanVienDTO;
import java.util.List;

/**
 *
 * @author Trieu
 */
public class NhanVienBLL {
    private NhanVienDAL nhanVienDAO;
    
    public NhanVienBLL(){
        this.nhanVienDAO = new NhanVienDAL();
    }
    
    public List<NhanVienDTO> findAll(){
        return nhanVienDAO.findAll();
    }
    
    
    public List<NhanVienDTO> findByStatus(boolean status){
        return nhanVienDAO.findByStatus(status);
    }
    
    public NhanVienDTO findById(int id) {
        return nhanVienDAO.findById(id);
    }
    
    public NhanVienDTO findBySDT(String sdt){
        return nhanVienDAO.findBySdt(sdt);
    }
     public Long save(NhanVienDTO nhanVien) {
        return nhanVienDAO.save(nhanVien);
    }
      public void update(NhanVienDTO nhanVien) {
        nhanVienDAO.update(nhanVien);
    }
     
      public void delete(int id) {
        nhanVienDAO.delete(id);
    }

}
