package de.dresden.tu.dao.impl;

import de.dresden.tu.dao.IAccountDao;

/**
 * 账户的持久层实现类
 */
public class AccountDaoImpl implements IAccountDao {
    public void saveAccount() {
        System.out.println("account saved successful...");
    }
}
