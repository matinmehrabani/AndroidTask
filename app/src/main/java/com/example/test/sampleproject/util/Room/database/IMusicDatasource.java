package com.example.test.sampleproject.util.Room.database;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.test.sampleproject.model.TableMusic;

import java.util.List;

import io.reactivex.Flowable;

public interface IMusicDatasource {


    Flowable<TableMusic> getUserById(int id);

    Flowable<List<TableMusic>> getAll();

    void insertAll(List<TableMusic> list);


}
