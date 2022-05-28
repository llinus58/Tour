/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.LoaiHinhDuLichDAL;
import DTO.LoaiHinhDuLichDTO;
import com.mycompany.util.DBConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Admin
 */
public class LoaiHinhDuLichBLL {
    LoaiHinhDuLichDAL dal;
     public LoaiHinhDuLichBLL() {
         dal = new LoaiHinhDuLichDAL();
     }
     
     public ArrayList getAll()
     {
         return dal.getList();
     }
     
     public String goitenLoaiHinhDuLich(int maloai)
     {
         return dal.GoiTenLoaiHinhDuLich(maloai);
     }
     
     public int goimaLoaiHinhDuLich(String tenloai)
     {
         return dal.GoiMaLoaiHinhDuLich(tenloai);
     }
     
     public boolean themLoaiHinhDuLich(LoaiHinhDuLichDTO lhdl)
     {
         return dal.themLoaiHinhDuLich(lhdl);
     }
     
     public boolean suaLoaiHinhDuLich(int maloai ,String tenloai)
     {
         return dal.suaLoaiHinhDuLich(maloai, tenloai);
     }
     
     public boolean xoaLoaiHinhDuLich(int maloai)
     {
         return dal.xoaLoaiHinhDuLich(maloai);
     }
     
     public int goiSoLuongTour(int maloai)
     {
         return dal.SoLuongTour(maloai);
     }
}
