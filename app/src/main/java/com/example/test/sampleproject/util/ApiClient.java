package com.example.test.sampleproject.util;

import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit;
    private static InterfaceApi api;
private static final String BASE_URL = "https://api.whichapp.com";
    public static Retrofit getClient(){

        if(retrofit==null){

            retrofit=new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();


        }
        return retrofit;
    }

    public static InterfaceApi getApi() {
        api = getClient().create(InterfaceApi.class);
        return api;
    }
}
