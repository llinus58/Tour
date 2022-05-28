/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import DTO.KhachHangDTO;
import com.mycompany.mapper.KhachHangMapper;
import java.util.List;

/**
 *
 * @author Trieu
 */
public class KhachHangDAL extends DAL<KhachHangDTO> {

    public List<KhachHangDTO> findAll() {
        String sql = "SELECT * FROM KHACHHANG";
        return query(sql, new KhachHangMapper());
    }

    public KhachHangDTO findById(int id) {
        String sql = "SELECT * FROM KHACHHANG WHERE MAKH = ?";
        List<KhachHangDTO> khachHang = query(sql, new KhachHangMapper(), id);
        if (khachHang.isEmpty()) {
            return null;
        }
        return khachHang.get(0);
    }

    public KhachHangDTO findBySdt(String sdt) {
        String sql = "SELECT * FROM KHACHHANG WHERE SDT = ?";
        List<KhachHangDTO> khachHang = query(sql, new KhachHangMapper(), sdt);

        if (khachHang.isEmpty()) {
            return null;
        }
        return khachHang.get(0);

    }

    public Long save(KhachHangDTO khachHang) {
        String sql = "INSERT INTO KHACHHANG(HoTen,GioiTinh,NgaySinh,DiaChi,CMND,SDT) VALUES(?,?,?,?,?,?)";
        return insert(sql, khachHang.getHoTen(), khachHang.getGioiTinh(), khachHang.getNgaySinh(),
                khachHang.getDiaChi(), khachHang.getCMND(), khachHang.getSDT());
    }

    public void update(KhachHangDTO khachHang) {
        String sql = "UPDATE khachhang SET HoTen = ?, GioiTinh = ?, NgaySinh = ?, DiaChi = ?, "
                + "CMND = ?, SDT = ? WHERE MaKH = ?";

        update(sql, khachHang.getHoTen(), khachHang.getGioiTinh(), khachHang.getNgaySinh(), khachHang.getDiaChi(),
                khachHang.getCMND(), khachHang.getSDT(), khachHang.getMaKH());
    }

    public void delete(int id) {
        String sql = "DELETE FROM KHACHHANG WHERE MAKH = ?";
        update(sql, id);
        deleteKHKhoiDoan(id);
    }
    public void deleteKHKhoiDoan(int idkh) {
        String sql = "DELETE FROM dskhachhang_doan WHERE MAKH = ?";
        update(sql, idkh);
    }
}
