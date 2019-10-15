package com.syubsyubboy.daggerandknife.presentation.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.syubsyubboy.daggerandknife.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SearchResultViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_url)
    TextView tvUrl;

    public SearchResultViewHolder(@NonNull View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }
}
