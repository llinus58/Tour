/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.VaiTroDTO;
import com.mycompany.mapper.VaiTroMapper;
import com.mycompany.util.DBConnectionUtil;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Trieu
 */
public class VaiTroDAL  extends DAL<VaiTroDTO>{
    PreparedStatement ps;
    ResultSet rs;
    Connection conn = DBConnectionUtil.getConnection();
    public List<VaiTroDTO> findAll() {
        String sql = "SELECT * FROM VAITRO";
        return query(sql, new VaiTroMapper());
    }
    public int Soluongnvdamnhan(int idvaitro){
         String sql = "SELECT count(*) from nhanvien where mavaitro=?";
        
        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1,idvaitro);
            rs = ps.executeQuery();
            while(rs.next()){
                return rs.getInt(1);
            }
            
        } catch (SQLException ex) {
            
        }
       return 0;
    }
   
    public VaiTroDTO findById(int id){
        String sql ="SELECT * FROM VAITRO WHERE MaVaiTro = ? ";
        List<VaiTroDTO> vaiTro = query(sql,new VaiTroMapper(),id);
        if(vaiTro.isEmpty()){
            return null;
        }
        return vaiTro.get(0);
    }
    public VaiTroDTO findByTenVaiTro(String tenVaiTro){
        String sql = "SELECT * FROM VAITRO WHERE TENVAITRO  = ?";
        List<VaiTroDTO> vaiTro = query(sql,new VaiTroMapper(),tenVaiTro);
        if(vaiTro.isEmpty()){
            return null;
        }
        else
        {
            return vaiTro.get(0);
        }
        
    }
    
    public Long save(VaiTroDTO vaiTro){
        String sql = "INSERT INTO VAITRO(TENVAITRO) VALUES(?)";
        return insert(sql,vaiTro.getTenVaiTro());
    }
    
    public void update(VaiTroDTO vaiTro){
        String sql ="UPDATE VAITRO SET TENVAITRO = ? WHERE MAVAITRO = ?";
        update(sql,vaiTro.getTenVaiTro(),vaiTro.getMaVaiTro());
    }
    
    public void delete(int id){
        String sql = "DELETE FROM VAITRO WHERE MAVAITRO = ?";
        update(sql,id);
    }
}
