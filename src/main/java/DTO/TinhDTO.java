/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DTO;

import java.util.Objects;

/**
 *
 * @author Bon Nguyen
 */
public class TinhDTO {
    private int maTinh;
    private String tenTinh;
    
    public TinhDTO() {
    }

    
    public TinhDTO(int maTinh, String tenTinh) {
        this.maTinh = maTinh;
        this.tenTinh = tenTinh;
    }
    
    
    public int getMaTinh(){
        return maTinh;
    }
    public String getTenTinh(){
        return tenTinh;
    }
    
    
    public void setMaTinh(int maTinh){
        this.maTinh = maTinh;
    }
    public void setTenTinh(String tenTinh){
        this.tenTinh = tenTinh;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 13;
        hash = 89 * hash + this.maTinh;
        hash = 89 * hash + Objects.hashCode(this.tenTinh);
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
        final TinhDTO other = (TinhDTO) obj;
        return true;
    }

    @Override
    public String toString() {
        return "TinhDTO{" + "maTinh=" + maTinh + ", tenTinh=" + tenTinh + '}';
    }
    
}
