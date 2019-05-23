package com.wudi.controller;

import com.github.pagehelper.PageInfo;
import com.wudi.mapper.BookMapper;
import com.wudi.mapper.ClickMapper;
import com.wudi.mapper.RateMapper;
import com.wudi.model.*;
import com.wudi.service.BookService;
import com.wudi.service.ClickService;
import com.wudi.service.HistoryService;
import com.wudi.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Controller
public class IndexController {
    @Autowired
    ClickService clickService;
    @Autowired
    ClickMapper clickMapper;
    @Autowired
    BookMapper bookMapper;
    @Autowired
    BookService bookService;
    @Autowired
    HistoryService historyService;
    @Autowired
    RateService rateService;
    @Autowired
    RateMapper rateMapper;

    @GetMapping("/main")
    public String list(Model model, HttpSession session) {

        List<BookAndClick> hotBooks = clickService.returnHotBooks();
        model.addAttribute("hotbooks", hotBooks);

        Integer userid = (Integer) session.getAttribute("loginUserid");
        if (userid != null) {
            List<Book> cfbooks = bookService.recommendBooksBasedItem(userid, 12);
            model.addAttribute("cfbooks", cfbooks);
        }

        return "main";
    }

    @GetMapping("/main/{bookid}")//前往图书详情页
    public String toBookdetail(@PathVariable("bookid") Integer bookid, Model model,HttpSession session) {

        clickService.addClick(bookid,1);//添加点击量

        float avgScore =rateService.returnAvgScore(bookid);//返回平均分数
        model.addAttribute("avgScore",avgScore);
        int rateNum =rateService.returnRateNum(bookid);//返回评分人数
        model.addAttribute("rateNum",rateNum);

        Book book = bookMapper.selectByPrimaryKey(bookid);
        model.addAttribute("bookdetail", book);//查找具体书籍详细

        Integer userid = (Integer) session.getAttribute("loginUserid");//导入用户id
        List<Book> books = bookMapper.recommendByAuthor(book.getAuthor());
        model.addAttribute("cfbooks", books);//按作者推荐书籍

        if(userid != null){
            int isHistory = historyService.countRecords(bookid,userid);
            session.setAttribute("isHistory",isHistory);//用户是否收藏
            Rate isRate = rateService.returnRate(userid,bookid);
            if(isRate!=null){//用户是否评分
            model.addAttribute("isRate",isRate);}
        }
        return "bookdetail";
    }

    @GetMapping("/search")
    public String searchBooksList(@RequestParam(required = false, defaultValue = "as") String keyword,
                                  @RequestParam(required = false, defaultValue = "1") Integer pageNum,
                                  @RequestParam(required = false, defaultValue = "10") Integer pageSize,
                                  HttpSession session, Model model) {
        PageInfo<Book> books = bookService.selectByKeyword(pageNum, pageSize, keyword);
        session.setAttribute("keyword", keyword);
        model.addAttribute("books", books);
        return "search";
    }

  //在图书详情页删除收藏记录
    @DeleteMapping("/main/{bookid}")
    public String deleteHistory(@PathVariable("bookid") Integer bookid, HttpSession session){
        Integer userid =(Integer) session.getAttribute("loginUserid");
        HistoryKey historyKey = new HistoryKey();
        historyKey.setUserid(userid);
        historyKey.setBookid(bookid);
        historyService.deleteByPrimary(historyKey);
        return "redirect:/main/{bookid}";
    }
//在图书详情页删除评分
    @PutMapping("/main/{bookid}")
    public String deleteRate(@PathVariable("bookid") Integer bookid,HttpSession session){
        Integer userid =(Integer) session.getAttribute("loginUserid");
        RateKey rateKey = new RateKey();
        rateKey.setUserid(userid);
        rateKey.setBookid(bookid);
        rateMapper.deleteByPrimaryKey(rateKey);
        return "redirect:/main/{bookid}";
    }
}
