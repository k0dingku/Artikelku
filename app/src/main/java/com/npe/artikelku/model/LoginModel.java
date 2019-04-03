package com.npe.artikelku.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class LoginModel {
    @SerializedName("api_status")
    @Expose
    int api_status;
    @SerializedName("api_message")
    @Expose
    String api_message;
    @SerializedName("api_response_fields")
    @Expose
    List<String> api_response_fields;
    @SerializedName("api_authorization")
    @Expose
    String api_authorization;
    @SerializedName("id")
    @Expose
    String id;
    @SerializedName("nama")
    @Expose
    String nama;
    @SerializedName("email")
    @Expose
    String email;
    @SerializedName("noHp")
    @Expose
    String noHp;
    @SerializedName("gender")
    @Expose
    String gender;
    @SerializedName("bank")
    @Expose
    String bank;
    @SerializedName("nomor_rekening")
    @Expose
    String nomor_rekening;
    @SerializedName("nama_rekening")
    @Expose
    String nama_rekening;

    public LoginModel() {
    }

    public LoginModel(int api_status, String api_message, List<String> api_response_fields, String api_authorization, String id, String nama, String email, String noHp, String gender, String bank, String nomor_rekening, String nama_rekening) {
        this.api_status = api_status;
        this.api_message = api_message;
        this.api_response_fields = api_response_fields;
        this.api_authorization = api_authorization;
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.noHp = noHp;
        this.gender = gender;
        this.bank = bank;
        this.nomor_rekening = nomor_rekening;
        this.nama_rekening = nama_rekening;
    }

    public int getApi_status() {
        return api_status;
    }

    public void setApi_status(int api_status) {
        this.api_status = api_status;
    }

    public String getApi_message() {
        return api_message;
    }

    public void setApi_message(String api_message) {
        this.api_message = api_message;
    }

    public List<String> getApi_response_fields() {
        return api_response_fields;
    }

    public void setApi_response_fields(List<String> api_response_fields) {
        this.api_response_fields = api_response_fields;
    }

    public String getApi_authorization() {
        return api_authorization;
    }

    public void setApi_authorization(String api_authorization) {
        this.api_authorization = api_authorization;
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
