package com.lhozy.service.impl;

import com.lhozy.service.IAccountService;
import org.springframework.stereotype.Service;

@Service("accountService")
public class AccountServiceImpl implements IAccountService {

    @Override
    public void save() {
        System.out.println("执行save方法");
//        Integer i = 1/0;
    }

    @Override
    public void update(Integer id) {
        System.out.println("执行update方法");

    }

    @Override
    public Integer delete() {
        System.out.println("执行delete方法");
        return 1;
    }
}
