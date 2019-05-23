package com.wudi.mapper;

import com.wudi.model.Usermsg;

public interface UsermsgMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Usermsg record);

    int insertSelective(Usermsg record);

    Usermsg selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Usermsg record);

    int updateByPrimaryKey(Usermsg record);
}