/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.DiaDiemDAL;
import DTO.DiaDiemDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Bon Nguyen
 */
public class DiaDiemBLL {
    private DiaDiemDAL diaDiemDAO;
    
    public DiaDiemBLL(){
        this.diaDiemDAO = new DiaDiemDAL();
    }
    
    public List<DiaDiemDTO> findAll(){
        return diaDiemDAO.findAll();
    }
    
    public DiaDiemDTO findById(int id) {
        return diaDiemDAO.findById(id);
    }
    
    public DiaDiemDTO findByTenDiaDiem(String tenDiaDiem){
        return diaDiemDAO.findByTenDiaDiem(tenDiaDiem);
    }
     public Long save(DiaDiemDTO diaDiem) {
        return diaDiemDAO.save(diaDiem);
    }
      public void update(DiaDiemDTO diaDiem) {
        diaDiemDAO.update(diaDiem);
    }
     
      public void delete(int id) {
        diaDiemDAO.delete(id);
    }
      public void delete_dsdd(int id) {
        diaDiemDAO.delete_dsdd(id);
    }
      
      
}
