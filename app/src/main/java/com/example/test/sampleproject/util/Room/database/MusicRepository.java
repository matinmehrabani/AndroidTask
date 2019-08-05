package com.example.test.sampleproject.util.Room.database;

import com.example.test.sampleproject.model.TableMusic;

import java.util.List;

import io.reactivex.Flowable;

public class MusicRepository implements IMusicDatasource {

    private  IMusicDatasource mLocalDataSource;
    private static MusicRepository mInstance;

    public MusicRepository(IMusicDatasource mLocalDataSource) {
        this.mLocalDataSource = mLocalDataSource;
    }

    public static MusicRepository getInstance(IMusicDatasource mLocalDataSource){

        if(mInstance==null){

            mInstance=new MusicRepository(mLocalDataSource);
        }
        return mInstance;
    }

    @Override
    public Flowable<TableMusic> getUserById(int id) {
        return mLocalDataSource.getUserById(id);
    }

    @Override
    public Flowable<List<TableMusic>> getAll() {
        return mLocalDataSource.getAll();
    }

    @Override
    public void insertAll(List<TableMusic> list) {
mLocalDataSource.insertAll(list);
    }
}
