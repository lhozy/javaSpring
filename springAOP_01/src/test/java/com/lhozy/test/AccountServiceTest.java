package com.lhozy.test;

import com.lhozy.domain.Account;
import com.lhozy.service.IAccountService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})
public class AccountServiceTest {
//    private ApplicationContext ac;
    @Autowired
    private IAccountService as;

//    @Before
//    public void init(){
//        ac = new ClassPathXmlApplicationContext("bean.xml");
//        as = ac.getBean("accountService", IAccountService.class);
//    }
    @Test
    public void testTransfer(){
        as.transfer("aaa","bbb",100f);
    }
    @Test
    public void testFindAll(){
        //ApplicationContext ac = new ClassPathXmlApplicationContext("bean.xml");
        //IAccountService accountService = ac.getBean("accountService", IAccountService.class);
        List<Account> allAccount = as.findAllAccount();
        for (Account account : allAccount) {
            System.out.println(account);
        }
    }

    @Test
    public void testFindOne() {
        //3.执行方法
        Account account = as.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave() {
        Account account = new Account();
        account.setName("test anno");
        account.setMoney(12345f);
        //3.执行方法
        as.saveAccount(account);

    }

    @Test
    public void testUpdate() {
        //3.执行方法
        Account account = as.findAccountById(4);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //3.执行方法
        as.deleteAccount(4);
    }

}
