package com.wudi.mapper;

import com.wudi.model.BookAndClick;
import com.wudi.model.Click;

import java.util.List;

public interface ClickMapper {
    int deleteByPrimaryKey(Integer bookid);

    int insert(Click record);

    int insertSelective(Click record);

    Click selectByPrimaryKey(Integer bookid);

    int updateByPrimaryKeySelective(Click record);

    int updateByPrimaryKey(Click record);

    List<Integer> returnHotBookid ();//返回热门书籍的id

    List<BookAndClick> returnHotBook();//返回热门书籍的点击量

}