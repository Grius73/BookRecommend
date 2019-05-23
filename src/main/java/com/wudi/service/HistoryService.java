package com.wudi.service;

import com.github.pagehelper.PageInfo;
import com.wudi.model.Book;
import com.wudi.model.HistoryKey;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
public interface HistoryService {
    List<Book> queryBookByHistory(int userid);
    int deleteByPrimary(HistoryKey historyKey);
    int addHistory(HistoryKey historyKey);
    PageInfo<HistoryKey> returnAll(int pageNum,int pageSize);
    int countRecords(int bookid,int userid);
}
