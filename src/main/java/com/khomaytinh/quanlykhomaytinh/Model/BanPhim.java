package com.khomaytinh.quanlykhomaytinh.Model;

public class BanPhim extends HangHoa {
    private String Model;
    private String KetNoi;
    private String Thietke;
    private String Switch;
    private String KeyCaps;

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

    public String getThietke() {
        return Thietke;
    }

    public void setThietke(String thietke) {
        Thietke = thietke;
    }

    public String getSwitch() {
        return Switch;
    }

    public void setSwitch(String aSwitch) {
        Switch = aSwitch;
    }

    public String getKeyCaps() {
        return KeyCaps;
    }

    public void setKeyCaps(String keyCaps) {
        KeyCaps = keyCaps;
    }
}
