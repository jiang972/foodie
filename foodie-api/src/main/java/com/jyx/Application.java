package com.jyx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.jyx.mapper")
@ComponentScan(basePackages = {"com.jyx","org.n3r.idworker"})
@EnableScheduling //开启定时
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class,args);
    }
}
