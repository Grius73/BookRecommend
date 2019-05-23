package com.wudi.service;

import com.wudi.model.Account;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
public interface UserService {
    public Account getUserById(int userId);
    public List<Account> getAlluser();//获取所有用户
    public boolean userInsert(Account record);//添加用户
    public boolean isUserExist(String username);//用户是否存在
    public Account queryByUsername(String username);//返回相应用户名的用户
}
