package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.BanPhim;
import com.khomaytinh.quanlykhomaytinh.Model.Chuot;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ChuotMapper implements RowMapper<Chuot> {
    @Override
    public Chuot mapRow(ResultSet rs, int rowNum) throws SQLException {
        Chuot hh = new Chuot();
        hh.setID(rs.getString("MAHH"));
        hh.setTen(rs.getString("Ten"));
        hh.setHangSX(rs.getString("HangSX"));
        hh.setGia(rs.getDouble("Gia"));
        hh.setHinhAnh(rs.getBlob("HinhAnh"));
        hh.setTrongLuong(rs.getDouble("TrongLuong"));
        hh.setSoLuongCon(rs.getInt("SoLuongCon"));

        hh.setModel(rs.getString("Model"));
        hh.setKetNoi(rs.getString("KetNoi"));

        hh.setSoNut(rs.getString("SoNut"));
        hh.setLed(rs.getString("Led"));
        hh.setMau(rs.getString("Mau"));
        hh.setCamBien(rs.getString("CamBien"));
        return hh;
    }
}
