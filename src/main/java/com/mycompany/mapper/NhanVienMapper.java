/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapper;

import DTO.NhanVienDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trieu
 */
public class NhanVienMapper  implements RowMapper<NhanVienDTO>{

    @Override
    public NhanVienDTO mapRow(ResultSet rs) {
        try{
            NhanVienDTO nhanVien = new NhanVienDTO();
            nhanVien.setMaNhanVien(rs.getInt("MaNV"));
            nhanVien.setMaVaiTro(rs.getInt("MaVaiTro"));
            nhanVien.setHoTen(rs.getString("HoTen"));
            nhanVien.setGioiTinh(rs.getBoolean("GioiTinh"));
            nhanVien.setNgaySinh(rs.getDate("NgaySinh").toLocalDate());
            nhanVien.setDiaChi(rs.getString("DiaChi"));
            nhanVien.setSDT(rs.getString("SDT"));
            nhanVien.setTrangThai(rs.getBoolean("TrangThai"));
            
            return nhanVien;
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }
    
}
