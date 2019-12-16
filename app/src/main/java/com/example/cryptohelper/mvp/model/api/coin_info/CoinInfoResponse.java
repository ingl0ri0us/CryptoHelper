package com.example.cryptohelper.mvp.model.api.coin_info;

import com.google.gson.annotations.SerializedName;


public class CoinInfoResponse {
    @SerializedName("status")
    Status status;
    @SerializedName("data")
    Data data;

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
    }

    class Data {
        @SerializedName(value = "1", alternate = {"52","1027"})
        CoinIdRestModel requestKey;

        class CoinIdRestModel {
            @SerializedName("urls")
            Urls urls;
            @SerializedName("platform")
            Platform platform;
            @SerializedName("id")
            int id;
            @SerializedName("name")
            String name;
            @SerializedName("symbol")
            String symbol;
            @SerializedName("category")
            String category;
            @SerializedName("slug")
            String slug;
            @SerializedName("logo")
            String logo;
            @SerializedName("description")
            String description;
            @SerializedName("date_added")
            String dateAdded;
            @SerializedName("notice")
            String notice;
            @SerializedName("tags")
            String[] tags;

            class Urls {
                @SerializedName("website")
                String[] website;
                @SerializedName("technical_doc")
                String[] technical_doc;
                @SerializedName("explorer")
                String[] explorer;
                @SerializedName("source_code")
                String[] source_code;
                @SerializedName("message_board")
                String[] message_board;
                @SerializedName("chat")
                String[] chat;
                @SerializedName("announcement")
                String[] announcement;
                @SerializedName("reddit")
                String[] reddit;
                @SerializedName("twitter")
                String[] twitter;
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
    }
}