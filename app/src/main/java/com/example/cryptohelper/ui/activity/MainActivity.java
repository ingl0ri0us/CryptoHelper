package com.example.cryptohelper.ui.activity;


import android.os.Bundle;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cryptohelper.R;
import com.example.cryptohelper.mvp.presenter.MainPresenter;
import com.example.cryptohelper.mvp.view.MainViewInterface;
import com.example.cryptohelper.ui.adapter.CoinsRecycleViewAdapter;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;
import timber.log.Timber;

public class MainActivity extends MvpAppCompatActivity implements MainViewInterface {

    @InjectPresenter
    MainPresenter mainPresenter;

    @BindView(R.id.recyclerView_coinName_with_rank)
    RecyclerView recyclerView;

    CoinsRecycleViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @ProvidePresenter
    public MainPresenter createPresenter() {
        return new MainPresenter(AndroidSchedulers.mainThread());
    }

    @Override
    public void displayError(String s) {
        showToast(s);
    }

    @Override
    public void showToast(String s) {
        Toast.makeText(MainActivity.this, s, Toast.LENGTH_LONG).show();
    }

    @Override
    public void init() {
        Timber.d("init method");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new CoinsRecycleViewAdapter(mainPresenter.getCoinRecyclerViewPresenter());
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateList() {
        Timber.d("Update list method");
        adapter.notifyDataSetChanged();
    }
}
