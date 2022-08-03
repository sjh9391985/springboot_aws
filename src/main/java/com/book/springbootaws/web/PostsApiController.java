package com.book.springbootaws.web;

import com.book.springbootaws.service.posts.PostsService;
import com.book.springbootaws.web.dto.PostsSaveRequestsDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    /**
     * @Autowired를 사용하지 않은 이유
     * 스프링에선 Bean을 주입받는 방식들이 다음과 같음: @Autowired, setter, 생성자
     * 이 중 가장 권장하는 방식은 생성자로 주입받는 방식. (@Autowired는 권장하지 않음)
     *
     * 생성자로 Bean을 주입받게 된다면 @Autowired와 동일한 효과를 볼 수 있다는 것.
     * 생성자는 @RequiredArgsConstructor 에서 해결을 해줌.
     * final이 선언된 모든 필드를 인자값으로 하는 롬복의 @RequiredArgsConstructor이 대신 생성해준것.
     *
     * 생성자를 직접 안 쓰고 롬복 어노테이션을 사용한 이유: 해당 클래스의 의존성 관계가 변경될 때마다 생성자 코드를 계속해서 수정하는 번거로움을 해결하기 위함.
     *
     * @Autowired 를 권장하지 않는 이유: (참고) https://madplay.github.io/post/why-constructor-injection-is-better-than-field-injection \
     */

    private final PostsService postsService;


    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestsDto requestsDto){
        return postsService.save(requestsDto);
    }

}
