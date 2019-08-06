package com.example.test.sampleproject;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.example.test.sampleproject.model.Music;
import com.example.test.sampleproject.model.TableMusic;
import com.example.test.sampleproject.ui.ListMusicActivity;
import com.example.test.sampleproject.util.ApiClient;
import com.example.test.sampleproject.util.Room.database.MusicRepository;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainPresenter implements MainInterface.presenter{
    List<Music> list;
    MainInterface.ui show;
MusicRepository musicRepository;
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

    @Override
    public void insertAll(TableMusic tableMusic, Context context) {
        musicRepository=MusicRepository.getInstance(context);
        musicRepository.insertAll(tableMusic);
    }


}
