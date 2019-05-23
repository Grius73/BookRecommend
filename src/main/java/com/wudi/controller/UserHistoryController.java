package com.wudi.controller;

import com.wudi.mapper.AccountMapper;
import com.wudi.model.Book;
import com.wudi.model.HistoryKey;
import com.wudi.service.BookService;
import com.wudi.service.HistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Controller
public class UserHistoryController {
    @Autowired
    HistoryService historyservice;
    @Autowired
    BookService bookService;
    @Autowired
    AccountMapper accountMapper;
    @GetMapping("/historys")
    public String list(Model model, HttpSession session){
        Integer loginUserid=(Integer) session.getAttribute("loginUserid");//获取当前用户名
        System.out.println(loginUserid);
        List<Book> historys = historyservice.queryBookByHistory(loginUserid);
        model.addAttribute("historys",historys);
        return "history/list";
    }
    @GetMapping("/history/{bookid}")
    public String addHistory(@PathVariable("bookid") Integer bookid, HttpSession session){
        Integer userid =(Integer) session.getAttribute("loginUserid");
        HistoryKey historyKey = new HistoryKey();
        historyKey.setUserid(userid);
        historyKey.setBookid(bookid);
        historyservice.addHistory(historyKey);
        return"redirect:/main/{bookid}";
    }

    //用户评分删除
    @DeleteMapping("/history/{bookid}")
    public String deleteHistory(@PathVariable("bookid") Integer bookid, HttpSession session){
        System.out.println("删除评分id:"+bookid);
        Integer userid =(Integer) session.getAttribute("loginUserid");
        HistoryKey historyKey = new HistoryKey();
        historyKey.setUserid(userid);
        historyKey.setBookid(bookid);
        historyservice.deleteByPrimary(historyKey);
        return "redirect:/historys";
    }

}
