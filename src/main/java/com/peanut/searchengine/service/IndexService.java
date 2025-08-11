package com.peanut.searchengine.service;

import com.peanut.searchengine.dto.req.ReqPostListDTO;
import com.peanut.searchengine.dto.res.ResPostListDTO;
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

    public List<ResPostListDTO> search(String title, String content, String author, String serviceName) {

        return indexStore.values().stream()
                .filter(doc -> serviceName == null || doc.getServiceName().equalsIgnoreCase(serviceName))
                .filter(doc -> title == null || doc.getTitle().toLowerCase().contains(title.toLowerCase()))
                .filter(doc -> content == null || doc.getContent().toLowerCase().contains(content.toLowerCase()))
                .filter(doc -> author == null || doc.getAuthor().toLowerCase().contains(author.toLowerCase()))
                .map(doc -> ResPostListDTO.builder()
                        .id(doc.getId())
                        .title(doc.getTitle())
                        .content(doc.getContent())
                        .nickname(doc.getAuthor())
                        .build())
                .toList();
    }
}

