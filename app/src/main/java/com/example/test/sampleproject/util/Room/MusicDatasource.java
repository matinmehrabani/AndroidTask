package com.example.test.sampleproject.util.Room;

import com.example.test.sampleproject.model.TableMusic;
import com.example.test.sampleproject.util.Room.database.IMusicDatasource;

import java.util.List;

import io.reactivex.Flowable;

public class MusicDatasource implements IMusicDatasource {

    private MusicDao musicDao;
private static MusicDatasource mInstance;

    public MusicDatasource(MusicDao musicDao) {
        this.musicDao = musicDao;
    }

    public static MusicDatasource getInstance(MusicDao musicDao){

        if(mInstance==null){

            mInstance=new MusicDatasource(musicDao);

        }
        return mInstance;
    }

    @Override
    public Flowable<TableMusic> getUserById(int id) {
        return musicDao.getUserById(id);
    }

    @Override
    public Flowable<List<TableMusic>> getAll() {
        return musicDao.getAll();
    }

    @Override
    public void insertAll(List<TableMusic> list) {
musicDao.insertAll(list);
    }
}
