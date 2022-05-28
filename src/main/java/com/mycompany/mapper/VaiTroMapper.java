/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mapper;

import DTO.VaiTroDTO;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Trieu
 */
public class VaiTroMapper implements RowMapper<VaiTroDTO> {

    @Override
    public VaiTroDTO mapRow(ResultSet rs) {
        try {
            VaiTroDTO vaiTro = new VaiTroDTO();
            vaiTro.setMaVaiTro(rs.getInt("MaVaiTro"));
            vaiTro.setTenVaiTro(rs.getString("TenVaiTro"));
       

            return vaiTro;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
}
