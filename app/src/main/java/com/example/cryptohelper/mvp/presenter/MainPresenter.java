package com.example.cryptohelper.mvp.presenter;

import android.annotation.SuppressLint;

import com.example.cryptohelper.mvp.model.api.CoinRepo;
import com.example.cryptohelper.mvp.model.api.coin_id_map.CoinIdMapResponse;
import com.example.cryptohelper.mvp.model.api.coin_id_map.CoinIdMapResponseParser;
import com.example.cryptohelper.mvp.view.CoinCardView;
import com.example.cryptohelper.mvp.view.MainViewInterface;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Scheduler;
import io.reactivex.subjects.PublishSubject;
import moxy.InjectViewState;
import moxy.MvpPresenter;
import timber.log.Timber;

@InjectViewState
public class MainPresenter
        extends MvpPresenter<MainViewInterface> {

    class CoinsRecyclerViewPresenter implements CoinRecyclerViewPresenter {
        PublishSubject<CoinCardView> clickSubject = PublishSubject.create();
        List<CoinIdMapResponse.Data> coinsList = new ArrayList<>();

        @Override
        public void bind(CoinCardView cardView) {
            Timber.d("bind cardView");
            CoinIdMapResponse.Data coinInfo = coinsList.get(cardView.getPos());
            cardView.setCoinName(coinInfo.getName());
            cardView.setCoinRank(Integer.toString(coinInfo.getRank()));
        }

        @Override
        public int getCount() {
            return coinsList.size();
        }

        @Override
        public PublishSubject<CoinCardView> getClickSubject() {
            return clickSubject;
        }
    }

    private Scheduler mainThreadScheduler;
    private CoinRepo repo;
    private CoinsRecyclerViewPresenter coinRecyclerViewPresenter;

    public MainPresenter(Scheduler scheduler) {
        this.mainThreadScheduler = scheduler;
        this.repo = new CoinRepo();
        this.coinRecyclerViewPresenter = new CoinsRecyclerViewPresenter();
    }


    @SuppressWarnings("ResultOfMethodCallIgnored")
    @SuppressLint("CheckResult")
    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();

        getViewState().init();

        repo.getIdMap()
                .observeOn(mainThreadScheduler)
                .subscribe(coinIdMapResponse -> {
                            CoinIdMapResponseParser parser = new CoinIdMapResponseParser(coinIdMapResponse);
                            Timber.d("Data passed to parser");
                            coinRecyclerViewPresenter.coinsList.addAll(parser.getTopHundredSortedData());
                            getViewState().updateList();
                        }, Timber::e);

        coinRecyclerViewPresenter
                .getClickSubject()
                .subscribe(cardView -> {
            CoinIdMapResponse.Data coin = coinRecyclerViewPresenter.coinsList.get(cardView.getPos());
            getViewState().showToast(coin.getName());
        });
    }

    public CoinRecyclerViewPresenter getCoinRecyclerViewPresenter() {
        return coinRecyclerViewPresenter;
    }
}
