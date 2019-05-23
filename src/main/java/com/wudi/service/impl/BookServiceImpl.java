package com.wudi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wudi.mapper.BookMapper;
import com.wudi.model.Book;
import com.wudi.recommend.BookRecommender;
import com.wudi.service.BookService;
import org.apache.mahout.cf.taste.common.TasteException;
import org.apache.mahout.cf.taste.recommender.Recommender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookRecommender bookRecommender;
    @Override
    public PageInfo<Book> getAllBook(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Book> books=bookMapper.getAll();
        return new PageInfo<>(books,5);
    }
    @Override
    public PageInfo<Book> selectByKeyword(int pageNum,int pageSize,String keyword){
        PageHelper.startPage( pageNum, pageSize);
        List<Book> books=bookMapper.selectByKeyWord(keyword);
        return new PageInfo<>(books,5);
    }

    @Override
    public List<Book> recommendBooksBasedUser(int userID, int size) {
        List<Long> recommendedItems=null;
        try {
            recommendedItems=bookRecommender.userBasedRecommender(new Integer(userID).longValue(),size);
        } catch (TasteException e) {
            e.printStackTrace();
        }
        if(!recommendedItems.isEmpty())
        return bookMapper.selectByLongList(recommendedItems);
        else return null;
    }

    @Override
    public List<Book> recommendBooksBasedItem(int userID, int size) {
        List<Long> recommendedItems=null;
        try {
            recommendedItems=bookRecommender.itemBasedRecommender(new Integer(userID).longValue(),size);
        } catch (TasteException e) {
            e.printStackTrace();
        }
        if(!recommendedItems.isEmpty())
        return bookMapper.selectByLongList(recommendedItems);
        else return null;
    }
}
