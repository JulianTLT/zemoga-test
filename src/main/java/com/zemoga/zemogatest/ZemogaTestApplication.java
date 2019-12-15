package com.zemoga.zemogatest;

import com.zemoga.zemogatest.conf.DbConfiguration;
import com.zemoga.zemogatest.conf.PersistenceConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class ZemogaTestApplication {

	public static void main(String[] args) {

		ApplicationContext context = new AnnotationConfigApplicationContext(DbConfiguration.class);

		SpringApplication.run(ZemogaTestApplication.class, args);
	}

}
