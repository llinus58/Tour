/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mapper;

import DTO.TinhDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Bon Nguyen
 */
public class TinhMapper implements RowMapper<TinhDTO>{
    @Override
    public TinhDTO mapRow(ResultSet rs) {
        try {
            TinhDTO tinh = new TinhDTO();
            tinh.setMaTinh(rs.getInt("MaTinh"));
            tinh.setTenTinh(rs.getString("TenTinh"));
       

            return tinh;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
