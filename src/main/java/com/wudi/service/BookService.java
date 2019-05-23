package com.wudi.service;

import com.github.pagehelper.PageInfo;
import com.wudi.model.Book;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
public interface BookService {
    public PageInfo<Book> getAllBook(int pageNum, int pageSize);//获取所有的书
    public PageInfo<Book> selectByKeyword(int pageNum,int pageSize,String keyword);//关键词查询
    List<Book> recommendBooksBasedUser(int userID,int size);
    List<Book> recommendBooksBasedItem(int userID,int size);

}
