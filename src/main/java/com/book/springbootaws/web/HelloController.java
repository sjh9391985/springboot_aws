package com.book.springbootaws.web;

import com.book.springbootaws.web.dto.HelloResponseDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/*
* 1. RestController
* 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줌.
* @ResponseBody를 각 메소드마다 선언했던것을 한번에 사용할 수 있도록 해줌.
* */
@RestController
public class HelloController {

    /**
     * 2. GetMapping
     * HTTP Method인 GET의 요청을 받을 수 있는 API를 만들어줌.
     *
     * @RequestParam
     * 외부에서 API로 넘긴 파라미터를 가져오는 어노테이션
     * 여기서는 외부에서 name이란 이름으로 넘긴 파라미터를 메소드 파라미터 name에 저장하게 됨.
     */

    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }

    @GetMapping("/hello/dto")
    public HelloResponseDto helloDto(@RequestParam("name") String name, @RequestParam("amount") int amount){
        return new HelloResponseDto(name, amount);
    }
}
