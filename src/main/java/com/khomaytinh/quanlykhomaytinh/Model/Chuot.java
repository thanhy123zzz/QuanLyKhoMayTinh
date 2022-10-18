package com.khomaytinh.quanlykhomaytinh.Model;

public class Chuot extends HangHoa{
    private String Model;
    private String KetNoi;
    private String SoNut;
    private String Led;
    private String Mau;
    private String CamBien;

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

    public String getSoNut() {
        return SoNut;
    }

    public void setSoNut(String soNut) {
        SoNut = soNut;
    }

    public String getLed() {
        return Led;
    }

    public void setLed(String led) {
        Led = led;
    }

    public String getMau() {
        return Mau;
    }

    public void setMau(String mau) {
        Mau = mau;
    }

    public String getCamBien() {
        return CamBien;
    }

    public void setCamBien(String camBien) {
        CamBien = camBien;
    }
}
