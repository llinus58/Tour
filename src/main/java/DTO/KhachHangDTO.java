/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.time.LocalDate;
import java.util.Objects;

/**
 *
 * @author Trieu
 */
public class KhachHangDTO {
      private int maKH;
    private String hoTen;
    private boolean gioiTinh;
    private LocalDate ngaySinh;
    private String diaChi;
    private String CMND;
    private String SDT;

    public KhachHangDTO() {
    }

    public KhachHangDTO(int maKH, String hoTen, boolean gioiTinh, LocalDate ngaySinh, String diaChi, String CMND, String SDT) {
        this.maKH = maKH;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.CMND = CMND;
        this.SDT = SDT;
    }

    
    
    public int getMaKH() {
        return maKH;
    }

    public String getHoTen() {
        return hoTen;
    }

    public boolean getGioiTinh() {
        return gioiTinh;
    }

    public LocalDate getNgaySinh() {
        return ngaySinh;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public String getCMND() {
        return CMND;
    }

    public String getSDT() {
        return SDT;
    }

    public void setMaKH(int maKH) {
        this.maKH = maKH;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public void setGioiTinh(boolean gioiTinh) {
        this.gioiTinh = gioiTinh;
    }

    public void setNgaySinh(LocalDate ngaySinh) {
        this.ngaySinh = ngaySinh;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public void setCMND(String CMND) {
        this.CMND = CMND;
    }

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 83 * hash + this.maKH;
        hash = 83 * hash + Objects.hashCode(this.hoTen);
        hash = 83 * hash + (this.gioiTinh ? 1 : 0);
        hash = 83 * hash + Objects.hashCode(this.ngaySinh);
        hash = 83 * hash + Objects.hashCode(this.diaChi);
        hash = 83 * hash + Objects.hashCode(this.CMND);
        hash = 83 * hash + Objects.hashCode(this.SDT);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final KhachHangDTO other = (KhachHangDTO) obj;
        return true;
    }

    @Override
    public String toString() {
        return "KhachHangDTO{" + "maKH=" + maKH + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", CMND=" + CMND + ", SDT=" + SDT + '}';
    }
    
}
