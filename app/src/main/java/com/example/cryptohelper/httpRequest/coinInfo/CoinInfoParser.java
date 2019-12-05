package com.example.cryptohelper.httpRequest.coinInfo;


public class CoinInfoParser {

    private String coinName;
    private String coinUrl;
    private String coinDescription;

    public CoinInfoParser(CoinInfoResponse coinInfoResponse) {
        coinName = coinInfoResponse.data.requestKey.name;
        coinUrl = coinInfoResponse.data.requestKey.urls.website[0];
        coinDescription = coinInfoResponse.data.requestKey.description;
    }

    public String getCoinName() {
        return coinName;
    }

    public String getCoinUrl() {
        return coinUrl;
    }

    public String getCoinDescription() {
        return coinDescription;
    }
}
