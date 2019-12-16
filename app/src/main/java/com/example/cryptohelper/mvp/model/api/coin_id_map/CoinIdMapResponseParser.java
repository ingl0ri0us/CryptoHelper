package com.example.cryptohelper.mvp.model.api.coin_id_map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import timber.log.Timber;

public class CoinIdMapResponseParser {

    private CoinIdMapResponse.Data[] array;

    public CoinIdMapResponseParser(CoinIdMapResponse coinIdMapResponse) {
        this.array = coinIdMapResponse.data;
    }

    public ArrayList<CoinIdMapResponse.Data> getTopHundredSortedData() {
        Timber.d("Array sorting method");
        List<CoinIdMapResponse.Data> sortedData = Arrays.asList(array);
        Collections.sort(sortedData);
        Timber.d("data sorted");
        return new ArrayList<>(sortedData.subList(0, 99));
    }
}