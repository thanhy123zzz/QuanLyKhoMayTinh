package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.Accounts;
import com.khomaytinh.quanlykhomaytinh.Model.ThuKho;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ThuKhoMapper implements RowMapper<ThuKho> {
    @Override
    public ThuKho mapRow(ResultSet rs, int rowNum) throws SQLException {
        ThuKho ad = new ThuKho();
        ad.setID(rs.getString("MaTK"));
        ad.setGioiTinh(rs.getBoolean("GioiTinh"));
        ad.setTen(rs.getString("TenTK"));
        ad.setSoDT(rs.getString("SDT"));
        ad.setNgaySinh(rs.getDate("NgaySinh"));
        ad.setCCCD(rs.getString("CCCD"));
        ad.setTaiKhoan(new Accounts(rs.getString("UserName")));
        ad.setNgayBatDauLam(rs.getDate("NgayBatDau"));
        ad.setLuong(rs.getDouble("Luong"));
        ad.setSoTienTrenGio(rs.getDouble("SoTienTrenGio"));
        return ad;
    }
}
