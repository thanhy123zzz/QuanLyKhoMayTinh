package com.khomaytinh.quanlykhomaytinh.Model;

import java.util.Date;

public class ThuKho extends Admin{
    private Double soTienTrenGio;
    private Date ngayBatDauLam;
    private Double luong;

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

    public Double getLuong() {
        return luong;
    }

    public void setLuong(Double luong) {
        this.luong = luong;
    }
}