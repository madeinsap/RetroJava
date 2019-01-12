package com.project.solomode.testapp.testapp;

import com.project.solomode.testapp.testapp.HomeActivity.Model.Instansi;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("data/haverslineKelurahan.php")
    Observable<List<Instansi>> getAllData(@Query("lat") String lat, @Query("lng") String lng);

}
