package com.example.cryptohelper.httpRequest;

import com.example.cryptohelper.httpRequest.coinInfo.CoinInfoResponse;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface CoinMarketCapEndpoints {
    @GET("v1/cryptocurrency/info")
    Observable<CoinInfoResponse> loadCoinInfo(@Header("X-CMC_PRO_API_KEY") String ApiKey,
                                              @Query("id") String coinId);

}
