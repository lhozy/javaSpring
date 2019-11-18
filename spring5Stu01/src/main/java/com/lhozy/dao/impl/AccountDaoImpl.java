package com.lhozy.dao.impl;

import com.lhozy.dao.AccountDao;
import com.lhozy.domain.Account;

import java.util.ArrayList;
import java.util.List;

public class AccountDaoImpl implements AccountDao {

    public List<Account> find() {
        Account account = new Account();
        account.setId(12);
        account.setUid(11);
        account.setMoney(100.00);
        List<Account> list = new ArrayList<Account>();
        list.add(account);
        return list;
    }
}
