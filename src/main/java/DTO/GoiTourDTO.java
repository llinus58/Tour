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
public class GoiTourDTO {
    int MaGiaTour, MaTour;
    double GiaCoBan;
    public GoiTourDTO(){
        
    }
    public GoiTourDTO(int MaGiaTour, int MaTour, double GiaCoBan) {
        this.MaGiaTour = MaGiaTour;
        this.MaTour = MaTour;
        this.GiaCoBan = GiaCoBan;
       
    }

    public int getMaGiaTour() {
        return MaGiaTour;
    }

    public void setMaGiaTour(int MaGiaTour) {
        this.MaGiaTour = MaGiaTour;
    }

    public int getMaTour() {
        return MaTour;
    }

    public void setMaTour(int MaTour) {
        this.MaTour = MaTour;
    }

    public double getGiaCoBan() {
        return GiaCoBan;
    }

    public void setGiaCoBan(double GiaCoBan) {
        this.GiaCoBan = GiaCoBan;
    }

    
    
    

    
}
