package com.book.springbootaws.web;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/*
* 1. RestController
* 컨트롤러를 JSON을 반환하는 컨트롤러로 만들어 줌.
* @ResponseBody를 각 메소드마다 선언했던것을 한번에 사용할 수 있도록 해줌.
* */
@RestController
public class HelloController {

    /*
    * 2. GetMapping
    * HTTP Method인 GET의 요청을 받을 수 있는 API를 만들어줌.
    * */
    @GetMapping("/hello")
    public String Hello(){
        return "hello";
    }
}
