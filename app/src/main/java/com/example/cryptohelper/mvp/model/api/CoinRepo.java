package com.example.cryptohelper.mvp.model.api;

import com.example.cryptohelper.mvp.model.api.coin_id_map.CoinIdMapResponse;
import com.example.cryptohelper.mvp.model.api.coin_info.CoinInfoResponse;

import io.reactivex.Single;
import io.reactivex.schedulers.Schedulers;

public class CoinRepo {
    private String apiKey = "bc3489ce-f35c-429b-9671-ea67d57282fc";

    public Single<CoinInfoResponse> getCoin(String coinId) {

        return CoinMarketCapApi
                .getApi()
                .getCoinInfo(apiKey, coinId)
                .subscribeOn(Schedulers.io());
    }

    public Single<CoinIdMapResponse> getIdMap() {

        return CoinMarketCapApi
                .getApi()
                .getIdMap(apiKey)
                .subscribeOn(Schedulers.io());
    }
}
