package com.book.springbootaws.domain.posts;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PostsRepositoryTest {

    @Autowired
    PostsRepository postsRepository;

    @After // 1
    public void cleanup(){
        postsRepository.deleteAll();
    }

    @Test
    public void read_post(){

        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() // 2
                .title(title)
                .content(content)
                .author("sjh9391985@gmail.com")
                .build());

        List<Posts> postsList = postsRepository.findAll(); // 3

        Posts posts = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title);
        assertThat(posts.getContent()).isEqualTo(content);
    }
}

/**
 *
 * 1. @After
 * Junit에서 단위테스트가 끝날 때마다 수행되는 메소드를 지정
 * 보통 배포 전 전체 테스트를 수행할 때 테스트간 데이터 침범을 막기 위해 사용
 * 여러 테스트가 동시 수행되면 테스트용 DB와 H2에 데이터가 그대로 남아있어 다음 테스트 실행시 테스트 실패할 수 있음
 *
 * 2. @postsRepository.save()
 * 테이블 posts에 insert/update 쿼리를 수행
 * id값이 있다면 update, 없다면 insert 실행
 *
 * 3. postsRepository.findAll
 * 테이블 posts에 있는 모든 데이터를 조회해오는 메소드
 *
 */
