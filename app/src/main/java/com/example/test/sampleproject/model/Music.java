package com.example.test.sampleproject.model;

import com.google.gson.annotations.SerializedName;

public class Music {

    @SerializedName("iso")
    private String iso;

    @SerializedName("name")
    private String name;

    @SerializedName("phone")
    private String phone;

    public String getIso() {
        return iso;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
