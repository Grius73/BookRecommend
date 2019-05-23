package com.wudi.mapper;

import com.wudi.model.HistoryKey;

import java.util.List;

public interface HistoryMapper {
    int deleteByPrimaryKey(HistoryKey key);

    int insert(HistoryKey record);

    int insertSelective(HistoryKey record);

    List<Integer> queryBookidByUserid(Integer userid);//返回该用户的收藏的书籍id

    Integer countByPrimaryKey(HistoryKey record);

    List<HistoryKey> getAll();//返回所有收藏

}