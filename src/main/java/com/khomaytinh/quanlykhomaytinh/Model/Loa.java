package com.khomaytinh.quanlykhomaytinh.Model;

public class Loa extends HangHoa{
    private String Model;
    private String KetNoi;
    private String DangLoa;
    private String KieuLoa;

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public String getKetNoi() {
        return KetNoi;
    }

    public void setKetNoi(String ketNoi) {
        KetNoi = ketNoi;
    }

    public String getDangLoa() {
        return DangLoa;
    }

    public void setDangLoa(String dangLoa) {
        DangLoa = dangLoa;
    }

    public String getKieuLoa() {
        return KieuLoa;
    }

    public void setKieuLoa(String kieuLoa) {
        KieuLoa = kieuLoa;
    }
}
