package com.example.retrofitpractice.POJO;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class mtest {
    @SerializedName("name")
    @Expose
    public String name;

    @SerializedName("job")
    @Expose
    public String job;
    @SerializedName("id")
    @Expose
    public String id;

    @SerializedName("createdAt")
    @Expose
    public String createdAt;

    public mtest(String name, String job) {
        this.name = name;
        this.job = job;
    }
}
