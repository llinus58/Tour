/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

/**
 *
 * @author Admin
 */
public class TourDTO {
    int MaTour;
    int MaLoaiHinhDuLich;
    String TenTour ;

    public TourDTO() {
    }

    public int getMaTour() {
        return MaTour;
    }

    public void setMaTour(int MaTour) {
        this.MaTour = MaTour;
    }

    public int getMaLoaiHinhDuLich() {
        return MaLoaiHinhDuLich;
    }

    public void setMaLoaiHinhDuLich(int MaLoaiHinhDuLich) {
        this.MaLoaiHinhDuLich = MaLoaiHinhDuLich;
    }

    public String getTenTour() {
        return TenTour;
    }

    public void setTenTour(String TenTour) {
        this.TenTour = TenTour;
    }

    
    
    
    
}
