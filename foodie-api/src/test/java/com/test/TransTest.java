package com.test;


import com.jyx.Application;
import com.jyx.service.StuService;
import com.jyx.service.TestTransService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

//@RunWith(SpringRunner.class)
//@SpringBootTest(classes = Application.class)
public class TransTest {

    @Autowired
    StuService stuService;

    @Autowired
    TestTransService testTransService;

    //@Test
    public void test(){
        testTransService.testPropagationTrans();
    }
}
