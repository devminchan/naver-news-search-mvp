package com.syubsyubboy.daggerandknife.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class NewsResult {
    private String title;
    private String link;
    private String description;
    private String pubDate;
}
