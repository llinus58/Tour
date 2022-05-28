/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BLL;

import DAL.TinhDAL;
import DTO.TinhDTO;
import java.util.List;

/**
 *
 * @author Bon Nguyen
 */
public class TinhBLL {
    private TinhDAL tinhDAO;

    public TinhBLL() {
        this.tinhDAO = new TinhDAL();
    }
    
    
    public List<TinhDTO> findAll() {
        return tinhDAO.findAll();
    }
    
   

  
    public TinhDTO findById(int id) {
        return tinhDAO.findById(id);
    }


    public Long save(TinhDTO tinh) {
        return tinhDAO.save(tinh);
    }


    public void update(TinhDTO tinh) {
        tinhDAO.update(tinh);
    }


    public void delete(int id) {
        tinhDAO.delete(id);
    }
}
