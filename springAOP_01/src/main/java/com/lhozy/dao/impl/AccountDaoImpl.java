package com.lhozy.dao.impl;

import com.lhozy.dao.IAccountDao;
import com.lhozy.domain.Account;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.util.List;

/**
 * Account持久层实现类
 */
public class AccountDaoImpl implements IAccountDao{
    private QueryRunner queryRunner;

    public void setQueryRunner(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    public List<Account> findAllAccount() {
        try {
            return queryRunner.query("select * from account",new BeanListHandler<Account>(Account.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public Account findAccountById(Integer accountId) {
        try{
            return queryRunner.query("select * from account where id = ? ",new BeanHandler<Account>(Account.class),accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAccount(Account account) {
        try{
            queryRunner.update("insert into account(name,money)values(?,?)",account.getName(),account.getMoney());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void updateAccount(Account account) {
        try{
            queryRunner.update("update account set name=?,money=? where id=?",account.getName(),account.getMoney(),account.getId());
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public void deleteAccount(Integer accountId) {
        try{
            queryRunner.update("delete from account where id=?",accountId);
        }catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    public Account findAccountByName(String accountName){
        try {
            List<Account> accounts = queryRunner.query("select * from account where name = ? ", new BeanListHandler<Account>(Account.class), accountName);
            if (accounts == null || accounts.size()==0) {
                return null;
            }
            if(accounts.size() > 1){
                throw new RuntimeException("重复数据");
            }
            return accounts.get(0);

        }catch (Exception e){
            throw new RuntimeException(e);
        }

    }
//    public void transfer(String sourceName, String destName, Float money) {
//        Account sourceAccount = findAccountByName(sourceName);
//        Account destAccount= findAccountByName(destName);
//        sourceAccount.setMoney(sourceAccount.getMoney() - money);
//        destAccount.setMoney(destAccount.getMoney() + money);
//        saveAccount(sourceAccount);
//        saveAccount(destAccount);
//
//    }
}
