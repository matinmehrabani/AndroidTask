package com.example.test.sampleproject.util.Room;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.example.test.sampleproject.model.TableMusic;

import java.util.List;

import io.reactivex.Flowable;

@Dao
public interface MusicDao {

    @Query("SELECT * FROM musics WHERE id=:id")
    Flowable<TableMusic> getUserById(int id);

    @Query("SELECT * FROM musics")
    Flowable<List<TableMusic>> getAll();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<TableMusic> list);


}
