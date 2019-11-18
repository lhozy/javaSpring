package com.lhozy.service.impl;

import com.lhozy.dao.AccountDao;
import com.lhozy.domain.Account;
import com.lhozy.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class AccountServiceImpl implements AccountService{
    private AccountDao accountDao;
    public List<Account> findAccount() {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        accountDao = ac.getBean("accountDao", AccountDao.class);
        return accountDao.find();
    }
}
