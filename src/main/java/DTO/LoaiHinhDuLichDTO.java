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
public class LoaiHinhDuLichDTO {
    int MaLoaiDuLich;
    String TenLoaiDuLich;
    int SoLuong ;

    public LoaiHinhDuLichDTO() {
    }

    public int getMaLoaiDuLich() {
        return MaLoaiDuLich;
    }

    public void setMaLoaiDuLich(int MaLoaiDuLich) {
        this.MaLoaiDuLich = MaLoaiDuLich;
    }

    public String getTenLoaiDuLich() {
        return TenLoaiDuLich;
    }

    public void setTenLoaiDuLich(String TenLoaiDuLich) {
        this.TenLoaiDuLich = TenLoaiDuLich;
    }

    public int getSoLuong() {
        return SoLuong;
    }

    public void setSoLuong(int SoLuong) {
        this.SoLuong = SoLuong;
    }

    
    
}
