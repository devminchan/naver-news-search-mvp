package com.syubsyubboy.daggerandknife.presentation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;

import com.syubsyubboy.daggerandknife.contracts.MainActivityContract;
import com.syubsyubboy.daggerandknife.R;
import com.syubsyubboy.daggerandknife.entities.NewsResult;
import com.syubsyubboy.daggerandknife.presentation.adapters.SearchResultAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import dagger.android.AndroidInjection;

public class MainActivity extends AppCompatActivity implements MainActivityContract.View {

    @Inject
    MainActivityContract.Presenter presenter;
    SearchResultAdapter adapter;
    @BindView(R.id.recycler_view)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        AndroidInjection.inject(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
        initAdaptersAndListeners();
    }

    private void initComponents() {
        // findViewById 대체
        ButterKnife.bind(this);
        initActionBar();
    }

    private void initActionBar() {
        setSupportActionBar(toolbar);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_activity_main, menu);

        searchView = (SearchView) menu.findItem(R.id.app_bar_search).getActionView();
        searchView.setMaxWidth(Integer.MAX_VALUE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                presenter.searchNews(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });

        return true;
    }

    private void initAdaptersAndListeners() {
        adapter = new SearchResultAdapter(this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onNewsResultUpdated(List<NewsResult> results) {
        adapter.setItemList(results);
        adapter.notifyDataSetChanged();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter.dispose();
    }
}
