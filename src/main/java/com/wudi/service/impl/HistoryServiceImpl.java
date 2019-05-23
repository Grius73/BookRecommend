package com.wudi.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wudi.mapper.BookMapper;
import com.wudi.mapper.HistoryMapper;
import com.wudi.model.Book;
import com.wudi.model.HistoryKey;
import com.wudi.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Service
public class HistoryServiceImpl implements HistoryService {
    @Autowired
    HistoryMapper historyMapper;
    @Autowired
    BookMapper bookMapper;
    @Override
    public List<Book> queryBookByHistory(int userid) {
        List<Integer> historyKeys=historyMapper.queryBookidByUserid(userid);
        List<Book> books=bookMapper.selectByList(historyKeys);
        return books;
    }

    @Override
    public int deleteByPrimary(HistoryKey historyKey) {
        return historyMapper.deleteByPrimaryKey(historyKey);
    }

    @Override
    public int addHistory(HistoryKey historyKey) {
        return historyMapper.insert(historyKey);
    }

    @Override
    public PageInfo<HistoryKey> returnAll(int pageNum, int pageSize) {
        PageHelper.startPage( pageNum, pageSize);
        List<HistoryKey> historyKeys=historyMapper.getAll();
        return new PageInfo<>(historyKeys,5);
    }

    @Override
    public int countRecords(int bookid, int userid) {
        HistoryKey historyKey=new HistoryKey();
        historyKey.setUserid(userid);
        historyKey.setBookid(bookid);
        return historyMapper.countByPrimaryKey(historyKey);
    }
}
