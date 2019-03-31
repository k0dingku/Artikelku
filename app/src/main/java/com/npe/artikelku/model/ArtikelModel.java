package com.npe.artikelku.model;

public class ArtikelModel {
    private String judul;
    private boolean isExpand;

    public ArtikelModel(String judul) {
        this.judul = judul;
        isExpand = false;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
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
