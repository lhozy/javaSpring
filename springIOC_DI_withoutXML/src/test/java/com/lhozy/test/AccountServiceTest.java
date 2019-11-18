package com.lhozy.test;

import com.lhozy.domain.Account;
import com.lhozy.service.IAccountService;
import config.SpringConfiguration;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class) //spring整合Junit的类，替换Junit的Runner
@ContextConfiguration(classes = SpringConfiguration.class)//classes创建注解配置的IOC容器，指定根据自定义的配置类SpringConfiguration来创建，
                                                                // locations 用于xml的配置
public class AccountServiceTest {
    @Autowired
    private IAccountService as;
//    private ApplicationContext ac;
//    private IAccountService as;

//    @Before
//    public void init(){
////        ac = new ClassPathXmlApplicationContext("bean.xml");//创建xml配置的IOC容器
//        ac = new AnnotationConfigApplicationContext(SpringConfiguration.class);//创建注解配置的IOC容器
//        as = ac.getBean("accountService", IAccountService.class);
//    }
    @Test
    public void testFindAll(){
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
        Account account = as.findAccountById(5);
        account.setMoney(23456f);
        as.updateAccount(account);
    }

    @Test
    public void testDelete() {
        //3.执行方法
        as.deleteAccount(5);
    }
}
