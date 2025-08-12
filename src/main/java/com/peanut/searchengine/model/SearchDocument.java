package com.peanut.searchengine.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchDocument {

    private Long id;
    private String serviceName;
    private String title;
    private String content;
    private String author;
    private LocalDateTime createdAt;
    private Boolean isDeleted;

}

