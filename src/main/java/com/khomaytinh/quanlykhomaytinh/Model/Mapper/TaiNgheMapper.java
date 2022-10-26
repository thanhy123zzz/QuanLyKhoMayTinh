package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.Chuot;
import com.khomaytinh.quanlykhomaytinh.Model.TaiNghe;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class TaiNgheMapper implements RowMapper<TaiNghe> {
    @Override
    public TaiNghe mapRow(ResultSet rs, int rowNum) throws SQLException {
        TaiNghe hh = new TaiNghe();
        hh.setID(rs.getString("MAHH"));
        hh.setTen(rs.getString("Ten"));
        hh.setHangSX(rs.getString("HangSX"));
        hh.setGia((long)rs.getDouble("Gia"));
        hh.setHinhAnh(rs.getBlob("HinhAnh"));
        hh.setTrongLuong(rs.getDouble("TrongLuong"));
        hh.setSoLuongCon(rs.getInt("SoLuongCon"));

        hh.setModel(rs.getString("Model"));
        hh.setKetNoi(rs.getString("KetNoi"));

        hh.setLed(rs.getString("Led"));

        hh.setKieuTN(rs.getString("KieuTN"));
        hh.setMau(rs.getString("Mau"));
        hh.setTanSo(rs.getString("TanSo"));
        hh.setKhaNangCachAm(rs.getString("KhaNangCachAm"));
        hh.setChatLieu(rs.getString("ChatLieu"));
        return hh;
    }
}
