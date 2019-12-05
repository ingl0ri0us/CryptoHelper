package com.example.cryptohelper;

import com.example.cryptohelper.httpRequest.CoinMarketCapEndpoints;
import com.example.cryptohelper.httpRequest.CoinMarketCapRepo;
import com.example.cryptohelper.httpRequest.coinInfo.CoinInfoResponse;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

class MainPresenter implements MainPresenterInterface {

    private static final String ApiKey = "bc3489ce-f35c-429b-9671-ea67d57282fc";
    private MainViewInterface mvi;

    MainPresenter(MainViewInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getCoinInfo(String coinName) {
        getObservable(coinName).subscribeWith(getObserver());
    }

    private Observable<CoinInfoResponse> getObservable(String coinId) {
        return CoinMarketCapRepo
                .getRepo()
                .create(CoinMarketCapEndpoints.class)
                .loadCoinInfo(ApiKey, coinId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    private DisposableObserver<CoinInfoResponse> getObserver() {
        return new DisposableObserver<CoinInfoResponse>() {
            @Override
            public void onNext(CoinInfoResponse coinInfoResponse) {
                mvi.displayCoinInfo(coinInfoResponse);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        };
    }
}
