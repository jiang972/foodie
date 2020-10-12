package com.jyx.mapper;

import com.jyx.my.mapper.MyMapper;
import com.jyx.pojo.Category;
import com.jyx.pojo.vo.CategoryVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CategoryMapperCustom  {

     List<CategoryVO> getSubCatList(Integer rootCatId);

     List getSixNewItemsLazy(@Param("paramsMap") Map<String,Object> map);
}