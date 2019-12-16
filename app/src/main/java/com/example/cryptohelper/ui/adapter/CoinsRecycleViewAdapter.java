package com.example.cryptohelper.ui.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptohelper.R;
import com.example.cryptohelper.mvp.presenter.CoinRecyclerViewPresenter;
import com.example.cryptohelper.mvp.view.CoinCardView;
import com.jakewharton.rxbinding3.view.RxView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CoinsRecycleViewAdapter extends RecyclerView.Adapter<CoinsRecycleViewAdapter.ViewHolder> {

    private CoinRecyclerViewPresenter presenter;

    public CoinsRecycleViewAdapter(CoinRecyclerViewPresenter presenter) {
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater
                .from(parent.getContext()).inflate(R.layout.coin_card_view, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.pos = position;
        presenter.bind(holder);
        RxView
                .clicks(holder.itemView)
                .map(o -> holder)
                .subscribe(presenter.getClickSubject());
    }

    @Override
    public int getItemCount() {
        return presenter.getCount();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements CoinCardView {
        int pos = 0;

        @BindView(R.id.coin_name)
        TextView coinNameCardView;
        @BindView(R.id.coin_rank)
        TextView coinRankCardView;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        public int getPos() {
            return pos;
        }

        @Override
        public void setCoinName(String coinName) {
            coinNameCardView.setText(coinName);
        }

        @Override
        public void setCoinRank(String coinRank) {
            coinRankCardView.setText(coinRank);
        }
    }
}
