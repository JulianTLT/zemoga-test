package com.zemoga.zemogatest.conf;


import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.io.IOException;
import java.util.Properties;

@Configuration
@ComponentScan(basePackages = "com.zemoga.zemogatest")
@EnableTransactionManagement
public class PersistenceConfig {

    private final String hibernateHbm2ddl= "hibernate.hbm2ddl.auto";
    private final String hibernateDialect = "hibernate.dialect";
    private final String hibernateShowSql = "hibernate.show_sql";
    private final String packageToScan = "com.zemoga.zemogatest.conf";

    @Bean
    public DataSource dataSource(DbConfiguration dbConfiguration) {
        BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(dbConfiguration.driverClassName);
        dataSource.setUrl(dbConfiguration.url);
        dataSource.setUsername(dbConfiguration.user);
        dataSource.setPassword(dbConfiguration.password);
        return dataSource;
    }

    private Properties hibernateProperties(DbConfiguration dbConfiguration) {
        Properties hibernateProperties = new Properties();
        hibernateProperties.put(hibernateHbm2ddl, dbConfiguration.hibernateHbm2ddl);
        hibernateProperties.put(hibernateDialect, dbConfiguration.hibernateDialect);
        hibernateProperties.put(hibernateShowSql, dbConfiguration.showSql);
        return hibernateProperties;
    }

    @Bean
    public SessionFactory sessionFactory(DataSource dataSource, DbConfiguration dbConfiguration) throws IOException {
        LocalSessionFactoryBean sessionFactoryBean = new LocalSessionFactoryBean();
        sessionFactoryBean.setDataSource(dataSource);
        sessionFactoryBean.setPackagesToScan(packageToScan);
        sessionFactoryBean.setHibernateProperties(hibernateProperties(dbConfiguration));
        sessionFactoryBean.afterPropertiesSet();
        return sessionFactoryBean.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager(SessionFactory sessionFactory) {
        return new HibernateTransactionManager(sessionFactory);
    }


}
