package com.jyx.mapper;

import com.jyx.my.mapper.MyMapper;
import com.jyx.pojo.Category;
import com.jyx.pojo.vo.CategoryVO;

import java.util.List;

public interface CategoryMapperCustom  {

     List<CategoryVO> getSubCatList(Integer rootCatId);
}