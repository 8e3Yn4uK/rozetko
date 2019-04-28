package com.ve3yn4uk.shoppingbackend.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBuilder;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;
import java.util.logging.Logger;

/**
 * Created by 8e3Yn4uK on 27.04.2019
 */

@Configuration
@ComponentScan(basePackages = {"com.ve3yn4uk.shoppingbackend.entity"})
@EnableTransactionManagement
@PropertySource({"classpath:persistence-mysql.properties", "classpath:security-persistence-mysql.properties"})
public class HibernateConfig {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private Environment env;


    // DataSource bean
    @Bean
    public DataSource getDataSource() {

        BasicDataSource dataSource = new BasicDataSource();

        // database connection information
        dataSource.setDriverClassName(env.getProperty("jdbc.driver"));

        logger.info(">>> jdbc url: " + env.getProperty("jdbc.url"));
        logger.info(">>> jdbc user: " + env.getProperty("jdbc.user"));

        dataSource.setUrl(env.getProperty("jdbc.url"));
        dataSource.setUsername(env.getProperty("jdbc.user"));
        dataSource.setPassword(env.getProperty("jdbc.password"));

        return dataSource;
    }

    // SessionFactory bean
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

        builder.addProperties(getHibernateProperties());
        builder.scanPackages(env.getProperty("hibernate.packagesToScan"));

        return builder.buildSessionFactory();
    }

    public Properties getHibernateProperties() {

        Properties properties = new Properties();

        properties.put("hibernate.dialect", env.getProperty("hibernate.dialect"));
        properties.put("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
        properties.put("hibernate.format_sql", env.getProperty("hibernate.format_sql"));

        return properties;
    }

    // TransactionManager bean
    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

        return transactionManager;
    }
}
