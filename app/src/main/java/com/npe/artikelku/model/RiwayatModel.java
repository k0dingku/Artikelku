package com.npe.artikelku.model;

public class RiwayatModel {
    String tanggal;
    String judul;
    String saldo;

    public RiwayatModel(String tanggal, String judul, String saldo) {
        this.tanggal = tanggal;
        this.judul = judul;
        this.saldo = saldo;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getSaldo() {
        return saldo;
    }

    public void setSaldo(String saldo) {
        this.saldo = saldo;
    }
}
