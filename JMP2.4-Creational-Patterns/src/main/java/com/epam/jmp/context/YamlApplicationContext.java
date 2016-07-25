package com.epam.jmp.context;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

/**
 * Created by Dzmitry_Misiuk on 7/25/2016.
 */
public class YamlApplicationContext extends AbstractRefreshableConfigApplicationContext {


    public YamlApplicationContext(String configLocation) {
        setConfigLocations(configLocation);
        refresh();
    }

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {

        return;
    }
}
