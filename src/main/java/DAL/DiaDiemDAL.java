/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.DiaDiemDTO;
import com.mycompany.mapper.DiaDiemMapper;
import com.mycompany.util.DBConnectionUtil;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bon Nguyen
 */
public class DiaDiemDAL extends DAL<DiaDiemDTO> {

    public List<DiaDiemDTO> findAll() {
        String sql = "SELECT * FROM DIADIEM";
        return query(sql, new DiaDiemMapper());
    }

    public DiaDiemDTO findById(int id) {
        String sql = "SELECT * FROM DIADIEM WHERE MADIADIEM = ?";
        List<DiaDiemDTO> diaDiem = query(sql, new DiaDiemMapper(), id);

        if (diaDiem.isEmpty()) {
            return null;
        }
        return diaDiem.get(0);
    }

    public DiaDiemDTO findByTenDiaDiem(String tenDiaDiem) {
        String sql = "SELECT * FROM DIADIEM WHERE TENDIADIEM = ?";
        List<DiaDiemDTO> diaDiem = query(sql, new DiaDiemMapper(), tenDiaDiem);
        return diaDiem.isEmpty() ? null : diaDiem.get(0);
    }

    public Long save(DiaDiemDTO diaDiem) {
        String sql = "INSERT INTO DIADIEM(MADIADIEM, MATINH, TENDIADIEM, DIACHI, GIOITHIEU) VALUES(?, ?, ?, ?, ?)";
        return insert(sql, diaDiem.getMaDiaDiem(), diaDiem.getMaTinh(), diaDiem.getTenDiaDiem(), diaDiem.getDiaChi(), diaDiem.getGioiThieu());

    }

    public void update(DiaDiemDTO diaDiem) {
        String sql = "UPDATE diadiem SET MaTinh = ?, "
                + "TenDiaDiem = ?, DiaChi = ?, GioiThieu = ?  WHERE MaDiaDiem = ?";
        update(sql, diaDiem.getMaTinh(), diaDiem.getTenDiaDiem(),
                diaDiem.getDiaChi(), diaDiem.getGioiThieu(), diaDiem.getMaDiaDiem());
    }

    public void delete(int id) {
        String sql = "DELETE FROM DIADIEM WHERE MADIADIEM = ? ";
        update(sql, id);
    }

    public void delete_dsdd(int id) {
        String sql = "DELETE from dsdiadiem_tour where MaDiaDiem = ?";
        update(sql, id);
    }

    
    

}
