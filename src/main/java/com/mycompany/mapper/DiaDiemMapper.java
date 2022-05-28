/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mapper;

import DTO.DiaDiemDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bon Nguyen
 */
public class DiaDiemMapper implements RowMapper<DiaDiemDTO>{
    @Override
    public DiaDiemDTO mapRow(ResultSet rs) {
        try{
            DiaDiemDTO diaDiem = new DiaDiemDTO();
            diaDiem.setMaDiaDiem(rs.getInt("MaDiaDiem"));
            diaDiem.setMaTinh(rs.getInt("MaTinh"));
            diaDiem.setTenDiaDiem(rs.getString("TenDiaDiem"));
            diaDiem.setDiaChi(rs.getString("DiaChi"));
            diaDiem.setGioiThieu(rs.getString("GioiThieu"));
            
            return diaDiem;
            
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return null;
    }
}