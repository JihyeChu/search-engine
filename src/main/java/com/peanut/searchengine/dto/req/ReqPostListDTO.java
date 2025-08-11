package com.peanut.searchengine.dto.req;

import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
public class ReqPostListDTO {
    private Long id;
    private String title;
    private String content;
    private String nickname;
    private LocalDateTime createdAt;
}