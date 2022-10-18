package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.ChiTietPhieu;
import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChiTiecPhieuMapper implements RowMapper<ChiTietPhieu> {
    @Override
    public ChiTietPhieu mapRow(ResultSet rs, int rowNum) throws SQLException {
        ChiTietPhieu c = new ChiTietPhieu();
        c.setDonGia(rs.getDouble("DonGia"));
        c.setHangHoa(new HangHoa(rs.getInt("MaHH")));
        c.setSoLuong(rs.getInt("SoLuong"));
        c.setThanhTien(rs.getDouble("ThanhTien"));
        return c;
    }
}
