package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.Accounts;
import com.khomaytinh.quanlykhomaytinh.Model.PhieuXuatNhap;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PhieuXuatNhapMapper implements RowMapper<PhieuXuatNhap> {
    @Override
    public PhieuXuatNhap mapRow(ResultSet rs, int rowNum) throws SQLException {
        PhieuXuatNhap p = new PhieuXuatNhap();
        p.setMaPhieu(rs.getString("MaPhieu"));
        p.setLoai(rs.getString("Loai"));
        p.setNgayXP(rs.getDate("NgayXN"));
        p.setSoLoaiSP(rs.getInt("SLLoaiSP"));
        p.setTongTienCaPhieu(rs.getDouble("TongTienCaPhieu"));
        p.setTrangThai(rs.getBoolean("TrangThai"));
        p.setAccounts(new Accounts(rs.getString("MaTK")));
        return p;
    }
}
