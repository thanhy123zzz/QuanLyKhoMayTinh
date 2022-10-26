package com.khomaytinh.quanlykhomaytinh.Model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ThuKho extends Admin{
    private Double soTienTrenGio;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date ngayBatDauLam;
    private long luong;

    public Double getSoTienTrenGio() {
        return soTienTrenGio;
    }

    public void setSoTienTrenGio(Double soTienTrenGio) {
        this.soTienTrenGio = soTienTrenGio;
    }

    public Date getNgayBatDauLam() {
        return ngayBatDauLam;
    }

    public void setNgayBatDauLam(Date ngayBatDauLam) {
        this.ngayBatDauLam = ngayBatDauLam;
    }

    public long getLuong() {
        return luong;
    }

    public void setLuong(long luong) {
        this.luong = luong;
    }
}
