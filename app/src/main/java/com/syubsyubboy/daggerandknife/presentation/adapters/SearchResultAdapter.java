package com.syubsyubboy.daggerandknife.presentation.adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.syubsyubboy.daggerandknife.R;
import com.syubsyubboy.daggerandknife.entities.NewsResult;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class SearchResultAdapter extends RecyclerView.Adapter<SearchResultViewHolder> {

    private Context context;

    private List<NewsResult> itemList;

    @Inject
    public SearchResultAdapter(Context context) {
        this.context = context;
        itemList = new ArrayList<>();
    }

    @NonNull
    @Override
    public SearchResultViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_search_result, viewGroup, false);
        SearchResultViewHolder holder = new SearchResultViewHolder(v);

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull SearchResultViewHolder searchResultViewHolder, int i) {
        NewsResult r = itemList.get(i);

        searchResultViewHolder.tvTitle.setText(r.getTitle());
        searchResultViewHolder.tvUrl.setText(r.getLink());
    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public void setItemList(List<NewsResult> list) {
        this.itemList = list;
    }
}
