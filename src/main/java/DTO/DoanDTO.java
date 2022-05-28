/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;


import java.time.LocalDate;

/**
 *
 * @author Admin
 */
public class DoanDTO {
    int id;
    int idTour;
    int idGiaTour;
    String tenDoan;
    LocalDate ngayKH;
    LocalDate ngayKT;
    public DoanDTO(){
        
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdTour() {
        return idTour;
    }

    public void setIdTour(int idTour) {
        this.idTour = idTour;
    }

    public int getIdGiaTour() {
        return idGiaTour;
    }

    public void setIdGiaTour(int idGiaTour) {
        this.idGiaTour = idGiaTour;
    }

    public String getTenDoan() {
        return tenDoan;
    }

    public void setTenDoan(String tenDoan) {
        this.tenDoan = tenDoan;
    }

    public LocalDate getNgayKH() {
        return ngayKH;
    }

    public void setNgayKH(LocalDate ngayKH) {
        this.ngayKH = ngayKH;
    }

    public LocalDate getNgayKT() {
        return ngayKT;
    }

    public void setNgayKT(LocalDate ngayKT) {
        this.ngayKT = ngayKT;
    }

    
}
