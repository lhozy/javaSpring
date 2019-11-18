package com.lhozy.test;

import com.lhozy.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:bean.xml"})

public class AdviceTest {
    @Autowired
    IAccountService accountService;

    @Test
    public void testSave(){
        accountService.save();
    }
    @Test
    public void testUpdate(){
        accountService.update(1);
    }
    @Test
    public void testDelete(){
        accountService.delete();
    }

}
