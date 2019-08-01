package com.example.test.sampleproject;

import com.example.test.sampleproject.model.Music;

import java.util.List;

public interface MainInterface {
    interface presenter{

        void getListMusic();
    }
   interface ui{

        void init();
        void showList(List<Music> list);
   }
}
