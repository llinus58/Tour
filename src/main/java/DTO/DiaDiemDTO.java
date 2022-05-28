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
public class DiaDiemDTO {
    private int maDiaDiem;
    private int maTinh;
    private String tenDiaDiem;
    private String diaChi;
    private String gioiThieu;
    
    public DiaDiemDTO() {
        
    }
    
    public DiaDiemDTO(int maDiaDiem, int maTinh, String tenDiaDiem, String diaChi, String gioiThieu){
        this.maDiaDiem = maDiaDiem;
        this.maTinh = maTinh;
        this.tenDiaDiem = tenDiaDiem;
        this.diaChi = diaChi;
        this.gioiThieu = gioiThieu;
    }
    
    
    public int getMaDiaDiem(){
        return maDiaDiem;
    }
    public int getMaTinh (){
        return maTinh;
    }
    public String getTenDiaDiem(){
        return tenDiaDiem;
    }
    public String getDiaChi(){
        return diaChi;
    }
    public String getGioiThieu(){
        return gioiThieu;
    }
    
    
    public void setMaDiaDiem(int maDiaDiem){
        this.maDiaDiem = maDiaDiem;
    }
    public void setMaTinh(int maTinh){
        this.maTinh = maTinh;
    }
    public void setTenDiaDiem(String tenDiaDiem){
        this.tenDiaDiem = tenDiaDiem;
    }
    public void setDiaChi(String diaChi){
        this.diaChi = diaChi;
    }
    public void setGioiThieu(String gioiThieu){
        this.gioiThieu = gioiThieu;
    }
    
    
    @Override
    public int hashCode() {
        int hash = 11;
        hash = 89 * hash + this.maDiaDiem;
        hash = 89 * hash + this.maTinh;
        hash = 89 * hash + Objects.hashCode(this.tenDiaDiem);
        hash = 89 * hash + Objects.hashCode(this.diaChi);
        hash = 89 * hash + Objects.hashCode(this.gioiThieu);
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
        final DiaDiemDTO other = (DiaDiemDTO) obj;
        return true;
    }
    
    
    @Override
    public String toString() {
        return "DiaDiemDTO{" + "maDiaDiem=" + maDiaDiem + ", maTinh=" + maTinh + ", tenDiaDiem=" + tenDiaDiem + ", diaChi=" + diaChi + ", gioiThieu=" + gioiThieu + '}';
    }
}