/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.DoanDAL;
import DAL.NhanVienDAL;
import DTO.DoanDTO;
import DTO.KhachHangDTO;
import DTO.NhanVienDTO;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Trieu
 */
public class DoanBLL {
    private DoanDAL d;
    public DoanBLL(){
        this.d = new DoanDAL();
    }
    
    public ArrayList<DoanDTO> findAll(){
        return d.findAll();
    }
    public String findNamebyID_Tour(int id){
        return d.findNamebyID_Tour(id);
    }
    public Double cal_GoiGiaTour(int idgiatour,int idtour){
        return d.cal_GoiGiaTour(idgiatour, idtour);
    }
    public DoanDTO findDoanbyID(int id){
        return d.findDoanbyID(id);
    }
    public ArrayList<KhachHangDTO> listKH_Doan(int i){
        return d.listKH_Doan(i);
    }
    public ArrayList<KhachHangDTO> listKH_Doan_Cothethem(int iddoan){
        return d.listKH_Doan_Cothethem(iddoan);
    }
    public ArrayList<NhanVienDTO> listNV_Doan(int i){
        return d.listNV_Doan(i);
    }
    public ArrayList<String> fillCBTour(){
        return d.fillCBTour();
    }
    public ArrayList<Integer> listMaGiaTour(int id){
        return d.listMaGiaTour(id);
    }
    public boolean insert(DoanDTO doan){
        return d.insert(doan);
    }
    public boolean delete(int id){
        return  d.delete(id);
    }
    public boolean update(DoanDTO dc){
        return d.update(dc);
    }
    public boolean themKHvaoDoan(int idkh,int iddoan){
        return d.themKHvaoDoan(idkh, iddoan);
    }
    public boolean themNVvaoDoan(int idnv,int iddoan){
        return d.themNVvaoDoan(idnv, iddoan);
    }
    public boolean xoaKHkhoiDoan(int idkh,int iddoan){
        return d.xoaKHkhoiDoan(idkh, iddoan);
    }

    public boolean xoaNVkhoiDoan(int idnv, int iddoan) {
        return d.xoaNVkhoiDoan(idnv, iddoan);
    }

    public ArrayList<NhanVienDTO> listNV_Doan_Cothethem(int idDoan) {
        return d.listNV_Doan_Cothethem(idDoan);
    }
    public ArrayList<DoanDTO> ThongKeDoan(int idtour , int idnv ,String from , String to){
        return d.ThongKeDoan(idtour,idnv, from, to);
    }
    public int cal_SoLuongKH(int iddoan)
    {
        return d.cal_SoLuongKH(iddoan);
    }
    public double cal_GiaDVGoiTour(int idgiatour)
    {
        return d.cal_GiaDVGoiTour(idgiatour);
    }
    public double cal_GiaCoBanTour(int idgiatour, int idtour)
    {
        return d.cal_GiaCoBanTour(idgiatour, idtour);
    }

    public ArrayList<DoanDTO> getDSTour(int idkh) {
        return d.getDSTour(idkh);
    }

    public int soTourDiDuoc(int idtour) {
        return d.soTourDiDuoc(idtour);
    }
}
