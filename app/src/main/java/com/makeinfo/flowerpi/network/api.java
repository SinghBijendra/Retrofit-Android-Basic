package com.makeinfo.flowerpi.network;
import com.makeinfo.flowerpi.model.Flower;

import java.util.List;

import retrofit.Callback;
import retrofit.http.GET;

/**
 * Created by ojas on 27/7/15.
 */
public interface api {
    @GET("/feeds/flowers.json")
    public void getData(Callback<List<Flower>> response);

}
