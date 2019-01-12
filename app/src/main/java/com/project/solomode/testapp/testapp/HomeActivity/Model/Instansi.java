package com.project.solomode.testapp.testapp.HomeActivity.Model;

import com.google.gson.annotations.SerializedName;

public class Instansi {
    @SerializedName("instansi")
    private String instansi;
    @SerializedName("alamat")
    private String alamat;

    public Instansi(String instansi, String alamat) {
        this.instansi = instansi;
        this.alamat = alamat;
    }

    public String getInstansi() {
        return instansi;
    }

    public void setInstansi(String instansi) {
        this.instansi = instansi;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

}
