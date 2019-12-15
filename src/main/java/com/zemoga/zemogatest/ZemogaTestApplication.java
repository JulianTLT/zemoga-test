package com.zemoga.zemogatest;

import com.zemoga.zemogatest.conf.DbConfiguration;
import com.zemoga.zemogatest.conf.PersistenceConfig;
import com.zemoga.zemogatest.repository.PortfolioRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class ZemogaTestApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(DbConfiguration.class,PersistenceConfig.class);
		SpringApplication.run(ZemogaTestApplication.class, args);
	}

}
