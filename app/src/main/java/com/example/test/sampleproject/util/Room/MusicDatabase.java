package com.example.test.sampleproject.util.Room;


import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.test.sampleproject.model.TableMusic;

import static com.example.test.sampleproject.util.Room.MusicDatabase.DATABASE_VERSION;

@Database(entities = TableMusic.class, version = DATABASE_VERSION)
public abstract class MusicDatabase extends RoomDatabase {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Music_Room";

public abstract MusicDao musicDao();

private static MusicDatabase mInstance;

    public static MusicDatabase getInstance(Context context){

        if(mInstance==null){

            mInstance= Room.databaseBuilder(context,MusicDatabase.class,DATABASE_NAME)
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return mInstance;
    }
}
