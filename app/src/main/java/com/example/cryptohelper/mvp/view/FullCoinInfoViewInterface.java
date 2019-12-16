package com.example.cryptohelper.mvp.view;

import moxy.MvpView;
import moxy.viewstate.strategy.AddToEndSingleStrategy;
import moxy.viewstate.strategy.StateStrategyType;

@StateStrategyType(AddToEndSingleStrategy.class)
public interface FullCoinInfoViewInterface
        extends MvpView {

    void setCoinName(String coinName);

    void setCoinUrl(String coinUrl);

    void setCoinDescription(String coinDescription);

    void setCoinThumbnail();

}
