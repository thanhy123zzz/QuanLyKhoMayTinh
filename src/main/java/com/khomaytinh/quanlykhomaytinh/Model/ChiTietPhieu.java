package com.khomaytinh.quanlykhomaytinh.Model;

public class ChiTietPhieu {
    private HangHoa hangHoa;
    private int soLuong;
    private long donGia;
    private long thanhTien;
    private String idHangHoa;

    public String getIdHangHoa() {
        return idHangHoa;
    }

    public void setIdHangHoa(String idHangHoa) {
        this.idHangHoa = idHangHoa;
    }

    public HangHoa getHangHoa() {
        return hangHoa;
    }

    public void setHangHoa(HangHoa hangHoa) {
        this.hangHoa = hangHoa;
    }

    public int getSoLuong() {
        return soLuong;
    }

    public void setSoLuong(int soLuong) {
        this.soLuong = soLuong;
    }

    public long getDonGia() {
        return donGia;
    }

    public void setDonGia(long donGia) {
        this.donGia = donGia;
    }

    public long getThanhTien() {
        return thanhTien;
    }

    public void setThanhTien(long thanhTien) {
        this.thanhTien = thanhTien;
    }
}
