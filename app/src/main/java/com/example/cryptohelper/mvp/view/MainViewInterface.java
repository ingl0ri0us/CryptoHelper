package com.example.cryptohelper.mvp.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(value = AddToEndSingleStrategy.class)
public interface MainViewInterface extends MvpView {
    void displayError(String s);

    void showToast(String s);

    void init();

    void updateList();

//    void showLoading();
//    void hideLoading();
}
