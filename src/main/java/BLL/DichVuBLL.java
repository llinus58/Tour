/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DichVuDAL;
import DTO.DichVuDTO;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DichVuBLL {
    DichVuDAL dal;

    public DichVuBLL() {
        dal = new DichVuDAL();
    }
    
    public ArrayList getAll(String where, String order) throws SQLException {
        //còn xử lý lọc dữ liệu
        return dal.getList(where, order);
    }
    
    public boolean suaDV(String MaDV,String TenDV, double Gia ,String MoTa)
    {
        return dal.suaDichVu(MaDV, TenDV, Gia, MoTa);
    }
    
    public boolean xoaDV(String MaDV)
    {
        return dal.xoaDichVu(MaDV);
    }

    public DichVuDTO timMaDV(String madv) throws SQLException {
        String where = " MaDichVu = " + madv;
        ArrayList<DichVuDTO> list = dal.getList(where, " MaDichVu ASC");
        if (list.size() > 0) {
            return list.get(0);
        } else {
            return null;
        }
    }

    public ArrayList timTenDV(String title) throws SQLException {
        String where = " TenDichVu LIKE '%" + title + "%'";
        String order = " isbn ASC";
        return dal.getList(where, order);
    }

    public ArrayList getListByCategory(String category) throws SQLException {
        String where = " category LIKE '%" + category + "%'";
        String order = " isbn ASC";
        return dal.getList(where, order);
    }
    public boolean themDichVu(DichVuDTO dv) throws SQLException
    {
        return dal.themDichVu(dv);
        
    }

    public void delete(int iddv) {
       dal.deleteDV(iddv);
    }
}
