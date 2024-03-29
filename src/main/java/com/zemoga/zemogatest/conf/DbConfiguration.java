package com.zemoga.zemogatest.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application.properties")
public class DbConfiguration {
    @Value("${zemoga.db.url}")
    String url;
    @Value("${zemoga.db.user}")
    String user;
    @Value("${zemoga.db.password}")
    String password;
    @Value("${jdbc.driverClassName}")
    String driverClassName;
    @Value("${hibernate.dialect}")
    String hibernateDialect;
    @Value("${hibernate.hbm2ddl.auto}")
    String hibernateHbm2ddl;
    @Value("${hibernate.showsql}")
    String showSql;


}
