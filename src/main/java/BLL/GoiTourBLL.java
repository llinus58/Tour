/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.GoiTourDAL;
import DTO.GoiTourDTO;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class GoiTourBLL {
    private GoiTourDAL d;
    public GoiTourBLL(){
        this.d = new GoiTourDAL();
    }
     public String GoiTenTour(int matour){
         return d.GoiTenTour(matour);
     }
     public int TongDV(int magiatour){
         return d.TongDV(magiatour);
     }
     public long TongGiaDV(int magiatour){
         return  d.TongGiaDV(magiatour);
     }
     public ArrayList<GoiTourDTO> getList(){
         return d.getList();
     }
     public boolean themGoiTour(int matour,double giacoban){
         return d.themGoiTour(matour, giacoban);
     }
     public void themDSDV_Tour(int magiatour,ArrayList<Integer> dssv){
         d.themDSDV_Tour(magiatour, dssv);
     }
     public int magiatourVuathem(){
         return d.magiatourVuathem();
     }
     public GoiTourDTO timGoiTour(int idgiatour){
         return  d.timGoiTour(idgiatour);
     }
      public ArrayList<Integer> layDSDV(int idgiatour){
          return d.layDSDV(idgiatour);
      }
      public boolean xoaDSDV(int idgiatour){
          return d.xoaDSDV(idgiatour);
      }
      public boolean thaydoiGiaCoBan(int idgiatour,double giamoi){
          return d.thaydoiGiaCoBan(idgiatour, giamoi);
      }

    public boolean cotrongDoan(int idgoitour) {
        return d.checkExist(idgoitour);
    }

    public void delete(int idgoitour) {
       d.delete(idgoitour);
    }

    public ArrayList<GoiTourDTO> getList(int idtour) {
        return d.getList(idtour);
    }

}
