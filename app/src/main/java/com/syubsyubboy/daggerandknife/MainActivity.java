package com.syubsyubboy.daggerandknife;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.Lazy;
import dagger.android.DaggerActivity_MembersInjector;

public class MainActivity extends AppCompatActivity implements MainPresenter.View {

    @Inject
    SharedPreferences sharedPreferences;

    @BindView(R.id.textView)
    TextView textView;
    @BindView(R.id.button)
    Button button;

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        ((MyApp) getApplication()).getComponents().inject(this);

        sharedPreferences.edit().putString("greeting", "hi").apply();

        String greeting = sharedPreferences.getString("greeting", "fu");
        textView.setText(greeting);

        presenter = new MainPresenterImpl(this);
        presenter.initData();
    }

    @Override
    public void setItemData(String data) {
        textView.setText(data);
    }
}
