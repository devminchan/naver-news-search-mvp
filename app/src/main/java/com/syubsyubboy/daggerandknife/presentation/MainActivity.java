package com.syubsyubboy.daggerandknife.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.syubsyubboy.daggerandknife.contracts.MainActivityContract;
import com.syubsyubboy.daggerandknife.R;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button)
    Button button;

    @Inject
    MainActivityContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        presenter.initData();
    }

    @Override
    public void onDataChanged(String data) {
        textView.setText(data);
    }
}
