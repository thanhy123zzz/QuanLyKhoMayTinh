package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.Laptop;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class LapTopMapper implements RowMapper<Laptop> {
    @Override
    public Laptop mapRow(ResultSet rs, int rowNum) throws SQLException {
        Laptop hh = new Laptop();
        hh.setID(rs.getString("MAHH"));
        hh.setTen(rs.getString("Ten"));
        hh.setHangSX(rs.getString("HangSX"));
        hh.setGia(rs.getDouble("Gia"));
        hh.setHinhAnh(rs.getBlob("HinhAnh"));
        hh.setTrongLuong(rs.getDouble("TrongLuong"));
        hh.setSoLuongCon(rs.getInt("SoLuongCon"));

        hh.setHeDieuHanh(rs.getString("HeDieuHanh"));
        hh.setWebCam(rs.getString("WebCam"));
        hh.setRam(rs.getString("RAM"));
        hh.setGPU(rs.getString("GPU"));
        hh.setCPU(rs.getString("CPU"));
        hh.setCard(rs.getString("CARD"));
        hh.setPin(rs.getString("Pin"));
        return hh;
    }
}
