package com.khomaytinh.quanlykhomaytinh.Model;

import java.sql.Blob;

public class ThongKe {
    private HangHoa hangHoah;
    private ChiTietPhieu chiTietPhieu;

    public HangHoa getHangHoah() {
        return hangHoah;
    }

    public void setHangHoah(HangHoa hangHoah) {
        this.hangHoah = hangHoah;
    }

    public ChiTietPhieu getChiTietPhieu() {
        return chiTietPhieu;
    }

    public void setChiTietPhieu(ChiTietPhieu chiTietPhieu) {
        this.chiTietPhieu = chiTietPhieu;
    }
}
