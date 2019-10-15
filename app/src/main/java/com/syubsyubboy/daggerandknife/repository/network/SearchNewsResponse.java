package com.syubsyubboy.daggerandknife.repository.network;

import com.syubsyubboy.daggerandknife.entities.NewsResult;

import java.util.List;

import lombok.Data;

@Data
public class SearchNewsResponse {
    private int total;
    private int start;
    private int display;
    private List<NewsResult> items;
}
