package com.book.springbootaws.web.dto;

import com.book.springbootaws.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 *
 * Entity 클래스와 유사한 형태임에도 Dto 클래스를 추가한것은
 * Entitu 클래스는 Request/Response 클래스로 사용해서는 안됨.
 *
 * Entity 클래스는 데이터베이스와 맞닿는 핵심 클래스이기에 이 클래스를 기준으로 테이블 생성 및 스키마가 변경됨.
 * Req/Res 용 Dto는 view를 위한 클래스라 자주 변경이 필요함.
 * 그러므로 view Layer와 DB Layer의 역할 분리는 철저하게 하는 것이 좋음.
 */

@Getter
@NoArgsConstructor
public class PostsSaveRequestsDto {

    private String title;
    private String content;
    private String author;

    @Builder
    public PostsSaveRequestsDto(String title, String content, String author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Posts toEntity() {
        return Posts.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
