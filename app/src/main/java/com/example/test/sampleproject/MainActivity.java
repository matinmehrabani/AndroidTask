package com.example.test.sampleproject;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.test.sampleproject.model.Music;
import com.example.test.sampleproject.util.Adapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements MainInterface.ui {
    private RecyclerView recyclerView;
    private Adapter adapter;
    MainPresenter mainPresenter;
    ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
       showProgressDialog();

        mainPresenter.getListMusic();
    }

    @Override
    public void init() {
        recyclerView = findViewById(R.id.listmusic);
        mainPresenter = new MainPresenter(this);
    }

    @Override
    public void showList(List<Music> list) {
        progressDialog.dismiss();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this, list);
        recyclerView.setAdapter(adapter);
    }

    private void showProgressDialog(){
        progressDialog = new ProgressDialog(MainActivity.this);
        progressDialog.setMessage("Loading....");
        progressDialog.show();

    }
}
