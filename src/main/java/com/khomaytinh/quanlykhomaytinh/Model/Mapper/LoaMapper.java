package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;
import com.khomaytinh.quanlykhomaytinh.Model.Loa;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LoaMapper implements RowMapper<Loa> {
    @Override
    public Loa mapRow(ResultSet rs, int rowNum) throws SQLException {
        Loa hh = new Loa();
        hh.setID(rs.getInt("MAHH"));
        hh.setTen(rs.getString("TenHH"));
        hh.setHangSX(rs.getString("HangSX"));
        hh.setGia(rs.getDouble("Gia"));
        hh.setHinhAnh(rs.getBlob("HinhAnh"));
        hh.setTrongLuong(rs.getDouble("TrongLuong"));
        hh.setSoLuongCon(rs.getInt("SoLuongCon"));

        hh.setModel(rs.getString("Model"));
        hh.setKetNoi(rs.getString("KetNoi"));

        hh.setDangLoa(rs.getString("DangLoa"));
        hh.setKieuLoa(rs.getString("KieuLoa"));
        return hh;
    }
}
