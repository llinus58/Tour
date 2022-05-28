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
public class DichVuDTO {
    int MaDV;
    String TenDV, MoTa ;
    double GiaDV;

    public DichVuDTO() {
    }

    public DichVuDTO(int MaDV, String TenDV, String MoTa, double GiaDV) {
        this.MaDV = MaDV;
        this.TenDV = TenDV;
        this.MoTa = MoTa;
        this.GiaDV = GiaDV;
    }

    public int getMaDV() {
        return MaDV;
    }

    public void setMaDV(int MaDV) {
        this.MaDV = MaDV;
    }

    public String getTenDV() {
        return TenDV;
    }

    public void setTenDV(String TenDV) {
        this.TenDV = TenDV;
    }

    public String getMoTa() {
        return MoTa;
    }

    public void setMoTa(String MoTa) {
        this.MoTa = MoTa;
    }

    public double getGiaDV() {
        return GiaDV;
    }

    public void setGiaDV(double GiaDV) {
        this.GiaDV = GiaDV;
    }
    
    
}
