package com.jyx.service;

import com.jyx.pojo.Category;
import com.jyx.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryService {
    /**
     * 查询全部分类
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据一级分类id查询子分类
     * @param rootCatId
     * @return
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);
}
