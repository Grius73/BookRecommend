package com.wudi.service.impl;

import com.wudi.mapper.BookMapper;
import com.wudi.mapper.ClickMapper;
import com.wudi.model.Book;
import com.wudi.model.BookAndClick;
import com.wudi.model.Click;
import com.wudi.service.ClickService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Service
public class ClickServiceImpl implements ClickService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    ClickMapper clickMapper;
    @Override
    public List<Book> returnHotBook() {
        List<Integer> bookids =clickMapper.returnHotBookid();
        return bookMapper.selectByList(bookids);
    }

    @Override
    public List<BookAndClick> returnHotBooks() {
       List<BookAndClick> books=clickMapper.returnHotBook();
       return books;
    }

    @Override
    public void addClick(int bookid, int addsize) {
        long size=clickMapper.selectByPrimaryKey(bookid).getSize()+addsize;
        Click click=new Click();
        click.setBookid(bookid);
        click.setSize(size);
        clickMapper.updateByPrimaryKeySelective(click);
    }
}
