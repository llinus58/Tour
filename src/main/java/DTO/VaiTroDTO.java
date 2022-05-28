/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import java.util.Objects;

/**
 *
 * @author Trieu
 */
public class VaiTroDTO {
      private int maVaiTro;
    private String tenVaiTro;
    private int soNhanVienDamNhan;

    public VaiTroDTO() {
    }

    public VaiTroDTO(int maVaiTro, String tenVaiTro, int soNhanVienDamNhan) {
        this.maVaiTro = maVaiTro;
        this.tenVaiTro = tenVaiTro;
        this.soNhanVienDamNhan = soNhanVienDamNhan;
    }
    
    public int getMaVaiTro() {
        return maVaiTro;
    }

    public String getTenVaiTro() {
        return tenVaiTro;
    }

    public int getSoNhanVienDamNhan() {
        return soNhanVienDamNhan;
    }

    public void setMaVaiTro(int maVaiTro) {
        this.maVaiTro = maVaiTro;
    }

    public void setTenVaiTro(String tenVaiTro) {
        this.tenVaiTro = tenVaiTro;
    }

    public void setSoNhanVienDamNhan(int soNhanVienDamNhan) {
        this.soNhanVienDamNhan = soNhanVienDamNhan;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 71 * hash + this.maVaiTro;
        hash = 71 * hash + Objects.hashCode(this.tenVaiTro);
        hash = 71 * hash + this.soNhanVienDamNhan;
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
        final VaiTroDTO other = (VaiTroDTO) obj;
        return true;
    }

    @Override
    public String toString() {
        return "VaiTroDTO{" + "maVaiTro=" + maVaiTro + ", tenVaiTro=" + tenVaiTro + ", soNhanVienDamNhan=" + soNhanVienDamNhan + '}';
    }

   
    
}
