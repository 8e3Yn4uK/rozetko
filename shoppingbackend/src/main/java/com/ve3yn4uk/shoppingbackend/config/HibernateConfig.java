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
public class HibernateConfig {

    private Logger logger = Logger.getLogger(getClass().getName());

    @Autowired
    private Environment env;

    final static String jdbc_driver = "com.mysql.cj.jdbc.Driver";
    final static String jdbc_url = "jdbc:mysql://localhost:3306/rozetko?useSSL=false&serverTimezone=UTC";
    final static String jdbc_user = "root";
    final static String jdbc_pwd = "root";

    // DataSource bean
    @Bean
    public DataSource getDataSource() {

        BasicDataSource dataSource = new BasicDataSource();

        // database connection information
        dataSource.setDriverClassName(jdbc_driver);

        logger.info(">>> jdbc url: " + jdbc_url);
        logger.info(">>> jdbc user: " + jdbc_user);

        dataSource.setUrl(jdbc_url);
        dataSource.setUsername(jdbc_user);
        dataSource.setPassword(jdbc_pwd);

        return dataSource;
    }

    // SessionFactory bean
    @Bean
    public SessionFactory getSessionFactory(DataSource dataSource) {

        LocalSessionFactoryBuilder builder = new LocalSessionFactoryBuilder(dataSource);

        builder.addProperties(getHibernateProperties());
        builder.scanPackages("com.ve3yn4uk.shoppingbackend.entity");

        return builder.buildSessionFactory();
    }

    public Properties getHibernateProperties() {

        Properties properties = new Properties();

        properties.put("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        properties.put("hibernate.show_sql", true);
        properties.put("hibernate.format_sql", true);

        return properties;
    }

    // TransactionManager bean
    @Bean
    public HibernateTransactionManager getTransactionManager(SessionFactory sessionFactory) {

        HibernateTransactionManager transactionManager = new HibernateTransactionManager(sessionFactory);

        return transactionManager;
    }
}
