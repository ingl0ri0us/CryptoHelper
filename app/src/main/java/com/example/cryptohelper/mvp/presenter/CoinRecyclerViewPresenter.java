package com.example.cryptohelper.mvp.presenter;

import com.example.cryptohelper.mvp.view.CoinCardView;

import io.reactivex.subjects.PublishSubject;

public interface CoinRecyclerViewPresenter {
    void bind(CoinCardView cardView);
    int getCount();
    PublishSubject<CoinCardView> getClickSubject();
}
