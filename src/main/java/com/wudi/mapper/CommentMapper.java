package com.wudi.mapper;

import com.wudi.model.Comment;

import java.util.List;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer bookid);

    int insert(Comment record);

    int insertSelective(Comment record);

    List<Comment> selectByPrimaryKey(Integer bookid);

    List<Comment> selectByUserid(Integer userid);

    int updateByPrimaryKeySelective(Comment record);

    int updateByPrimaryKeyWithBLOBs(Comment record);

    int updateByPrimaryKey(Comment record);

    int delectByRecord(Comment record);

    int deleteBytwId(int bookid, int userid);
}