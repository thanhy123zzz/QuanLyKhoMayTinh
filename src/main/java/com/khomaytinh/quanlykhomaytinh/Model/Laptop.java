package com.khomaytinh.quanlykhomaytinh.Model;

public class Laptop extends HangHoa{
    private String heDieuHanh;
    private String webCam;
    private String ram;
    private String GPU;
    private String CPU;
    private String Card;
    private String pin;

    public String getHeDieuHanh() {
        return heDieuHanh;
    }

    public void setHeDieuHanh(String heDieuHanh) {
        this.heDieuHanh = heDieuHanh;
    }

    public String getWebCam() {
        return webCam;
    }

    public void setWebCam(String webCam) {
        this.webCam = webCam;
    }

    public String getRam() {
        return ram;
    }

    public void setRam(String ram) {
        this.ram = ram;
    }

    public String getGPU() {
        return GPU;
    }

    public void setGPU(String GPU) {
        this.GPU = GPU;
    }

    public String getCPU() {
        return CPU;
    }

    public void setCPU(String CPU) {
        this.CPU = CPU;
    }

    public String getCard() {
        return Card;
    }

    public void setCard(String card) {
        Card = card;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
}
