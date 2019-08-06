package com.example.test.sampleproject.util.Room.database;

import android.content.Context;
import android.os.AsyncTask;

import com.example.test.sampleproject.model.TableMusic;
import com.example.test.sampleproject.util.Room.MusicDao;
import com.example.test.sampleproject.util.Room.MusicDatabase;

import java.util.List;

import io.reactivex.Flowable;

public class MusicRepository implements IMusicDatasource {

    private IMusicDatasource mLocalDataSource;
    private static MusicRepository mInstance;
    private MusicDao musicDao;
private List<TableMusic> list;
    public MusicRepository(Context context) {
        MusicDatabase database=MusicDatabase.getInstance(context);
        musicDao=database.musicDao();
    }

    public static MusicRepository getInstance(Context context) {

        if (mInstance == null) {

            mInstance = new MusicRepository(context);
        }
        return mInstance;
    }


    @Override
    public TableMusic getUserById(final int id) {
       return null;
    }

    @Override
    public List<TableMusic> getAll() {
        AsyncTask.execute(new Runnable() {
            @Override
            public void run() {
                list= (List<TableMusic>) musicDao.getAll();
            }
        });
        return list;
    }

    @Override
    public void insertAll(final TableMusic tableMusic) {
AsyncTask.execute(new Runnable() {
    @Override
    public void run() {
        musicDao.insertAll(tableMusic);
    }
});
    }
}
