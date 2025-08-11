package com.peanut.searchengine.controller;

import com.peanut.searchengine.dto.req.ReqPostListDTO;
import com.peanut.searchengine.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class IndexController {

    private final IndexService indexService;

    @PostMapping("/index")
    public ResponseEntity<Void> index(@RequestBody List<ReqPostListDTO> dtoList) {
        indexService.index(dtoList);
        return ResponseEntity.ok().build();
    }
}
