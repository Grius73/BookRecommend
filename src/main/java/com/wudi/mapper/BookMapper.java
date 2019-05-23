package com.wudi.mapper;

import com.wudi.model.Book;

import java.util.List;

public interface BookMapper {
    int deleteByPrimaryKey(Integer bookid);

    int insert(Book record);

    int insertSelective(Book record);

    Book selectByPrimaryKey(Integer bookid);

    int updateByPrimaryKeySelective(Book record);

    int updateByPrimaryKey(Book record);

    List<Book> selectByList(List<Integer> bookid);

    List<Book> selectByKeyWord (String keyword);//返回关键词

    List<Book> selectByAuthor(String author);//按作者查询

    List<Book> getAll();//返回所有的图书

    List<Book> selectByLongList(List<Long> bookid);

    List<Book> recommendByAuthor(String author);//按照作者推荐10本

}