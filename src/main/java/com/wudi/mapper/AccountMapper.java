package com.wudi.mapper;

import com.wudi.model.Account;

import java.util.List;

public interface AccountMapper {
    int deleteByPrimaryKey(Integer userid);

    int insert(Account record);

    int insertSelective(Account record);

    Account selectByPrimaryKey(Integer userid);

    int updateByPrimaryKeySelective(Account record);

    int updateByNameSelective(Account record);

    int updateByPrimaryKey(Account record);

    boolean checkUserExist(String username);

    Account selectByUsername(String username);

    List<Account> getAll();
}