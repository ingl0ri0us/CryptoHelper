package com.example.cryptohelper.mvp.model.api;

import com.example.cryptohelper.mvp.model.api.coin_id_map.CoinIdMapResponse;
import com.example.cryptohelper.mvp.model.api.coin_info.CoinInfoResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CoinMarketCapEndpoints {
    @GET("v1/cryptocurrency/info")
    Single<CoinInfoResponse> getCoinInfo(@Header("X-CMC_PRO_API_KEY") String ApiKey,
                             @Query("id") String coinId);

    @GET("/v1/cryptocurrency/map")
    Single<CoinIdMapResponse> getIdMap(@Header("X-CMC_PRO_API_KEY") String ApiKey);

}
