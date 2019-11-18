package com.lhozy;

import com.lhozy.dao.AccountDao;
import com.lhozy.domain.Account;
import com.lhozy.service.AccountService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
//        AccountDao accountDao = ac.getBean("accountDao", AccountDao.class);
//        System.out.println(accountDao);
//        List<Account> accounts = accountDao.find();
//        System.out.println(accounts);
        AccountService accountService = ac.getBean("accountService", AccountService.class);
        List<Account> accounts = accountService.findAccount();
        System.out.println(accounts);
        System.out.println(accountService);
    }
}
