package com.khomaytinh.quanlykhomaytinh.Model;

import org.springframework.web.multipart.MultipartFile;

import java.sql.Blob;

public class HangHoa {
    private String ID;
    private String ten;
    private String hangSX;
    private long gia;
    private Double trongLuong;
    private Blob hinhAnh;
    private int soLuongCon;
    private MultipartFile hinhAnhbit;

    public MultipartFile getHinhAnhbit() {
        return hinhAnhbit;
    }

    public void setHinhAnhbit(MultipartFile hinhAnhbit) {
        this.hinhAnhbit = hinhAnhbit;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getTen() {
        return ten;
    }

    public void setTen(String ten) {
        this.ten = ten;
    }

    public String getHangSX() {
        return hangSX;
    }

    public void setHangSX(String hangSX) {
        this.hangSX = hangSX;
    }

    public long getGia() {
        return gia;
    }

    public void setGia(long gia) {
        this.gia = gia;
    }

    public Double getTrongLuong() {
        return trongLuong;
    }

    public void setTrongLuong(Double trongLuong) {
        this.trongLuong = trongLuong;
    }

    public Blob getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(Blob hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public int getSoLuongCon() {
        return soLuongCon;
    }

    public void setSoLuongCon(int soLuongCon) {
        this.soLuongCon = soLuongCon;
    }

    public HangHoa(String ID) {
        this.ID = ID;
    }
    public HangHoa() {

    }
}
