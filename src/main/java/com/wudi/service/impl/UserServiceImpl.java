package com.wudi.service.impl;

import com.wudi.mapper.AccountMapper;
import com.wudi.model.Account;
import com.wudi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author wudi
 * @date ${date} - ${time}
 */
@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    AccountMapper accountMapper;

    @Override
    public Account getUserById(int userId) {
        return accountMapper.selectByPrimaryKey(userId);
    }

    @Override
    public List<Account> getAlluser() {
        return accountMapper.getAll();
    }

    @Override
    public boolean userInsert(Account record) {
        if(accountMapper.checkUserExist(record.getUsername()))
        {return false;}else{accountMapper.insertSelective(record);
        return true;}
    }

    @Override
    public boolean isUserExist(String username) {
        return accountMapper.checkUserExist(username);
    }

    @Override
    public Account queryByUsername(String username) {
        return accountMapper.selectByUsername(username);
    }
}
