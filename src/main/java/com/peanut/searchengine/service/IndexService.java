package com.peanut.searchengine.service;

import com.peanut.searchengine.dto.req.ReqPostListDTO;
import com.peanut.searchengine.model.SearchDocument;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
public class IndexService {

    private final Map<Long, SearchDocument> indexStore = new ConcurrentHashMap<>();

    public void index(List<ReqPostListDTO> dtoList) {
        List<SearchDocument> documentList = dtoList.stream()
                .map(dto -> SearchDocument.builder()
                        .id(dto.getId())
                        .serviceName("newsfeed")
                        .title(dto.getTitle())
                        .content(dto.getContent())
                        .author(dto.getNickname())
                        .createdAt(dto.getCreatedAt())
                        .build())
                .toList();

        for (SearchDocument document : documentList) {
            indexStore.put(document.getId(), document);
        }
    }
}

