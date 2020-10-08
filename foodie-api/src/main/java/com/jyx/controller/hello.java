package com.jyx.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore  //swagger忽略
@RestController
public class hello {

    @GetMapping("/hello")
    public String helloWorld(){
        return "helloWorld";
    }
}
