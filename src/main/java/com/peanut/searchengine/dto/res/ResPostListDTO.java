package com.peanut.searchengine.dto.res;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResPostListDTO {

    private Long id;
    private String title;
    private String content;
    private String nickname;
    private LocalDateTime createdAt;

}