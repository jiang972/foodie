package com.jyx.service;

import com.jyx.pojo.Items;
import com.jyx.pojo.ItemsImg;
import com.jyx.pojo.ItemsParam;
import com.jyx.pojo.ItemsSpec;
import com.jyx.pojo.vo.CommentLevelCountsVO;
import com.jyx.pojo.vo.ItemCommentVO;
import com.jyx.utils.PagedGridResult;

import java.util.List;

public interface ItemService {

    /**
     * 根据商品ID查询详情
     * @param itemId
     * @return
     */
    Items queryItemById(String itemId);

    /**
     * 根据商品id查询商品图片列表
     * @param itemId
     * @return
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 根据商品id查询商品规格
     * @param itemId
     * @return
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 根据商品id查询商品参数
     * @param itemId
     * @return
     */
    ItemsParam queryItemParam(String itemId);

    /**
     * 根据商品id查询商品评价等级数量
     * @param itemId
     * @return
     */
    CommentLevelCountsVO queryCommentCounts(String itemId);

    /**
     * 根据商品id查询商品的评价（分页）
     * @param itemId
     * @param level
     * @return
     */
    PagedGridResult queryItemComments(String itemId, Integer level, Integer page, Integer pageSize);

}
