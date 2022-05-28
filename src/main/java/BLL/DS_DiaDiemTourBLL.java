/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DS_DiaDiemTourDAL;
import java.util.ArrayList;

/**
 *
 * @author Admin
 */
public class DS_DiaDiemTourBLL {

    DS_DiaDiemTourDAL ds = new DS_DiaDiemTourDAL();

    public ArrayList getDSDiaDiem(int matour) {
        return ds.getDSDiaDiem(matour);
    }

    public boolean themDS_DiaDiemTour(int maTour, int maDiaDiem) {
        return ds.themDS_DiaDiemTour(maTour, maDiaDiem);
    }

    public int timMaDiaDiem(String tenDiaDiem) {
        return ds.timMaDiaDiem(tenDiaDiem);
    }

    public boolean xoaDS_DiaDiemTour(int maTour, int maDiaDiem) {
        return ds.xoaDS_DiaDiemTour(maTour, maDiaDiem);
    }
}
