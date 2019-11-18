package com.lhozy.dao;

import com.lhozy.domain.Account;

import java.util.List;

/**
 * Account持久层接口
 */
public interface IAccountDao {
    /**
     * 查询所有
     * @return
     */
    List<Account> findAllAccount();

    /**
     * 根据ID查询
     * @return
     */
    Account findAccountById(Integer accountId);

    /**
     * 新增
     * @param account
     */
    void saveAccount(Account account);

    /**
     * 修改
     * @param account
     */
    void updateAccount(Account account);

    /**
     * 删除
     * @param accountId
     */
    void deleteAccount(Integer accountId);

    Account findAccountByName(String accountName);

}
