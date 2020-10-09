package com.jyx.controller;


import com.jyx.enums.YesOrNo;
import com.jyx.pojo.Carousel;
import com.jyx.service.CarouselService;
import com.jyx.utils.JSONResult;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

@RequestMapping("index")
@Api(value = "首页",tags = {"首页展示的相关接口"})//swagger配置
@RestController
public class IndexController {

    final static Logger logger = LoggerFactory.getLogger(IndexController.class);

    @Autowired
    CarouselService carouselService;

    @ApiOperation(value = "获取首页轮播图列表",notes = "获取首页轮播图列表",httpMethod = "GET")
    @GetMapping("/carousel")
    public JSONResult carousel(){
        List<Carousel> carousels = carouselService.queryAll(YesOrNo.YES.type);
        return JSONResult.ok(carousels);
    }
}
