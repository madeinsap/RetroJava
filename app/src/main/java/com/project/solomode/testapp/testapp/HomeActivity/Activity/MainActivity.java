package com.project.solomode.testapp.testapp.HomeActivity.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SnapHelper;
import android.support.v7.widget.Toolbar;
import android.util.Log;

import com.project.solomode.testapp.testapp.ApiClient;
import com.project.solomode.testapp.testapp.ApiInterface;
import com.project.solomode.testapp.testapp.HomeActivity.Model.Instansi;
import com.project.solomode.testapp.testapp.HomeActivity.Adapter.MyAdapter;
import com.project.solomode.testapp.testapp.R;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableSingleObserver;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    ArrayList<Instansi> instansiList;
    RecyclerView recyclerView;
    Toolbar toolbar;
    MyAdapter mAdapter;
    CompositeDisposable compositeDisposable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        compositeDisposable = new CompositeDisposable();

        fletchData();

        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Instansi Today");

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView = findViewById(R.id.my_recycler);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
    }

    private void fletchData() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);

        compositeDisposable.add(apiService.getAllData("lat", "lng")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleResponse, this::errorResponse));
    }

    private void errorResponse(Throwable throwable) {

    }

    private void handleResponse(List<Instansi> instansis) {
        instansiList = (ArrayList<Instansi>) instansis;
        mAdapter = new MyAdapter(instansiList);
        recyclerView.setAdapter(mAdapter);
    }
}
