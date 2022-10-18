package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.ManHinh;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ManHinhMapper implements RowMapper<ManHinh> {
    @Override
    public ManHinh mapRow(ResultSet rs, int rowNum) throws SQLException {
        ManHinh hh = new ManHinh();
        hh.setID(rs.getInt("MAHH"));
        hh.setTen(rs.getString("TenHH"));
        hh.setHangSX(rs.getString("HangSX"));
        hh.setGia(rs.getDouble("Gia"));
        hh.setHinhAnh(rs.getBlob("HinhAnh"));
        hh.setTrongLuong(rs.getDouble("TrongLuong"));
        hh.setSoLuongCon(rs.getInt("SoLuongCon"));

        hh.setModel(rs.getString("Model"));
        hh.setKetNoi(rs.getString("KetNoi"));
        hh.setTanSoQuet(rs.getString("TanSoQuet"));
        hh.setTiLeKhungHinh(rs.getString("TiLeKhungHinh"));
        hh.setLoaiMH(rs.getString("LoaiMH"));
        hh.setMauSacHienThi(rs.getString("MauSachHienThi"));
        return hh;
    }
}
