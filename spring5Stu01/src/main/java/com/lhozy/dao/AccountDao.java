package com.lhozy.dao;

import com.lhozy.domain.Account;

import java.util.List;

public interface AccountDao {
    List<Account> find();
}
