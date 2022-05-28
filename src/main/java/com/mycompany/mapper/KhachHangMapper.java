/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapper;

import DTO.KhachHangDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trieu
 */
public class KhachHangMapper implements RowMapper<KhachHangDTO> {

    @Override
    public KhachHangDTO mapRow(ResultSet rs) {
       try{
          KhachHangDTO khachHang = new KhachHangDTO();
          khachHang.setMaKH(rs.getInt("MaKH"));
          khachHang.setHoTen(rs.getString("HoTen"));
          khachHang.setGioiTinh(rs.getBoolean("GioiTinh"));
          khachHang.setNgaySinh(rs.getDate("NgaySinh").toLocalDate());
          khachHang.setDiaChi(rs.getString("DiaChi"));
          khachHang.setCMND(rs.getString("CMND"));
          khachHang.setSDT(rs.getString("SDT"));
          
          return khachHang;
      }
      catch(SQLException e)
      {
          System.out.println(e.getMessage());
      }
      
      return null;
    }
    
}
