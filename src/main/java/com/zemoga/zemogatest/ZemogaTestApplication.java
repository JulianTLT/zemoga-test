package com.zemoga.zemogatest;

import com.zemoga.zemogatest.conf.DbConfiguration;
import com.zemoga.zemogatest.conf.PersistenceConfig;
import com.zemoga.zemogatest.conf.TwitterConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import twitter4j.Twitter;
import twitter4j.TwitterException;

@SpringBootApplication(exclude = HibernateJpaAutoConfiguration.class)
public class ZemogaTestApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(DbConfiguration.class,
				PersistenceConfig.class, TwitterConfig.class);
		SpringApplication.run(ZemogaTestApplication.class, args);
	}

}
