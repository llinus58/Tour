/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.KhachHangDAL;
import DTO.KhachHangDTO;
import java.util.List;

/**
 *
 * @author Trieu
 */
public class KhachHangBLL {
    private KhachHangDAL khachHangDAO;

    public KhachHangBLL() {
        this.khachHangDAO = new KhachHangDAL();
    }

    public List<KhachHangDTO> findAll() {
        return khachHangDAO.findAll();
    }

    public KhachHangDTO findById(int id) {
        return khachHangDAO.findById(id);
    }

    public KhachHangDTO findBySDT(String sdt) {
        return khachHangDAO.findBySdt(sdt);
    }

    public Long save(KhachHangDTO KhachHang) {
        return khachHangDAO.save(KhachHang);
    }

    public void update(KhachHangDTO KhachHang) {
        khachHangDAO.update(KhachHang);
    }

    public void delete(int id) {
        khachHangDAO.delete(id);
    }

}
