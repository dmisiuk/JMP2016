package com.epam.jmp.context;

import org.apache.commons.configuration2.Configuration;
import org.apache.commons.configuration2.FileBasedConfiguration;
import org.apache.commons.configuration2.PropertiesConfiguration;
import org.apache.commons.configuration2.builder.FileBasedConfigurationBuilder;
import org.apache.commons.configuration2.builder.fluent.Parameters;
import org.apache.commons.configuration2.ex.ConfigurationException;
import org.springframework.beans.BeansException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.RuntimeBeanReference;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.beans.factory.support.ManagedList;
import org.springframework.context.ApplicationContextException;
import org.springframework.context.support.AbstractRefreshableConfigApplicationContext;

import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by Dzmitry_Misiuk on 7/25/2016.
 */
public class PropertiesApplicationConfiguration extends AbstractRefreshableConfigApplicationContext {

    private Configuration configuration;


    public PropertiesApplicationConfiguration(String configLocation) {
        setConfigLocations(configLocation);
        refresh();
    }

    @Override
    protected void loadBeanDefinitions(DefaultListableBeanFactory beanFactory) throws BeansException, IOException {
        preparePropertiesConfiguration();
        Collection<String> beanNames = readBeanNames();
        for (String beanName : beanNames) {
            BeanDefinition beanDefinition = prepareBeanDefinition(beanName);
            beanFactory.registerBeanDefinition(beanName, beanDefinition);
        }

        return;
    }

    private BeanDefinition prepareBeanDefinition(String beanName) {
        String prefix = "beans." + beanName + ".";
        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        String scope = configuration.getString(prefix + "scope", "singleton");
        beanDefinition.setScope(scope);
        String beanClass = configuration.getString(prefix + "class");
        beanDefinition.setBeanClassName(beanClass);

        MutablePropertyValues propertyValues = prepareProperties(prefix);
        beanDefinition.setPropertyValues(propertyValues);
        return beanDefinition;
    }

    private MutablePropertyValues prepareProperties(String prefix) {
        MutablePropertyValues properties = new MutablePropertyValues();
        Iterator<String> keys = configuration.getKeys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (key.startsWith(prefix)) {
                String propertyName = key.substring(prefix.length());
                if (propertyName.contains(".") || propertyName.equals("class") || propertyName.equals("scope")) {
                    continue;
                }
                String value = configuration.getString(key);
                Object parsedValue = parseValue(value);
                properties.add(propertyName, parsedValue);
            }
        }
        return properties;
    }

    private Object parseValue(String value) {
        if (value.startsWith("[") && value.endsWith("]")) {
            List values = new ManagedList();
            String[] rowValues = value.substring(1, value.length() - 1).split(",");
            for (String rowValue : rowValues) {
                values.add(parseValue(rowValue));
            }
            return values;
        }
        if (value.startsWith("ref:")) {
            return new RuntimeBeanReference(value.substring(4));
        }
        return value;
    }

    private Collection<String> readBeanNames() {
        Iterator<String> keys = configuration.getKeys();
        Set<String> uniqueBeanNames = new HashSet<>();
        while (keys.hasNext()) {
            String key = keys.next();
            if (key.startsWith("beans.")) {
                int indexTheNextDot = key.indexOf(".", 6);
                String beanName = key.substring(6, indexTheNextDot);
                uniqueBeanNames.add(beanName);
            }
        }
        return uniqueBeanNames;
    }

    private void preparePropertiesConfiguration() {
        String configLocation = this.getConfigLocations()[0];
        Parameters params = new Parameters();
        FileBasedConfigurationBuilder<FileBasedConfiguration> builder =
                new FileBasedConfigurationBuilder<FileBasedConfiguration>(PropertiesConfiguration.class)
                        .configure(params.properties()
                                .setFileName(configLocation));
        try {
            configuration = builder.getConfiguration();
        } catch (ConfigurationException cex) {
            throw new ApplicationContextException("Error read context properties file", cex);
        }
    }
}
