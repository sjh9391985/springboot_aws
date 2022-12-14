package com.book.springbootaws.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)  // 1
@WebMvcTest(controllers = HelloController.class) // 2
public class HelloControllerTest {

    @Autowired // 3
    private MockMvc mvc; // 4

    @Test
    public void hello_return() throws Exception{
        String hello = "hello";

        mvc.perform(get("/hello")) // 5
                .andExpect(status().isOk()) // 6
                .andExpect(content().string(hello)); // 7
    }

    @Test
    public void lombok_test() throws Exception{
        String name = "hello";
        int amount = 1000;

        mvc.perform(get("/hello/dto").param("name",name).param("amount", String.valueOf(amount))) // 8
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name))) // 9
                .andExpect(jsonPath("$.amount", is(amount)));
    }

}

/**
 * 1. RunWith(SpringRunner.class)
 * 테스트 진행시 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴
 * 스프링부트 테스트와 JUnit 사이에 연결자 역할을 함.
 *
 * 2. WebMvcTest
 * 여러 스프링 테스트 어노테이션 중, Web에 집중할 수 있는 어노테이션
 * 선언시 @Controller, @ControllerAdvice 등을 사용가능
 * 단, @Service, @Component, @Repository 등은 사용불가
 *
 * 3. Autowired
 * 스프링이 관리하는 빈을 주입받음
 *
 * 4. private MockMvc mvc
 * 웹 API를 테스트 할 경우 사용
 * 스프링 MVC 테스트의 시작점
 * 이 클래스를 통해 HTTP GET, POST 등에 대한 API 테스트를 할 수 있음
 *
 * 5. mvc.perform(get("/hello"))
 * MockMvc를 통해 /hello 주소로 HTTP GET 요청을 함.
 * 체이닝이 지원되어 여러 검증기능을 선언가능.
 *
 * 6. .andExpect(status().isOk())
 * mvc.perform의 결과를 검증
 * HTTP Header의 Status를 검증가능
 * 200, 404, 500 등의 상태를 점검
 *
 * 7. .andExpect(content().string(hello))
 * mvc.perform의 결과를 검증
 * Controller에서 "hello"를 리턴하기에 이 값이 맞는지 검증.
 *
 * 8. param
 * API 테스트할 때 사용될 요청 파라미터를 설정
 * 값은 String만 허용가능
 * 숫자, 날짜 등의 데이터는 등록시 문자열로 변경해야함
 *
 * 9. jsonPath
 * JSON 응답값을 필드별로 검증할 수 있는 메소드
 * $를 기준으로 필드명을 명시
 * name, amount를 검증하기에 $name, $amount로 검증
 */

