package com.example.test.sampleproject;

import android.content.Context;

import com.example.test.sampleproject.model.Music;
import com.example.test.sampleproject.model.TableMusic;

import java.util.List;

public interface MainInterface {
    interface presenter{

        void getListMusic();
        void insertAll(TableMusic tableMusic, Context context);
    }
   interface ui{

        void init();
        void showList(List<Music> list);
   }
}
