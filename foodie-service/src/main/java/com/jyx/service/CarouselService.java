package com.jyx.service;


import com.jyx.pojo.Carousel;

import java.util.List;

public interface CarouselService {
    /**
     * 查询全部轮播图
     */
    List<Carousel> queryAll(Integer isShow);
}
