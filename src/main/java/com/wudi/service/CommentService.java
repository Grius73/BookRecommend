package com.wudi.service;

import com.github.pagehelper.PageInfo;
import com.wudi.model.Comment;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
public interface CommentService {
    public void insertComment(String content,int bookid,int userid);//插入数据
    public List<Comment> returnCommentBybkid (int bookid);//返回该book的的评论
    public PageInfo<Comment> returnCommentByuserid(int pageNum,int pageSize,int userid);//返回该用户的所有评论
    public void deleteComment(Comment comment);//按记录删除
    public void deleteCommentByTwi(int bookid,int userid);
}
