package com.wudi.controller;

import com.github.pagehelper.PageInfo;
import com.wudi.mapper.AccountMapper;
import com.wudi.mapper.HistoryMapper;
import com.wudi.model.Account;
import com.wudi.model.Book;
import com.wudi.model.HistoryKey;
import com.wudi.model.Rate;
import com.wudi.service.HistoryService;
import com.wudi.service.RateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Controller
public class AdminController {
    @Autowired
    AccountMapper accountMapper;
    @Autowired
    HistoryService historyService;
    @Autowired
    HistoryMapper historyMapper;
    @Autowired
    RateService rateService;
    @GetMapping("/accounts")
    public String list(Model model){
        List<Account> accounts = accountMapper.getAll();
        model.addAttribute("accounts",accounts);
        return "account/list";
    }
    //来到用户账号添加页面
    @GetMapping("/account")
    public String toAddPage(Model model){
        return "account/add";
    }

    //用户账号添加
    //SpringMVC自动将请求参数和入参对象的属性进行一一绑定；要求请求参数的名字和javaBean入参的对象里面的属性名是一样的
    @PostMapping("/account")
    public String addAccount(Account account){
        //来到用户账号列表页面
        System.out.println("保存的用户账号信息："+account);
        //保存用户账号
        accountMapper.insertSelective(account);
        // redirect: 表示重定向到一个地址  /代表当前项目路径
        // forward: 表示转发到一个地址
        return "redirect:/accounts";
    }

    //来到修改页面，查出当前用户账号，在页面回显
    @GetMapping("/account/{userid}")
    public String toEditPage(@PathVariable("userid") Integer userid,Model model){
        //回到修改页面(add是一个修改添加二合一的页面);
        Account account=accountMapper.selectByPrimaryKey(userid);
        model.addAttribute("account",account);
        return "account/add";
    }

    //用户账号修改；需要提交用户账号id；
    @PutMapping("/account")
    public String updateAccount(Account account){
        System.out.println("修改的用户账号数据："+account);
        accountMapper.updateByNameSelective(account);
        return "redirect:/accounts";
    }

    //用户账号删除
    @DeleteMapping("/account/{userid}")
    public String deleteAccount(@PathVariable("userid") Integer userid){
        System.out.println("删除用户id:"+userid);
        accountMapper.deleteByPrimaryKey(userid);
        return "redirect:/accounts";
    }

    @GetMapping("/admin/historys")//访问用户收藏界面
    public String getHistorysTypeList(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                      @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                      Model model){
        PageInfo<HistoryKey> historykeys= historyService.returnAll(pageNum,pageSize);
        model.addAttribute("historys",historykeys);
        return "admin/history/list";
    }
    @GetMapping("/admin/history")
    public String toAddHistory(Model model){return"/admin/history/add";}

    @PostMapping("/admin/history")//添加界面
    public String addHistory(HistoryKey historyKey){
        historyMapper.insertSelective(historyKey);
        return "redirect:/admin/historys";
    }
    @GetMapping("/admin/history/{userid}")
    public String toEditHistory(@PathVariable("userid")Integer userid,
                                @RequestParam("bookid")Integer bookid, Model model){
        HistoryKey historyKey=new HistoryKey();
        historyKey.setUserid(userid);
        historyKey.setBookid(bookid);
        model.addAttribute("history",historyKey);
        return "redirect:/admin/history/add";
    }
    @PutMapping("/admin/history/{userid}")
    public String updateHistory(HistoryKey historyKey){
        historyMapper.insertSelective(historyKey);
        return "redirect:/admin/historys";
    }
    //删除收藏
    @DeleteMapping("/admin/history/{userid}")
    public String deleteHistory(@PathVariable(value = "userid") Integer userid,
                                @RequestParam("bookid") Integer bookid){
        HistoryKey historyKey=new HistoryKey();
        historyKey.setBookid(bookid);
        historyKey.setUserid(userid);
        historyMapper.deleteByPrimaryKey(historyKey);
        return "redirect:/admin/historys";
    }
    @GetMapping("/admin/rates")//访问用户评分界面
    public String getRatesTypeList(@RequestParam(required = false,defaultValue = "1") Integer pageNum,
                                   @RequestParam(required = false,defaultValue = "10") Integer pageSize,
                                   Model model){
        PageInfo<Rate> rates= rateService.returnAllRate(pageNum,pageSize);
        model.addAttribute("rates",rates);
        return "admin/rate/list";
    }

}
