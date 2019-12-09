package com.example.cryptohelper;

import com.example.cryptohelper.httpRequest.coinInfo.CoinInfoResponse;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndSingleStrategy.class)
interface MainViewInterface extends MvpView {
    void displayCoinInfo(CoinInfoResponse coinInfoResponse);
    void displayError(String s);
    void showToast(String s);
}
