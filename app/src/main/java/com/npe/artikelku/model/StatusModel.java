package com.npe.artikelku.model;

public class StatusModel {
    String Tanggal;
    String Judul;
    String Status;
    private boolean isExpand;

    public StatusModel(String tanggal, String judul, String status) {
        Tanggal = tanggal;
        Judul = judul;
        Status = status;
    }

    public String getTanggal() {
        return Tanggal;
    }

    public void setTanggal(String tanggal) {
        Tanggal = tanggal;
    }

    public String getJudul() {
        return Judul;
    }

    public void setJudul(String judul) {
        Judul = judul;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }
    public void expanded(){
        isExpand = true;
    }
    public void collapse(){
        isExpand = false;
    }
    public boolean isExpand(){
        return isExpand;
    }
}
