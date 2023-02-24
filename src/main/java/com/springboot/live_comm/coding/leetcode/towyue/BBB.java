package com.springboot.live_comm.coding.leetcode.towyue;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BBB implements ReviewService {
    @Override
    public List<ReviewForm> queryReviewForms(Integer poiId, Date begin, Date end, PageQuery pageQuery) {
        List<ReviewForm> list = new ArrayList();
        ReviewForm goodReviewForm = new ReviewForm();
        ReviewForm badReviewForm = new ReviewForm();

        List<Score> good = new ArrayList<>();
        Score score1 = new Score();
        score1.setStar(5);
        Score score2 = new Score();
        score2.setStar(4);
        good.add(score1);
        good.add(score2);
        goodReviewForm.setRecommend(1);
        goodReviewForm.setScores(good);

        List<Score> bad = new ArrayList<>();
        Score score3 = new Score();
        score3.setStar(1);
        Score score4 = new Score();
        score4.setStar(2);
        bad.add(score3);
        bad.add(score4);
        badReviewForm.setRecommend(3);
        badReviewForm.setScores(bad);
        for (int i = 0; i < 99; i++) {
            if ((i / 50) % 2 == 1) {
                list.add(goodReviewForm);
            } else {
                list.add(badReviewForm);
            }
        }
        return list;
    }

    @Override
    public Integer countReviewForms(Integer poiId, Date begin, Date end) {
        return 99;
    }

    //    完成calculateBadRate方法实现门店差评率统计（差评标准：评价表单的score平均得分<3星 或者 推荐值为强烈不推荐）

    /**
     * 统计门店差评率，差评标准：平均得分<3星 或者 推荐值为强烈不推荐
     *
     * @param poiId 门店ID
     * @param begin 开始时间
     * @param end   结束时间
     * @return 差评率
     */
    public Float calculateBadRate(ReviewService reviewService, Integer poiId, Date begin, Date end) {
//        先查询总数量
        Integer num = reviewService.countReviewForms(poiId, begin, end);
        if (num.equals(0)) {
//            若没有数据则直接返回
            return (float) 0;
        }

        //*******因题目未做出解释，那么认定pageQuery.setPageNo(0)有效，代表查询第一页，0-100
//        由于PageQuery的pageSize为100，所以按照100进行分页计算（加一是为了将超出整百的数据也统计进去）
        int count;
        if (num % 100 == 0) {
            count = (num / 100);
        } else {
            count = (num / 100) + 1;
        }
//        记录差评总数量
        int badEvaluate = 0;
//        按照一百为单位调用queryReviewForms方法获取结果
        for (int i = 0; i < count; i++) {
            PageQuery pageQuery = new PageQuery();
            //*******因题目未做出解释此处认定pageQuery.setPageNo(0)有效，代表查询第一页，0-100
            pageQuery.setPageNo(i);
//            获取第i+1页的结果i=0时查询第一页
            List<ReviewForm> reviewForms = reviewService.queryReviewForms(poiId, begin, end, pageQuery);
//           遍历每一页的结果找到结果为差评的评论
            for (ReviewForm reviewForm : reviewForms) {
                Integer bad = 3;//（3是强烈不推荐的）
//              由于是Integer为了，所以使用equals
                if (bad.equals(reviewForm.getRecommend())) {
//                    强烈不推荐(由于强烈不推荐计算少，所以先计算强烈不推荐的)
//                    （总差评数加一）
                    badEvaluate++;
                } else {
//                    然后判断平均分
                    List<Score> scores = reviewForm.getScores();
                    int countScore = 0;
                    for (Score score : scores) {
//                       获取各纬度评分总分
                        countScore = countScore + score.getStar();
                    }
//                    计算平均分（由于只需要与3比较所以直接使用int计算就行）
                    int size = countScore / (scores.size());
                    if (size < 3) {
//                        平均分小于三（总差评数加一）
                        badEvaluate++;
                    }
                }

            }

        }
//        转型总差评数
        Float flotBadEvaluate = (float) badEvaluate;
//        转型总评价数
        Float allNum = new Float(num);
//        计算结果（由于是差评率所以将结果改为百分比的值）
        Float res = (flotBadEvaluate / allNum) * 100F;
        return res;
    }

    public static void main(String[] args) {
        BBB bbb = new BBB();
        System.out.println(bbb.calculateBadRate(bbb, 1, new Date(), new Date()));
//        int num = 0;
//        for (int i = 0; i < 200; i++) {
//            if ((i / 50) % 2 == 1) {
//                System.out.println(i + "888888" + "好");
//            } else {
//                System.out.println(i + "666666" + "坏");
//                num++;
//            }
//        }
//        System.out.println(num);
    }
}
