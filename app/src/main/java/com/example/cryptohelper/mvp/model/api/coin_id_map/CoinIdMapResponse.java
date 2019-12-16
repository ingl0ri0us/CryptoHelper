package com.example.cryptohelper.mvp.model.api.coin_id_map;

import com.google.gson.annotations.SerializedName;

public class CoinIdMapResponse {
    @SerializedName("status")
    Status status;
    @SerializedName("data")
    Data[] data;

    class Status {
        @SerializedName("timestamp")
        String timestamp;
        @SerializedName("error_code")
        int errorCode;
        @SerializedName("error_message")
        String errorMessage;
        @SerializedName("elapsed")
        int elapsed;
        @SerializedName("credit_count")
        int credit_count;
        @SerializedName("notice")
        String notice;
    }

    public class Data implements Comparable<Data> {
        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
        @SerializedName("symbol")
        String symbol;
        @SerializedName("slug")
        String slug;
        @SerializedName("is_active")
        int isActive;
        @SerializedName("rank")
        int rank;
        @SerializedName("first_historical_data")
        String firstHistoricalData;
        @SerializedName("last_historical_data")
        String lastHistoricalData;
        @SerializedName("platform")
        Platform platform;

        public String getName() {
            return name;
        }

        public int getRank() {
            return rank;
        }

        @Override
        public int compareTo(Data compareWhat) {
            return this.rank - compareWhat.getRank();
        }
    }

    class Platform {
        @SerializedName("id")
        int id;
        @SerializedName("name")
        String name;
        @SerializedName("symbol")
        String symbol;
        @SerializedName("slug")
        String slug;
        @SerializedName("token_address")
        String token_address;
    }
}
