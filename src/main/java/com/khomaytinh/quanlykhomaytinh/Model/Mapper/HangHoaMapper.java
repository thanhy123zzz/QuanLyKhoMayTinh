package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.HangHoa;
import com.khomaytinh.quanlykhomaytinh.Model.Laptop;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class HangHoaMapper implements RowMapper<HangHoa> {
    @Override
    public HangHoa mapRow(ResultSet rs, int rowNum) throws SQLException {
        HangHoa hh = new HangHoa();
        hh.setID(rs.getString("MAHH"));
        hh.setTen(rs.getString("Ten"));
        hh.setHangSX(rs.getString("HangSX"));
        hh.setGia((long)rs.getDouble("Gia"));
        hh.setHinhAnh(rs.getBlob("HinhAnh"));
        hh.setTrongLuong(rs.getDouble("TrongLuong"));
        hh.setSoLuongCon(rs.getInt("SoLuongCon"));
        return hh;
    }
}
