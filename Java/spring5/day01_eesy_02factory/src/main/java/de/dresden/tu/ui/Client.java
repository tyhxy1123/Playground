package de.dresden.tu.ui;

import de.dresden.tu.factory.BeanFactory;
import de.dresden.tu.service.IAccountService;
import de.dresden.tu.service.impl.AccountServiceImpl;

/**
 * 模拟一个表现层，用于调用业务
 */
public class Client {
    public static void main(String[] args) {
        IAccountService as = (IAccountService) BeanFactory.getBean("accountService");

        as.saveAccount();
    }
}
