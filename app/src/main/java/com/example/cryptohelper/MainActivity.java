package com.example.cryptohelper;


import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cryptohelper.httpRequest.coinInfo.CoinInfoParser;
import com.example.cryptohelper.httpRequest.coinInfo.CoinInfoResponse;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import timber.log.Timber;

public class MainActivity extends MvpAppCompatActivity implements MainViewInterface {

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.bitcoin_button)
    Button btcButton;
    @BindView(R.id.ethereum_button)
    Button ethButton;
    @BindView(R.id.ripple_button)
    Button xrpButton;
    @BindView(R.id.coinName)
    TextView coinName;
    @BindView(R.id.urlAddress)
    TextView coinUrl;
    @BindView(R.id.coinDescription)
    TextView coinDescription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.bitcoin_button)
    public void btcButtonClick() {
        mainPresenter.getCoinInfo("1");
    }
    @OnClick(R.id.ethereum_button)
    public void ethButtonClick() {
        mainPresenter.getCoinInfo("1027");
    }
    @OnClick(R.id.ripple_button)
    public void xrpButtonClick() {
        mainPresenter.getCoinInfo("52");
    }

    @Override
    public void displayCoinInfo(CoinInfoResponse coinInfoResponse) {
        if (coinInfoResponse != null) {
            CoinInfoParser coinInfoParser = new CoinInfoParser(coinInfoResponse);
            if (coinInfoParser.getErrorCode() == 0) {
                coinName.setText(coinInfoParser.getCoinName());
                coinUrl.setText(coinInfoParser.getCoinUrl());
                coinDescription.setText(coinInfoParser.getCoinDescription());
                Timber.d("Response successful, api credits used: %s", coinInfoParser.getApiCreditsUsed());
            } else {
                Timber.e("Error code: %s. %s", coinInfoParser.getErrorCode(), coinInfoParser.getErrorMessage());
            }

        } else {
            Timber.e("Coin info response is null");
        }
    }

    @Override
    public void displayError(String s) {
        showToast(s);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
    }
}
