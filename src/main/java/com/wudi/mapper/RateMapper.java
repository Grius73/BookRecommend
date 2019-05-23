package com.wudi.mapper;

import com.wudi.model.Rate;
import com.wudi.model.RateKey;

import java.util.List;

public interface RateMapper {
    int deleteByPrimaryKey(RateKey key);

    int insert(Rate record);

    int insertSelective(Rate record);

    Rate selectByPrimaryKey(RateKey key);

    int updateByPrimaryKeySelective(Rate record);

    int updateByPrimaryKey(Rate record);

    List<Rate> selectByUserid(int userid);

    List<Rate> selectByBookid(int bookid);

    List<Rate> getAll();

    List<Integer> getRelateUserid(int userid);//返回相关用户id

    List<Integer> getRelatedBookid(List<Integer> userids);//返回相关书籍id

    int rateSizeByUserid(int userid);//返回该用户的评论条数

    int sameBookByUserid(int userid1,int userid2);//寻找两个用户的相同书籍本数

    float avgScore (int bookid);//返回书籍平均分数

    int rateNum(int bookid);//返回书籍评分人数

}