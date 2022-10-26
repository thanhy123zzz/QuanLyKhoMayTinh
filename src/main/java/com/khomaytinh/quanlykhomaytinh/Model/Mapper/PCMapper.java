package com.khomaytinh.quanlykhomaytinh.Model.Mapper;

import com.khomaytinh.quanlykhomaytinh.Model.PC;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PCMapper implements RowMapper<PC> {
    @Override
    public PC mapRow(ResultSet rs, int rowNum) throws SQLException {
        PC hh = new PC();
        hh.setID(rs.getString("MAHH"));
        hh.setTen(rs.getString("Ten"));
        hh.setHangSX(rs.getString("HangSX"));
        hh.setGia((long)rs.getDouble("Gia"));
        hh.setHinhAnh(rs.getBlob("HinhAnh"));
        hh.setTrongLuong(rs.getDouble("TrongLuong"));
        hh.setSoLuongCon(rs.getInt("SoLuongCon"));

        hh.setHeDieuHanh(rs.getString("HeDieuHanh"));
        hh.setWebCam(rs.getString("WebCam"));
        hh.setRam(rs.getString("RAM"));
        hh.setGPU(rs.getString("GPU"));
        hh.setCPU(rs.getString("CPU"));
        hh.setCARD(rs.getString("CARD"));

        hh.setHDD(rs.getString("SSD"));
        hh.setManHinh(rs.getString("ManHinh"));
        hh.setMain(rs.getString("Main"));
        return hh;
    }
}
