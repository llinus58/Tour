/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.TourDAL;
import DTO.TourDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class TourBLL {
    TourDAL dal;

    public TourBLL() {
        dal = new TourDAL();
    }
    
    public ArrayList getAll()
    {
        return dal.getList();
    }
    public TourDTO getTour(int id)
    {
        return dal.getTour(id);
    }
    public boolean themTour(TourDTO t)
    {
        return dal.themTour(t);
    }
    
    public boolean suaTour(int MaTour , String TenTour , int MaLoaiDL)
    {
        return dal.suaTour(MaTour, TenTour, MaLoaiDL);
    }
    
    public void xoaTour(int MaTour)
    {
        dal.xoaTour(MaTour);
    }

    public boolean cotrongDoan(int idtour) {
        return dal.checkExist(idtour);
    }
    
}
