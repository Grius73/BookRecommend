package com.wudi.service;

import com.github.pagehelper.PageInfo;
import com.wudi.model.Rate;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
public interface RateService {
    PageInfo<Rate> returnAllRate(int pageNum,int pageSize);//返回所有评分
    int isRecordExist (int userid,int bookid);//判断评分是否存在
    Rate returnRate(int userid,int bookid);//返回某人对某书籍的具体评分
    float returnAvgScore(int bookid);//返回平均分数
    int returnRateNum(int bookid);//返回书籍评分人数
}
