package com.wudi.controller;

import com.wudi.mapper.AccountMapper;
import com.wudi.model.Account;
import com.wudi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Controller
public class LoginController {
    @Autowired
    UserService userService;
    @Autowired
    AccountMapper accountMapper;
    Account account;

    @PostMapping(value = "/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Map<String, Object> map, HttpSession session) {
        if (userService.isUserExist(username) && userService.queryByUsername(username).getPassword().equals(password)) {
            //登陆成功，防止表单重复提交，可以重定向到主页
            account = accountMapper.selectByUsername(username);
            int loginUserid = account.getUserid();//获取当前登录用户id
            int loginUserRole = account.getRole();
            session.setAttribute("loginUserid", loginUserid);
            session.setAttribute("loginUser", username);
            if (loginUserRole == 1) {//验证权限
                return "redirect:/books";
            } else {
                return "redirect:/main";
            }

        } else {
            //登陆失败
            map.put("msg", "用户名密码错误");
            return "login";
        }
    }

    @GetMapping(value = "/login")
    public String ToLogin(HttpSession session) {
        if(session!=null)
            session.invalidate();//注销
        return "login";
    }

    @GetMapping(value = "/register")
    public String ToRegister() {
        return "register";
    }

    @PostMapping(value = "/register")
//    public String register(@RequestParam(value = "username", required = false) String username,
//                           @RequestParam(value = "password", required = false) String password) {
//        Account account1 =new Account();
//        account1.setPassword(password);
//        account1.setUsername(username);
//        account1.setRole(2);
//        accountMapper.insert(account1);
//        return "register";
//     }

    public String register(@RequestParam(value = "username",required = false) String username,
                           @RequestParam(value = "password",required = false) String password,
                           @RequestParam(value = "repassword",required = false) String repassword,
                           Map<String,Object> map) {

        if (userService.isUserExist(username)) {
            System.out.println("用户名存在");
            map.put("msg","用户名已存在");
            return "register";
        } else if(!password.equals(repassword)){
            map.put("msg","两次输入的密码不一致");
            return "register";
        }else {
            map.put("msg", "注册成功");
            Account account1 =new Account();
            account1.setUsername(username);
            account1.setPassword(password);
            account1.setRole(2);
            userService.userInsert(account1);
            return "login";
        }
    }

}
