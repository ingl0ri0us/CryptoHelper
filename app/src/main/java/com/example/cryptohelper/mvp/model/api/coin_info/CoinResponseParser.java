package com.example.cryptohelper.mvp.model.api.coin_info;


public class CoinResponseParser {

    private String coinName;
    private String coinUrl;
    private String coinDescription;
    private int apiCreditsUsed;
    private int errorCode;
    private String errorMessage;

    public CoinResponseParser(CoinInfoResponse coinInfoResponse) {
        coinName = coinInfoResponse.data.requestKey.name;
        coinUrl = coinInfoResponse.data.requestKey.urls.website[0];
        coinDescription = coinInfoResponse.data.requestKey.description;
        apiCreditsUsed = coinInfoResponse.status.credit_count;
        errorCode = coinInfoResponse.status.errorCode;
        errorMessage = coinInfoResponse.status.errorMessage;
    }

    public int getErrorCode() {
        return errorCode;
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

    public int getApiCreditsUsed() {
        return apiCreditsUsed;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}
