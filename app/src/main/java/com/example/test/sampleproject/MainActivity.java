package com.example.test.sampleproject;

import android.app.ProgressDialog;
import android.database.Observable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.example.test.sampleproject.model.Music;
import com.example.test.sampleproject.model.TableMusic;
import com.example.test.sampleproject.util.Adapter;
import com.example.test.sampleproject.util.Room.MusicDatabase;
import com.example.test.sampleproject.util.Room.MusicDatasource;
import com.example.test.sampleproject.util.Room.database.MusicRepository;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

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
        MusicDatabase musicDatabase = MusicDatabase.getInstance(this);//create database
        musicRepository = MusicRepository.getInstance(MusicDatasource.getInstance(musicDatabase.musicDao()));
        loadData();
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0;i<listmusic.size();i++) {
                    TableMusic tableMusic = new TableMusic(listmusic.get(i).getIso(),listmusic.get(i).getName(),listmusic.get(i).getPhone());
                    mlist.add(tableMusic);
                }
Disposable disposable= io.reactivex.Observable.create(new ObservableOnSubscribe<Object>() {


    @Override
    public void subscribe(ObservableEmitter<Object> emitter) throws Exception {

        musicRepository.insertAll(mlist);
    }
})
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .subscribe(new Consumer() {

                       @Override
                       public void accept(Object o) throws Exception {
                           Toast.makeText(MainActivity.this, "user added", Toast.LENGTH_SHORT).show();
                       }
                   }, new Consumer<Throwable>() {
                       @Override
                       public void accept(Throwable throwable) throws Exception {
                           Toast.makeText(MainActivity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                       }
                   }, new Action() {
                       @Override
                       public void run() throws Exception {
                           loadData();//Refresh data

                       }
                   }


        );
                compositeDisposable.addAll(disposable);
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

    public void database() {


    }

    private void loadData() {

        Disposable disposable = musicRepository.getAll()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Consumer<List<TableMusic>>() {
                    @Override
                    public void accept(List<TableMusic> list) throws Exception {
                        onAddAllMusic(list);

                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        Toast.makeText(MainActivity.this, "" + throwable.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                });
        compositeDisposable.addAll(disposable);
    }

    private void onAddAllMusic(List<TableMusic> list) {
        mlist.clear();
        mlist.addAll(list);
       // adapter.notifyDataSetChanged();
    }


}
