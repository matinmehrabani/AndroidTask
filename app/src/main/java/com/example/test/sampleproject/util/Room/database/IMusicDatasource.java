package com.example.test.sampleproject.util.Room.database;

import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.test.sampleproject.model.TableMusic;

import java.util.List;

import io.reactivex.Flowable;

public interface IMusicDatasource {


    TableMusic getUserById(int id);

    List<TableMusic> getAll();

    void insertAll(TableMusic tableMusic);


}
