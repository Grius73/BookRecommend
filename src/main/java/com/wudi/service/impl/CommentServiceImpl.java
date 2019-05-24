package com.wudi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wudi.mapper.CommentMapper;
import com.wudi.model.Book;
import com.wudi.model.Comment;
import com.wudi.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentMapper commentMapper;
    @Override
    public void insertComment(String content, int bookid, int userid) {
        Comment comment = new Comment();
        comment.setUserid(userid);
        comment.setBookid(bookid);
        comment.setContent(content);
        comment.setDatetime(new Date());
        commentMapper.insert(comment);
    }

    @Override
    public List<Comment> returnCommentBybkid(int bookid) {
        return commentMapper.selectByPrimaryKey(bookid);
    }

    @Override
    public PageInfo<Comment> returnCommentByuserid(int pageNum,int pageSize,int userid) {
        PageHelper.startPage(pageNum,pageSize);
        List<Comment> comments=commentMapper.selectByUserid(userid);
        return new PageInfo<>(comments,5);
    }

    @Override
    public void deleteComment(Comment comment) {
        commentMapper.delectByRecord(comment);
    }

    @Override
    public void deleteCommentByTwi(int bookid, int userid) {
        Comment comment=new Comment();
        comment.setBookid(bookid);
        comment.setUserid(userid);
        commentMapper.delectByRecord(comment);
    }
}
