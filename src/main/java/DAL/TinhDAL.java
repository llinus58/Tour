/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAL;

import DTO.TinhDTO;
import com.mycompany.mapper.TinhMapper;
import java.util.List;

/**
 *
 * @author Bon Nguyen
 */
public class TinhDAL extends DAL<TinhDTO>{
    public List<TinhDTO> findAll() {
        String sql = "SELECT * FROM TINH";
        return query(sql, new TinhMapper());
    }
    
   
    public TinhDTO findById(int id){
        String sql ="SELECT * FROM TINH WHERE MaTinh = ? ";
        List<TinhDTO> tinh = query(sql,new TinhMapper(),id);
        if(tinh.isEmpty()){
            return null;
        }
        return tinh.get(0);
    }
    
    
    public Long save(TinhDTO tinh){
        String sql = "INSERT INTO TINH(TENTINH) VALUES(?)";
        return insert(sql,tinh.getTenTinh());
    }
    
    public void update(TinhDTO tinh){
        String sql ="UPDATE TINH SET TENTINH = ? WHERE MATINH = ?";
        update(sql,tinh.getTenTinh(),tinh.getMaTinh());
    }
    
    public void delete(int id){
        String sql = "DELETE FROM VAITRO WHERE MATINH = ?";
        update(sql,id);
    }
}
