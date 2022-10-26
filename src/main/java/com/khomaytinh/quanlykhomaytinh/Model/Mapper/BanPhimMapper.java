package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;
import com.khomaytinh.quanlykhomaytinh.Model.Laptop;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class BanPhimMapper implements RowMapper<BanPhim> {
    @Override
    public BanPhim mapRow(ResultSet rs, int rowNum) throws SQLException {
        BanPhim hh = new BanPhim();
        hh.setID(rs.getString("MAHH"));
        hh.setTen(rs.getString("Ten"));
        hh.setHangSX(rs.getString("HangSX"));
        hh.setGia((long)rs.getDouble("Gia"));
        hh.setHinhAnh(rs.getBlob("HinhAnh"));
        hh.setTrongLuong(rs.getDouble("TrongLuong"));
        hh.setSoLuongCon(rs.getInt("SoLuongCon"));

        hh.setModel(rs.getString("Model"));
        hh.setKetNoi(rs.getString("KetNoi"));

        hh.setThietke(rs.getString("ThietKe"));
        hh.setKeyCaps(rs.getString("KeyCaps"));
        hh.setSwitch(rs.getString("Switch"));
        return hh;
    }
}
