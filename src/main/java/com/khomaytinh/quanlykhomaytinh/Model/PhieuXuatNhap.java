package com.khomaytinh.quanlykhomaytinh.Model;

import java.util.Date;
import java.util.List;

public class PhieuXuatNhap {
    private int maPhieu;
    private String loai;
    private Date ngayXP;
    private int SoLoaiSP;
    private Double tongTienCaPhieu;
    private boolean trangThai;
    private Accounts accounts;
    private List<ChiTietPhieu> chiTietPhieus;

    public int getMaPhieu() {
        return maPhieu;
    }

    public void setMaPhieu(int maPhieu) {
        this.maPhieu = maPhieu;
    }

    public String getLoai() {
        return loai;
    }

    public void setLoai(String loai) {
        this.loai = loai;
    }

    public Date getNgayXP() {
        return ngayXP;
    }

    public void setNgayXP(Date ngayXP) {
        this.ngayXP = ngayXP;
    }

    public int getSoLoaiSP() {
        return SoLoaiSP;
    }

    public void setSoLoaiSP(int soLoaiSP) {
        SoLoaiSP = soLoaiSP;
    }

    public Double getTongTienCaPhieu() {
        return tongTienCaPhieu;
    }

    public void setTongTienCaPhieu(Double tongTienCaPhieu) {
        this.tongTienCaPhieu = tongTienCaPhieu;
    }

    public boolean isTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    public Accounts getAccounts() {
        return accounts;
    }

    public void setAccounts(Accounts accounts) {
        this.accounts = accounts;
    }

    public List<ChiTietPhieu> getChiTietPhieus() {
        return chiTietPhieus;
    }

    public void setChiTietPhieus(List<ChiTietPhieu> chiTietPhieus) {
        this.chiTietPhieus = chiTietPhieus;
    }
}
