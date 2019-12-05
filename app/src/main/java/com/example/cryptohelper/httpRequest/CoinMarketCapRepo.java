package com.example.cryptohelper.httpRequest;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class CoinMarketCapRepo {
    private static Retrofit repo;

    private CoinMarketCapRepo() {
    }

    public static Retrofit getRepo() {
        if (repo == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            OkHttpClient okHttpClient = builder.build();

            repo = new Retrofit
                    .Builder()
                    .baseUrl("https://pro-api.coinmarketcap.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return repo;
    }
}