package com.example.cryptohelper.mvp.presenter;

import com.example.cryptohelper.mvp.view.FullCoinInfoViewInterface;

import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class FullCoinInfoPresenter extends MvpPresenter<FullCoinInfoViewInterface> {


//    @SuppressLint("CheckResult")
//    void loadCoin(String coinId) {
//        CoinRepo coinRepo = new CoinRepo();
//        coinRepo.getCoin(coinId)
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(coinInfoResponse -> {
//                    CoinResponseParser parser = new CoinResponseParser(coinInfoResponse);
//
//                    if (parser.getErrorCode() == 0) {
//                        getViewState().setCoinName(parser.getCoinName());
//                        getViewState().setCoinUrl(parser.getCoinUrl());
//                        getViewState().setCoinDescription(parser.getCoinDescription());
//                        Timber.d("Response successful, api credits used: %s", parser.getApiCreditsUsed());
//                    } else {
//                        Timber.e("Error code: %s. %s", parser.getErrorCode(), parser.getErrorMessage());
//                    }
//                }, throwable -> {
//
//                });
//
//    }
}
