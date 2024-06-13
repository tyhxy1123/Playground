package de.dresden.tu.service.impl;

import de.dresden.tu.dao.IAccountDao;
import de.dresden.tu.dao.impl.AccountDaoImpl;
import de.dresden.tu.factory.BeanFactory;
import de.dresden.tu.service.IAccountService;

/**
 * 业务层实现类
 */
public class AccountServiceImpl implements IAccountService {

    private IAccountDao accountDao = (IAccountDao) BeanFactory.getBean("accountDao");

    public void saveAccount() {
        accountDao.saveAccount();
    }
}
