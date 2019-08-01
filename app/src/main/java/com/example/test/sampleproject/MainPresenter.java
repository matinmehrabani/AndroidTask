package com.example.test.sampleproject;

import android.util.Log;
import android.widget.Toast;

import com.example.test.sampleproject.model.Music;
import com.example.test.sampleproject.ui.ListMusicActivity;
import com.example.test.sampleproject.util.ApiClient;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainInterface.presenter{
    List<Music> list;
    MainInterface.ui show;

    public MainPresenter(MainInterface.ui show) {
        this.show = show;
    }

    @Override
    public void getListMusic() {
ApiClient.getApi().getAllMusic().enqueue(new Callback<List<Music>>() {
    @Override
    public void onResponse(Call<List<Music>> call, Response<List<Music>> response) {
        list=response.body();
        show.showList(list);

    }

    @Override
    public void onFailure(Call<List<Music>> call, Throwable t) {
        Log.i("matin", "onFailure: swjduiwehjdfe"+"noresponcecode200");
    }
});
    }
}
