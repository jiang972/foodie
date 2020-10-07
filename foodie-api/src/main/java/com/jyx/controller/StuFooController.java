package com.jyx.controller;

import com.jyx.pojo.Stu;
import com.jyx.service.StuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StuFooController {

    @Autowired
    StuService stuService;

    @GetMapping("/getStu")
    public Stu helloWorld(int id){
        return stuService.getStuInfo(id);
    }
}
