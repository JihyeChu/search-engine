package com.peanut.searchengine.controller;

import com.peanut.searchengine.dto.req.ReqPostListDTO;
import com.peanut.searchengine.dto.res.ResPostListDTO;
import com.peanut.searchengine.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/search")
    public ResponseEntity<List<ResPostListDTO>> search(@RequestParam(required = false) String title,
                                                       @RequestParam(required = false) String content,
                                                       @RequestParam(required = false) String author,
                                                       @RequestParam(required = false) String serviceName){
        return ResponseEntity.ok().body(indexService.search(title, content, author, serviceName));
    }
}
