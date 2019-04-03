package com.npe.artikelku.model.user;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "user_table")
public class UserModel {
    @PrimaryKey
    @NonNull
    String id;
    @NonNull
    String nama;
    @NonNull
    String email;
    @NonNull
    String noHp;
    @NonNull
    String gender;
    @NonNull
    String bank;
    @NonNull
    String nomor_rekening;
    @NonNull
    String nama_rekening;

    public UserModel() {
    }

    public UserModel(String id, String nama, String email, String noHp, String gender, String bank, String nomor_rekening, String nama_rekening) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.gender = gender;
        this.bank = bank;
        this.nomor_rekening = nomor_rekening;
        this.nama_rekening = nama_rekening;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBank() {
        return bank;
    }

    public void setBank(String bank) {
        this.bank = bank;
    }

    public String getNomor_rekening() {
        return nomor_rekening;
    }

    public void setNomor_rekening(String nomor_rekening) {
        this.nomor_rekening = nomor_rekening;
    }

    public String getNama_rekening() {
        return nama_rekening;
    }

    public void setNama_rekening(String nama_rekening) {
        this.nama_rekening = nama_rekening;
    }
}
