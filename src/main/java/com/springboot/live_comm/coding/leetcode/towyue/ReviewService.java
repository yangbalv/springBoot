package com.springboot.live_comm.coding.leetcode.towyue;

import java.util.Date;
import java.util.List;

/**
 * 评价服务接口
 */
public interface ReviewService {
    /**
     * 分页查询评价表单详情
     * @param poiId
     * @param begin
     * @param end
     * @return
     */
    List<ReviewForm> queryReviewForms(Integer poiId, Date begin, Date end, PageQuery pageQuery);

    /**
     * 计算时间周期内的某门店的评价总数量
     * @param poiId
     * @param begin 开始时间
     * @param end 结束时间
     * @return
     */
    Integer countReviewForms(Integer poiId, Date begin, Date end);
}