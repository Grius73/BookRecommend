package com.wudi.service;

import com.wudi.model.Book;
import com.wudi.model.BookAndClick;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
public interface ClickService {
    public List<Book> returnHotBook ();
    public List<BookAndClick> returnHotBooks();
    public void addClick(int bookid,int addsize);
}
