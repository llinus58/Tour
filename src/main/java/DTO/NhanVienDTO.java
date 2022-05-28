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
public class NhanVienDTO {
     private int maNhanVien;
    private int maVaiTro;
    private String hoTen;
    private boolean gioiTinh;
    private LocalDate ngaySinh;
    private String diaChi;
    private String SDT;
    private boolean trangThai;

    public NhanVienDTO() {
    }

    public NhanVienDTO(int maNhanVien, int maVaiTro, String hoTen, boolean gioiTinh, LocalDate ngaySinh, String diaChi, String SDT, boolean trangThai) {
        this.maNhanVien = maNhanVien;
        this.maVaiTro = maVaiTro;
        this.hoTen = hoTen;
        this.gioiTinh = gioiTinh;
        this.ngaySinh = ngaySinh;
        this.diaChi = diaChi;
        this.SDT = SDT;
        this.trangThai = trangThai;
    }

    public int getMaNhanVien() {
        return maNhanVien;
    }

    public int getMaVaiTro() {
        return maVaiTro;
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

    public String getSDT() {
        return SDT;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setMaNhanVien(int maNhanVien) {
        this.maNhanVien = maNhanVien;
    }

    public void setMaVaiTro(int maVaiTro) {
        this.maVaiTro = maVaiTro;
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

    public void setSDT(String SDT) {
        this.SDT = SDT;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 71 * hash + this.maNhanVien;
        hash = 71 * hash + this.maVaiTro;
        hash = 71 * hash + Objects.hashCode(this.hoTen);
        hash = 71 * hash + (this.gioiTinh ? 1 : 0);
        hash = 71 * hash + Objects.hashCode(this.ngaySinh);
        hash = 71 * hash + Objects.hashCode(this.diaChi);
        hash = 71 * hash + Objects.hashCode(this.SDT);
        hash = 71 * hash + (this.trangThai ? 1 : 0);
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
        final NhanVienDTO other = (NhanVienDTO) obj;
        return true;
    }

    @Override
    public String toString() {
        return "NhanVienDTO{" + "maNhanVien=" + maNhanVien + ", maVaiTro=" + maVaiTro + ", hoTen=" + hoTen + ", gioiTinh=" + gioiTinh + ", ngaySinh=" + ngaySinh + ", diaChi=" + diaChi + ", SDT=" + SDT + ", trangThai=" + trangThai + '}';
    }
    
    
    
}
