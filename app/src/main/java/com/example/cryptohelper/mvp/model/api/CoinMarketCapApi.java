package com.example.cryptohelper.mvp.model.api;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinMarketCapApi {
    private static CoinMarketCapApi instance = new CoinMarketCapApi();

    public static CoinMarketCapApi getInstance() {
        if(instance == null) {
            instance = new CoinMarketCapApi();
        }
        return instance;
    }

    private CoinMarketCapEndpoints api;

    private CoinMarketCapApi() {
        api = new Retrofit
                .Builder()
                .baseUrl("https://pro-api.coinmarketcap.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(CoinMarketCapEndpoints.class);
    }

    public static CoinMarketCapEndpoints getApi() {
        return instance.api;
    }
}