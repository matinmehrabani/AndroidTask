package com.example.test.sampleproject.util;

import com.example.test.sampleproject.model.Music;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface InterfaceApi {

    @GET("/v1/countries")
    Call<List<Music>> getAllMusic();
}
