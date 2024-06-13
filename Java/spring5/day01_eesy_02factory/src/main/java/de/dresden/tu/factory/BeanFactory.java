package de.dresden.tu.factory;

import de.dresden.tu.dao.impl.AccountDaoImpl;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 一个创建Bean对象的工厂
 *
 * Bean: 有可重用组件的含义
 * JavaBean: 用Java语言编写的可重用组件
 *      JavaBean > 实体类
 *
 * 用来创建service和dao对象
 *
 * 1. 需要一个配置文件来配置service和dao
 *      配置内容: 唯一标识=全限定类名(key=value)
 * 2. 通过读取配置文件的内容，反射创建对象
 *
 * 配置文件可以是xml也可以是properties
 */
public class BeanFactory {
    //定义一个Properties对象
    private static Properties props;

    //使用静态代码块为Properties对象赋值
    static{
        //实例化对象
        props = new Properties();
        //获取properties文件的流对象
        InputStream in = BeanFactory.class.getClassLoader().getResourceAsStream("bean.properties");
        try {
            props.load(in);
        } catch (IOException e) {
            throw new ExceptionInInitializerError("properties init fail");
        }
    }

    /**
     * 根据bean的名称获取bean对象
     * @param beanName
     * @return
     */
    public static Object getBean(String beanName){
        Object bean = null;
        try {
            String beanPath = props.getProperty(beanName);
            bean = Class.forName(beanPath).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return bean;
    }
}
