package com.jyx.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore  //swagger忽略
@RestController
public class hello {

    final static Logger logger = LoggerFactory.getLogger(hello.class);
    @GetMapping("/hello")
    public String helloWorld(){
        logger.info("hello");
        return "helloWorld";
    }
}
