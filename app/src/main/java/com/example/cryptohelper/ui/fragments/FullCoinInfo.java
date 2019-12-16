package com.example.cryptohelper.ui.fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.cryptohelper.R;
import com.example.cryptohelper.mvp.view.FullCoinInfoViewInterface;

import moxy.InjectViewState;
import moxy.MvpAppCompatFragment;
import moxy.MvpFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class FullCoinInfo extends MvpAppCompatFragment implements FullCoinInfoViewInterface {

//    @BindView(R.id.coinName)
//    TextView coinName;
//    @BindView(R.id.urlAddress)
//    TextView coinUrl;
//    @BindView(R.id.coinDescription)
//    TextView coinDescription;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_full_coin_info, container, false);
    }

    @Override
    public void setCoinName(String coinName) {

    }

    @Override
    public void setCoinUrl(String coinUrl) {

    }

    @Override
    public void setCoinDescription(String coinDescription) {

    }

    @Override
    public void setCoinThumbnail() {

    }
}
