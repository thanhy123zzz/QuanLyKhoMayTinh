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
        ad.setTen(rs.getString("TenTK"));
        ad.setGioiTinh(rs.getBoolean("GioiTinh"));
        ad.setNgaySinh(rs.getDate("NgaySinh"));
        ad.setSoDT(rs.getString("SDT"));
        
        ad.setCCCD(rs.getString("CCCD"));
        ad.setNgayBatDauLam(rs.getDate("NgayBatDau"));
        ad.setLuong((long)rs.getDouble("Luong"));
        ad.setSoTienTrenGio(rs.getDouble("SoTienTrenGio"));
        ad.setTaiKhoan(new Accounts(rs.getString("UserName")));
        
        
        
        return ad;
    }
}
