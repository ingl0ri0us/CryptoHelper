package com.example.cryptohelper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cryptohelper.httpRequest.coinInfo.CoinInfoParser;
import com.example.cryptohelper.httpRequest.coinInfo.CoinInfoResponse;

//import butterknife.BindView;
//import butterknife.ButterKnife;
//import butterknife.OnClick;

public class MainActivity extends AppCompatActivity implements MainViewInterface {

    Button btcButton, ethButton, xrpButton;
    TextView coinName, coinUrl, coinDescription;
    MainPresenterInterface mainPresenter;

//    @BindView(R.id.bitcoin_button)
//    Button btcButton;
//    @BindView(R.id.ethereum_button)
//    Button ethButton;
//    @BindView(R.id.ripple_button)
//    Button xrpButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
        initViews();
        initMVP();
        setButtonsBehaviour();
    }

//    @OnClick(R.id.bitcoin_button)
//    public void btcButtonClick() {
//        mainPresenter.getCoinInfo("bitcoin");
//    }

    private void initViews() {
        btcButton = findViewById(R.id.bitcoin_button);
        ethButton = findViewById(R.id.ethereum_button);
        xrpButton = findViewById(R.id.ripple_button);
        coinName = findViewById(R.id.coinName);
        coinUrl = findViewById(R.id.urlAddress);
        coinDescription = findViewById(R.id.coinDescription);
    }

    private void initMVP() {
        mainPresenter = new MainPresenter(this);
    }

    private void setButtonsBehaviour() {
        btcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.getCoinInfo("1");
            }
        });

        ethButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.getCoinInfo("1027");
            }
        });

        xrpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainPresenter.getCoinInfo("52");
            }
        });
    }

    @Override
    public void displayCoinInfo(CoinInfoResponse coinInfoResponse) {
        CoinInfoParser coinInfoParser = new CoinInfoParser(coinInfoResponse);
        coinName.setText(coinInfoParser.getCoinName());
        coinUrl.setText(coinInfoParser.getCoinUrl());
        coinDescription.setText(coinInfoParser.getCoinDescription());
    }
}
