package com.example.test.sampleproject;

import android.app.ProgressDialog;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.test.sampleproject.model.Music;
import com.example.test.sampleproject.model.TableMusic;
import com.example.test.sampleproject.util.Adapter;
import com.example.test.sampleproject.util.Room.database.MusicRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.disposables.CompositeDisposable;

public class MainActivity extends AppCompatActivity implements MainInterface.ui {
    private RecyclerView recyclerView;
    private Adapter adapter;
    MainPresenter mainPresenter;
    ProgressDialog progressDialog;
    private FloatingActionButton floatingActionButton;
    private CompositeDisposable compositeDisposable;
    private MusicRepository musicRepository;
    List<TableMusic> mlist;
List<Music> listmusic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        showProgressDialog();
        mainPresenter.getListMusic();
floatingActionButton.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        for(int i =0;i<listmusic.size();i++){
            mainPresenter.insertAll(new TableMusic(listmusic.get(i).getIso(),listmusic.get(i).getName(),listmusic.get(i).getPhone()),MainActivity.this);

        }
        Toast.makeText(MainActivity.this, "add all music", Toast.LENGTH_SHORT).show();
    }
});
    }
    @Override
    public void init() {
        recyclerView = findViewById(R.id.listmusic);
        mainPresenter = new MainPresenter(this);
        floatingActionButton = findViewById(R.id.fab);
        compositeDisposable = new CompositeDisposable();
       mlist=new ArrayList<>();
       listmusic=new ArrayList<>();
    }

    @Override
    public void showList(List<Music> list) {
        progressDialog.dismiss();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, list);
        recyclerView.setAdapter(adapter);
        listmusic=list;
    }

    private void showProgressDialog() {
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

    }

}
