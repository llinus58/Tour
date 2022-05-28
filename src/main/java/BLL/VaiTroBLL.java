/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.VaiTroDAL;
import DTO.VaiTroDTO;
import java.util.List;

/**
 *
 * @author Trieu
 */
public class VaiTroBLL {
      private VaiTroDAL vaiTroDAO;

    public VaiTroBLL() {
        this.vaiTroDAO = new VaiTroDAL();
    }
    
    public VaiTroDTO findByTenVaiTro(String tenVaiTro){
        return vaiTroDAO.findByTenVaiTro(tenVaiTro);
    }
    public List<VaiTroDTO> findAll() {
        return vaiTroDAO.findAll();
    }
    
   

  
    public VaiTroDTO findById(int id) {
        return vaiTroDAO.findById(id);
    }
    public int SoLuongNV(int idvaitro){
        return vaiTroDAO.Soluongnvdamnhan(idvaitro);
    }

    public Long save(VaiTroDTO vaiTro) {
        return vaiTroDAO.save(vaiTro);
    }


    public void update(VaiTroDTO vaiTro) {
        vaiTroDAO.update(vaiTro);
    }


    public void delete(int id) {
        vaiTroDAO.delete(id);
    }
}
