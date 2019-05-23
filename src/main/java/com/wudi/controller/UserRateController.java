package com.wudi.controller;

import com.wudi.mapper.AccountMapper;
import com.wudi.mapper.RateMapper;
import com.wudi.model.RateKey;
import com.wudi.model.Rate;
import com.wudi.model.RateKey;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Controller
public class UserRateController {
    @Autowired
    RateMapper rateMapper;
    @Autowired
    AccountMapper accountMapper;
    @GetMapping("/rates")
    public String list(Model model, HttpSession session){
        Integer loginUserid=(Integer) session.getAttribute("loginUserid");//获取当前用户名
        System.out.println(loginUserid);
        List<Rate> rates = rateMapper.selectByUserid(loginUserid);
        model.addAttribute("rates",rates);
        return "rate/list";
    }
    @GetMapping("/rate/{bookid}")
    public String addrate(@PathVariable("bookid") Integer bookid,
                          @RequestParam("rate") Integer rating,
                          HttpSession session){
        Integer userid =(Integer) session.getAttribute("loginUserid");
        Rate rate = new Rate();
        rate.setUserid(userid);
        rate.setBookid(bookid);
        rate.setRating(rating);
        rateMapper.insert(rate);
        return"redirect:/main/{bookid}";
    }

    //用户评分删除
    @DeleteMapping("/rate/{bookid}")
    public String deleteRate(@PathVariable("bookid") Integer bookid,HttpSession session){
        System.out.println("删除评分id:"+bookid);
        Integer userid =(Integer) session.getAttribute("loginUserid");
        RateKey rateKey = new RateKey();
        rateKey.setUserid(userid);
        rateKey.setBookid(bookid);
        rateMapper.deleteByPrimaryKey(rateKey);
        return "redirect:/rates";
    }
}
